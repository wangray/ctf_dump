from pwn import *
import itertools as it
from collections import OrderedDict

mem = open("challenge_dump", 'rb').read() + '\x00'*0x3000

desired_buf = "92 2E 63 75 1D B1 F3 FF FF FF FF FF FF FF FF FF FF FF 00 B0 6D B8 00".replace(" ", "").decode("hex")
cands = ['0', 'w', '}', '5', 'o', '1', 't', '3', '7', 'f', 'i', '?', 'c', 'b', 'd', 'g', 'r', '\n', '.', '2', 'e', 'm', 'n', 'x', '{', 'a', 's', '6', '4', 'h', 'l', 'u', ' ']

curr_outbyte = 0 
shift_ctr = 0
char_mapping = OrderedDict()
for cand in cands:
    char_mapping[cand] = []


def shift_shit(bit, output):
    global curr_outbyte, shift_ctr
    curr_outbyte |= (bit << shift_ctr)

    shift_ctr += 1
    if shift_ctr >= 8:
        # reset shift_ctr and set byte
        shift_ctr = 0
        print "RESETTING byte", hex(curr_outbyte)
        output += chr(curr_outbyte)
        curr_outbyte = 0

    return output

def loop_func(byte_store, tableaddr, output):
    global curr_outbyte, shift_ctr, char_mapping
    print "loop_func tableaddr", hex(tableaddr)
    # byte_store = input_buf[input_idx]
    table_byte = mem[tableaddr:tableaddr+1]

    
    # 0x32
    if table_byte == '\xff':
        # goto 0x347
        # call loop_func again with new tableaddr
        retval, output = loop_func(byte_store, u16(mem[tableaddr+8:tableaddr+10]), output)

        # now 0x35a 
        if retval == 1:
            # goto 0x376
            print "shift_shit 0 ctr", shift_ctr
            new_output = shift_shit(0, output)
            print "shift_shit 0 out:", hex(curr_outbyte)
            char_mapping[byte_store].append(0)
            return 1, new_output
        else:
            # goto 0x389

            print "Calling loopfunc 2, deref", hex(tableaddr+16)
            new_retval, output = loop_func(byte_store, u16(mem[tableaddr+16:tableaddr+18]), output)

            if new_retval == 1:
                # goto 0x3b8
                print "shift_shit 1 ctr", shift_ctr
                new_output = shift_shit(1, output)
                print "shift_shit 1 out:", hex(curr_outbyte)
                char_mapping[byte_store].append(1)
                return 1, new_output
            else:
                return 0 , output
    else:
        # goto 0x400
        # compare bytes 
        print "cmp ", repr(table_byte), repr(byte_store)
        if table_byte == byte_store:
            # goto ret 1
            return 1, output
        else:
            return 0 , output

def process_string(target_str):
    output = ""
    for i in range(len(target_str)):
        print ""

        byte_store = target_str[i]

        retval, output = loop_func(byte_store, 0x1300, output)
        if retval == 0:
            print "WRONG!"
            exit(0)    
    return output

def solve():
    global cands
    cand_pairs = ["".join(i) for i in it.permutations(cands, 2)]


    known_flag = "flag.txt" + "\x00"*92 + '00'*2 + '6'
    # known_flag = ""
    curr_flag_idx = 0
    output = ''
    max_matched_bytes = 0
    cand_matches = set()

    for cand in cand_pairs:
        curr_outbyte = 0 
        shift_ctr = 0

        cand_flag = known_flag+cand

        # process two bytes of input
        candoutput = process_string(cand_flag)
        print "cand", cand
        print "candoutput", candoutput.encode("hex")
        # print "desiredout", desired_buf[:len(candoutput)].encode('hex')

        if len(candoutput) > 0 and desired_buf[:len(candoutput)] == candoutput:
            print 'MATCH!'
            if len(candoutput) > max_matched_bytes:
                print "POTENTIAL CAND MATCH", cand_flag
                print "cand_output", candoutput.encode('hex')
                cand_matches.add(cand_flag)

                # known_flag = cand_flag
                # max_matched_bytes = len(candoutput)
                # break

    print cand_matches

# solve()

# for cand in cands:
out = process_string(" ")
print out.encode("hex")

print char_mapping
