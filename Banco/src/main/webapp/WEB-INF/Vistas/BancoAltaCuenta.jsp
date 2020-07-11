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
      <jsp:include page="BancoMasterPage.jsp" />
      <link rel="stylesheet" href="CSS/Formato.css" type="text/css">
      </link>
      <script type="text/javascript" src="JS/Tablas.js"></script>
      <title>Cargar Cuentas</title>
      <script>
         $(document).ready(function () {
             $('#tablaAltaCuenta').DataTable(
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
      <div class="padre">
         <form action="agregarCuenta.do?User=${Username}" method="post" style="width:100%">
            <div>
               <label class="titulo"> Alta de Cuentas</label>
               <br>
               <br>
               <div style="float:left;Width:50%">
                  <table id="tablaAltaCuenta">
                     <thead>
                        <tr>
                           <th>DNI</th>
                           <th>Nombre</th>
                           <th>Apellido</th>
                           <th>Fecha de Nacimiento</th>
                           <th>Usuario</th>
                           <th></th>
                        </tr>
                     </thead>
                     <c:forEach items="${lstClientes}" var="cli">
                        <tr>
                           <td>
                              <input type="hidden" id="hdnDNI" name="hdnDNI" value="${cli.getDNI()}"/>
                              <input type="hidden" id="hdnUsuario" name="hdnUsuario" value="${cli.getUsuario().getUsername()}"/>
                              ${cli.getDNI()}
                           </td>
                           <td>${cli.getNombre()}</td>
                           <td>${cli.getApellido()}</td>
                           <td style="text-align:center;"><input type="hidden" name="txtFecha"/>${cli.getFecha()}</td>
                           <td>${cli.getUsuario().getUsername()}</td>
                           <td style="text-align:center"> <input name="btnSeleccionar" type="button" class="boton" value="Seleccionar" onclick="Seleccionar('tablaAltaCuenta',${lstClientes.indexOf(cli)})"/> </td>
                        </tr>
                     </c:forEach>
                     </tbody>
                  </table>
                  ${Msg}
               </div>
               <div style="float:left; padding:2% 0px 0px 50px;Width:45%">
                  CBU:<input type="number" id="txtCBU" name="txtCBU"/>
                  <br>
                  <br>
                  Nombre: <input type="text" id="txtNombre" name="txtNombre"/>
                  Tipo Cuenta:	
                  <select id="ddlTipo" name="ddlTipo" style="width: 159px;">
                     <c:forEach items="${lstTipoAcc}" var="tipoAcc">
                        <option value="${tipoAcc.getCodTipoCuenta()}">${tipoAcc.getTipoCuenta()}</option>
                     </c:forEach>
                  </select>
                  <br>
                  <br>
                  DNI del cliente seleccionado: <input type="text" id="txtDNICli" name="txtDNICli" disabled/>
                  <input type="hidden" id="hdnDNICli" name="hdnDNICli"/>
                  <br>  
                  <br> 
                  Usuario seleccionado:<input type="text" id="txtUsuario" name="txtUsuario" disabled/>
                  <input type="hidden" id="hdnUser" name="hdnUser"/>
                  <br>  
                  <br> 
               </div>
            </div>
            <div style="clear:both;padding-top:2%">
               <input class="boton" type="submit" id="txtAceptar" name="txtAceptar" value="Aceptar"/>
            </div>
         </form>
      </div>
   </body>
</html>

