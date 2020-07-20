<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="css/estilos.css" rel="stylesheet">
</head>
<body>
   <div id="contenido3">    <!-- panel o bloque -->
        <header>
            <img alt="logotivo" src="img/bannerturismo01.jpg">
        </header>
        
        <div id="contenido2">
              <h1>Bienvenido a la pagina Principal</h1>
           
              <h1>Tour</h1>
              
              <form action="ProductoServlet" method="post">
              <label>Codigo del Tour :</label><br>
              <input type="text"
              pattern="[a-zA-Z0-9]{1,5}" 
              placeholder="ingrese el codigo de 5 caracteres max"
              value="${codigo }"
               name="cod">
              <br>
              <label> Tour:</label><br>
              <input type="text" 
              value="${descripcion }"
              placeholder="ingrese nombre del tour"
               name="desc" >
              <br>
              <label> Disponibilidad:</label><br>
              <input type="text" 
              value="${stock}"
              placeholder="ingrese el disponibilidad"
               name="sto">
              <br>
              <label>Precio :</label><br>
              <input type="text"
              value="${precio }" 
              placeholder="ingres precio del Tour"
               name="pre" >
              <br>
              <label>Destino :</label><br>
              <select name="cat">
		        <option value="0">Seleccione</option>
				<option value="1">Paracas-Ica</option>
				<option value="2">Lunahuana</option>
				<option value="3">Churin</option>
			</select>
              
              <%-- <input type="text"
              pattern="[1-3]{1}"
              value="${categoria }"
              placeholder="ingrese categoria del 1 al 3"  
               name="cat">  --%>
              <br>        
              <br>             
              <button name="opcion" value="reg">Registrar</button>
              <button name="opcion" value="act">Actualizar</button>
              <button name="opcion" value="eli">Eliminar</button>
              <button name="opcion" value="bus">Buscar</button>
              <button name="opcion" value="lim">Limpiar</button>
              

              
              </form>
              <a href="listado.jsp">Vea Los Productos</a>
              ${aviso}
              
        </div>     
        
   
   </div>
   
</body>
<footer>
              <img alt="logotivo" src="img/bannerturismo02.jpg">
              </footer>
</html>