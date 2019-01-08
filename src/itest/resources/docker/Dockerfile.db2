FROM ibmcom/db2express-c:latest

EXPOSE 50000

WORKDIR /home/db2inst1

ADD db-init.sh /home/db2inst1

ENV DB2INST1_PASSWORD db2inst1-pwd
ENV LICENSE accept

RUN ["chmod", "+x", "/home/db2inst1/db-init.sh"]
RUN su - db2inst1 -c /home/db2inst1/db-init.sh
