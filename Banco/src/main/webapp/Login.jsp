<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="CSS/Login.css" type="text/css"><link>
<jsp:include page="MasterPage.html" />
<style>
html { 
  background: url(Multimedia/PagPrincipal.jpg) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
</style>
<title>Iniciar sesión</title>
</head>
<body>
	<form>
		<div id="divPadre">
			<label>Iniciar sesión:</label>
			<br>
			<br>
			Usuario:	<input id="txtUsuario" type="text"/>
			<br>
			<br>
			Contraseña:	<input id="txtContrasenia" type="password"/>
			<br>
			<br>
			<input id="txtVolver" type="button" value="Volver"/>
			<input id="txtAceptar" type="button" value="Aceptar"/>
		</div>
	</form>
</body>
</html>