#!/usr/bin/python

from pwn import *
from random import choice
from string import ascii_uppercase

# context.log_level = 'debug'


'''
nc hackermud_a7fca6ddb0023d0e08da5ea26876c2ca.quals.shallweplayaga.me 4041
Welcome to hackerMUD!
Proof Challenge Data: 04691e66679ce70eee2ba974f1561cc842bd
Enter Proof of Work Data:
02000000ff280200fb193300bd1b2c00b9b43600101a110097171e0025af0100cce13c009c6718008a2d3e00c9d3050062eb3f00744907004d671900f7dd0c0021a51f00
Login with new user? (y/n) y
Enter new (7-12 c): AAAAAAAAAAAA
Please enter password: AAAAAAAAAAAA
New player successfully created!
Please enter your name: AAAAAAAAAAAA
Please enter password: AAAAAAAAAAAA
Logging in with password digest: 02737e4e8c87d7466b623c1f844fdd71

Root Directory
The root directory of the server, the starting place of this realm

'''

r = remote('hackermud_a7fca6ddb0023d0e08da5ea26876c2ca.quals.shallweplayaga.me', 4041)
r.recvuntil('Data: ')
chal_data = r.recvuntil('\n').strip()
print "Challenge Data: {}\n".format(chal_data)


p = process('./proof_tool')
p.recvuntil(": ")
p.sendline(chal_data)
p.recvuntil('data: ')
resp_data = p.recvuntil('\n').strip()
p.close()
print "Response Data: {}\n".format(resp_data)

userpass = ''.join(choice(ascii_uppercase) for i in range(12))
print "userpass: {}".format(userpass)
r.recvuntil('Data: ')
r.sendline(resp_data)
r.recvuntil('(y/n) ')
r.sendline('y')
r.recvuntil('c): ')
r.sendline(userpass)
r.recvuntil('password: ')
r.sendline(userpass)
r.recvuntil('name: ')
r.sendline(userpass)
r.recvuntil('password: ')
r.sendline(userpass)


r.interactive()
