<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transferencia Bancaria</title>
<link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css"><link>
</head>
<body>
	
	<form>
		<div>
			<ul name=”navbar”>
				<li class="logo"><a href="#"><img id="logo" src="Multimedia/Logo.png" alt="Logo"/></a></li>
				 <li class="opcion"><a href=”#”>Clientes</a></li>
				 <li class="opcion"><a href=”#”>Cuentas</a></li>
				 <li class="opcion"><a href=”#”>Prestamos</a></li>
				 <li class="opcion"><a href=”#”>Actividades</a></li>
				 <li class="usuario"><a href="#"><img id="usuario" src="Multimedia/Usuario.png" alt="Iniciar sesión"/></a></li>
			</ul>
		</div>
	</form>
	

	<form style="padding-left:35%  ; ">
		Transferencia Desde el CBU:
		<select>	
				<option>Cuenta Corriente - CBU 156871278457</option>
		</select>
		<br>
		Transferencia al CBU:
		<input type="number"/>
		<br>
		Importe a Transferir:
		<input type="number" min="1000"/>
		<br>
		Concepto:
		<select>  
			<option>Varios</option>
		</select>
		<br>
	</form>
	
</body>
</html>