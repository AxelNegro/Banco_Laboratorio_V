<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Movimientos de la cuenta</title>
      <jsp:include page="ClienteMasterPage.html" />
      <link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css">
      <link>
   </head>
   <body>
      <div id="titulo">
         <label class="titulo">Movimientos de la cuenta</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <div style="float:left">
               <form>
                  <table style="width:95%">
                     <thead>
                        <tr>
                           <td> Numero de Movimiento </td>
                           <td> Nombre de Movimiento </td>
                           <td> Fecha del Movimiento</td>
                           <td> Monto del Movimiento</td>
                        </tr>
                     </thead>
                     <tbody>
                        <tr>
                           <td> 2 </td>
                           <td> Transferencia a 156871278457 </td>
                           <td> 05/06/2020</td>
                           <td> -$ 1833.33 </td>
                        </tr>
                     </tbody>
                  </table>
               </form>
            </div>
            <div style="float:left; border:2px solid grey;text-align:center;width:49%">
               <br>
               <label style="font-family:Arial;font-weight:bold;font-size:20px">Caja de Ahorro en pesos</label>
               <br>
               <br>
               <label style="font-family:Arial;font-size:20px">$4567,34</label>
               <br>
               <br>
               <hr>
               <br>
               <label style="font-family:Arial;font-weight:bold;font-size:20px">Caja de Ahorro en dolares</label>
               <br>
               <br>
               <label style="font-family:Arial;font-size:20px">$324,56</label>
               <br>
               <br>
            </div>
         </div>
      </div>
   </body>
</html>

