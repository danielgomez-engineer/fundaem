# Etapa 1: construir el JAR con Maven y Java 17
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

# Etapa 2: imagen ligera solo con el JAR y Java para ejecución
FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=build /app/target/fundaem-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
