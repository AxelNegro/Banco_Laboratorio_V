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
	<form >	
				<table>
					  <tr>
					    <th>Dni</th>
					    <th>Nombre</th>
					    <th>Apellido</th>
					    <th>Fecha Nacimiento</th>
					    <th>Direccion</th>
					    <th>Localidad</th>
					    <th>Provincia</th>
					    <th>Modificar</th>
					     <th>Borrar</th>
					  </tr>
					  <tr>
					    <td>1549682</td>
					    <td>Alfredo</td>
					    <td>Torres</td>
					    <td style="text-align: center;">16/2/1950</td>
					    <td>calle falsa 123</td>
					    <td>Avenida simpre viva</td>
					    <td>Buenos aires</td>
					    <td> <input class="btntabla" id="BtnModificar" type="button" value="Modificar"/></td>
					   <td> <input class="btntabla" id="BtnBorrar" type="button" value="Borrar"/></td>
					  </tr>
					  <tr>
					    <td>1543242</td>
					    <td>Diego</td>
					    <td>Torres</td>
					    <td style="text-align: center;">16/2/1934</td>
					    <td>calle real 123</td>
					    <td>Avenida simpre feliz</td>
					    <td>Buenos aires</td>
					    <td> <input class="btntabla" id="BtnModificar" type="button" value="Modificar"/></td>
					   <td> <input class="btntabla" id="BtnBorrar" type="button" value="Borrar"/></td>
					  </tr>
					  <tr>
					    <td>1232682</td>
					    <td>Martin</td>
					    <td>Perez</td>
					    <td style="text-align: center;">15/2/1930</td>
					    <td>calle loca 123</td>
					    <td>Avenida viva</td>
					    <td>Buenos aires</td>
					    <td><input class="btntabla" id="BtnModificar" type="button" value="Modificar"/></td>
					   <td><input class="btntabla" id="BtnBorrar" type="button" value="Borrar"/></td>
					  </tr>
				
			</table>
	
	
	</form>
</body>
</html>