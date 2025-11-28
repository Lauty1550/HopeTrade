# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn -DskipTests package

# Stage 2: Runtime
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Limitar memoria máxima de Java a 400MB para no hacer OOM
ENV JAVA_OPTS="-Xmx400m -Xms128m"

# Puerto que Railway provee
ENV PORT=8080
EXPOSE 8080

# Start command usando variable PORT
CMD ["sh", "-c", "java $JAVA_OPTS -Dserver.port=$PORT -jar app.jar"]
