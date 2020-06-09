<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="BancoMasterPage.html" />
<link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css"><link>
<title>Cargar Clientes</title>
</head>
<body>
	<div class="padre">
	   <div class="hijo">
	      <form>
	         <label class="titulo">Alta de Clientes</label>
	         <br>
	         <br>
	         Documento:	<input id="TxtDocumento" type="text"/>
	         &nbsp;&nbsp;  &nbsp;&nbsp;
	         Nacionalidad:	<input id="TxtNacionalidad" type="text"/>
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
	         Sexo  :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;		
	         <select name="ddlSexo">
	            <option value="Hombre">Hombre</option>
	            <option value="Mujer">Mujer</option>
	         </select>
	         <label style="padding-left : 8%;"> Provincia :	<input id="TxtProvincia" type="text"/></label>
	         <br>
	         <br>
	         Usuario : &nbsp;&nbsp;    	<input id="TxtUsuario" type="text"/>
	         &nbsp;&nbsp;  &nbsp;&nbsp; Fecha nacimiento	<input type="date" id="FechaNac" name="trip-start" 
	            min="1900-01-01">
	         <br>
	         <br>
	         <input class="botoncargar" id="txtVolver" type="button" value="Volver"/>
	         <input class="botoncargar" id="txtAceptar" type="button" value="Aceptar"/>
	      </form>
	   </div>
	</div>
</body>
</html>