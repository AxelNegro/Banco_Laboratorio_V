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
      <title>Dar Baja/Modificar Usuarios</title>
      <script>
         $(document).ready(function () {
             $('#tablaUsuarios').DataTable(
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
         <label class="titulo">Alta de Usuarios</label>
      </div>
      <div class="padre">
         <div class="hijo">
            <form action="modificarUser.do?User=${Username}" method="post">
               <input type="hidden" id="hdnId" name="hdnId" value=""/>
               <table style="width:95%" id="tablaUsuarios">
                  <thead>
                     <tr>
                        <th>Usuario</th>
                        <th>Contraseña</th>
                        <th>Tipo de Usuario</th>
                        <th>Estado</th>
                        <th></th>
                        <th></th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach items="${lstUsers}" var="user">
                        <tr>
                           <td>
                              <input type="hidden" name="hdnUser" value="${user.getUsername()}"/>
                              <input type="hidden" name="hdnPass" value="${user.getPassword()}"/>
                              <input type="hidden" name="hdnTipo" value="${user.getTipoUsuario()}"/>
                              <input type="hidden" name="hdnEstado" value="${user.getEstado()}"/>
                              ${user.getUsername()}
                           </td>
                           <td> <input type="hidden" name="txtPassword"/> ${user.getPassword()}</td>
                           <td>
                              <input type="hidden" name="ddlTipo"/>
                              <c:choose>
                                 <c:when test = "${user.getTipoUsuario()==true}">
                                    Banco
                                 </c:when>
                                 <c:otherwise>
                                    Cliente 
                                 </c:otherwise>
                              </c:choose>
                           </td>
                           <td>
                              <c:choose>
                                 <c:when test = "${user.getEstado()==true}">
                                    Activo
                                 </c:when>
                                 <c:otherwise>
                                    Inactivo 
                                 </c:otherwise>
                              </c:choose>
                           </td>
                           <td style="text-align:center"> <input name="btnModificar" type="button" class="boton" value="Modificar" onclick="Modificar('tablaUsuarios',this.parentElement.parentElement.rowIndex-1)"/> </td>
                           <td style="text-align:center">
                              <c:choose>
                                 <c:when test = "${user.getEstado()==true}">
                                    <input name="btnDesactivar" type="submit" class="boton" value="Desactivar" onclick="document.getElementById('hdnId').value=this.parentElement.parentElement.rowIndex-1"/> 
                                 </c:when>
                                 <c:otherwise>
                                    <input name="btnDesactivar" type="submit" class="boton" value="Activar" onclick="document.getElementById('hdnId').value=this.parentElement.parentElement.rowIndex-1"/> 
                                 </c:otherwise>
                              </c:choose>
                           </td>
                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
               ${Msg}
            </form>
         </div>
      </div>
   </body>
</html>
