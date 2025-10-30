FROM ubuntu:latest
LABEL authors="elliotthudson"


FROM openjdk:17-jdk-slim


VOLUME /tmp


WORKDIR /app


EXPOSE 8080

COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]