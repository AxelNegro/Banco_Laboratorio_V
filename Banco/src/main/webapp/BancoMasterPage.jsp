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
   <form>
      <div>
         <ul>
            <li class="logo"><a href="#"><img id="logo" src="Multimedia/Logo.png" alt="Logo"/></a></li>
            <li class="opcion">
               <a class="menu" href=BancoAltaCliente.jsp>Clientes</a>
               <ul class="submenu">
                  <li><a href=BancoAltaCliente.jsp>Alta</a>
                  <li>
                  <li><a href=BancoByMClientes.jsp>Baja y Modificación</a>
                  <li>
               </ul>
            </li>
            <li class="opcion">
               <a class="menu" href=BancoAltaCuenta.jsp>Cuentas</a>
               <ul class="submenu">
                  <li><a href=BancoAltaCuenta.jsp>Alta</a>
                  <li>
                  <li><a href=BancoByMCuentas.jsp>Baja y Modificación</a>
                  <li>
               </ul>
            </li>
            <li class="opcion">
               <a class="menu" href=BancoAltaUsuario.jsp>Usuarios</a>
               <ul class="submenu">
                  <li><a href=BancoAltaUsuario.jsp>Alta</a>
                  <li>
                  <li><a href=BancoByMUsuarios.jsp>Baja y Modificación</a>
                  <li>
               </ul>
            </li>
            <li class="opcion"><a class="menu" href=BancoAprobarPrestamos.jsp>Prestamos</a></li>
            <li class="opcion"><a class="menu" href=BancoReportes.jsp>Reportes</a></li>
            <li class="usuario"><a href="#"><img id="usuario" src="Multimedia/Usuario.png" alt="Usuario"/></a></li>
            <li class="usuario">
               <p id="username">Nombre de usuario</p>
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