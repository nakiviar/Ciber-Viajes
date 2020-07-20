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

              <h1 align="center" >
              <font color="red">Reactivar Usuario</font></h1>
              <br>
              <form align="center" action="ReactivarServlet" method="post">
               <label>Usuario:</label>
              <select name="cbousueli">
              <ct:usuarioselicombo/>
              </select>
              <br>
              <br>
              <button name="opcion" value="reactivar-usu">Reactivar</button>
              <a href="principal_admin.jsp">Regresar</a>           
              </form>
              <%--mostramos el mensaje enviado como atributo --%>
              ${aviso2}
   
        </div>
        
        <div id="contenido3">


              <h1 align="center">Reactivar Producto</h1>
              <br>
              <form align="center" action="ReactivarServlet" method="post">
               <label>Producto:</label>
              <select name="cboproeli">
              <ct:productoselicombo/>
              </select>
              <br>
              <br>
              <button name="opcion" value="reactivar-pro">Reactivar</button>
              <a href="principal_admin.jsp">Regresar</a>           
              </form>
              <%--mostramos el mensaje enviado como atributo --%>

   
        </div>
        
        <div id="contenido3">

              <h1 align="center">Reactivar Proveedor</h1>
              <br>
              <form align="center" action="ReactivarServlet" method="post">
               <label>Proveedor:</label>
              <select name="cboproveli">
              <ct:proveedorelicombo/>
              </select>
              <br>
              <br>
              <button name="opcion" value="reactivar-prov">Reactivar</button>
              <a href="principal_admin.jsp">Regresar</a>           
              </form>
              <%--mostramos el mensaje enviado como atributo --%>

   
        </div> 
        
        <div id="contenido3">

              <h1 align="center">Reactivar Categoria</h1>
              <br>
              <form align="center" action="ReactivarServlet" method="post">
               <label>Categoria:</label>
              <select name="cbocateli">
              <ct:categoriaselicombo/>
              </select>
              <br>
              <br>
              <button name="opcion" value="reactivar-cat">Reactivar</button>
              <a href="principal_admin.jsp">Regresar</a>           
              </form>
              <%--mostramos el mensaje enviado como atributo --%>

   
        </div>          

</body>
</html>