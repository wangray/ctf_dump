from pwn import *

f = open('test1.script', 'r')

lines = f.read()

# print lines


lines = lines.replace('S', '1')
lines = lines.replace('B', '1')
lines = lines.replace('A', '1')
lines = lines.replace('N', '1')
lines = lines.replace('s', '0')
lines = lines.replace('b', '0')
lines = lines.replace('a', '0')
lines = lines.replace('n', '0')

orig_lines = lines
print lines

lines = lines.split("\r\n")

for line in lines:
    sytes = line.split(" ")
    # print sytes
    # print int(syte)
    for syte in sytes:
        if syte != "":
            # print(chr(int(syte[::-1], 2)))
            orig_lines = orig_lines.replace(syte[::-1], chr(int(syte, 2)))

# print orig_lines


