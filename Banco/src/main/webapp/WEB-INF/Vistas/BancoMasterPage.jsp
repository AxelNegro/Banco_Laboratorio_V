<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="CSS/MasterPage.css" type="text/css"><link>
<title>Master Page del banco</title>
</head>
<body>
   <form method="get">
      <div>
         <ul>
            <li class="logo"><a href="#"><img id="logo" src="Multimedia/Logo.png" alt="Logo"/></a></li>
            <li class="opcion">
               <a class="menu" href="BancoAltaCliente.do?user=${Username}">Clientes</a>
               <ul class="submenu">
                  <li><a href="BancoAltaCliente.do?user=${Username}">Alta</a>
                  <li>
                  <li><a href="leerTodosClientes.do?user=${Username}&origen=0">Baja y Modificación</a>
                  <li>
               </ul>
            </li>
            <li class="opcion">
               <a class="menu" href="BancoAltaCuenta.do?user=${Username}">Cuentas</a>
               <ul class="submenu">
                  <li><a href="leerTodosClientes.do?user=${Username}&origen=1">Alta</a>
                  <li>
                  <li><a href="leerTodosCuenta.do?user=${Username}">Baja y Modificación</a>
                  <li>
               </ul>
            </li>
            <li class="opcion">
               <a class="menu" href="BancoAltaUsuario.do?user=${Username}">Usuarios</a>
               <ul class="submenu">
                  <li><a href="BancoAltaUsuario.do?user=${Username}">Alta</a>
                  <li>
                  <li><a href="leerTodosUser.do?user=${Username}">Baja y Modificación</a>
                  <li>
               </ul>
            </li>
            <li class="opcion"><a class="menu" href="BancoAprobarPrestamos.do?user=${Username}">Prestamos</a></li>
            <li class="opcion"><a class="menu" href="BancoReportes.do?user=${Username}">Reportes</a></li>
            <li class="usuario"><a href="#"><img id="usuario" src="Multimedia/Usuario.png" alt="Usuario"/></a></li>
            <li class="usuario">
               <p id="username">${Username}</p>
            </li>
         </ul>
      </div>
   </form>
   <footer id="footer">
      <ul>
         <li>Derechos reservados Grupo 8</li>
      </ul>
   </footer>
</body>
</html>