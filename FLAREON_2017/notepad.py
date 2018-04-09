from z3 import *

s = "XQ2eLZ.dl"
desired = 0x8fecd63f

final_val = 0
for char in s:
        final_val = ord(char) + ((final_val << 19) | (final_val >> 13)) & 0xffffffff
        print(hex(final_val))

p, q, r, t, u, v, w, x, y, z = BitVecs('p q r t u v w x y z', 64)

c1, c2, c3, c4, c5,c6,c7,c8,c9,c10,c11 = BitVecs("c1 c2 c3 c4 c5 c6 c7 c8 c9 c10 c11", 64)


.add(c9 + (q << 19 | q >> 13) & 0xffffffff == r)
s.add(c8 + (r << 19 | r >> 13) & 0xffffffff == t)
s.add(c7 + (t << 19 | t >> 13) & 0xffffffff == u)
s.add(c6 + (u << 19 | u >> 13) & 0xffffffff == v)
s.add(c5 + (v << 19 | v >> 13) & 0xffffffff == w)
s.add(c4 + (w << 19 | w >> 13) & 0xffffffff == x)
s.add(c3 + (x << 19 | x >> 13) & 0xffffffff == y)
s.add(c2 + (y << 19 | y >> 13) & 0xffffffff == z)
s.add(c1 + (z << 19 | z >> 13) & 0xffffffff == 0x8fecd63f)

s.add(c1 == 0x6C) # l
s.add(c2 == 0x6C) # l
s.add(c3 == 0x64) # d
s.add(c4 == 0x2e) # .


# s.add(c1 >= 32)
# s.add(c2 >= 32)
# s.add(c3 >= 32)
# s.add(c4 >= 32)
# s.add(c5 >= 0x41)
# s.add(c6 >= 0x41)
# s.add(c7 >= 0x41)
# s.add(c8 >= 0x41)
# s.add(c9 >= 0x41)
s.add(Or(And(0x41 <= c5, 0x5a >= c5), And(0x30 <= c5, 0x39 >= c5), And(0x61 <= c5, 0x7a >= c5)))
s.add(Or(And(0x41 <= c6, 0x5a >= c6), And(0x30 <= c6, 0x39 >= c6), And(0x61 <= c6, 0x7a >= c6)))
s.add(Or(And(0x41 <= c7, 0x5a >= c7), And(0x30 <= c7, 0x39 >= c7), And(0x61 <= c7, 0x7a >= c7)))
s.add(Or(And(0x41 <= c8, 0x5a >= c8), And(0x30 <= c8, 0x39 >= c8), And(0x61 <= c8, 0x7a >= c8)))
s.add(Or(And(0x41 <= c9, 0x5a >= c9), And(0x30 <= c9, 0x39 >= c9), And(0x61 <= c9, 0x7a >= c9)))
s.add(Or(And(0x41 <= c10, 0x5a >= c10), And(0x30 <= c10, 0x39 >= c10), And(0x61 <= c10, 0x7a >= c10)))
s.add(Or(And(0x41 <= c11, 0x5a >= c11), And(0x30 <= c11, 0x39 >= c11), And(0x61 <= c11, 0x7a >= c11)))

# s.add((c5 >= 32 and 0x5a > c5) or (0x30 <= c5 and 0x40 > c5))
# s.add((c6 >= 32 and 0x5a > c6) or (0x30 <= c6 and 0x40 > c6))
# s.add((c7 >= 32 and 0x5a > c7) or (0x30 <= c7 and 0x40 > c7))
# s.add((c8 >= 32 and 0x5a > c8) or (0x30 <= c8 and 0x40 > c8))
# s.add((c9 >= 32 and 0x5a > c9) or (0x30 <= c9 and 0x40 > c9))

# s.add()
# s.add(0x5a > c6)
# s.add(0x5a > c7)
# s.add(0x5a > c8)
# s.add(0x5a > c9)

# s.add(127 > c4)
# s.add(127 > c1)
# s.add(127 > c2)
# s.add(127 > c3)

print(s.check())
sats = s.model()
chars = [sats[c1],sats[c2],sats[c3],sats[c4],sats[c5],sats[c6],sats[c7],sats[c8],sats[c9], sats[c10]][::-1]
print(chars)

name = ''.join([chr(int(str(w))) for w in chars])
print(name)
