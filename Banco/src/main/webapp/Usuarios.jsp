<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="BancoMasterPage.html" />
<link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css"><link>
<title>Dar Baja/Modificar Usuarios</title>
       <script>
        $(document).ready(function () {
            $('#tablaUsuarios').DataTable(
                {
                    "lengthChange": false,
                    "info": false
                }
            );
        });
    </script>
</head>
<body>
	<div class="padre">
	   <div class="hijo">
	     
	         <table  id="tablaUsuarios">
	            <thead>
	            
	            <tr>
	               <th>Username</th>
	               <th>Password</th>
	               <th>Estado</th>
	               <th>Modificar</th>
	               <th>Borrar</th>
	            </tr>
	            </thead>
	            <tbody>
	            <tr>	  
	               <form style="width:100%;height:100%">     	                
	               <td>Alfredo123</td>
	               <td>1232</td>
	               <td>Activa</td>
	               <td> <input class="btntabla" id="BtnModificar" type="button" value="Modificar"/></td>
	               <td> <input class="btntabla" id="BtnBorrar" type="button" value="Borrar"/></td>
	                </form>
	               </tr>
	               <tr>	  
	               <form style="width:100%;height:100%">            
	                <td>Hugo123</td>
	               <td>1232</td>
	               <td>Activa</td>
	               <td> <input class="btntabla" id="BtnModificar" type="button" value="Modificar"/></td>
	               <td> <input class="btntabla" id="BtnBorrar" type="button" value="Borrar"/></td>
	               </tr>
	              </form>
	            </tr>
	       
	             </tbody>
	         </table>
	      
	   </div>
	</div>
</body>
</html>