run: .botserver
	sudo docker run -p 8080:80 -p 8443:443  -ti --rm botserver

.botserver:
	sudo docker build --rm . -t botserver
	touch $@

