FROM openjdk:8-jdk-alpine


COPY target/*.jar app.jar


RUN  apk add build-base


ENTRYPOINT ["java", "-jar", "/app.jar"]
