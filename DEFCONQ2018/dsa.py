def dsa_sign(msg, d):
    k_e = random.randint(0, q)
    r = pow(g, k_e, p) % q
    x = bytes2int(hashlib.sha1(msg).digest())

    s = ((x + d*r)*modinv(q, k_e)) % q

    return (r,s)
