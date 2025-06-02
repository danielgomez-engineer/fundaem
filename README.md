# 🎯 Fundaem - Backend

**Fundaem** es una aplicación web para la gestión de eventos de una fundación sin fines de lucro. Incluye autenticación, autorización por roles (`ADMIN` y `CLIENTE`), validaciones, manejo profesional de errores y arquitectura limpia basada en capas.

Este proyecto forma parte de mi portafolio como desarrollador Java Fullstack en formación.

---

## 🧩 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Security (JWT)**
- **Hibernate / JPA**
- **ModelMapper**
- **DTOs y validaciones con Bean Validation**
- **Manejo de errores personalizado**
- **Base de datos:** MySQL
- **Herramientas:** Maven, Postman, Git

---

## 🔐 Autenticación y roles

- Sistema de login con **JWT**
- Registro de usuarios con roles: `CLIENTE` y `ADMIN`
- Protección de rutas con `@PreAuthorize`
- Acceso restringido según el rol

---

## 🧱 Estructura del proyecto

src/
├── config/ # Configuración general (CORS, JWT, PasswordEncoder)
├── security/ # Filtros, utilidades y proveedores de seguridad
├── controller/ # Controladores REST
├── service/ # Servicios e interfaces
├── repository/ # Repositorios JPA
├── entity/ # Entidades JPA (Usuario, Evento, etc.)
├── dto/ # DTOs para entrada y salida
└── exception/ # Manejo global de errores
---
## 📌 Entidades principales

- **Usuario**: autenticación y gestión de roles (`ADMIN`, `CLIENTE`)
- **Evento**: CRUD completo con validaciones
- **Rol**: Enum asociado a los usuarios

---

## 📥 Instalación y ejecución

1. Clona el repositorio:

```bash
git clone https://github.com/danielgomez-engineer/fundaem.git
cd fundaem
Configura la base de datos en application.properties:



👨‍💻 Autor
Daniel Felipe Gómez Ferreira
📧 danielf23.dev@gmail.com
🔗 GitHub
🔗 Portafolio y LinkedIn próximamente...

📌 Estado del proyecto
✅ Backend completo
🚧 Frontend en desarrollo (o por implementar)
🧪 Pruebas unitarias en progreso

Gracias por visitar este proyecto. Estoy abierto a sugerencias, colaboraciones y nuevas oportunidades en desarrollo Java.
