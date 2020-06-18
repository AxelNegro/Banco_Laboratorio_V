<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="BancoMasterPage.jsp" />
<link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css"><link>
<title>Dar Baja/Modificar Usuarios</title>
</head>
<body>
	<div id="titulo">
		<label class="titulo">Alta de Usuarios</label>
	</div>
	<div class="padre">
	   <div class="hijo">
	      <form style="width:100%;height:100%">
	         Usuario: <input type="text" id="txtUsuario" placeholder="Usuario" />
	         <br>
	         <br>
	         Contraseña: <input type="password" id="txtContrasenia" placeholder="Contraseña" />
	         <br>
	         <br>
	         <input class="botoncargar" id="txtVolver" type="button" value="Volver"/>
             <input class="botoncargar" id="txtAceptar" type="button" value="Aceptar"/>
	      </form>
	   </div>
	</div>
</body>
</html>