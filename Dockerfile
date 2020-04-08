FROM maven:3-jdk-11 AS MAVEN_BUILD

MAINTAINER Valid Akhundov

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:11-slim

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/*.jar /app/covid19-notifier.jar

ENTRYPOINT ["java", "-jar", "covid19-notifier.jar"]
