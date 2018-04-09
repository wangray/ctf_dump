from pwn import *
import time
import random

for i in xrange(0, 256):
	r = remote("jargon_theanswertolifetheuniverseandeverything.quals.shallweplayaga.me",12000)

	r.sendline("32") # send number of bytes

	rand = "".join([chr(random.randint(0, 255)) for i in xrange(32)])

	r.sendline(rand)
	resp = r.recvuntil("Stack\n-----")
	if "empty" not in resp and "ip: fuzyll" not in resp:
		print resp, repr(rand)

	r.close()
	time.sleep(.5)

