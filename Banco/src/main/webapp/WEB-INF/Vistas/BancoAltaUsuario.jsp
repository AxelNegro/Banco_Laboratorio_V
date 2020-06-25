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
	      <form action="agregarUser.do?User=${Username}" method="post">
	         Usuario: <input type="text" id="txtUsuario" name="txtUsuario" placeholder="Usuario" />
	         <br>
	         <br>
	         Contraseña: <input type="text" id="txtContrasenia" name="txtContrasenia" placeholder="Contraseña" />
	         <br>
	         <br>
	         Tipo de usuario: <input type="radio" id="rdTipo" name="rdTipo" value="true"/> Banco	
	         			      <input type="radio" id="rdTipo" name="rdTipo" value="false"/> Cliente
	   		 <br>
	   		 <br>
             <input class="botoncargar" id="txtAgregar" name="txtAgregar" type="submit" value="Agregar"/>
            ${Msg}
	      </form>
	   </div>
	</div>
</body>
</html>