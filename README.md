# EventBook (desde cero)

Aplicación web **Jakarta EE 10** para gestionar eventos con **sesiones, cookies y filtros**.

## Integrantes

Jonathan Eduardo Jolón García - 2400483 - jejolong@alumno.uspg.edu.gt

Juan Andrés Pirir Palma - 2400479 - japirirp@alumno.uspg.edu.gt

Daniela Marisabel Lopez Aroche - 2400330 - dmlopeza@alumno.uspg.edu.gt

Andrea Alejandra López Jiménez - 2400040 - aalopezj@alumno.uspg.edu.gt

Luis Angel Franco Cruz - 2400497 - lafrancoc@alumno.uspg.edu.gt



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
