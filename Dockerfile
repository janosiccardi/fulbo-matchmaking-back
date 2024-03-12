FROM gradle:jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle bootJar --no-daemon
FROM gradle:jdk17-alpine
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/fulbo-matchmaking-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/fulbo-matchmaking-0.0.1-SNAPSHOT.jar"]