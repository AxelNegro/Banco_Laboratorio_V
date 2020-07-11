<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Solicitud de Prestamo</title>
      <jsp:include page="ClienteMasterPage.jsp" />
      <link rel="stylesheet" href="CSS/Formato.css" type="text/css">
      </link>
      <script type="text/javascript" src="JS/Prestamos.js"></script>
   </head>
   <body>
      <div id="titulo">
         <label class="titulo">Solicitar Prestamo</label> 
      </div>
      <div class="padre">
         <div class="hijo">
            <form action="pedidoPrestamo.do?User=${Username}" method="post">
               Prestamo para la Cuenta: 
               <select id="ddlCuenta" name="ddlCuenta" onchange="Asignar(this,0)">
                  <option></option>
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
               Dinero Solicitado:
               <input type="number" id="txtImporte" name="txtImporte" onchange="Asignar(this,1);Calcular(this,document.getElementById('ddlPlazo'))"/>
               <br>
               <br>
               Plazo de Pago:
               <select id="ddlPlazo" name="ddlPlazo" onchange="Asignar(this,2);Calcular(document.getElementById('txtImporte'),this)">
                  <option></option>
                  <option value="3">3 Meses</option>
                  <option value="6">6 Meses</option>
                  <option value="12">12 Meses</option>
                  <option value="24">24 Meses</option>
               </select>
               <br>
               <br>
               <h1>Datos Finales del Prestamo</h1>
               <input type="hidden" id="hdnImporteTotal" name="hdnImporteTotal"/>
               <input type="hidden" id="hdnImporteCuotas" name="hdnImporteCuotas"/>
               <div style="float:left;width:49%;text-align:right">
                  Prestamo para la Cuenta:
                  <label id="lblCuenta">Especifique una cuenta.</label>
                  <br>
                  <br>
                  Dinero Solicitado:
                  <label id="lblDinero">Especifique un importe.</label> 
                  <br>
                  <br>
                  Plazo de Pago:
                  <label id="lblCuotas">Especifique la cantidad de cuotas.</label> 
                  <br>
               </div>
               <div style="float:left;width:35%; margin-left:3%;text-align:left">
                  Interes:
                  <label id="lblInteres">Especifique la cantidad de cuotas.</label> 
                  <br>
                  <br>
                  Importe total de: <label id="lblImporteTotal">Especifique el importe solicitado y la cantidad de cuotas.</label> 
                  <br>
                  <br>
                  Cuotas de:
                  <label id="lblImporteCuotas">Especifique el importe solicitado y la cantidad de cuotas.</label> 
                  <br>
               </div>
               <br>
               <div style="clear:both;padding-top:2%">
                  <input type="submit" id="btnEnviar" name="btnEnviar" class="boton" value="Enviar">
               </div>
               ${Msg}
            </form>
         </div>
      </div>
   </body>
</html>

