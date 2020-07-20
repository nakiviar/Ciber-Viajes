<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

        <h1 align="center"> ${param.descripcion} </h1><br>
        <form align="center" action="" method="post"><br>
        <img  alt="foto del producto" src="img/productos2/${param.cod}.jpg" align="center" width="250px">
        <br>
        <label >SKU:${param.cod}</label><br>
        <label>Precio:${p.precio }</label><br>
        <label>Stock disponible:${p.stock }</label><br>
        <label>Cantidad:</label>
        <input type="number"><br>
        <button>Agregar compra</button>
        <a href="ProductoServlet?opcion=listar-cli">Cancelar</a>
      
      </form>

</body>
</html>