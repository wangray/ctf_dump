from pwn import *

p = remote("localhost", 31337)

print p.recvuntil("3) Q (Quit)")
p.sendline("N")

print p.recvuntil("3) Quit game (Q)")

p.sendline("V")

output = p.recvall(timeout=2)
print "\n".join([repr(line) for line in output.split("\n")])
