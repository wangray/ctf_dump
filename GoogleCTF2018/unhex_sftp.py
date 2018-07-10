from pwn import *

f = open('hex_out', 'rb').read()

print xor(f, 0x37)