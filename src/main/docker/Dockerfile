FROM anapsix/alpine-java:jre8
MAINTAINER hugo.costa.tek@gmail.com

ENV HOME /var/lib/account-service-api
ENV JARFILE /var/lib/account-service-api/app.jar

VOLUME /var/lib/account-service-api

COPY account-service-api.jar /var/lib/account-service-api/app.jar

RUN chmod 500 /var/lib/account-service-api/app.jar

COPY docker-entrypoint.sh /entrypoint.sh

RUN chmod 500 /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]