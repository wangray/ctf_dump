import binascii
from pwn import *


key = p64(0x0F57CBE9AFB7CBE3D) + p64(0x99BEFB1199A5F9C2) + p64(0x0FB993FBEB3B1E711) + p64(0x0C223301199BED2E7) + p64(0xCEF0F082BE)

table = open("table").read()
odd_table = table[1::2]

flag = ""
for byte in key: 
    flag_i = odd_table.index(byte)+1
    flag += chr(flag_i)
    print flag

print flag
