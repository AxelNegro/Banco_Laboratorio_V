

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <jsp:include page="BancoMasterPage.html" />
      <link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css">
      <link>
      <title>Aprobar Creditos</title>
   </head>
   <body>
      <div id="titulo">
         <label class="titulo">Reportes</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <form action="">
               Buscar entre las fechas <input type="date"/> y <input type="date"/>	
               <br>
               <button style="margin-top:2%;margin-bottom:2%" type="button" class="botonReportes" >Pagos realizados<br />Entre fechas</button>
               <button style="margin-top:2%;margin-bottom:2%""type="button" class="botonReportes" >Creditos aprobados <br />Entre fechas</button>
               <br>
            </form>
            <form>
               <table style="width:95%">
                  <tr>
                     <th>Dni </th>
                     <th>Nombre</th>
                     <th>Apellido</th>
                     <th>Cbu</th>
                     <th>Numero Cuenta</th>
                     <th>Tipo de Cuenta</th>
                     <th>Numero de pago</th>
                     <th>Fecha Pago</th>
                     <th>Pago de cuota de</th>
                  </tr>
                  <tr>
                     <td>1549682</td>
                     <td>Alfredo</td>
                     <td>Torres</td>
                     <td>0000545167856180</td>
                     <td>1232</td>
                     <td>Cuenta Corriente</td>
                     <td>1/5</td>
                     <td>10/5/20</td>
                     <td>$2200</td>
                  </tr>
               </table>
            </form>
         </div>
      </div>
   </body>
</html>

