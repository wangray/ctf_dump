import sys
import struct
import hashlib
import thread
from threading import Thread

from pwn import *

# inspired by C3CTF's POW

def pow_hash(challenge, solution):
    return hashlib.sha256(challenge.encode('ascii') + struct.pack('<Q', solution)).hexdigest()

def check_pow(challenge, n, solution):
    h = pow_hash(challenge, solution)
    return (int(h, 16) % (2**n)) == 0

def solve_pow(challenge, n):
    candidate = 0
    while True:
        if check_pow(challenge, n, candidate):
            return candidate
        candidate += 1

def proof_of_work(p):
    messages = p.recvuntil("Solution:")
    messages = messages.split("\n")
    challenge = messages[1].split(": ")[1]
    n = int(messages[2].split(": ")[1])
    log.info("POW Challenge: {} {}".format(challenge, n))

    payload = solve_pow(challenge, n)
    log.info("POW Solution: {}".format(payload))

    p.sendline(str(payload))

# if len(sys.argv) > 1 and sys.argv[1] == 'remote':
# else:
    # p = process("./official")
    # if len(sys.argv) > 1 and sys.argv[1] == 'gdb':
        # gdb.attach(p, """
              # set disassembly-flavor intel
               # b main
               # """)

p1 = remote("3aef2bbc.quals2018.oooverflow.io", 31337)
# p2 = remote("3aef2bbc.quals2018.oooverflow.io", 31337)
# proof_of_work(p1)
# proof_of_work(p2)


rset = []
sset = []
hashes = []
def do_sign(p):
    for i in range(0x41, 0x7a):
        # print("i", i)
        newcmd = "ls"+ chr(i)*254
        # print newcmd
        # res = p.recvuntil(">")
        # p.sendline("S")
        # p.recvuntil("cmd:")
        # p.sendline(newcmd)
        # r = p.recvuntil("s:")
        # r = r.split("r:")[1].split("s:")[0].strip()
        newhash = hashlib.sha1(newcmd).hexdigest()
        # print "r", r
        # s = p.recvline().strip()
        # print "s", s
        # rset.append(r)
        # sset.append(s)
        hashes.append(newhash)

do_sign(p1)

# print rset, sset, hashes
print [int(s, 16) for s in hashes]

# t1 = Thread(target=do_sign, args=(p1,))
# t2 = Thread(target=do_sign, args=(p2,))
# t1.start()
# t2.start()

# print(p1.recvuntil(">"))
# print(p2.recvuntil(">"))

# p1.sendline("S")
# p2.sendline("S")
# p1.recvuntil("cmd:")
# p2.recvuntil("cmd:")
# p1.sendline("ls")
# p2.sendline("ls")

# print(p1.recvuntil(">"))
# print(p2.recvuntil(">"))




