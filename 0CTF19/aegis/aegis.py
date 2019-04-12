from pwn import *

# context.log_level = "debug"
context.terminal = ['tmux', 'splitw', '-h']

if len(sys.argv) > 1 and sys.argv[1] == 'remote':
    pass
else:
    p = process("./aegis")
    if len(sys.argv) > 1 and sys.argv[1] == 'gdb':
        gdb.attach("aegis", """
              set disassembly-flavor intel
               """)

               # b main
               # b add_note
               # b show_note
               # b update_note
               # b delete_note

def add(size, content, noteid):
    p.recvuntil("Choice: ")
    p.sendline("1")
    p.recvuntil("Size: ")
    p.sendline(str(size))
    p.recvuntil("Content:")
    p.send(content)  
    p.recvuntil("ID:")
    p.sendline(noteid)

def update(index, content, noteid):
    p.recvuntil("Choice: ")
    p.sendline("3")
    p.recvuntil("Index: ")
    p.sendline(str(index))
    p.recvuntil("Content:")
    p.send(content)  
    p.recvuntil("ID:")
    p.sendline(noteid)

def magic(addr):
    p.recvuntil("Choice: ")
    p.sendline("666")
    p.recvuntil("Number: ")
    p.sendline(str(addr))



def delete(index):
    p.recvuntil("Choice: ")
    p.sendline("4")
    p.recvuntil("Index: ")
    p.sendline(str(index))

def show(index):
    p.recvuntil("Choice: ")
    p.sendline("2")
    p.recvuntil("Index: ")
    p.sendline(str(index))
    return p.recvuntil("=====")

add(16, "A"*8, 'B'*8)
update(0,"A"*8, 'B'*8)
print show(0)





