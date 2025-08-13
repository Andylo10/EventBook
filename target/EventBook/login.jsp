<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <title>EventBook • Iniciar sesión</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-5" style="max-width:480px;">
  <h1 class="mb-4 text-center">EventBook</h1>

  <c:if test="${param.err == '1'}">
    <div class="alert alert-danger">Credenciales inválidas.</div>
  </c:if>
  <c:if test="${param.reg == '1'}">
    <div class="alert alert-success">Registro exitoso. Ahora inicia sesión.</div>
  </c:if>

  <form method="post" action="${pageContext.request.contextPath}/login" class="card p-4 shadow-sm">
    <div class="mb-3">
      <label class="form-label">Email</label>
      <input name="email" type="email" class="form-control" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Contraseña</label>
      <input name="password" type="password" class="form-control" required>
    </div>
    <div class="d-grid gap-2">
      <button class="btn btn-primary">Iniciar sesión</button>
    </div>
  </form>

  <div class="text-center mt-3">
    <a href="${pageContext.request.contextPath}/register">¿No tienes cuenta? Regístrate</a>
  </div>
</div>
</body>
</html>
