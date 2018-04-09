from pwn import *
import time
import random
hexdigs = '0123456789abcdef'

val_array = []

for char in xrange(0xf0, 0x100):
	for j in xrange(0, 255, 16):
		r = remote("jargon_theanswertolifetheuniverseandeverything.quals.shallweplayaga.me",12000)

		r.sendline("2") # send number of bytes

		# rand = "".join([chr(random.randint(0, 255)) for i in xrange(32)])
		string = chr(char) + chr(j)
		print repr(string)

		r.sendline(string)
		resp = r.recvuntil("Stack\n-----")
		start = resp.find("murphy's law")
		end = resp.find("\n", start)

	# if "empty" not in resp and "ip: fuzyll" not in resp:
		val = resp[start + len("murphy's law "): end]
		print val
		val_array.append(val)

		r.close()
		time.sleep(.25)

print val_array

# for char in xrange(0x0, 0xf):
# 	r = remote("jargon_theanswertolifetheuniverseandeverything.quals.shallweplayaga.me",12000)

# 	r.sendline("2") # send number of bytes

# 	# rand = "".join([chr(random.randint(0, 255)) for i in xrange(32)])
# 	string = chr(char) + "\xa0"
# 	print repr(string)

# 	r.sendline(string)
# 	resp = r.recvuntil("Stack\n-----")
# # if "empty" not in resp and "ip: fuzyll" not in resp:
# 	print resp

# 	r.close()
# 	time.sleep(.5)
