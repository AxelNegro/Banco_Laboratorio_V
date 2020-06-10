<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<jsp:include page="BancoMasterPage.html" />
<link rel="stylesheet" href="CSS/UsuarioBanco.css" type="text/css"><link>
<title>Aprobar Creditos</title>
<script>
        $(document).ready(function () {
            $('#tablaBancoCliente').DataTable(
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
	<form >	
				<table id=tablaBancoCliente>
				  <thead>
					  <tr>
					    <th>Dni </th>
					    <th>Nombre</th>
					    <th>Apellido</th>
					    <th>Cbu</th>
					    <th>Numero Cuenta</th>
					    <th>Tipo de Cuenta</th>
					    <th>Monton solicitado</th>
					    <th>Plazo Pago</th>
					    <th>Interes</th>
					    <th>Cuotas de </th>
					    <th>Aprobar</th>
					    <th>Rechazar</th>
					  </tr>
					    </thead>
	            <tbody>
					  <tr>
					    <td>1549682</td>
					    <td>Alfredo</td>
					    <td>Torres</td>
					    <td>0000545167856180</td>
					    <td>1232</td>
					    <td>Cuenta Corriente</td>
					    <td>$10000</td>
					    <td>5 meses</td>
					    <td>10%</td>
					    <td>$2200</td>
					    <td> <input class="btntabla" id="btnAprobarCredito" type="button" value="Aprobar"/></td>
					   <td> <input class="btntabla" id="btnRechazarCredito" type="button" value="Rechazar"/></td>
					  </tr>
					  
				      </tbody>
			</table>
	
	
	</form>
	</div>
</body>
</html>