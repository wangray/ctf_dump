import os
from pwn import *

# p = gdb.debug('./insanity', '''
# b *0x555555555214
# b *0x5555555552b0
# commands
# x/s $rax
# end
# b *0x55555555511C
# commands
# set $pc = 0x55555555512c
# c
# end
# ''')
#
# p = gdb.debug('./insanity', '''
# b *0x5555555552ea
# b *0x55555555511c
# commands
# x/s $rax
# end
# ''')
p = gdb.debug('./insanity', '''
b *0x5555555552ea
commands
x/s $rax
end
''')
context(arch = "amd64", os = 'linux', endian = 'little')

#p = process('./insanity')

buf = open('../clobber2/input.raw76.zlib', 'rb').read()

wbuf= p32(len(buf))
p.write(wbuf)
p.recv(1)

if len(buf) < 0x10000:
	buf += 'A'*(0x10000 - len(buf))
p.write(buf)

p.interactive()
