<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <title>EventBook • Nuevo evento</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg bg-white border-bottom">
  <div class="container">
    <a class="navbar-brand text-primary" href="${pageContext.request.contextPath}/events">EventBook</a>
    <div class="ms-auto">
      <a class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath}/events">Volver</a>
    </div>
  </div>
</nav>
<div class="container py-4" style="max-width:640px;">
  <h2 class="mb-3">Crear evento</h2>
  <c:if test="${param.err == '1'}">
    <div class="alert alert-danger">Datos inválidos. Revisa los campos.</div>
  </c:if>
  <form method="post" action="${pageContext.request.contextPath}/admin/events" class="card p-4 shadow-sm">
    <div class="mb-3">
      <label class="form-label">Nombre</label>
      <input name="name" type="text" class="form-control" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Fecha</label>
      <input name="date" type="date" class="form-control" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Ubicación</label>
      <input name="location" type="text" class="form-control" required>
    </div>
    <div class="d-grid gap-2">
      <button class="btn btn-primary">Guardar</button>
    </div>
  </form>
</div>
</body>
</html>
