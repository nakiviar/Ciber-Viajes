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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="contenido3">



                       
              <h1 align="center">USUARIOS</h1>
              <br>
              <h1 align="center">Mi Perfil</h1>
              <br>
              <form align="center" action="" method="post">
              <label >Usuario</label>
              <br>
              <input type="text" 
              value="${up.getUsuario()}"
              disabled="disabled" >
              <br>
              <label>Nombre </label>
              <br>
              <input type="text" 
              value="${up.getNombre() }"
               disabled="disabled">
              <br>
              <label> Apellido Paterno </label>
              <br>
              <input type="text" 
              value="${ up.getApepa() }"
              disabled="disabled"  >
              <br>
              <label> Apellido Materno</label>
              <br>
              <input type="text" 
              value="${ up.getApema() }"
              disabled="disabled" >
              <br>
              <label>Fecha de Nacimiento :</label>
              <br>
              <input type="text"  
              value="${ up.getFecha() }"
              disabled="disabled">
              <br>
               <label>Correo </label>
              <br>
              <input type="text" 
              value="${ up.getCorreo() }"
              disabled="disabled">
              <br>
               <label>Direccion </label>
              <br>
              <input type="text" 
              value="${ up.getDireccion() }"
              disabled="disabled">                     
              <br>
               <label>Distrito </label>
               <br>
               <input type="text"
               value="${ up.getDistrito() }"
              disabled="disabled">
              <br>
              <label>Telefono </label>
              <br>
              <input type="text"
              value="${ up.getTelefono() }"
              disabled="disabled">
              <br>
              <br>
              <a href="principal_usuario.jsp">Regresar</a>   
              </form>        
              <%--mostramos el mensaje enviado como atributo --%>
              ${aviso}
             
        </div>
  
</body>
</html>