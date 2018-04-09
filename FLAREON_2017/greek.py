import socket
import subprocess
import time

# for i in xrange(256):
# 	subprocess.Popen(".\greek_to_me.exe")
# 	s = socket.socket()         # Create a socket object
# 	host = '127.0.0.1' # Get local machine name
# 	port =2222
# 	                # Reserve a port for your service.
# 	s.connect((host, port))

# 	print(i)
# 	s.send(chr(i)*3 + "\r\n")
# 	print s.recv(1000)
# 	s.close()
# 	time.sleep(1)

i = 162
s = socket.socket()         # Create a socket object
host = '127.0.0.1' # Get local machine name
port =2222
                # Reserve a port for your service.
s.connect((host, port))

print(i)
s.send(chr(i)*3 + "\r\n")