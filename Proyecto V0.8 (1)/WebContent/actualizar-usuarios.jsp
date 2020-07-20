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

                       
              <h1 align="center">USUARIOS</h1>
              <br>
              <h1 align="center">Actualizar Usuario</h1>
              <br>
              <form align="center" action="CrudUsr" method="post">
               <label>Usuario:</label>
              <select name="cod">
              <ct:usuarioscombo/>
              </select>
              <button name="opcion" value="bususu">Cargar</button>
              <br>
              <br>
              <label>Usuario :</label><br>
              <input type="text" 
              value="${usu }"
              disabled="disabled" >
              <input type="hidden" 
              value="${usu }"
              name="usu" >
              <br>
              <label>Clave :</label><br>
              <input type="password" 
              value="${clave }"
              maxlength="30"
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30."
               name="clave" >
              <br>
              <label>Nombre :</label><br>
              <input type="text" 
              value="${nom }"
              maxlength="30"
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30."
               name="nom">
              <br>
              <label> Apellido Paterno:</label><br>
              <input type="text" 
              value="${apepa }"
              maxlength="30"
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30."
               name="apepa" >
              <br>
              <label> Apellido Materno:</label><br>
              <input type="text" 
              value="${apema }"
              maxlength="30"
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30."
               name="apema" >
              <br>
              <label>Fecha de Nacimiento :</label><br>
              <input type="date"  
              value="${fecha }"
               name="fecna">
              <br>
               <label>Correo :</label><br>
              <input type="email" 
              value="${correo }"
               name="correo">
              <br>
               <label>Direccion :</label><br>
              <input type="text" 
              value="${dire }"
              maxlength="30"
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30."
               name="dire">                     
              <br>
               <label>Distrito :</label><br>
               <select name="cbodis" >
               <ct:Combodistritos valorcombo="${iddis }"/>
               </select> 
              <br>
              <label>Telefono :</label><br>
              <input type="text"
              value="${tele }"
              pattern="[0-9]{7,10}" 
              title="Solo numeros. Tamaño minimo:7 . Tamaño maximo:10."
               name="tele">
              <br>
              <label>Tipo de Usuario :</label><br>
               <select name="cbotipo" >
               <ct:tipousuarioscombo valorcombo="${tipo }"/>
               </select> 
              <br>
              <button name="opcion" value="act">Actualizar</button>
              <a href="CrudUsr?opcion=listar">Regresar</a>           
              </form>
              <%--mostramos el mensaje enviado como atributo --%>
              ${aviso2}
             
        </div>
  
</body>
</html>