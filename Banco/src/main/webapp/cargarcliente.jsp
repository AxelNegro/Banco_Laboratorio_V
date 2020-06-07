<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css"><link>
<title>Cargar Clientes</title>
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
			<label class="titulo" style="padding:6%">Cargar Cliente</label>
			<br>
			<br>
			Documento:	<input id="TxtDocumento" type="text"/>
			
									&nbsp;&nbsp;  &nbsp;&nbsp;  Nacionalidad:	<input id="TxtNacionalidad" type="text"/>
			<br>
			<br>
			Nombre : &nbsp;&nbsp;&nbsp;   <input id="TxtNombre " type="text"/>
									&nbsp;&nbsp;  &nbsp;&nbsp;  Direccion:	<input id="TxtDireccion" type="text"/>	
			<br>
			<br>
			Apellido : &nbsp;&nbsp;    	<input id="TxtApellido" type="text"/>
									&nbsp;&nbsp;  &nbsp;&nbsp;  Localidad:	<input id="TxtLocalidad" type="text"/>
			<br>
			<br>
			Sexo  :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;		<select name="ddlSexo">
							  <option value="Hombre">Hombre</option>
								<option value="Mujer">Mujer</option>
							</select>
			<label style="padding-left : 8%;"> Provincia :	<input id="TxtProvincia" type="text"/></label>
			<br>
			<br>
			Fecha nacimiento	<input type="date" id="FechaNac" name="trip-start"
     			  min="1900-01-01">
			<br>
			<br>
			
			<input id="txtVolver" type="button" value="Volver"/>
			<input id="txtAceptar" type="button" value="Aceptar"/>
		</div>
	</form>
	
</body>
</html>