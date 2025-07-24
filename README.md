# 🌐 Fundaem - Aplicación Web

**Fundaem** es una aplicación web para la gestión de eventos de una fundación sin fines de lucro. Esta versión incluye el frontend construido con **Spring Boot + Thymeleaf**, integrando vistas dinámicas y conexión directa al backend desplegado.

---

## 🧩 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Thymeleaf (Motor de plantillas)**
- **Spring MVC**
- **Hibernate / JPA**
- **PostgreSQL**
- **Render (despliegue)**

---

## 🚀 ¿Qué hace esta aplicación?

- Permite iniciar sesión como administrador o cliente
- Gestión de eventos (listar, crear, editar, eliminar)
- Validaciones de formularios
- Vistas dinámicas renderizadas con Thymeleaf
- Integración directa con base de datos y capa de seguridad

---

## 🖥️ Ver en producción

🔗 [https://fundaem.onrender.com/](https://fundaem.onrender.com/)

---

## 📥 Cómo ejecutar localmente

1. Clona el repositorio

```bash
git clone https://github.com/danielgomez-engineer/fundaem-frontend.git
cd fundaem-frontend
```

2. Configura tu base de datos en application.properties:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/fundaem_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

3. Ejecuta el proyecto:

```bash
./mvnw spring-boot:run
```

👨‍💻 Autor

Daniel Felipe Gómez Ferreira
📧 danielf23.dev@gmail.com
🔗 GitHub
🔗 Portafolio (próximamente)

