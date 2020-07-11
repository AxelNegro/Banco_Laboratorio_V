<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="CSS/MasterPage.css"/>
      <title>Master Page del cliente</title>
   </head>
   <body>
      <form>
         <div>
            <ul name=”navbar”>
               <li class="logo"><a href="ClienteInicio.do?User=${Username}"><img id="logo" src="Multimedia/Logo.png" alt="Logo"/></a></li>
               <li class="opcion"><a class="menu" href="estadoCuentas.do?User=${Username}">Historial</a></li>
               <li class="opcion">
                  <a class="menu" href="leerTransTerceros.do?User=${Username}">Transferir</a>
                  <ul class="submenu">
                     <li><a href="leerTransTerceros.do?User=${Username}">A cuentas de terceros</a>
                     <li>
                     <li><a href="leerCuentasxUsuario.do?User=${Username}&Origen=0">A cuentas propias</a>
                     <li>
                  </ul>
               </li>
               <li class="opcion">
                  <a class="menu" href="leerCuentasxUsuario.do?User=${Username}&Origen=1">Prestamos</a>
                  <ul class="submenu">
                     <li><a href="leerCuentasxUsuario.do?User=${Username}&Origen=1">Pedir</a>
                     <li>
                     <li><a href="leerPrestamosaPagar.do?User=${Username}">Pagar</a>
                     <li>
                  </ul>
               </li>
               <li class="usuario"><a href="TodosInicio.do"><img id="usuario" src="Multimedia/Usuario.png" alt="Usuario"/></a></li>
               <li class="usuario">
                  <p id="username">${Username}</p>
               </li>
            </ul>
         </div>
      </form>
      <footer id="footer">
         <ul>
            <li>Derechos reservados Grupo 10</li>
         </ul>
      </footer>
   </body>
</html>