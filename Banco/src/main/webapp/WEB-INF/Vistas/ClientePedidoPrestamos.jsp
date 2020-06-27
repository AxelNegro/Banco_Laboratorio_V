

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Solicitud de Prestamo</title>
      <jsp:include page="ClienteMasterPage.jsp" />
      <link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css">
      <link>
   </head>
   <body>
      <div id="titulo">
         <label class="titulo">Solicitar Prestamo</label> 
      </div>
      <div class="padre">
         <div class="hijo">
            <form>
               <div>
                  <br>
                  Prestamo para la Cuenta: 
                  <select>
                     <option>Cuenta Corriente - CBU 156871278457</option>
                  </select>
                  <br>
                  Dinero Solicitado: </label>
                  <input type="number" min="10000" Value="10000"/>
                  <br>
                  <label>Plazo de Pago:</label>
                  <select name="ddlPlazo">
                  	<option value="3">3 Meses</option>
                  	<option value="6">6 Meses</option>
                  	<option value="12">12 Meses</option>
                  	<option value="24">24 Meses</option>
                  </select>
                  <br><br>
                  <input type="submit" class="botoncargar" value="Calcular">
                  <h1>Datos Finales del Prestamo</h1>
                  <label>Prestamo para la Cuenta: </label>
                  <label>Cuenta Corriente - CBU 156871278457</label>
                  <br>
                  <label>Dinero Solicitado: </label>
                  <label> $ 10000</label> 
                  <br>
                  <label>Plazo de Pago:</label>
                  <label> 6 Meses</label> 
                  <br>
                  <label>Interes:</label>
                  <label> 10% </label> 
                  <br>
                  <Label>Cuotas de :</Label>
                  <label> $ 1833.33</label> 
                  <br><br>
                  <input type="submit" class="botoncargar" value="Enviar">
                  <input type="submit" class="botoncargar" value="Modificar">
                  <input type="submit" class="botoncargar" value="Cancelar">
               </div>
            </form>
         </div>
      </div>
   </body>
</html>
