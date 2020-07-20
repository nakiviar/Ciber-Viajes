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

              <h1 align="center">CATEGORIAS</h1>
              <br>
              <h1 align="center">Actualizar Categoria</h1>
              <br>
              <form align="center" action="CategoriaServlet" method="post">   
              <label>Categoria:</label>
              <select name="cbocat">
              <ct:categoriacombo/>
              </select>
              <button name="opcion" value="buscat">Cargar</button>
              <br>
              <br>
              <label>Id Categoria :</label><br>
              <input type="text" 
              value="${codigo}"
              disabled="disabled" >
              <input type="hidden" 
              value="${codigo}"
              name="idcat" >
              <br>
              <label>Nombre Categoria:</label><br>
              <input type="text"
              maxlength="30"
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30."  
              value="${ nombre }"
               name="name" >
              <br>
              <label>Descripcion de Categoria:</label><br>
              <input type="text" 
              value="${descripcion}"
              maxlength="30"
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30." 
               name="desc">              
              <br>        
              <br>             
              <button name="opcion" value="act">Actualizar</button>
              <a href="CategoriaServlet?opcion=lista">Volver</a>
              </form>
              ${aviso}

</body>
</html>