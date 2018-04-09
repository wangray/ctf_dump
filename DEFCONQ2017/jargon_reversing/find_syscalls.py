from pwn import *
from jargon_array import arr

# for char in xrange(0xb1, 0xc0):
# 	for in_char in xrange(0xb0, 0xc0):
# 		r = remote("jargon_theanswertolifetheuniverseandeverything.quals.shallweplayaga.me",12000)

# 		r.sendline("4") # send number of bytes

# 		# rand = "".join([chr(random.randint(0, 255)) for i in xrange(32)])
# 		string = chr(char) + chr(in_char) + "\x84\xa0"
# 		print repr(string)

# 		r.sendline(string)
# 		resp = r.recvuntil("Stack\n-----")
# 		if "not implemented" not in resp:
# 			print resp

# 		r.close()
		# time.sleep(.5)

new_arr = arr

# for char in xrange(0xb0, 0xc0):
# 	for in_char in xrange(0xb0, 0xc0):
# 		r = remote("jargon_theanswertolifetheuniverseandeverything.quals.shallweplayaga.me",12000)

# 		r.sendline("3") # send number of bytes

# 		# rand = "".join([chr(random.randint(0, 255)) for i in xrange(32)])
# 		string = chr(char) + chr(in_char) + "\x2a"
# 		print repr(string)

# 		r.sendline(string)
# 		resp = r.recvuntil("Stack\n-----")

# 		if "not implemented" not in resp:
# 			print resp		
# 		else:
# 			start = resp.find("Syscall ")
# 			end = resp.find("is", start)

# 			syscall_name = resp[start + len("Syscall "): end]

# 			if syscall_name in new_arr:
# 				new_arr.remove(syscall_name)

# 		r.close()
# 		time.sleep(.1)

for char in xrange(0, 256):
	r = remote("jargon_theanswertolifetheuniverseandeverything.quals.shallweplayaga.me",12000)

	r.sendline("3") # send number of bytes

	# rand = "".join([chr(random.randint(0, 255)) for i in xrange(32)])
	string = chr(char) + chr(in_char) + "\x2a"
	print repr(string)

	r.sendline(string)
	resp = r.recvuntil("Stack\n-----")

	if "not implemented" not in resp:
		print resp		
	else:
		start = resp.find("Syscall ")
		end = resp.find("is", start)

		syscall_name = resp[start + len("Syscall "): end]

		if syscall_name in new_arr:
			new_arr.remove(syscall_name)

	r.close()
	time.sleep(.1)


print new_arr
print len(new_arr)