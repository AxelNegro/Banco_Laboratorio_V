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
      <title>Movimientos de la cuenta</title>
      <jsp:include page="ClienteMasterPage.jsp" />
      <link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css">
      <link>
      <script>
         $(document).ready(function () {
             $('#tablaMovimientos').DataTable(
                 {
                     "lengthChange": false,
                     "info": false,
                     "pageLength":5
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
         	<form>
	            <div style="float:left;width:55%">
	               <table id=tablaMovimientos>
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
		                           <td>${movxacc.getCuentaOrig().getCBU()}</td>
		                           <td>${movxacc.getCuentaDest().getCBU()}</td>
		                           <td>${movxacc.getMovimiento().getConcepto()}</td>
		                           <td>${movxacc.getMovimiento().getFecha()}</td>
		                           <td>$ ${movxacc.getMovimiento().getImporte()}</td>
		                     </tr>
	                     </c:forEach>
	                  </tbody>
	               </table>
	            </div>
	            <div style="float:left;width:35%; border:2px solid grey;margin-left:3%">
	            	<c:forEach items="${lstAccxUser}" var="accxuser">
	            		<c:choose>
		            		<c:when test = "${accxuser.getCuenta().getEstado()}">
				                <br>
				                <label style="font-family:Arial;font-size:20px;font-weight:bold">
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
								</label>
								<br>
				                <br>
				                <label style="font-family:Arial;font-size:15px">${accxuser.getCuenta().getNombre()}</label>
				                <br>
				                <br>
				                <label style="font-family:Arial;font-size:15px">$ ${accxuser.getCuenta().getSaldo()}</label>
				                <br>
				                <c:choose>
				                <c:when test = "${lstAccxUser.indexOf(accxuser)!=lstAccxUser.size()-1}">
				                	<hr>
				                </c:when>
				                <c:otherwise>
				                	<br>
				                </c:otherwise>
				                </c:choose>
		            		</c:when>
	            		</c:choose>
	            	</c:forEach>
	            </div>
            </form>
         </div>
      </div>
   </body>
</html>

