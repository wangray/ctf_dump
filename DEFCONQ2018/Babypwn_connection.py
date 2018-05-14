from pwn import *

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

p = remote("e4771e24.quals2018.oooverflow.io", 31337)
messages = p.recvuntil("Solution:")
messages = messages.split("\n")
challenge = messages[1].split(": ")[1]
n = int(messages[2].split(": ")[1])
print challenge, n

payload = solve_pow(challenge, n)
print "Finish proof of work: ", payload

p.sendline(str(payload))
p.interactive()
