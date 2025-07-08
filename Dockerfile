FROM maven:3.8.7-openjdk-17 AS build
WORKDIR /app
RUN git clone https://github.com/silentlunar/api-stub.git .
RUN mvn clean package

FROM openjdk:17-jdk-slim
COPY --from=build /app/target/springstub-0.0.1-SNAPSHOT.jar /app.jar
COPY --from=build /app/jolokia-agent-jvm-2.2.9-javaagent.jar /jolokia-agent.jar

EXPOSE 8080 8778

CMD ["java", "-javaagent:/jolokia-agent.jar=port=8778,host=0.0.0.0", "-jar", "/app.jar"]
