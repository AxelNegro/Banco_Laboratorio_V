<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
      <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
      <title>Pago de Cuotas</title>
      <jsp:include page="ClienteMasterPage.jsp" />
      <link rel="stylesheet" href="CSS/Formato.css" type="text/css">
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
            <form action="cancelarPrestamo.do?User=${Username}" method="post">
               <input type="hidden" id="hdnCodPrestamo" name="hdnCodPrestamo"/>
               <table id=tablaPrestamos style="width:95%">
                  <thead>
                     <tr>
                        <th>C�digo de Prestamo</th>
                        <th>Prestamo dado a la cuenta</th>
                        <th>Monto obtenido</th>
                        <th>Importe total a pagar</th>
                        <th>Pagado en</th>
                        <th>Fecha del pedido</th>
                        <th>Fecha respondido</th>
                        <th>Estado</th>
                        <th></th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach items="${lstPrestxCli}" var="prestxcli">
                        <tr>
                           <td>${prestxcli.getPrestamo().getCodPrestamo()}</td>
                           <td>${prestxcli.getPrestamo().getCuenta().getCBU()}</td>
                           <td>${prestxcli.getPrestamo().getImporteBruto()}</td>
                           <td>${prestxcli.getPrestamo().getImporteNeto()}</td>
                           <td>${prestxcli.getPrestamo().getPlazoenMeses()} cuotas</td>
                           <td>${prestxcli.getPrestamo().getFechaPedido()}</td>
                           <td>${prestxcli.getPrestamo().getFechaRespuesta()}</td>
                           <td>
                              <c:choose>
                                 <c:when test = "${prestxcli.getPrestamo().getEstado()==-1}">
                                    Cancelado
                                 </c:when>
                                 <c:when test = "${prestxcli.getPrestamo().getEstado()==0}">
                                    Pendiente
                                 </c:when>
                                 <c:when test = "${prestxcli.getPrestamo().getEstado()==1}">
                                    Aceptado
                                 </c:when>
                                 <c:when test = "${prestxcli.getPrestamo().getEstado()==2}">
                                    Rechazado
                                 </c:when>
                                 <c:when test = "${prestxcli.getPrestamo().getEstado()==3}">
                                    Pagado
                                 </c:when>
                              </c:choose>
                           </td>
                           <td>
                              <c:choose>
                                 <c:when test = "${prestxcli.getPrestamo().getEstado()==0}">
                                    <input class="boton" style="width:100%" type="submit" onclick='document.getElementById("hdnCodPrestamo").value=${prestxcli.getPrestamo().getCodPrestamo()}' value="Cancelar">
                                 </c:when>
                                 <c:when test = "${prestxcli.getPrestamo().getEstado()==1}">
                                    <input class="boton" style="width:100%" type="button" onclick='window.open("leerCuotasxPrestamo.do?CodPrestamo=${prestxcli.getPrestamo().getCodPrestamo()}&User=${Username}", "_blank", "scrollbars=1,resizable=1,height=1000,width=1150");' value="Pagar">
                                 </c:when>
                                 <c:otherwise>
                                 </c:otherwise>
                              </c:choose>
                           </td>
                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
               ${Msg}
            </form>
         </div>
      </div>
   </body>
</html>