function Modificar(NombreTabla,Fila){
	var Tabla=document.getElementById(NombreTabla);
	var Filas=Tabla.rows[Fila+1];
	var Modificar;
	switch(NombreTabla){
	case 'tablaUsuarios':
		Filas.cells[1].innerHTML='<input type="text" id="txtPassword" name="txtPassword" placeholder="Contraseña"/>';
		Filas.cells[2].innerHTML='<select id="ddlTipo" name="ddlTipo"><option value="true">Banco</option><option value="false">Cliente</option></select>';
		Filas.cells[4].innerHTML='<input name="btnModificar" type="submit" class="botoncargar" value="Aceptar"/>';
		Modificar=document.getElementsByName("btnModificar");
		Modificar[Fila].setAttribute('onclick','document.getElementById("hdnId").value="'+Fila+'"');
	break;
	case 'tablaClientes':
		Filas.cells[1].innerHTML='<input type="text" id="txtUsuario" name="txtUsuario" placeholder="Usuario"/>';
		Filas.cells[2].innerHTML='<input type="text" id="txtNombre" name="txtNombre" placeholder="Nombre"/>';
		Filas.cells[3].innerHTML='<input type="text" id="txtApellido" name="txtApellido" placeholder="Apellido"/>';
		Filas.cells[4].innerHTML='<select id="ddlSexo" name="ddlSexo"><option value="Hombre">Hombre</option><option value="Mujer">Mujer</option></select>';
		Filas.cells[5].innerHTML='<input type="date" id="txtFecha" name="txtFecha"/>';
		Filas.cells[6].innerHTML='<input type="text" id="txtNacionalidad" name="txtNacionalidad" placeholder="Nacionalidad"/>';
		Filas.cells[7].innerHTML='<input type="text" id="txtProvincia" name="txtProvincia" placeholder="Provincia"/>';
		Filas.cells[8].innerHTML='<input type="text" id="txtLocalidad" name="txtLocalidad" placeholder="Localidad"/>';
		Filas.cells[9].innerHTML='<input type="text" id="txtDireccion" name="txtDireccion" placeholder="Dirección"/>';
		Filas.cells[10].innerHTML='<input name="btnModificar" type="submit" class="botoncargar" value="Aceptar"/>';
		Modificar=document.getElementsByName("btnModificar");
		Modificar[Fila].setAttribute('onclick','document.getElementById("hdnId").value="'+Fila+'"');
	break;
	default:
	break;
	}
}

/*function LimpiarTabla(NombreTabla){
	var Tabla=document.getElementById(NombreTabla);
	for(var i = 0; i < Tabla.rows.length; i++){
		LimpiarFila(NombreTabla,i);
	}
}

function LimpiarFila(NombreTabla, Fila){
	var Tabla=document.getElementById(NombreTabla);
	var Filas=Tabla.rows[Fila+1];
	var Modificar;
	if(NombreTabla=='tablaUsuarios'){
		Filas.cells[1].innerHTML='${user.getPassword()}';
		Filas.cells[2].innerHTML='<input type="hidden" name="ddlTipo"/><c:choose><c:when test = "${user.getTipoUsuario()==true}">Banco</c:when><c:otherwise>Cliente</c:otherwise></c:choose>';
		Filas.cells[4].innerHTML='<input name="btnModificar" type="button" class="botoncargar" value="Modificar" onclick=""/>';
		Modificar=document.getElementsByName("btnModificar");
		Modificar[Fila].setAttribute('onclick','Modificar("tablaUsuarios",${lstUsers.indexOf(user)})');
	}
}*/