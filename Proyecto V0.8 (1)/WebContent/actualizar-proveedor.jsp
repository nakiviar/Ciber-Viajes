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

              <h1 align="center">PROVEEDORES</h1>
              <br>
              <h1 align="center">Actualizar Proveedor</h1>
              <br>
              <form align="center" action="ProveedorServlet" method="post">
              <label>Proveedor:</label>
              <select name="cod">
              <ct:proveedorcombo/>
              </select>
              <button name="opcion" value="busprov">Cargar</button>
              <br>
              <br>
              <label>Id Proveedor :</label><br>
              <input type="text" 
              value="${codigo }"
              disabled="disabled" >
              <input type="hidden" 
              value="${codigo }"
              name="idprov" >
              <br>
              <label>Nombre Empresa:</label><br>
              <input type="text"
              value="${ empresa }"
              maxlength="30"
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30."  
               name="name" >
              <br>
              <label>Nombre Persona a Cargo:</label><br>
              <input type="text" 
              value="${dueño}"
              maxlength="30"
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30."  
               name="due">              
              <br>
              <label>Direccion:</label><br>
              <input type="text" 
              value="${direccion}"
              maxlength="50"
              title="Tamaño minimo:3 . Tamaño maximo:30."  
               name="dire">              
              <br>
              <label>Telefono:</label><br>
              <input type="text" 
              value="${telefono}"
              pattern="[0-9]{7,10}" 
              title="Solo numeros. Tamaño minimo:7 . Tamaño maximo:10."
               name="tele">              
              <br>        
              <br>             
              <button name="opcion" value="act">Actualizar</button>
              <a href="ProveedorServlet?opcion=lista">Volver</a>
              </form>      
              ${aviso}

</body>
</html>