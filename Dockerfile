FROM openjdk:21

WORKDIR /usr/src/appb
COPY ./target/toDoApp-1.0-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar" ]