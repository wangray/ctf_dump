from pwn import *

f = open("lookup_table", "rb").read()

lookup = dict()
for i in range(len(f)/16):
    rax = u64(f[i*16:i*16+8])
    addr = u64(f[i*16+8:i*16+16])
    lookup[rax] = addr

for k, v in lookup.items():
    print hex(k), hex(v)
