<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
      <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <jsp:include page="BancoMasterPage.jsp" />
      <link rel="stylesheet" href="CSS/Formato.css" type="text/css">
      <link>
      <title>Reportes de Movimientos del Banco</title>
      <script>
         $(document).ready(function () {
             $('#tablaReportes').DataTable(
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
         <label class="titulo">Reportes de Movimientos del Banco</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <form action="filtrarMovimientos.do?User=${Username}" method="post">
               Buscar entre las fechas <input type="date" id="txtFecha1" name="txtFecha1"/> y <input type="date" id="txtFecha2" name="txtFecha2"/>	
               <br>
               <br>
               <input type="submit" id="btnFiltrar" name="btnFiltrar" class="boton" value="Filtrar"/>
               <br>
               <table id=tablaReportes style="width:95%">
                  <thead>
                     <tr>
                        <th>Nro. de Movimiento</th>
                        <th>CBU Origen</th>
                        <th>CBU Destino</th>
                        <th>Concepto del Movimiento</th>
                        <th>Fecha del Movimiento</th>
                        <th>Importe del Movimiento</th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach items="${lstMovxAcc}" var="movxacc">
                        <tr>
                           <td>${movxacc.getMovimiento().getCodMovimiento()}</td>
                           <td>
                              <c:choose>
                                 <c:when test= "${movxacc.getCuentaOrig().getCBU() == -1}">
                                    Banco
                                 </c:when>
                                 <c:otherwise>${movxacc.getCuentaOrig().getCBU()}</c:otherwise>
                              </c:choose>
                           </td>
                           <td>
                              <c:choose>
                                 <c:when test= "${movxacc.getCuentaDest().getCBU() == -1}">
                                    Banco
                                 </c:when>
                                 <c:otherwise>${movxacc.getCuentaDest().getCBU()}</c:otherwise>
                              </c:choose>
                           </td>
                           <td>${movxacc.getMovimiento().getConcepto().getDescripcion()}</td>
                           <td>${movxacc.getMovimiento().getFecha()}</td>
                           <td>$ ${movxacc.getMovimiento().getImporte()}</td>
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

