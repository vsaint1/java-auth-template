FROM maven:3.6.3-adoptopenjdk-11 as build

WORKDIR /app

COPY . .

RUN mvn clean package -Dmaven.test.skip=true

FROM alpine:latest

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
