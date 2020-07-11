<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
      <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
      <title>Pago de Cuotas</title>
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
      <div id="titulo" style="position:relative">
         <label class="titulo">Pago de prestamos</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <form action="pagarCuotas.do" method="post">
               <input type="hidden" id="hdnCodPrestamo" name="hdnCodPrestamo" value="${CodPrestamo}"/>
               <c:if test = "${lstCuotxPrest!=null&&lstCuotxPrest.size()>0}">
                  <input type="hidden" id="hdnImporteTotal" name="hdnImporteTotal" value="${lstCuotxPrest.get(0).getImporteMensual()}"/>
               </c:if>
               <input type="hidden" id="hdnUser" name="hdnUser" value="${Username}"/>
               <table id=tablaPrestamos style="width:95%">
                  <thead>
                     <tr>
                        <th></th>
                        <th>Cuota N°</th>
                        <th>Importe mensual</th>
                        <th>Fecha de Realización del Pago</th>
                        <th>Estado</th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach items="${lstCuotxPrest}" var="cuotxprest">
                        <tr>
                           <td>
                              <c:choose>
                                 <c:when test = "${cuotxprest.isEstado()}">
                                 </c:when>
                                 <c:otherwise>
                                    <input type="checkbox" id="chkPagar" name="chkPagar" value="${cuotxprest.getIdCuota()}">
                                 </c:otherwise>
                              </c:choose>
                           </td>
                           <td>${lstCuotxPrest.indexOf(cuotxprest)+1}</td>
                           <td>${cuotxprest.getImporteMensual()}</td>
                           <td>${cuotxprest.getFechaPago()}</td>
                           <td>
                              <c:choose>
                                 <c:when test = "${cuotxprest.isEstado()}">
                                    Pagado
                                 </c:when>
                                 <c:otherwise>
                                    A pagar
                                 </c:otherwise>
                              </c:choose>
                           </td>
                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
               <br>
               <br>
               Seleccione la cuenta con la que desea abonar: 
               <select id="ddlCuenta" name="ddlCuenta">
                  <c:forEach items="${lstAccxUser}" var="accxuser">
                     <c:if test = "${accxuser.getCuenta().getEstado()}">
                        <option value="${accxuser.getCuenta().getCBU()}">
                           <c:choose>
                              <c:when test = "${accxuser.getCuenta().getCodTipoCuenta()==1}">
                                 Caja de ahorro en pesos
                              </c:when>
                              <c:when test = "${accxuser.getCuenta().getCodTipoCuenta()==2}">
                                 Caja de ahorro en dólares
                              </c:when>
                              <c:when test = "${accxuser.getCuenta().getCodTipoCuenta()==3}">
                                 Cuenta corriente
                              </c:when>
                              <c:when test = "${accxuser.getCuenta().getCodTipoCuenta()==4}">
                                 Cuenta corriente especial en pesos
                              </c:when>
                              <c:when test = "${accxuser.getCuenta().getCodTipoCuenta()==5}">
                                 Cuenta corriente especial en dólares
                              </c:when>
                           </c:choose>
                        </option>
                     </c:if>
                  </c:forEach>
               </select>
               <br>
               <br>
               <input class="boton" style="width:45%" type="button" onclick="window.close()" value="Cerrar">
               <input class="boton" style="width:45%" type="submit" value="Pagar">
               ${Msg}
               ${Msg2}
            </form>
         </div>
      </div>
   </body>
</html>

