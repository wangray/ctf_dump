from pwn import *

xor = u16("T\x17", endianness="big")

res = 0x8dfa

password = []

for i in range(16):
    v3_tmp = res/2

