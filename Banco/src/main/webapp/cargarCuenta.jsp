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
 			Dni Due�o cuenta : <input id="DniDuenoCuenta" disabled></input>
 			<br>  
			<br> 
 				Nombre Due�o Cuenta:<input id="NombreDuenoCuenta" disabled ></input>
			<br>  
			<br> 
		
			<table >
					  <tr>
					    <th>Dni</th>
					    <th>Nombre</th>
					    <th>Apellido</th>
					    <th>Fecha Nacimiento</th>
					    <th>Direccion</th>
					    <th>Localidad</th>
					    <th>Provincia</th>
					    <th>Seleccionar</th>
					   
					  </tr>
					  <tr>
					    <td>1549682</td>
					    <td>Alfredo</td>
					    <td>Torres</td>
					    <td style="text-align: center;">16/2/1950</td>
					    <td>calle falsa 123</td>
					    <td>Avenida simpre viva</td>
					    <td>Buenos aires</td>
						<td>&nbsp;&nbsp;&nbsp;<input class="btntabla" id="BtnSeleccionar" type="button" value="Seleccionar"/></td>
					  </tr>
					  <tr>
					    <td>1543242</td>
					    <td>Diego</td>
					    <td>Torres</td>
					    <td style="text-align: center;">16/2/1934</td>
					    <td>calle real 123</td>
					    <td>Avenida simpre feliz</td>
					    <td>Buenos aires</td>
					    <td>&nbsp;&nbsp;&nbsp;<input class="btntabla" id="BtnSeleccionar" type="button" value="Seleccionar"/></td>

					  </tr>
					  <tr>
					    <td>1232682</td>
					    <td>Martin</td>
					    <td>Perez</td>
					    <td style="text-align: center;">15/2/1930</td>
					    <td>calle loca 123</td>
					    <td>Avenida viva</td>
					    <td>Buenos aires</td>
					    <td>&nbsp;&nbsp;&nbsp;<input class="btntabla" id="BtnSeleccionar" type="button" value="Seleccionar"/></td>
					  
					  </tr>
				
			</table>

			
			
			
			<input class="botoncargar" id="txtVolver" type="button" value="Volver"/>
			<input class="botoncargar" id="txtAceptar" type="button" value="Aceptar"/>
		</div>
	</form>
	
</body>
</html>