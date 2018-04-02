import os, base64, time, random, string
from Crypto.Cipher import AES
from Crypto.Hash import *
from pwn import *
import itertools

p = remote("localhost", 31337)
# context.log_level = "debug"

global_iv = '2jpmLoSsOlQrqyqE'

def pad(msg):
    pad_length = 16-len(msg)%16
    return msg+chr(pad_length)*pad_length

def send_msg(this_iv, msg):
    encoded_msg = base64.b64encode(this_iv + msg)
    # print "encoded_msg", encoded_msg
    p.sendline(encoded_msg)

    rec = p.recvline().strip()
    return base64.b64decode(rec)[16:]

welcome = p.recvline().strip()

welcome_ctext = base64.b64decode(welcome)[16:]

cmd_not_found_ctext = send_msg(global_iv, pad('doesntmatter'))

def send_ptext(ptext):
    forged_iv = xor(ptext, pad("Welcome!!"), global_iv)[:16]
    return send_msg(forged_iv, welcome_ctext[:16])


# resp = send_ptext("hitcon{" + "\x00")
# print "resp2", repr(resp)

flag_ctext = send_ptext(pad("get-flag"))
print "flag_ctext", repr(flag_ctext)
print "flag_ctext len", len(flag_ctext)

last_bytes = {}

def get_block1_byte_padding(known, padbyte):
    print "padbyte", repr(padbyte)
    for j in xrange(256):    
        # Outer loop is to guess a padding byte
        for i in xrange(128):
                c = chr(i)
                forged_iv = xor("get-sha1" + 'A'*7 + padbyte, known + c + 'A'*7 + chr(j), global_iv)[:16]

                get_sha_ctext = send_msg(forged_iv, flag_ctext[:16])

                if get_sha_ctext != cmd_not_found_ctext:
                    print "c", c
                    print "j", chr(j)

                    # We found all the possible j's that give a small enough padding byte at the end of the 1st block
                    return c, chr(j)

def get_block1_byte(known):
    assert len(known) == 7

    c, j = get_block1_byte_padding(known, '\x08')

    # last_bytes[padding] = chr to get the padding

    return c, j

flag = "hitcon{"

next_byte, block1_last_byte = get_block1_byte(flag)
flag += next_byte
print "flag", flag

print block1_last_byte

pairs = ["".join(chrs) for chrs in itertools.permutations(string.printable, 2)]

def get_block1_bytes_89():
    for pair in pairs:
        forged_iv = xor("get-sha256" + 'A'*5 + '\x06', flag + pair + 'A'*5 + block1_last_byte, global_iv)[:16]

        get_sha_ctext = send_msg(forged_iv, flag_ctext[:16])

        if get_sha_ctext != cmd_not_found_ctext:
            return pair
        
# next_bytes = get_block1_bytes_89()
# flag += next_bytes
# print "flag", flag
# We now have 10 bytes of flag

# flag  = "hitcon{P4d"

# # Build up hash table of encrypted Sha256's 
# sha256_table = {}
# for i in xrange(5):
#     for j in xrange(128):    
#         desired = "get-sha256" + 'A'*i + chr(j) + chr(5-i)*(5-i)
#         assert len(desired) == 16

#         forged_iv = xor(desired, 'command not foun', global_iv)[:16]
#         get_sha_ctext = send_msg(forged_iv, cmd_not_found_ctext[:16])

#         sha256_table[get_sha_ctext] = 'A'*i + chr(j)

# # Determine rest of 1st block
# for i in xrange(5):
#     desired = "get-sha256" + 'A'*i + '\x00' + chr(5-i)*(5-i)
#     assert len(desired) == 16

#     forged_iv = xor(desired, flag + '\x00' + block1_last_byte*(5-i), global_iv)[:16]
#     get_sha_ctext = send_msg(forged_iv, flag_ctext[:16])

#     next_byte = sha256_table[get_sha_ctext][-1]
#     print next_byte
#     flag += next_byte
#     print "flag", flag

# Now, use the IV as ctext and see what the corresponding ptext is
iv_ptext = send_msg('\x01'*16, global_iv)
print iv_ptext

