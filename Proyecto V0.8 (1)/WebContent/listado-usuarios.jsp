
<%@page import="model.UsuarioReporte"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="ct" %>	
<!DOCTYPE html >

<html lang="esS">
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
	<div class="container">
		<h1>Listado de Usuarios</h1>

		    <a class="btn btn-primary" href="registrar-usuario-admin.jsp">Registrar Usuario</a>
		    <a class="btn btn-primary" href="actualizar-usuarios.jsp">Actualizar Usuario</a>
		    <a class="btn btn-primary" href="eliminar-usuario.jsp">Eliminar Usuario</a>
		    <a class="btn btn-primary" href="CrudUsr?opcion=listar">Listar</a>
			<a class="btn btn-primary" href="principal_admin.jsp">Volver</a>
	<br>
	<br>
	<form action="CrudUsr" method="post">
	<select name="cbotipo">
	<ct:tipousuarioscombo/>   
	</select>
	<button name="opcion" value="listatipousu">Consultar</button>
    ${aviso2}	
	</form>
	</div>
      
	<br>
	<br>
	<div class="container">
		<table class="table">

			<tr>
			    <th>ID Usuario</th>
				<th>Nombre</th>
				<th>Apellido Paterno</th>
				<th>Apellido Materno</th>
				<th>Fecha de Nacimiento</th>
				<th>Correo</th>
				<th>Direccion</th>
				<th>Distrito</th>
				<th>Telefono</th>
				<th>Tipo Usuario</th>
			</tr>
			
			<%--obtener el listado enviado del servlet y muestro en las columnas --%>
			
			<%
			    ArrayList<UsuarioReporte> lista=(ArrayList<UsuarioReporte>)request.getAttribute("listado");

			
                if(lista !=null ){
                	for(UsuarioReporte ur :lista){
                		        	
			%>

			<tr class="grilla_campo">
				<td><%=ur.getUsuario()  %></td>
				<td><%=ur.getNombre() %></td>
				<td><%=ur.getApepa() %></td>
				<td><%=ur.getApema() %></td>
				<td><%=ur.getFechanac() %></td>
				<td><%=ur.getCorreo() %></td>
				<td><%=ur.getDireccion() %></td>
				<td><%=ur.getDistrito() %></td>
				<td><%=ur.getTelefono() %></td>
				<td><%=ur.getTipo() %></td>
			</tr>
			<%   
                	} //cierro el for..each
                } //cierro el if
			%>
			
		</table>
	</div>
</body>
</html>