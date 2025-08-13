<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <title>EventBook • Eventos</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg bg-white border-bottom">
  <div class="container">
    <a class="navbar-brand text-primary" href="${pageContext.request.contextPath}/events">EventBook</a>
    <div class="ms-auto d-flex gap-2">
      <c:if test="${sessionScope.role == 'ADMIN'}">
        <a class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath}/admin/events">Nuevo evento (Admin)</a>
      </c:if>
      <form method="post" action="${pageContext.request.contextPath}/auth/logout">
        <button class="btn btn-sm btn-outline-danger">Cerrar sesión</button>
      </form>
    </div>
  </div>
</nav>

<div class="container py-4">
  <h2 class="mb-3">Eventos disponibles</h2>
  <c:if test="${empty events}">
    <div class="alert alert-info">No hay eventos todavía.</div>
  </c:if>
  <c:if test="${not empty events}">
    <table class="table table-striped table-bordered">
      <thead class="table-dark">
      <tr>
        <th>#</th>
        <th>Nombre</th>
        <th>Fecha</th>
        <th>Ubicación</th>
        <c:if test="${sessionScope.role == 'ADMIN'}"><th>Acciones</th></c:if>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="e" items="${events}">
        <tr>
          <td>${e.id}</td>
          <td>${e.name}</td>
          <td>${e.date}</td>
          <td>${e.location}</td>
          <c:if test="${sessionScope.role == 'ADMIN'}">
            <td>
              <form method="post" action="${pageContext.request.contextPath}/admin/delete-event" onsubmit="return confirm('¿Eliminar evento?');">
                <input type="hidden" name="id" value="${e.id}">
                <button class="btn btn-sm btn-outline-danger">Eliminar</button>
              </form>
            </td>
          </c:if>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:if>
</div>
</body>
</html>
