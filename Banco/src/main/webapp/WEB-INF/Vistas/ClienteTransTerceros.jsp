<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Transferencia bancaria a cuentas de terceros</title>
      <jsp:include page="ClienteMasterPage.jsp" />
      <link rel="stylesheet" href="CSS/Formato.css" type="text/css">
      </link>
      <script type="text/javascript" src="JS/Popup.js"></script>
   </head>
   <body>
      <div id="titulo">
         <label class="titulo">Transferencia a cuentas de terceros</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <form action="realizarTransTerc.do?User=${Username}" method="post">
               Transferencia Desde el CBU:
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
               Transferencia al CBU:
               <input type="number" id="txtCBUDestino" name="txtCBUDestino" style="margin-bottom:1%"/>
               <input type="button" id="btnInformacion" name="btnInformacion" class="boton"  onclick='obtenerDatos("${Username}",document.getElementById("txtCBUDestino").value)' value="Informacion de la cuenta">
               <br>
               Importe a Transferir:
               <input type="number" id="txtImporte" name="txtImporte" step="0.01" style="margin-bottom:1%"/>
               <br>
               Concepto:
               <select id="ddlConcepto" name="ddlConcepto" style="margin-bottom:1%">
                  <c:forEach items="${lstConceptos}" var="concepto">
                     <option value="${concepto.getIdConcepto()}">${concepto.getDescripcion()}</option>
                  </c:forEach>
               </select>
               <br>
               <input type="submit" id="btnTransferir" name="btnTransferir" class="boton"  value="Transferir">
               ${Msg}
            </form>
         </div>
      </div>
   </body>
</html>