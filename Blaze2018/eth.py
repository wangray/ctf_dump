from ethjsonrpc import EthJsonRpc  # to use Parity-specific methods, import ParityEthJsonRpc
import binascii 

c = EthJsonRpc("something.420blaze.in", 8545)
print c.net_version()

chars = [""]*256
for i in range(500):
  tx = c.eth_getBlockByNumber(i, True)

  if len(tx['transactions']) > 1:
      inp = binascii.unhexlify(tx['transactions'][0]['input'][2:])
      if 'character' in inp:
        index = ord(inp.split("\xd1\xd1>\xbf\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00")[1][0])

        char = inp.split("character: ")[1][0]
        print index, char
        chars[index] = char 

print "".join(chars)





  