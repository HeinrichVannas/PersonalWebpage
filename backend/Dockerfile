FROM maven:latest AS build
COPY backend/pom.xml /app
COPY backend/src /app/src
WORKDIR /app
RUN mvn clean install -U

FROM openjdk:21
WORKDIR /app
COPY --from=build /app/target/*.jar /app/backend.jar
EXPOSE 10000
CMD ["java", "-jar", "/app/backend.jar"]