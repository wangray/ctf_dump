
f = open('keygen_elf', 'rb').read()
out = open('keygen_elf_patched', 'wb')
new_f = f.replace("\xcc\xc3", '\x90\x90').replace("\xcc\xeb\xfe", "\x90\x90\x90").replace("E82BFBFFFF".decode('hex'), "\x90"*5)
new_f = new_f.replace("E880FCFFFF".decode('hex'), "\x90"*5) # exit
new_f = new_f.replace("e0fe".decode('hex'), "\x90"*2) # inf loop on self


out.write(new_f)
out.close()
