FROM openjdk:17-jdk-alpine

LABEL author=djl.com

COPY target/spring-git-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]