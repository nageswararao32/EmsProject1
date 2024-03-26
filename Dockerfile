FROM maven:3.8.3-openjdk-17
WORKDIR /app
COPY  . /app/
RUN mvn clean package

FROM openjdk:17-alpine
WORKDIR /app
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8081