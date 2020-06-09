<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css"><link>
<title>Aprobar Creditos</title>
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
	<form >	
				<table >
					  <tr>
					    <th>Dni </th>
					    <th>Nombre</th>
					    <th>Apellido</th>
					    <th>Cbu</th>
					    <th>Numero Cuenta</th>
					    <th>Tipo de Cuenta</th>
					    <th>Monton solicitado</th>
					    <th>Plazo Pago</th>
					    <th>Interes</th>
					    <th>Cuotas de </th>
					    <th>Aprobar</th>
					    <th>Rechazar</th>
					  </tr>
					  <tr>
					    <td>1549682</td>
					    <td>Alfredo</td>
					    <td>Torres</td>
					    <td>0000545167856180</td>
					    <td>1232</td>
					    <td>Cuenta Corriente</td>
					    <td>$10000</td>
					    <td>5 meses</td>
					    <td>10%</td>
					    <td>$2200</td>
					    <td> <input class="btntabla" id="btnAprobarCredito" type="button" value="Aprobar"/></td>
					   <td> <input class="btntabla" id="btnRechazarCredito" type="button" value="Rechazar"/></td>
					  </tr>
					  
				
			</table>
	
	
	</form>
</body>
</html>