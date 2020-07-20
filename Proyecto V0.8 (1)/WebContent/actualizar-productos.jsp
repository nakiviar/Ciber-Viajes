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

              <h1 align="center">PRODUCTOS</h1>
              <br>
              <h1 align="center">Actualizar Productos</h1>
              <br>
              <form align="center" action="ProductoServlet" method="post">
               <label>Producto:</label>
              <select name="cod">
              <ct:productoscombo/>
              </select>
              <button name="opcion" value="bus">Cargar</button>
              <br>
              <br>
              <label>Id Producto :</label><br>  
               <input type="text" 
              value="${codigo}"
              disabled="disabled" >
              <input type="hidden" 
              value="${codigo}"
              name="idprod" >
              <br>
              <label>Nombre del Producto:</label><br>
              <input type="text"
              value="${ descripcion }"
              maxlength="30"
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30."
               name="name" >
              <br>
              <label>Proveedor:</label><br>  
              <select name="cbopro">
              <ct:proveedorcombo valorcombo="${idpro }"/>
              </select>          
              <br>
              <label>Categoria:</label><br>    
              <select name="cbocat">
              <ct:categoriacombo valorcombo="${idcat } "/>
              </select>        
              <br>
              <label>Precio:</label><br>
              <input type="text" 
              value="${precio}"
              pattern="[0-9]{1,}" 
               title="Solo numeros. Precio minimo:1 . "
               name="pre">              
              <br>    
              <label>Stock:</label><br>
              <input type="text" 
              value="${stock}"
              pattern="[0-9]{1,}" 
               title="Solo numeros. Stock minimo:1 . "
               name="sto">              
              <br>      
              <br>             
              <button name="opcion" value="act">Actualizar</button>
              <a href="ProductoServlet?opcion=listar">Volver</a>
              </form>
              ${aviso}

</body>
</html>