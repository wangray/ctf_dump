#!/usr/bin/env python2
from pwn import *

def readMoves():
    with open('./moves.txt', 'r') as f:
        return [move[:2] for move in f]

def doMove(p, mv):
    p.recvuntil('Your move (q to quit):')
    p.sendline(mv)


def main():
    moves = readMoves()
    print moves
    # p = process('./pegem')
    p = remote("pegem_d144a0fa24a0fc17809d4f56600bc740.quals.shallweplayaga.me", 1234)
    for mv in moves:
        doMove(p, mv)
    p.interactive()

if __name__ == "__main__":
    main()
