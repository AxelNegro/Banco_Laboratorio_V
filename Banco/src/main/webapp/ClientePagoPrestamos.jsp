<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pago de Cuotas</title>
<jsp:include page="ClienteMasterPage.html" />
<link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css"><link>
</head>
<body>

	<form style="padding-left:35%  ; ">
	
	 	<table>
			<thead>
				<tr>
					<td> </td>
					<td> Numero de Cuota </td>
					<td> Monto </td>
					<td> Fecha de Realizacion del Pago </td>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td><input type="checkbox"></td>
					<td> 1 </td>
					<td> $ 1833.33</td>
					<td> No se Realizo el Pago </td>
				</tr>
			</tbody>
			
			
		</table>
		<input type="submit" value="Pagar">
	</form>
</body>
</html>