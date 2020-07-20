
<%@page import="model.Proveedor"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<h1>Listado de Proveedores</h1>

		    <a class="btn btn-primary" href="registrar-proveedores.jsp">Registrar Proveedor</a>
		    <a class="btn btn-primary" href="actualizar-proveedor.jsp">Actualizar Proveedor</a>
		    <a class="btn btn-primary" href="eliminar-proveedor.jsp">Eliminar Proveedor</a>
		    <a class="btn btn-primary" href="ProveedorServlet?opcion=lista">Listar</a>
			<a class="btn btn-primary" href="principal_admin.jsp">Volver</a>
	${aviso}
	</div>
      
	<br>
	<br>
	<div class="container">
		<table class="table">

			<tr>
			    <th>Codigo de Proveedor</th>
				<th>Nombre de Empresa</th>
				<th>Dueño de Empresa</th>
				<th>Direccion</th>
				<th>Telefono</th>
				
			</tr>
			
			<%--obtener el listado enviado del servlet y muestro en las columnas --%>
			
			<%
			    ArrayList<Proveedor> lista=(ArrayList<Proveedor>)request.getAttribute("listado");

			
                if(lista !=null ){
                	for(Proveedor p :lista){
                		        	
			%>

			<tr class="grilla_campo">
				<td><%=p.getIdproveedor()  %></td>
				<td><%=p.getNomemp() %></td>
				<td><%=p.getNomdueño() %></td>
				<td><%=p.getDireccion() %></td>
				<td><%=p.getTelefono() %></td>

			</tr>
			<%   
                	} //cierro el for..each
                } //cierro el if
			%>
			
		</table>
	</div>

</body>
</html>