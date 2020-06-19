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
            <li class="logo"><a href="#"><img id="logo" src="Multimedia/Logo.png" alt="Logo"/></a></li>
            <li class="opcion"><a class="menu" href=ClienteMovimientos.do>Historial</a></li>
            <li class="opcion"><a class="menu" href=ClienteTransBancaria.do>Transferir</a></li>
            <li class="opcion">
               <a class="menu" href=ClientePedidoPrestamos.do>Prestamos</a>
               <ul class="submenu">
                  <li><a href=ClientePedidoPrestamos.do>Pedido</a>
                  <li>
                  <li><a href=ClientePagoPrestamos.do>Pago</a>
                  <li>
               </ul>
            </li>
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