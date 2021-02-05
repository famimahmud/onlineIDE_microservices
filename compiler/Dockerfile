FROM openjdk:8-jdk-alpine

COPY target/*.jar app.jar

RUN sudo apt update && sudo apt install build-essential

ENTRYPOINT ["java", "-jar", "/app.jar"]
