<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
html { 
  background: url(Multimedia/PagPrincipal.jpg) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
</style>
<link rel="stylesheet" type="text/css" href="CSS/MasterPage.css"/>
<title>Master Page</title>
</head>
<body>
   <form>
      <div>
         <ul name=”navbar”>
            <li class="logo"><a href="TodosInicio.do"><img id="logo" src="Multimedia/Logo.png" alt="Logo"/></a></li>
            <li class="usuario"><a  href="TodosLogin.do"><img id="usuario"  src="Multimedia/Usuario.png" alt="Iniciar sesión"/></a></li>
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