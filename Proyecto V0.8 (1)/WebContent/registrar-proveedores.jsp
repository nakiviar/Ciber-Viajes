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
              <h1 align="center"><font color=red>Registrar Proveedor</font></h1>
              <br>
              <form align="center" action="ProveedorServlet" method="post">
              <label>Id Proveedor :</label><br>
               <input type="text" 
              value="<ct:autoidproveedor/>"
              disabled="disabled" >
              <input type="hidden" 
              value="<ct:autoidproveedor/>"
              name="cboprov" >
              <br>
              <label>Nombre Empresa:</label><br>
              <input type="text"
              placeholder="Ingrese el nombre de la empresa" 
               maxlength="30"
              required
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30."
               name="name" >
              <br>
              <label>Nombre Persona a Cargo:</label><br>
              <input type="text" 
              placeholder="Dueño o perosna a cargo de la empresa"
              maxlength="30"
              required
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30."
               name="due">              
              <br>
              <label>Direccion:</label><br>
              <input type="text" 
              placeholder="Direccion de la empresa"
              maxlength="30"
              required
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30."
               name="dire">              
              <br>
              <label>Telefono:</label><br>
              <input type="text" 
              placeholder="Telefono de la empresa"
              pattern="[0-9]{7,10}" 
              title="Solo numeros. Tamaño minimo:7 . Tamaño maximo:10."
               name="tele">              
              <br>        
              <br>             
              <button name="opcion" value="reg">Registrar</button>
              <a href="listado-proveedores.jsp">Volver</a>
              </form>           
              ${aviso}

</body>
</html>