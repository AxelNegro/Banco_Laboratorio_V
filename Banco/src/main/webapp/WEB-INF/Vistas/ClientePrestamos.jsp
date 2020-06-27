<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
             $('#tablaPrestamos').DataTable(
                 {
                     "lengthChange": false,
                     "info": false,
                     "pageLength": 5
                 }
             );
         });
      </script>
   </head>
   <body>
      <div id="titulo">
         <label class="titulo">Prestamos del Cliente</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <form>
               <table id=tablaPrestamos style="width:95%">
                  <thead>
                     <tr>
                        <th> Código de Prestamo </th>
                        <th> Cuotas </th>
                        <th> Fecha de pedido </th>
                        <th> Estado </th>
                        <th></th>
                     </tr>
                  </thead>
                  <tbody>
                     <tr>
                        <td> 1 </td>
                        <td> 12 </td>
                        <td> $ 1833.33 </td>
                        <td> Aceptado </td>
                        <td><input class="botoncargar" style="width:100%" type="button" onclick='window.open("ClientePagoPrestamos.do?User=${Username}", "_blank", "scrollbars=1,resizable=1,height=1000,width=1150");' value="Pagar"></td>
                     </tr>
                  </tbody>
               </table>
               
            </form>
         </div>
      </div>
   </body>
</html>