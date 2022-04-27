FROM java:11
VOLUME /tmp
ADD target/*.jar doodle-chat-application.1.0-SNAPSHOT.jar
EXPOSE 8080
RUN sh -c 'touch /doodle-chat-application.1.0-SNAPSHOT.jar.jar'
ENTRYPOINT ["java", "-jar","/app.jar"]
