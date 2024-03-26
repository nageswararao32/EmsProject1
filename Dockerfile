FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY  . /app/
RUN mvn clean package

FROM openjdk:17-alpine
WORKDIR /app
ADD --from=build /app/target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8081
