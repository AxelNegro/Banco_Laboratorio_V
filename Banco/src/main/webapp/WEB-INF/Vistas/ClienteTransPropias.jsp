<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Transferencia bancaria a cuentas propias</title>
      <jsp:include page="ClienteMasterPage.jsp" />
      <link rel="stylesheet" href="CSS/Formato.css" type="text/css">
      </link>
   </head>
   <body>
      <div id="titulo">
         <label class="titulo">Transferencia a cuentas propias</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <form action="realizarTransProp.do?User=${Username}" method="post">
               Transferencia desde la cuenta origen:
               <select id="ddlCuentaOrigen" name="ddlCuentaOrigen" style="margin-bottom:1%">
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
               Transferencia hacia la cuenta destino:
               <select id="ddlCuentaDest" name="ddlCuentaDest" style="margin-bottom:1%">
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
               Importe a Transferir:
               <input type="number" id="txtImporte" name="txtImporte" placeholder="Importe" step="0.01" style="margin-bottom:1%"/>
               <br>
               <input type="submit" id="btnTransferir" name="btnTransferir" class="boton" value="Transferir">
               ${Msg}
            </form>
         </div>
      </div>
   </body>
</html>
