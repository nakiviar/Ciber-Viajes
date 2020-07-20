
<%@page import="model.ProductoReporte"%>
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
		<h1>Listado de Productos</h1>
		
            <a class="btn btn-primary" href="ProductoServlet?opcion=listar-cli">Listar</a>
			<a class="btn btn-primary" href="principal_usuario.jsp">Volver</a>
	<br>
	<br>
	<form action="ProductoServlet" method="post">
	<select name="combocat">
	 <ct:categoriacombo/>   
	</select>
	<button name="opcion" value="listarxcatxcli">Consultar</button>
	${aviso}
	
	</form>
	</div>
      
	<br>
	<br>
	<div class="container">
		<table class="table">

			<tr>
			    <th>Producto</th>
				<th>Codigo Producto</th>
				<th>Nombre del Producto</th>
				<th>Proveedore del Producto</th>
				<th>Categoria del Producto</th>
				<th>Precio del Producto</th>
				<th>Stock del Producto</th>
				
			</tr>
			
			<%--obtener el listado enviado del servlet y muestro en las columnas --%>
			
			<%
			    ArrayList<ProductoReporte> lista=(ArrayList<ProductoReporte>)request.getAttribute("listado2");

			
                if(lista !=null ){
                	for(ProductoReporte p :lista){
                		        	
			%>

			<tr class="grilla_campo">
			    <td><img alt="sin imagen" src="img/productos2<%=p.getIdprod()  %>.jpg" width="100px" height="100px"></td>
				<td><%=p.getIdprod()  %></td>
				<td><%=p.getDescripcion() %></td>
				<td><%=p.getProv() %></td>
				<td><%=p.getCat() %></td>
				<td><%=p.getPrecio() %></td>
				<td><%=p.getStock() %></td>
			</tr>
			<%   
                	} //cierro el for..each
                } //cierro el if
			%>
			
		</table>
	</div>
</body>
</html>