
FROM openjdk:17-jdk-slim
COPY target/user-service-0.0.1-SNAPSHOT.jar user-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/user-service.jar"]

