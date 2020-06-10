<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="BancoMasterPage.html" />
<link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css"><link>
<title>Dar Baja/Modificar Usuarios</title>
</head>
<body>
	<div id="titulo">
		<label class="titulo">Baja y Modificación de Usuarios</label>
	</div>
	<div class="padre">
	   <div class="hijo">
	      <form style="width:100%;height:100%">
	         <table style="width:95%">
	            <tr>
	               <th>Username</th>
	               <th>Password</th>
	               <th>Estado</th>
	               <th>Modificar</th>
	               <th>Borrar</th>
	            </tr>
	            <tr>	               
	               <td>Alfredo123</td>
	               <td>1232</td>
	               <td>Activa</td>
	               <td> <input class="btntabla" id="BtnModificar" type="button" value="Modificar"/></td>
	               <td> <input class="btntabla" id="BtnBorrar" type="button" value="Borrar"/></td>
	            </tr>
	         </table>
	      </form>
	   </div>
	</div>
</body>
</html>