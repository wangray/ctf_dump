import struct
from z3 import *

d = open('seccomp_bpf', 'rb').read() # bpf binary path
clss = [
'LD', 'LDX', 'ST', 'STX', 'ALU', 'JMP', 'RET', 'MISC'
]
imm = lambda x: '$' + hex(x)
abs = {
	0: 0x1337
}
mem = [0] * 16
for i in range(4):
	abs[0x10+i*4] = mem[i] = x = ZeroExt(16, BitVec('a%d' % i, 16))

orig = list(mem)

records = []
for i in range(0, len(d), 8):
	x = struct.unpack("<HBBL", d[i:i+8])
	records.append(x)
addr = 0x0005D+14, 0x000BB+14, 0x00119+14, 0x00177+14, 0x001D5+14, 0x00233+14, 0x00291+14, 0x2a3, 0x002EF+14, len(records)
values = None
for i in range(len(addr) - 2):
	solver = Solver()
	start = addr[-2-i]
	end = addr[-1-i]
	print hex(start), hex(end)
	i = start
	while i < end:
		code, jt, jf, k = records[i]
		cls = code & 7
		cls = clss[cls]
		if i > 0x32d:
			break
		print '%05X:' % (i),
		if cls in ('LD', 'LDX'):
			is_A = cls == 'LD'
			cls += 'WHB'[(code >> 3) & 3]
			print cls,
			mode = ['IMM', 'ABS', 'IND', 'MEM', 'LEN', 'MSH'][code >> 5]
			if mode == 'IMM':
				print imm(k),
				r = k
			elif mode in ('ABS', 'MEM'):
				print mode, '[' + hex(k) + ']',
				r = abs[k] if mode == 'ABS' else mem[k]
			else:
				print mode
				exit()
			if cls[-1] == 'H':
				cls = Extract(15, 0, cls)
			elif cls[-1] == 'B':
				exit()
			if is_A:
				A = r
			else:
				X = r
		elif cls in ('ST', 'STX'):
			print cls, '[0x%x]' % k,
			r = A if cls == 'ST' else X
			assert code >> 3 & 3 == 0
			mem[k] = r
		elif cls == 'ALU':
			op = code >> 4
			subop = ['+', '-', '*', '/', '|', '&', '<<', '>>', '~', '%', '^'][op]
			op = ['ADD', 'SUB', 'MUL', 'DIV', 'OR', 'AND', 'LSH', 'RSH', 'NEG', 'MOD', 'XOR'][op]
			x = A
			src = code & 8 != 0
			if src:
				y = X
			else:
				y = k
			if op != 'NEG':
				print op, 'A,',
				if src == True: # K
					print imm(k),
				else:
					print 'X',
				if len(subop) == 1:
					r = eval('%s %s %s' % ('x', subop, 'y'))
				else:
					if subop == 'LSH':
						r = x << y
					elif subop == 'RSH':
						r = LShR(x, y)
				A = r
			else:
				print 'NEG', 'A',
				A = ~A
			# print '#', subop,
		elif cls == 'JMP':
			op = code >> 4
			op = ['JA', 'JEQ', 'JGT', 'JGE', 'JSET', ][op]
			assert jf == 0 or jt == 0
			print op, imm(k) + ',',
			x = A
			y = k if code & 8 == 0 else X
			if op == 'JA':
				cond = True
			elif op == 'JEQ':
				cond = x == y
			elif op == 'JGT':
				cond = x > y
			elif op == 'JGTE':
				cond = x >= y
			elif op == 'JSET':
				cond = x & y != 0
			if jt != 0:
				print imm(jt),
				if records[i+1][0] == 6:
					solver.add(cond)
			else:
				print 'NOT', imm(jf),
			i += max(jt, jf)
		elif cls == 'MISC':
			if code & 0xf8 == 0:
				print 'TAX',
				X = A
			else:
				print 'TXA',
				A = X
		elif cls == 'RET':
			val = 'KXA'[(code >> 3) & 3]
			print cls,
			if val == 'K':
				print imm(k),
			else:
				print val,
			print 'wtf'
			exit()
		else:
			print cls,
			exit()
		print
		i += 1

	if values:
		for i in range(4):
			solver.add(mem[i] == values[i])
	print solver.check()
	model = solver.model()
	for i in range(4):
		z = model.eval(orig[i]).as_long()
		print i, hex(z)
	while True:
		values = [model.eval(orig[i]).as_long() for i in range(4)]
		print values
		solver.add(Or(*[x==y for x, y in zip(orig, values)]))
		print solver.check()
	solver = Solver()
	for i in range(4):
		abs[0x10+i*4] = mem[i] = ZeroExt(16, BitVec('a%d' % i, 16))
	import pdb
	pdb.set_trace()
	A = X = None
	orig = list(mem)
