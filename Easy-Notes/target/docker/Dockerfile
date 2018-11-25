FROM openjdk:8-jdk-alpine
RUN  apk update && apk upgrade && apk add netcat-openbsd
RUN mkdir -p /usr/local/easy-notes-config-service
ADD easy-notes.jar /tmp/easy-notes/
RUN chmod +x -R /tmp/easy-notes/
RUN ls -al /tmp/easy-notes/
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ["java","-jar","/tmp/easy-notes/easy-notes.jar"]
