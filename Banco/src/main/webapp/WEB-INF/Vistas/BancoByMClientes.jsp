<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
      <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <jsp:include page="BancoMasterPage.jsp" />
      <link rel="stylesheet" href="CSS/Formato.css" type="text/css">
      </link>
      <script type="text/javascript" src="JS/Tablas.js"></script>
      <script type="text/javascript" src="JS/Descolgables.js"></script>
      <title>Cargar Clientes</title>
      <script>
         $(document).ready(function () {
             $('#tablaClientes').DataTable(
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
      <div id="titulo">
         <label class="titulo">Baja y Modificación de Clientes</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <form action="modificarCliente.do?User=${Username}" method="post">
               <input type="hidden" id="hdnId" name="hdnId" value=""/>
               <table id=tablaClientes style="width:95%">
                  <thead>
                     <tr>
                        <th>DNI</th>
                        <th>Usuario</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Sexo</th>
                        <th>Fecha de Nacimiento</th>
                        <th>Nacionalidad</th>
                        <th>Provincia</th>
                        <th>Localidad</th>
                        <th>Direccion</th>
                        <th></th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach items="${lstClientes}" var="cli">
                        <tr>
                           <td>
                              <input type="hidden" name="hdnDNI" value="${cli.getDNI()}"/>
                              <input type="hidden" name="hdnUsuario" value="${cli.getUsuario().getUsername()}"/>
                              <input type="hidden" name="hdnNombre" value="${cli.getNombre()}"/>
                              <input type="hidden" name="hdnApellido" value="${cli.getApellido()}"/>
                              <input type="hidden" name="hdnSexo" value="${cli.getSexo()}"/>
                              <input type="hidden" name="hdnFecha" value="${cli.getFecha()}"/>
                              <input type="hidden" name="hdnNacionalidad" value="${cli.getNacionalidad()}"/>
                              <input type="hidden" name="hdnProvincia" value="${cli.getProvincia().getIdProvincia()}"/>
                              <input type="hidden" name="hdnLocalidad" value="${cli.getLocalidad().getIdLocalidad()}"/>
                              <input type="hidden" name="hdnDireccion" value="${cli.getDireccion()}"/>
                              ${cli.getDNI()}
                           </td>
                           <td><input type="hidden" name="ddlUsuario"/>${cli.getUsuario().getUsername()}</td>
                           <td><input type="hidden" name="txtNombre"/>${cli.getNombre()}</td>
                           <td><input type="hidden" name="txtApellido"/>${cli.getApellido()}</td>
                           <td><input type="hidden" name="ddlSexo"/>${cli.getSexo()}</td>
                           <td style="text-align:center;"><input type="hidden" name="txtFecha"/>${cli.getFecha()}</td>
                           <td><input type="hidden" name="txtNacionalidad"/>${cli.getNacionalidad()}</td>
                           <td><input type="hidden" name="ddlProvincia"/>${cli.getProvincia().getDescripcion()}</td>
                           <td><input type="hidden" name="ddlLocalidad"/>${cli.getLocalidad().getDescripcion()}</td>
                           <td><input type="hidden" name="txtDireccion"/>${cli.getDireccion()}</td>
                           <td style="text-align:center"> <input name="btnModificar" type="button" class="boton" value="Modificar" onclick="Modificar('tablaClientes',this.parentElement.parentElement.rowIndex-1)"/> </td>
                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
               ${Msg}
               <div id="divHidden">
                  <div id="hdnUsers">
                     <c:forEach items="${lstUserSinCli}" var="user">
                        <input type="hidden" name="hdnUsers" value="${user.getUsername()}"/>
                     </c:forEach>
                  </div>
                  <div id="hdnProvincias">
                     <c:forEach items="${lstProv}" var="prov">
                        <input type="hidden" name="${prov.getIdProvincia()}" value="${prov.getDescripcion()}"/>
                     </c:forEach>
                  </div>
                  <div id="hdnLocalidades">
                     <c:forEach items="${lstLoc}" var="loc">
                        <input type="hidden" name="${loc.getProvincia().getIdProvincia()}" id="${loc.getIdLocalidad()}" value="${loc.getDescripcion()}"/>
                     </c:forEach>
                  </div>
               </div>
            </form>
         </div>
      </div>
   </body>
</html>

