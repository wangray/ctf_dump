from pwn import *

p = process('./peropdo')

p.sendline('\x00'*4)

gdb.attach()
