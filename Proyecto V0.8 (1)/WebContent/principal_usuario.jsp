<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="/WEB-INF/libreria.tld" prefix="ct" %> 
    <%@taglib uri="http://displaytag.sf.net" prefix="display" %>  
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

<link rel="stylesheet" href="css/displaytag.css">
<link rel="stylesheet" href="css/screen.css">
</head>
<body>

<h1>${aviso } ${up.getNombre()} ${up.getApepa()}</h1>

<br>
<br>
<a class="btn btn-primary" href="ProductoServlet?opcion=listar-cli" target="marquito">Ver Productos</a>
<a class="btn btn-primary" href="perfil-usuario.jsp">Ver Perfil</a>
<a class="btn btn-primary" href="actualizar-perfil-usuario.jsp">Actualizar Perfil</a>
<a class="btn btn-primary" href="login.jsp">Salir</a>
${aviso2 }

<div style="margin-left: 10% " >
<iframe width="100%" height="900px" style="border:none;" name="marquito" >
</iframe>
</div>
</body>
</html>