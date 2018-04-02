from pwn import *
import pprint
from z3 import *

f = open("./seccomp_arg1_check").readlines()

class BPFInstr():
    def __init__(self, opcode, jt, jf, k, opcode_h, args_h):
        self.opcode = opcode 
        self.k = int(k, 16)
        self.jt = int(jt, 16)
        self.jf = int(jf, 16)
        self.opcode_h = opcode_h
        self.args_h = args_h

    def __str__(self):
        return "op: %s jt: %#02x jf: %#02x k: %#02x opcode_h: %s %s" % (self.opcode, self.jt, self.jf, self.k, self.opcode_h, self.args_h)

lines = [line.strip() for line in f if not ';' in line and not line == '\n']

opcodes = set()
asm = []
for line in lines:
    line = line.split("   ")
    raw_bytes = line[0].split()
    disasm = line[1].split()
    # print disasm
    
    bpf =  BPFInstr(raw_bytes[1], raw_bytes[2], raw_bytes[3], raw_bytes[4], disasm[0], disasm[1:])
    print bpf
    asm.append(bpf)

    opcodes.add((bpf.opcode, bpf.opcode_h))


# pprint.pprint(opcodes)


'''
set([('0x00', 'ld'),
     ('0x01', 'ldx'),
     ('0x02', 'st'),
     ('0x03', 'stx'),
     ('0x04', 'add'),
     ('0x06', 'ret'),
     ('0x07', 'tax'),
     ('0x0c', 'add'),
     ('0x15', 'jeq'),
     ('0x20', 'ld'),
     ('0x24', 'mul'),
     ('0x34', 'div'),
     ('0x54', 'and'),
     ('0x60', 'ld'),
     ('0x61', 'ldx'),
     ('0x74', 'rsh'),
     ('0x84', 'neg'),
     ('0x87', 'txa'),
     ('0xac', 'xor')])
'''

def execute(asm):
    global s, a, x, w1, w2, w3, w4
    # for instr in asm:
    pc = 0
    a_reg = 0 
    x_reg = 0

    temp = [0x7b6e, 0xffff, 0xffad, 0xfd21, 0, 0]
    # temp = [w1, w2, w3, w4, 0, 0]

    # init_arg = [ 0x7b6e6f63, 0x74696868]

    while pc < len(asm):
        print "pc: ", pc
        instr = asm[pc]
        if instr.opcode_h == "ld":
            # Check if it's a 
            # if instr.opcode == '0x20':
            #     # load from argument
            #     a_reg = init_arg[(instr.k - 0x10)/4]
            if instr.opcode == '0x00':
                # load immediate
                a_reg = instr.k
                a = instr.k
            elif instr.opcode == '0x60':
                a_reg = temp[instr.k]
            else:
                print "Invalid load"

        elif instr.opcode_h == "ldx":
            if instr.opcode == '0x01':
                # load immediate
                x_reg = instr.k
            elif instr.opcode == '0x61':
                x_reg = temp[instr.k]
            else:
                print "Invalid loadx"

        elif instr.opcode_h == "st":
            print "Store to temp ", instr.k
            temp[instr.k] = a_reg

        elif instr.opcode_h == "stx":
            print "Store x to temp ", instr.k
            temp[instr.k] = x_reg

        elif instr.opcode_h == "add":
            # Check if against x register or immediate
            if instr.opcode == '0x0c':
                a_reg = a_reg + x_reg
            else: 
                a_reg = a_reg + instr.k

        elif instr.opcode_h == "mul":
            a_reg = a_reg * instr.k
            
        elif instr.opcode_h == "div":
            a_reg = a_reg/instr.k

        elif instr.opcode_h == "ret":
            if instr.args_h[0] == 'KILL':
                print "U GOT KILLED! pc: ", pc
                pprint.pprint([hex(s) for s in temp])
                return pc
            else: 
                print "U WON"
                return pc

        elif instr.opcode_h == "tax":
            x_reg = a_reg
        
        elif instr.opcode_h == "txa":
            a_reg = x_reg

        elif instr.opcode_h == "jeq":
            # This is an immediate jeq
            if a_reg == instr.k:
                # take true branch 
                pc += instr.jt
            else: 
                pc += instr.jf

        elif instr.opcode_h == "rsh":
            a_reg = a_reg >> instr.k

        elif instr.opcode_h == "xor":
            # Careful, this will xor against the X reg, not the immediate value...
            a_reg = a_reg ^ x_reg
            
        elif instr.opcode_h == "and":
            a_reg = a_reg & instr.k
            
        elif instr.opcode_h == "neg":
            a_reg = ~a_reg
        
        else:
            print "U FUCKED UP UNHANDLED INSTRUCTION: ", instr

        # increment PC
        pc += 1


    pprint.pprint([hex(s) for s in temp])
    print "a: ", a_reg
    print "x: ", x_reg 



execute(asm)

# w1, w2, w3, w4 = BitVecs('w1 w2 w3 w4', 32)
# a, x = BitVecs('a x', 32)

# s = z3.Solver()


# def execute(asm):
#     global s, a, x, w1, w2, w3, w4
#     # for instr in asm:
#     pc = 0

#     # temp = [0x7b6e, 0xffff, 0xffad, 0xfd21, 0, 0]
#     temp = [w1, w2, w3, w4, 0, 0]

#     # init_arg = [ 0x7b6e6f63, 0x74696868]

#     while pc < len(asm):
#         print "pc: ", pc
#         instr = asm[pc]
#         if instr.opcode_h == "ld":
#             # Check if it's a 
#             # if instr.opcode == '0x20':
#             #     # load from argument
#             #     a_reg = init_arg[(instr.k - 0x10)/4]
#             if instr.opcode == '0x00':
#                 # load immediate
#                 # a_reg = instr.k
#                 s.add(a == instr.k)
#             elif instr.opcode == '0x60':
#                 # a_reg = temp[instr.k]
#                 s.add(a == temp[instr.k])
#             else:
#                 print "Invalid load"

#         elif instr.opcode_h == "ldx":
#             if instr.opcode == '0x01':
#                 # load immediate

#                 s.add(x_reg == instr.k)
#             elif instr.opcode == '0x61':
#                 s.add(x_reg = temp[instr.k])
#             else:
#                 print "Invalid loadx"

#         # elif instr.opcode_h == "st":
#         #     print "Store to temp ", instr.k
#         #     temp[instr.k] = a_reg

#         # elif instr.opcode_h == "stx":
#         #     print "Store x to temp ", instr.k
#         #     temp[instr.k] = x_reg

#         # elif instr.opcode_h == "add":
#         #     # Check if against x register or immediate
#         #     if instr.opcode == '0x0c':
#         #         a_reg = a_reg + x_reg
#         #     else: 
#         #         a_reg = a_reg + instr.k

#         # elif instr.opcode_h == "mul":
#         #     a_reg = a_reg * instr.k
            
#         # elif instr.opcode_h == "div":
#         #     a_reg = a_reg/instr.k

#         elif instr.opcode_h == "ret":
#             if instr.args_h[0] == 'KILL':
#                 print "U GOT KILLED! pc: ", pc
#                 pprint.pprint([hex(s) for s in temp])
#                 return pc
#             else: 
#                 print "U WON"
#                 return pc

#         # elif instr.opcode_h == "tax":
#         #     x_reg = a_reg
        
#         # elif instr.opcode_h == "txa":
#             # a_reg = x_reg
        
#         elif instr.opcode_h == "jeq":
#             # This is an immediate jeq
#             if a_reg == instr.k:
#                 # take true branch 
#                 pc += instr.jt
#             else: 
#                 pc += instr.jf

#         # elif instr.opcode_h == "rsh":
#         #     a_reg = a_reg >> instr.k

#         elif instr.opcode_h == "xor":
#             # Careful, this will xor against the X reg, not the immediate value...
#             a_reg = a_reg ^ x_reg
#             s.add(a == a ^ x)
            
#         # elif instr.opcode_h == "and":
#         #     a_reg = a_reg & instr.k
            
#         # elif instr.opcode_h == "neg":
#             # a_reg = ~a_reg
        
#         else:
#             print "U FUCKED UP UNHANDLED INSTRUCTION: ", instr

#         # increment PC
#         pc += 1

#     pprint.pprint([hex(s) for s in temp])
#     print "a: ", a_reg
#     print "x: ", x_reg 


# execute(asm)

# s.add(execute(asm) == 5)

# s.check()

# print s.model()

