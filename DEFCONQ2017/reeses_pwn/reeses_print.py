from pwn import *

def getfile(filename):
	fd = open(filename, "r")
	contents = fd.read()
	fd.close()
	return contents


mipsfile = "sample2"

contents = getfile(mipsfile)
print p32(len(contents))
print contents
