from pwn import *


r = remote("2018shell2.picoctf.com", 57775)
print r.recvuntil(">")
captcha = raw_input().strip()
r.sendline(captcha)
print r.recvuntil("Commence HTTP.\n\n")

# r.send("""GET /login HTTP/1.1\r\nHost: flag.local\n\n\n""")
payload = """POST /login HTTP/1.1\r\nHost: flag.local\r\nContent-Type: application/x-www-form-urlencoded\r\n\r\npass=potoooooooo&user=realbusinessuser\r\n"""
print payload
r.send(payload)

print r.recvall()
