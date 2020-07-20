<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido a la pagina de reserva</title>
<!-- enlazar los estilos y la pagina 
     href : nombre y ubicacion
     rel: relacion
-->
<link href="css/estilos.css" rel="stylesheet">
</head>
<body background= "img/Fondo1" >

   <div id="contenido">    <!-- panel o bloque -->
        <header>
            <img alt="logotivo" src="img/bannerturismo01.jpg">
        </header>
        
        <div id="contenido2">
              <h1>Acceso al sistema</h1>
              <%--<form action="CrudUsr?opcion=log" method="post"> --%>
              <form action="CrudUsr" method="post">
              <label>Usuario :</label><br>
              <input type="text" 
              placeholder="ingrese su usuario"
              required name="usuario">
              <br>
              <br>
              <label >Clave :</label><br>
              <input type="password" 
              placeholder="Ingrese su clave"
              required name="clave">
              <br>
              <br>    
              <button name="opcion" value="log">Iniciar Sesion</button>
                 
              </form>
              <%--mostramos el mensaje enviado como atributo --%>
              ${aviso}
              ${aviso2}
              <p>Si es nuevo registrese <a href="registro_usuario.jsp">aqui</a></p>
         <br>
         <br>
        </div>
        <footer><img alt="logotivo" src="img/bannerturismo02.jpg"></footer>
   </div>

</body>
</html>