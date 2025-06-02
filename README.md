# 🧩 Fundaem - Backend

Backend para una aplicación web de gestión de eventos de la fundación FUNDAEM. Desarrollado con Java, Spring Boot, Hibernate y MySQL.

## ✨ Funcionalidades principales

- Registro y autenticación de usuarios con roles (ADMIN, CLIENTE)
- Gestión de eventos (CRUD)
- Validaciones, manejo de errores y seguridad con JWT
- Protección de rutas con @PreAuthorize
- Arquitectura limpia con DTOs y ModelMapper

## 🛠️ Tecnologías

- Java 17
- Spring Boot 3.x
- Hibernate / JPA
- MySQL
- Spring Security + JWT
- Maven 

## 🚀 Cómo ejecutar el proyecto

### Requisitos previos
- JDK 17
- MySQL (con una base de datos creada)
- Maven o Gradle

### Pasos

```bash
# Clonar el proyecto
git clone https://github.com/danielfgomez/fundaem.git
cd fundaem

# Configura tu conexión a MySQL en /src/main/resources/application.properties

# Ejecuta la app
./mvnw spring-boot:run
