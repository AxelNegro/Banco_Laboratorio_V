<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="CSS/Formato.css" type="text/css">
      <title>Información del cliente a transferir</title>
   </head>
   <body>
      <div class="padre">
         <div class="hijo">
            <div id="titulo" style="position:relative">
               <label class="titulo">Información del cliente a transferir</label>
            </div>
            <br>
            <br>
            CBU Especificado: ${Cuenta.getCBU()}
            <br>
            <br>
            Apellido y nombre del dueño: ${Cliente.getApellido()}, ${Cliente.getNombre()}
            <br>
            <br>
            <input class="boton" type="button" onclick='window.close();' value="Aceptar">
            <br>
            <br>
            ${Msg}
         </div>
      </div>
   </body>
</html>