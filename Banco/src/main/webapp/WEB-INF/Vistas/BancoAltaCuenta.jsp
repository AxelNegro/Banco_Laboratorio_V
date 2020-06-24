

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
      <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
      <jsp:include page="BancoMasterPage.jsp" />
      <link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css">
      <link>
      <title>Cargar Cuentas</title>
      <script>
         $(document).ready(function () {
             $('#tablaBancoAltaCuenta').DataTable(
                 {
                     "lengthChange": false,
                     "info": false
                 }
             );
         });
      </script>
   </head>
   <body>
      <div class="padre">
         <form style="width:100% ">
            <div>
               <label class="titulo"> Alta de Cuentas</label>
               <br>
               <br>
               <div style="float:left;Width:50%">
                  <table id="tablaAltaCuentas">
                     <thead>
                        <tr>
                           <th>Dni</th>
                           <th>Nombre</th>
                           <th>Apellido</th>
                           <th>Fecha Nacimiento</th>
                           <th>Usuario</th>
                           <th>Seleccionar</th>
                        </tr>
                     </thead>
                     <tbody>
                        <tr>
                           <td>1549682</td>
                           <td>Alfredo</td>
                           <td>Torres</td>
                           <td style="text-align:center">16/2/1950</td>
                           <td>Alfredo123</td>
                           <td style="text-align:center"><input class="botoncargar" id="btnSeleccionar" type="button" value="Seleccionar"/></td>
                        </tr>
                     </tbody>
                  </table>
               </div>
               <div style="float:left; padding:2% 0px 0px 50px;Width:45%">
                  Cbu:<input type="text" id="txtCBU" name="txtCBU"/>
                  Numero Cuenta: <input type="number" id="txtNroCuenta" name="txtNroCuenta"/>
                  <br>
                  <br>
                  Nombre: <input type="text" id="txtNombre" name="txtNombre"/>
                  Tipo Cuenta:	
                  <select id="ddlTipo" name="ddlTipo" style="width: 159px;">
                     <option value="ahorroPesos">Caja de ahorro en pesos</option>
                     <option value="ahorroDolares">Caja de ahorro en dólares</option>
                     <option value="ctaCte">Cuenta corriente</option>
                     <option value="ctaCteEspPesos">Cuenta corriente especial en pesos</option>
                     <option value="ctaCteEspDolares">Cuenta corriente especial en dólares</option>
                  </select>
                  <br>
                  <br>
                  Saldo: <input type="number" id="txtSaldo" name="txtSaldo" />
                  Fecha Creacion:	<input type="date" id="txtFecha" name="txtFecha" min="1900-01-01">
                  <br>
                  <br>
                  DNI del cliente seleccionado: <input id="txtDNICli" name="txtDNICli" disabled></input>
                  <br>  
                  <br> 
                  Nombre del cliente seleccionado:<input id="txtNombreCli" name="txtNombreCli" disabled ></input>
                  <br>  
                  <br> 
               </div>
            </div>
            <div style="clear:both;padding-top:2%">
               <input class="botoncargar" type="button" id="txtAceptar" name="txtAceptar" value="Aceptar"/>
            </div>
         </form>
      </div>
   </body>
</html>

