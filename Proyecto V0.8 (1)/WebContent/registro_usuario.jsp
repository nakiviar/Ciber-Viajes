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
              <h1 align="center"><font color=red>Nuevo Registro</font></h1>
              <form align="center" action="CrudUsr" method="post">
              <label>Usuario :</label><br>
              <input type="text" 
              value="<ct:autoidusuario/>"
              disabled="disabled" >
              <input type="hidden" 
              value="<ct:autoidusuario/>"
              name="usu" >
              <br>
              <label>Clave :</label><br>
              <input type="password" 
              placeholder="Ingrese su clave"
              pattern="[a-zA-Z0-9]{3,10}"
              title="Letras y numeros. Tama�o minimo:3 . Tama�o maximo:10."
              required name="clave" >
              <br>
              <label>Nombre :</label><br>
              <input type="text" 
              placeholder="Ingrese su nombre"
              required name="nom">
              <br>
              <label> Apellido Paterno:</label><br>
              <input type="text" 
              placeholder="ingrese su apellido paterno"
              pattern="[a-zA-Z]{3,30}"
              title="Solo Letras. Tama�o minimo:3 . Tama�o maximo:30."
              required name="apepa" >
              <br>
              <label> Apellido Materno:</label><br>
              <input type="text" 
              placeholder="ingrese su apellido materno"
              pattern="[a-zA-Z]{3,30}"
              title="Solo Letras. Tama�o minimo:3 . Tama�o maximo:30."
              required name="apema" >
              <br>
              <label>Fecha de Nacimiento :</label><br>
              <input type="date"  required name="fecna">
              <br>
               <label>Correo :</label><br>
              <input type="email" 
              placeholder="Ingrese su Correo"
              required name="correo">
              <br>
               <label>Direccion :</label><br>
              <input type="text" 
              placeholder="Ingrese su Direccion"
              required name="dir">                     
              <br>
               <label>Distrito :</label><br>
               <select name="cbodis">
               <ct:Combodistritos/>
               </select> 
              <br>
              <label>Telefono :</label><br>
              <input type="text"
              pattern="[0-9]{7,10}" 
              placeholder="Ingrese su telefono"
              title="Solo numeros. Tama�o minimo:7 . Tama�o maximo:10."
              required name="tele">
              <br>
              <button name="opcion" value="reg-usuario">Registrar</button>
              <a href="login.jsp">Regresar</a>           
              </form>
              <%--mostramos el mensaje enviado como atributo --%>
              ${aviso2}
                   
        </div>
    
</body>
</html>