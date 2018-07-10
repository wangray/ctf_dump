FROM ubuntu:16.04

RUN dpkg --add-architecture i386 && apt-get -qy update && apt-get -qy install libc6:i386 nginx-extras ssl-cert && rm -rf /var/lib/apt/lists/*

COPY nginx.conf /etc/nginx/nginx.conf
COPY nginx_site_default.cfg /etc/nginx/conf.d/default.conf

EXPOSE 80
EXPOSE 443

COPY server /usr/local/bin/server
RUN chmod 755 /usr/local/bin/server
CMD nginx; /usr/local/bin/server

