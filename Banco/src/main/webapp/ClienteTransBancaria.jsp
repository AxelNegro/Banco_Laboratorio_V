

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Transferencia Bancaria</title>
      <jsp:include page="ClienteMasterPage.html" />
      <link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css">
      <link>
   </head>
   <body>
      <div id="titulo">
         <label class="titulo">Transferir a terceros</label>
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
               <br>
               Importe a Transferir:
               <input style="margin-bottom:1%" type="number" min="1000"/>
               <br>
               Concepto:
               <select style="margin-bottom:1%">
                  <option>Varios</option>
               </select>
               <br>
               <input style="width:30%"type="submit" value="Transferir">
            </form>
         </div>
      </div>
   </body>
</html>

