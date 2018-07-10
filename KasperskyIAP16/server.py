''
' flag: CAC92217938C1EF937D7879B874B05C6 '
''
import tornado.ioloop
import tornado.web
import re
import sys
import custom_crypt
import logging

logging.basicConfig(
    format='%(name)-15s: %(levelname)-8s [%(asctime)s] %(message)s', level=0, filename=r'private/server.log')


class BaseHandler(tornado.web.RequestHandler):


	def _handle_request_exception(self, e):
		self.write_error(
	    400, exc_info=sys.exc_info())


class MainHandler(BaseHandler):


	def get(self): self.write("Let's start")


class DownloadHandler(BaseHandler):


	def get(self):
		filename = self.request.arguments.get('filename')
		if filename:
		    m = re.match('[a-zA-Z0-9._ -]+', filename[0], re.I)
		    with open(m and m.group(), 'r') as f:
		        self.write(f.read())

		else:
		self.write('filename missed')


class LoginHandler(BaseHandler):


	def get(self): l = list() for param in ['username', 'password']: p = param in self.request.arguments and self.request.arguments[param][0]
	if not p:
	    self.write('%s missed' % param) return l.append(p)
	if custom_crypt.calc_hash(0, ':'.join(l)) == 0x582A05B50FECDD71:
	    with open(r 'private/mit_flag_2017.txt', 'r') as f:
	        self.write(f.read())

	else:
	self.write('login failed')


class VersionHandler(BaseHandler):


	def get(self): self.write("v1.1")


class HelpHandler(BaseHandler):


	def get(self): self.write("no help. Sorry :-(")

if __name__ == "__main__":
    app = tornado.web.Application([(r "/download", DownloadHandler), (r "/login", LoginHandler), (r "/version", VersionHandler), (r "/help", HelpHandler), ], default_handler_class=MainHandler, serve_traceback=True)
    app.listen(80)
    tornado.ioloop.IOLoop.current().start()
