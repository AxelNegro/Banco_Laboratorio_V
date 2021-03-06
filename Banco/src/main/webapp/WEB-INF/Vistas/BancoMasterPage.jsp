<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="CSS/MasterPage.css" type="text/css">
      <link>
      <title>Master Page del banco</title>
   </head>
   <body>
      <form method="get">
         <div>
            <ul>
               <li class="logo"><a href="BancoInicio.do?User=${Username}"><img id="logo" src="Multimedia/Logo.png" alt="Logo"/></a></li>
               <li class="opcion">
                  <a class="menu" href="leerUserSinCli.do?User=${Username}">Clientes</a>
                  <ul class="submenu">
                     <li><a href="leerUserSinCli.do?User=${Username}">Alta</a>
                     <li>
                     <li><a href="leerTodosClientes.do?User=${Username}&origen=0">Modificación</a>
                     <li>
                  </ul>
               </li>
               <li class="opcion">
                  <a class="menu" href="leerTodosClientes.do?User=${Username}&origen=1">Cuentas</a>
                  <ul class="submenu">
                     <li><a href="leerTodosClientes.do?User=${Username}&origen=1">Alta</a>
                     <li>
                     <li><a href="leerTodosCuenta.do?User=${Username}">Baja y Modificación</a>
                     <li>
                  </ul>
               </li>
               <li class="opcion">
                  <a class="menu" href="BancoAltaUsuario.do?User=${Username}">Usuarios</a>
                  <ul class="submenu">
                     <li><a href="BancoAltaUsuario.do?User=${Username}">Alta</a>
                     <li>
                     <li><a href="leerTodosUser.do?User=${Username}">Baja y Modificación</a>
                     <li>
                  </ul>
               </li>
               <li class="opcion"><a class="menu" href="leerTodosPrestamos.do?User=${Username}">Prestamos</a></li>
               <li class="opcion">
                  <a class="menu" href="mostrarReportesMovimientos.do?User=${Username}">Reportes</a>
                  <ul class="submenu">
                     <li><a href="reporteMovimientos.do?User=${Username}">Movimientos</a>
                     <li>
                     <li><a href="reportePrestamos.do?User=${Username}">Prestamos</a>
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