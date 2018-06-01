import sys
import gmpy2


target = int(sys.argv[1], 16)
nextprime = target
while True:
    nextprime = gmpy2.next_prime(nextprime)
    if gmpy2.is_prime(nextprime-target):
        print "Found", hex(nextprime), hex(nextprime-target)
        break
