import angr
import claripy
import simuvex
import IPython


goal = 0x7b7
avoid = 0xe93

def solve():
    proj = angr.Project("crackme1")

    pg = proj.factory.path_group()

    pg.explore(find=goal, avoid = avoid)
    IPython.embed()
    return pg.found[0].state.posix.dumps(0).split('\0')[0] # stdin


if __name__ == "__main__":
    print solve()
