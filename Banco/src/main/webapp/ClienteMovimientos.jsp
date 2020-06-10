

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
      <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
      <title>Movimientos de la cuenta</title>
      <jsp:include page="ClienteMasterPage.html" />
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
         <label class="titulo">Movimientos de la cuenta</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <div style="float:left;width:55%">
               <table id="tablaBancoCliente">
                  <thead>
                     <tr>
                        <th> Numero de Movimiento </th>
                        <th> Nombre de Movimiento </th>
                        <th> Fecha del Movimiento</th>
                        <th> Monto del Movimiento</th>
                     </tr>
                  </thead>
                  <tbody>
                     <tr>
                        <form style="padding-left:35%;">
                           <td> 2 </td>
                           <td> Transferencia a 156871278457 </td>
                           <td> 05/06/2020</td>
                           <td> -$ 1833.33 </td>
                        </form>
                     </tr>
                     </tr>
                  </tbody>
               </table>
            </div>
            <div style="float:left;width:35%; border:2px solid grey;margin-left:3%">
               <br>
               <label style="font-family:Arial;font-size:20px;font-weight:bold">Caja de ahorro en pesos</label>
               <br>
               <br>
               <label style="font-family:Arial;font-size:20px">$ 4563,23</label>
               <br>
               <hr>
               <br>
               <label style="font-family:Arial;font-size:20px;font-weight:bold">Caja de ahorro en dolares</label>
               <br>
               <br>
               <label style="font-family:Arial;font-size:20px">$ 354,55</label>
               <br>
            </div>
         </div>
      </div>
   </body>
</html>

