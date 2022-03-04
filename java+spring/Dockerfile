# Build image
FROM gradle:7.4.0-jdk17 AS build

WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . /home/gradle/src

RUN gradle build --no-daemon 

# Run image
FROM openjdk:17-oracle
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

EXPOSE 3001
ENTRYPOINT ["java", "-jar", "/app/spring-boot-application.jar"]
