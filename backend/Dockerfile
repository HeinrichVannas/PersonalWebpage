FROM maven:latest AS build
COPY src /app/src
COPY pom.xml /app
WORKDIR /app
RUN mvn clean install -U

FROM openjdk:21
WORKDIR /app
COPY --from=build /app/target/backend-0.0.3-SNAPSHOT.jar /app/backend.jar
EXPOSE 10000
CMD ["java", "-jar", "/app/backend.jar"]