from idautils import *
from idc import *
from idaapi import *

'''
.text:011D3E5B                 mov     eax, [ebp+cur_chunk_sz]
.text:011D3E5E                 mov     byte ptr [ebx+0Fh], 0
'''

# Eax contains the chunk_size, and ebx contains contents of chunk buffer
# Use a hook to record them for each of the 1000 chunks.

loc_of_interest = 0x8048942

class DbgHook(DBG_Hooks):
    def dbg_bpt(self, tid, ea):
        string = GetString(0x3133a000, True)
        print "[-] string", string

        string = GetString(0x31338000, True)
        print "[-] string", string
        print "[-] Hit brkpt"

debugger = DbgHook() 
debugger.hook()

# idc.AddBpt(loc_of_interest)

# add_bpt(loc_of_interest, 0, BPT_SOFT)
# enable_bpt(loc_of_interest, True)
AddBpt(loc_of_interest)

# 0x8 enables bp, not 0x1 means debugger will not stop at bp
# https://www.hex-rays.com/products/ida/support/idadoc/1076.shtml
SetBptAttr(loc_of_interest, BPTATTR_FLAGS, 0x8) 
