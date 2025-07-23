# Imagen base oficial de Java y Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar todo el proyecto
COPY . .

# Construir el proyecto
RUN mvn clean install -DskipTests

# Segunda etapa: imagen ligera para ejecución
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiar el .jar desde la etapa de compilación
COPY --from=build /app/target/*.jar app.jar

# Puerto por defecto en Spring Boot
EXPOSE 8080

# Comando para ejecutar el backend
ENTRYPOINT ["java", "-jar", "app.jar"]
