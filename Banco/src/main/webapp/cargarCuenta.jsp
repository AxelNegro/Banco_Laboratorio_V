<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css"><link>
<title>Cargar Cuentas</title>
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
		<div >
			<label class="titulo" style="padding-left:6%">Cargar Cuenta</label>
			<br>
			<br>
			Cbu:	<input id="TxtCbu" type="text"/>
			
							&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;	&nbsp;&nbsp;  &nbsp;&nbsp;  Numero Cuenta:	<input id="TxtNroCuenta" type="number"/>
			<br>
			<br>
			Nombre : <input id="TxtNombre " type="text"/>
							&nbsp;	&nbsp;&nbsp;&nbsp;	  Tipo Cuenta:	<select name="tipoCuenta" style="width: 159px;">
																						 <option value="ahorroPesos">Caja de ahorro en pesos</option>
																						<option value="ahorroDolares">Caja de ahorro en d�lares</option>
																						<option value="ctaCte">Cuenta corriente</option>
																						<option value="ctaCteEspPesos">Cuenta corriente especial en pesos</option>
																						<option value="ctaCteEspDolares">Cuenta corriente especial en d�lares</option>
																					</select>
			<br>
			<br>
			Saldo : &nbsp;&nbsp;    	<input id="TxtSaldo" type="number"/>
					&nbsp;&nbsp;  &nbsp;&nbsp;	Fecha Creacion	<input type="date" id="FechaCreacionCuenta" name="trip-start" 
     			  min="1900-01-01">
			<br>
			<br>

			<br> 
			<br> 
			
			<input class="botoncargar" id="txtVolver" type="button" value="Volver"/>
			<input class="botoncargar" id="txtAceptar" type="button" value="Aceptar"/>
		</div>
	</form>
	
</body>
</html>