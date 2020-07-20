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
<body >
<div class="container">
		<h1>Listado de Productos</h1>
		
            <a class="btn btn-primary" href="ProductoServlet?opcion=listar-cli">Listar</a>
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

<display:table name="${listado}" export="true" pagesize="10" decorator="decorator.Wrapper">
      <%--para mostrar determinadas columnas display:column 
      property="campo o atributo de la clase"
       title="nombre de la columna"
       sortable="las flechas al costado del nombre para cambiar de posicion de mayor a menor /viceversa"--%>
         <display:column property="foto" title=""></display:column> 
         <display:column property="idprod" title="Código"></display:column>
         <display:column property="descripcion" title="Nombre del Producto"></display:column> 
         <display:column property="prov" title="Nombre del Proveedor"></display:column>
         <display:column property="cat" title="Categoria del Producto"></display:column> 
         <display:column property="precio" title="Precio Unitario" sortable="true"></display:column>
         <display:column property="stock" title="Stock Disponible" sortable="true"></display:column>
         <%--agregamos los recursos del Wrapper --%>
         <display:column property="imagen" title="Comprar"></display:column>  
  </display:table>

</body>
</html>