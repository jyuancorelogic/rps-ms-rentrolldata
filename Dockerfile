FROM openjdk:8-jdk-alpine
COPY rentroll-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080 22 80
CMD ["java","-jar","app.jar"]
RUN sh -c 'touch app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]