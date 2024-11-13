
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/member-query-0.0.1-SNAPSHOT.jar member-query-service.jar

EXPOSE 10000

ENTRYPOINT ["java", "-jar", "member-query-service.jar"]

ENV TZ=Asia/Seoul