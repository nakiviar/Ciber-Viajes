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

<div id="contenido3">
              
              <%--Se actualiza al volver a entrar --%>   
              <h1 align="center">USUARIOS</h1>
              <br>
              <h1 align="center">Mi Perfil</h1>
              <br>
              <form align="center" action="CrudUsr" method="post">
              <label>Usuario </label>
              <br>
              <input type="text" 
              value="${up.getUsuario() }"
              disabled="disabled">
              <input type="hidden"
              value="${up.getUsuario() }"
              name="usu" >
              <br>
              <label>Clave </label>
              <br>
              <input type="password" 
              value="${up.getClave() }"
               name="clave">
              <br>
              <label>Nombre </label>
              <br>
              <input type="text" 
              value="${up.getNombre() }"
               name="nom">
              <br>
              <label> Apellido Paterno </label>
              <br>
              <input type="text" 
              value="${ up.getApepa() }"
              name="apepa">
              <br>
              <label> Apellido Materno</label>
              <br>
              <input type="text" 
              value="${ up.getApema() }"
              name="apema">
              <br>
              <label>Fecha de Nacimiento :</label>
              <br>
              <input type="date"  
              value="${ up.getFecha() }"
              name="fecha">
              <br>
               <label>Correo </label>
              <br>
              <input type="text" 
              value="${ up.getCorreo() }"
              name="correo">
              <br>
               <label>Direccion </label>
              <br>
              <input type="text" 
              value="${ up.getDireccion() }"
              name="dire">                     
              <br>
               <label>Distrito</label>
              <br>
               <select name="cbodis" >
               <ct:Combodistritos valorcombo="${up.getIddistrito() }"/>
               </select> 
              <br>
              <label>Telefono</label>
              <br>
              <input type="text"
              value="${ up.getTelefono() }"
              name="tele">
              <br>
              <br>
              <button name="opcion" value="act-perfil">Actualizar</button>
              <a href="principal_usuario.jsp">Regresar</a>           
              <%--mostramos el mensaje enviado como atributo --%>
              </form>
              ${aviso2}
             
        </div>
  
</body>
</html>