<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <title>EventBook • Registro</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5" style="max-width:520px;">
  <h1 class="mb-4 text-center">Crear cuenta</h1>

  <c:if test="${param.err == '1'}">
    <div class="alert alert-danger">Ocurrió un error. Revisa los campos.</div>
  </c:if>

  <form method="post" action="${pageContext.request.contextPath}/register" class="card p-4 shadow-sm">
    <div class="mb-3">
      <label class="form-label">Nombre</label>
      <input name="name" type="text" class="form-control" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Email</label>
      <input name="email" type="email" class="form-control" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Contraseña</label>
      <input name="password" type="password" class="form-control" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Rol (opcional)</label>
      <select name="role" class="form-select">
        <option value="">USER (por defecto)</option>
        <option value="ADMIN">ADMIN</option>
      </select>
    </div>
    <div class="d-grid gap-2">
      <button class="btn btn-primary">Registrarme</button>
    </div>
  </form>

  <div class="text-center mt-3">
    <a href="${pageContext.request.contextPath}/login.jsp">¿Ya tienes cuenta? Inicia sesión</a>
  </div>
</div>
</body>
</html>
