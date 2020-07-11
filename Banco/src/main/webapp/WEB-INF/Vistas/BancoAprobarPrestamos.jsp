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
      </link>
      <title>Aprobar prestamos</title>
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
         
         function Asignar(CodPrestamo,Fila){
          document.getElementById('hdnCodPrestamo').value=CodPrestamo;
          document.getElementById('hdnFila').value=Fila;
         }
      </script>
   </head>
   <body>
      <div id="titulo">
         <label class="titulo">Aprobar prestamos</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <form action="aprobarPrestamos.do?User=${Username}" method="post">
               <input type="hidden" id="hdnCodPrestamo" name="hdnCodPrestamo"/>
               <input type="hidden" id="hdnFila" name="hdnFila"/> 
               <table id=tablaPrestamos style="width:95%">
                  <thead>
                     <tr>
                        <th>Cod. de prestamo</th>
                        <th>DNI</th>
                        <th>Nombre y apellido</th>
                        <th>CBU</th>
                        <th>Numero de cuenta</th>
                        <th>Tipo de cuenta</th>
                        <th>Monto solicitado</th>
                        <th>Monto neto a pagar</th>
                        <th>Plazo de pago</th>
                        <th>Fecha de pedido</th>
                        <th></th>
                        <th></th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach items="${lstPrestxCli}" var="prestxcli">
                        <tr>
                           <td>${prestxcli.getPrestamo().getCodPrestamo()}</td>
                           <td>${prestxcli.getCliente().getDNI()}</td>
                           <td>${prestxcli.getCliente().getNombre()} ${prestxcli.getCliente().getApellido()}</td>
                           <td>${prestxcli.getPrestamo().getCuenta().getCBU()}</td>
                           <td>${prestxcli.getPrestamo().getCuenta().getNumeroCuenta()}</td>
                           <td>
                              <c:choose>
                                 <c:when test = "${prestxcli.getPrestamo().getCuenta().getCodTipoCuenta()==1}">
                                    Caja de ahorro en pesos
                                 </c:when>
                                 <c:when test = "${prestxcli.getPrestamo().getCuenta().getCodTipoCuenta()==2}">
                                    Caja de ahorro en dólares
                                 </c:when>
                                 <c:when test = "${prestxcli.getPrestamo().getCuenta().getCodTipoCuenta()==3}">
                                    Cuenta corriente
                                 </c:when>
                                 <c:when test = "${prestxcli.getPrestamo().getCuenta().getCodTipoCuenta()==4}">
                                    Cuenta corriente especial en pesos
                                 </c:when>
                                 <c:when test = "${prestxcli.getPrestamo().getCuenta().getCodTipoCuenta()==5}">
                                    Cuenta corriente especial en dólares
                                 </c:when>
                              </c:choose>
                           </td>
                           <td>${prestxcli.getPrestamo().getImporteBruto()}</td>
                           <td>${prestxcli.getPrestamo().getImporteNeto()}</td>
                           <td>${prestxcli.getPrestamo().getPlazoenMeses()} meses</td>
                           <td>${prestxcli.getPrestamo().getFechaPedido()}</td>
                           <td> <input class="boton" id="btnAprobar" name="btnAprobar" type="submit" onclick="Asignar('${prestxcli.getPrestamo().getCodPrestamo()}',this.parentElement.parentElement.rowIndex-1);" value="Aprobar"/></td>
                           <td> <input class="boton" id="btnRechazar" name="btnRechazar" type="submit" onclick="Asignar('${prestxcli.getPrestamo().getCodPrestamo()}',this.parentElement.parentElement.rowIndex-1);" value="Rechazar"/></td>
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
