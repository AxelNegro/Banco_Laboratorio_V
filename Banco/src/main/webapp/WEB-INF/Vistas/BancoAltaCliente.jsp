<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <jsp:include page="BancoMasterPage.jsp" />
      <link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css">
      <link>
      <title>Cargar Clientes</title>
   </head>
   <body>
      <div id="titulo">
         <label class="titulo">Alta de Clientes</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <form action="agregarCliente.do?User=${Username}" method="post">
               <br>
               <br>
               Documento:	<input type="number" id="txtDocumento" name="txtDocumento" style="margin-right:1%" placeholder="Documento"/>
               Usuario: <select id="ddlUsuario" name="ddlUsuario" style="margin-right:1%" placeholder="Usuario">
	               			<c:forEach items="${lstUserSinCli}" var="user">
	               				<option value="${user.getUsername()}">${user.getUsername()}</option>
	               			</c:forEach>
               			</select>
               
               <br>
               <br>
               Nombre: <input type="text" id="txtNombre" name="txtNombre" style="margin-right:1%" placeholder="Nombre"/>
               Apellido: <input type="text" id="txtApellido" name="txtApellido" style="margin-right:1%" placeholder="Apellido"/>
               <br>
               <br>
               Sexo:		
               <select id="ddlSexo" name="ddlSexo" style="margin-right:1%;width:6%;text-align:center">
                  <option value="Hombre">Hombre</option>
                  <option value="Mujer">Mujer</option>
               </select>
               Fecha nacimiento	<input type="date" id="dtFechaNac" name="dtFechaNac" style="margin-right:1%" min="1900-01-01">
               <br>
               <br>
               Nacionalidad: <input type="text" id="txtNacionalidad" name="txtNacionalidad" style="margin-right:1%" placeholder="Nacionalidad"/>
               Provincia: <input type="text" id="txtProvincia" name="txtProvincia" style="margin-right:1%" placeholder="Provincia"/>
               <br>
               <br>
               Localidad: <input type="text" id="txtLocalidad" name="txtLocalidad" style="margin-right:1%" placeholder="Localidad"/>
               Dirección: <input type="text" id="txtDireccion" name="txtDireccion" style="margin-right:1%" placeholder="Dirección"/>
               <br>
               <br>
               <input class="botoncargar" id="txtAgregar" name="txtAceptar" type="submit" value="Agregar"/>
               ${Msg}
            </form>
         </div>
      </div>
   </body>
</html>

