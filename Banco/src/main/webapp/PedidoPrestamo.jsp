<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitud de Prestamo</title>
</head>
<body>
	
	<div class= "Xd">
		<label>Prestamo para la Cuenta: </label>
		<select>
			<option>Cuenta Corriente - CBU 156871278457</option>
		</select>
		<br>
		<label>Dinero Solicitado: </label>
		<input type="number" min="10000" Value="10000"/>
		<br>
		<label>Plazo de Pago:</label>
		<input type="Number" min="6" value="6"/>
		<br><br><br><br><br>
		<input type="submit" value="Calcular">
		
		
		<h1>Datos Finales del Prestamo</h1>
		<label>Prestamo para la Cuenta: </label>
		<label>Cuenta Corriente - CBU 156871278457</label>
		<br>
		<label>Dinero Solicitado: </label>
		<label> $ 10000</label> 
		<br>
		<label>Plazo de Pago:</label>
		<label> 6 Meses</label> 
		<br>
		<label>Interes:</label>
		<label> 10% </label> 
		<br>
		<Label>Cuotas de :</Label>
		<label> $ 1833.33</label> 
		<br><br><br>
		<input type="submit" value="Enviar">
		<input type="submit" value="Modificar">
		<input type="submit" value="Cancelar">
	</div>

</body>
</html>