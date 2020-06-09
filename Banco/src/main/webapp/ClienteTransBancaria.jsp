<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transferencia Bancaria</title>
<jsp:include page="ClienteMasterPage.html" />
<link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css"><link>
</head>
<body>
	
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
		
		<input type="submit" value="Transferir">
	</form>
	
</body>
</html>