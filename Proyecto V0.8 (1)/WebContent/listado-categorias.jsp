<%@page import="model.Categorias"%>
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
		<h1>Listado de Categorias</h1>

		    <a class="btn btn-primary" href="registrar-categorias.jsp">Registrar Categoria</a>
		    <a class="btn btn-primary" href="actualizar-categorias.jsp">Actualizar Categoria</a>
		    <a class="btn btn-primary" href="eliminar-categoria.jsp">Eliminar Categoria</a>
		    <a class="btn btn-primary" href="CategoriaServlet?opcion=lista">Listar</a>
			<a class="btn btn-primary" href="principal_admin.jsp">Volver</a>
	${aviso}
	</div>
      
	<br>
	<br>
	<div class="container">
		<table class="table">

			<tr>
			    <th>Codigo de Categoría</th>
				<th>Nombre de Categoría</th>
				<th>Descripción de Categoría</th>
				
			</tr>
			
			<%--obtener el listado enviado del servlet y muestro en las columnas --%>
			
			<%
			    ArrayList<Categorias> lista=(ArrayList<Categorias>)request.getAttribute("listado");

			
                if(lista !=null ){
                	for(Categorias c :lista){
                		        	
			%>

			<tr class="grilla_campo">
				<td><%=c.getIdcategoria()  %></td>
				<td><%=c.getNombrecat() %></td>
				<td><%=c.getDescripcion() %></td>

			</tr>
			<%   
                	} //cierro el for..each
                } //cierro el if
			%>
			
		</table>
	</div>
   

</body>
</html>