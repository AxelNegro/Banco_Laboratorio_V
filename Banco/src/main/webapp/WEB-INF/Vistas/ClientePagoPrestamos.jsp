

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
      <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
      <title>Pago de Cuotas</title>
      <jsp:include page="ClienteMasterPage.jsp" />
      <link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css">
      <link>
      <script>
         $(document).ready(function () {
             $('#tablaBancoCliente').DataTable(
                 {
                     "lengthChange": false,
                     "info": false
                 }
             );
         });
      </script>
   </head>
   <body>
      <div id="titulo">
         <label class="titulo">Pago de prestamos</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <form >
               <table style="width:95%"id=tablaBancoCliente>
                  <thead>
                     <tr>
                        <th> </th>
                        <th> Numero de Cuota </th>
                        <th> Monto </th>
                        <th> Fecha de Realizacion del Pago </th>
                     </tr>
                  </thead>
                  <tbody>
                     <tr>
                        <td><input type="checkbox"></td>
                        <td> 1 </td>
                        <td> $ 1833.33</td>
                        <td> No se Realizo el Pago </td>
                     </tr>
                  </tbody>
               </table>
               <input class="botoncargar" style="width:45%" type="submit" value="Pagar">
            </form>
         </div>
      </div>
   </body>
</html>

