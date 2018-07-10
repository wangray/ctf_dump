import binascii as bs

out = open("binary_cip_data", 'w')
string = open("raw_cip_data", 'r').read()

print string
raw = bs.unhexlify(string)

print raw

out.write(raw)
