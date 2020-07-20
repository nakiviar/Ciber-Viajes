<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/WEB-INF/libreria.tld" prefix="ct" %> 
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

              <h1>CATEGORIAS</h1>
              <br>
              <h1>Registrar Categoria</h1>
              <br>
              <form action="CategoriaServlet" method="post">
              <label>ID Categoria :</label><br>
               <input type="text" 
              value="<ct:autoidcategoria/>"
              disabled="disabled" >
              <input type="hidden" 
              value="<ct:autoidcategoria/>"
              name="cbocat" >
              <br>
              <label>Nombre Categoria:</label><br>
              <input type="text"
              placeholder="Ingrese el nombre de la categoria" 
              maxlength="30"
              required
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30." 
               name="name" >
              <br>
              <label>Descripcion de Categoria:</label><br>
              <input type="text" 
              placeholder="Descripcion breve de la categoria"
              maxlength="30"
              required
              title="Solo Letras. Tamaño minimo:3 . Tamaño maximo:30."
              name="desc">              
              <br>        
              <br>             
              <button name="opcion" value="reg">Registrar</button>
              <a href="CategoriaServlet?opcion=lista">Volver</a>
              </form>
              ${aviso}
            
</body>
</html>