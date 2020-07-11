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
      <script type="text/javascript" src="JS/Tablas.js"></script>
      <title>Dar Baja/Modificar Cuenta</title>
      <script>
         $(document).ready(function () {
             $('#tablaCuentas').DataTable(
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
         <label class="titulo">Baja y Modificación de Cuentas</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <form action="modificarCuenta.do?User=${Username}" method="post">
               <input type="hidden" id="hdnId" name="hdnId" value=""/>
               <table id="tablaCuentas" style="width:95%">
                  <thead>
                     <tr>
                        <th>CBU</th>
                        <th>Usuario asignado</th>
                        <th>Numero de la Cuenta</th>
                        <th>Nombre de la Cuenta</th>
                        <th>Tipo de Cuenta</th>
                        <th>Saldo</th>
                        <th>Fecha de creación</th>
                        <th>Estado</th>
                        <th></th>
                        <th></th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach items="${lstAccxUser}" var="accxuser">
                        <c:choose>
                           <c:when test = "${accxuser.getCuenta().getCBU()!=-1}">
                              <tr>
                                 <td><input type="hidden" id="hdnCBU" name="hdnCBU" value="${accxuser.getCuenta().getCBU()}"/>
                                    <input type="hidden" id="hdnUsuario" name="hdnUsuario" value="${accxuser.getUsuario().getUsername()}"/>
                                    <input type="hidden" id="hdnNroCuenta" name="hdnNroCuenta" value="${accxuser.getCuenta().getNumeroCuenta()}"/>
                                    <input type="hidden" id="hdnNombre" name="hdnNombre" value="${accxuser.getCuenta().getNombre()}"/>
                                    <input type="hidden" id="hdnTipo" name="hdnTipo" value="${accxuser.getCuenta().getCodTipoCuenta()}"/>
                                    <input type="hidden" id="hdnSaldo" name="hdnSaldo" value="${accxuser.getCuenta().getSaldo()}"/>
                                    <input type="hidden" id="hdnFecha" name="hdnFecha" value="${accxuser.getCuenta().getFecha()}"/>
                                    <input type="hidden" id="hdnEstado" name="hdnEstado" value="${accxuser.getCuenta().getEstado()}"/>
                                    ${accxuser.getCuenta().getCBU()}
                                 </td>
                                 <td>${accxuser.getUsuario().getUsername()}</td>
                                 <td>${accxuser.getCuenta().getNumeroCuenta()}</td>
                                 <td><input type="hidden" id="txtNombre" name="txtNombre"/>${accxuser.getCuenta().getNombre()}</td>
                                 <td>
                                    <input type="hidden" id="ddlTipo" name="ddlTipo"/>
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
                                 </td>
                                <td><input type="hidden" id="txtSaldo" name="txtSaldo"/>${accxuser.getCuenta().getSaldo()}</td>
                                 <td style="text-align:center">${accxuser.getCuenta().getFecha()}</td>
                                 <td>
                                    <c:choose>
                                       <c:when test = "${accxuser.getCuenta().getEstado()==true}">
                                          Activa
                                       </c:when>
                                       <c:otherwise>
                                          Inactiva 
                                       </c:otherwise>
                                    </c:choose>
                                 </td>
                                 <td style="text-align:center"> <input type="button" id="btnModificar" name="btnModificar" class="boton" value="Modificar" onclick="Modificar('tablaCuentas',this.parentElement.parentElement.rowIndex-1)"/></td>
                                 <td style="text-align:center">
                                    <c:choose>
                                       <c:when test = "${accxuser.getCuenta().getEstado()==true}">
                                          <input type="submit" id="btnDesactivar" name="btnDesactivar" class="boton" value="Desactivar" onclick="document.getElementById('hdnId').value=this.parentElement.parentElement.rowIndex-1"/>
                                       </c:when>
                                       <c:otherwise>
                                          <input type="submit" id="btnDesactivar" name="btnDesactivar" class="boton" value="Activar" onclick="document.getElementById('hdnId').value=this.parentElement.parentElement.rowIndex-1"/>
                                       </c:otherwise>
                                    </c:choose>
                                 </td>
                              </tr>
                           </c:when>
                        </c:choose>
                     </c:forEach>
                  </tbody>
               </table>
               ${Msg}
            </form>
         </div>
      </div>
   </body>
</html>

