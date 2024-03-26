FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY  . /app/
RUN mvn clean package

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]