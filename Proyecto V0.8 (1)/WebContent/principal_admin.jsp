<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/bootstrapValidator.css">

<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrapValidator.js"></script>

</head>
<body>

<h1>${aviso }</h1>
<br>
<br>
<a class="btn btn-primary" href="CrudUsr?opcion=listar">Ver Usuarios</a>
<a class="btn btn-primary" href="ProductoServlet?opcion=listar">Ver Productos</a>
<a class="btn btn-primary" href="CategoriaServlet?opcion=lista">Ver Categorias</a>
<a class="btn btn-primary" href="ProveedorServlet?opcion=lista">Ver Proveedores</a>
<a class="btn btn-primary" href="">Ver Pedidos</a>
<a class="btn btn-primary" href="reactivar.jsp">Reactivar</a>
<a class="btn btn-primary" href="login.jsp">Salir</a>

${aviso2 } ${aviso3 } ${aviso4 } ${aviso5 }
</body>
</html>

