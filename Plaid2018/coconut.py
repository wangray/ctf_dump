from pwn import * 

p = remote("coconut.chal.pwning.xxx", 6817)

prompt = p.recvuntil("Note: Line numbers")
prompt += p.recvuntil(":")
print(prompt)

while True:
    func = prompt[prompt.index("myfunction:") + len("myfunction:"):prompt.index("<<<EOF>>>")].strip()
    threshold = int(prompt.split("<=")[2].split(":")[0])
    low = int(prompt.split(">=")[1].split(" and")[0])
    print "threshold", threshold
    print "low", low
    # print func

    # func = """
    # 3   pushq   %rbp
    # 4   movq    %rsp, %rbp
    # 5   movl    $1930534792, -20(%rbp)
    # 6   movl    $-643475228, -16(%rbp)
    # 7   movl    -16(%rbp), %eax
    # 8   movl    -20(%rbp), %edx
    # 9   andl    %edx, %eax
    # 10  movl    %eax, -12(%rbp)
    # 11  movl    -16(%rbp), %eax
    # 12  movl    %eax, -8(%rbp)
    # 13  movl    -8(%rbp), %eax
    # 14  movl    -20(%rbp), %edx
    # 15  xorl    %edx, %eax
    # 16  movl    %eax, -4(%rbp)
    # 17  movl    -8(%rbp), %eax
    # 18  popq    %rbp
    # 19  ret"""

    func = [f.split() for f in func.strip().split("\n")]
    maxlines = int(func[-1][0])-1

    # Start from back, usedefs
    func = func[::-1]

    uses = set()

    defs = set()
    defs.add("%eax")

    marked_lines = []

    for line in func: 
        linenum = line[0]
        instr = line[1]

        if instr == "ret" or instr == "popq" or instr == "pushq" or instr == "leave":
            continue

        rest = line[2:]
        # args = rest.split(', ') 
        src = rest[0][:-1]
        dest = rest[1]
        # print "src", src, "dest", dest

        if instr == "movl":
            if dest in defs:
                defs.remove(dest)
                defs.add(src)
                marked_lines.append(linenum)
        elif instr == "leal":
            src = src.replace("(", "").replace(")", "").split(",")
            src1 = src[0]
            src2 = src[1]
            if dest in defs:
                defs.remove(dest)
                defs.add(src1)
                defs.add(src2)
                marked_lines.append(linenum)
        else:
            if dest in defs:
                # defs.remove(dest)
                # defs.add(s)
                marked_lines.append(linenum)
                defs.add(src)

    marked_lines = sorted([int(ln) for ln in marked_lines])
    print "marked_lines", len(marked_lines)
    # print "marked_lines", marked_lines

    payload = ""
    start = None
    last = None
    for i in range(low, threshold):
        if i in marked_lines:
            if start != None:
                if last == None:
                    payload += '{}\n'.format(start)
                else:
                    payload += '{}-{}\n'.format(start, last)
            start = None
            last = None
            continue

        if start == None:
            start = i
        else:
            last = i
    if start != None:
        if last == None:
            payload += '{}\n'.format(start)
        else:
            payload += '{}-{}\n'.format(start, last)

    payload += "#\n"
    print payload
    p.send(payload)

    prompt = p.recvuntil("Note: Line numbers")
    prompt += p.recvuntil(":")
    # print(prompt)

# p.sendline("#") 
# p.interactive()

