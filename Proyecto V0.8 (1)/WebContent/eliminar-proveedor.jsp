<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="ct" %> 
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

              <h1 align="center">Proveedores</h1>
              <br>
              <h1 align="center">Eliminar Proveedor</h1>
              <br>
              <form align="center" action="ProveedorServlet" method="post">
              
              <label>Proveedor:</label>
              <select name="cboprov">
              <ct:proveedorcombo/>
              </select>            
              <br>        
              <br>             
              <button name="opcion" value="eli">Eliminar</button>
              <a href="ProveedorServlet?opcion=lista">Volver</a>
              </form>          
              ${aviso}

</body>
</html>