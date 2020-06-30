<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Transferencia bancaria a cuentas propias</title>
      <jsp:include page="ClienteMasterPage.jsp" />
      <link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css">
      <link>
   </head>
   <body>
      <div id="titulo">
         <label class="titulo">Transferencia a cuentas propias</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <form>
               Transferencia desde la cuenta origen:
               <select style="margin-bottom:1%">
                  <option>Cuenta Corriente - CBU 156871278457</option>
               </select>
               <br>
               Transferencia hacia la cuenta destino:
               <select style="margin-bottom:1%">
                  <option>Caja de ahorro en pesos - CBU 324322313</option>
               </select>
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

