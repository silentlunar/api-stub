FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
COPY --from=build /app/jolokia-agent-jvm-2.2.9-javaagent.jar jolokia-agent.jar

EXPOSE 8080 8778
CMD ["java", "-javaagent:jolokia-agent.jar=port=8778,host=0.0.0.0", "-jar", "app.jar"]