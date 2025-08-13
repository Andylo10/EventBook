# EventBook (desde cero)

Aplicación web **Jakarta EE 10** para gestionar eventos con **sesiones, cookies y filtros**.

## Requisitos
- JDK 21
- Maven 3.9+
- Contenedor compatible Jakarta EE 10:
  - **Tomcat 10.1+** (Servlet 6) o
  - **WildFly 30+**

## Cómo ejecutar
```bash
mvn clean package
```
Despliega el `target/EventBook.war` en tu servidor. Luego entra a:
```
http://localhost:8080/EventBook/login.jsp
```

### Usuarios demo
- admin@demo.com / admin123  (ADMIN)
- user@demo.com  / user123   (USER)

## Rutas
- /login (POST), /login.jsp
- /register (GET/POST), /register.jsp
- /events (GET)
- /admin/events (GET/POST)  [ADMIN]
- /admin/delete-event (POST) [ADMIN]

## Notas
- JSTL: se usa `org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1`
- Filtros:
  - `AuthFilter` protege `/events` y `/admin/*`.
  - `AdminFilter` permite `/admin/*` solo a rol `ADMIN`.
