<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Transferencia bancaria a cuentas de terceros</title>
      <jsp:include page="ClienteMasterPage.jsp" />
      <link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css">
      <link>
   </head>
   <body>
      <div id="titulo">
         <label class="titulo">Transferencia a cuentas de terceros</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <form>
               Transferencia Desde el CBU:
               <select style="margin-bottom:1%">
                  <option>Cuenta Corriente - CBU 156871278457</option>
               </select>
               <br>
               Transferencia al CBU:
               <input style="margin-bottom:1%" type="number"/>
               <input class="botoncargar" type="button" onclick='window.open("ClienteTransInfo.do?User=${Username}", "_blank", "scrollbars=1,resizable=1,height=400,width=1150");' value="Informacion de la cuenta">
               <br>
               Importe a Transferir:
               <input style="margin-bottom:1%" type="number" min="1000"/>
               <br>
               Concepto:
               <select style="margin-bottom:1%">
                  <option>Varios</option>
               </select>
               <br>
               <input class="botoncargar" type="submit" value="Transferir">
            </form>
         </div>
      </div>
   </body>
</html>

