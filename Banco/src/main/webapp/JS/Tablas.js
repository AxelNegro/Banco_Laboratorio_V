function Modificar(NombreTabla,Fila){
	var Tabla=document.getElementById(NombreTabla);
	var Filas=Tabla.rows[Fila+1];
	var Modificar;
	if(NombreTabla=='tablaUsuarios'){
		Filas.cells[1].innerHTML='<input type="text" id="txtPassword" name="txtPassword" placeholder="Contraseña"/>';
		Filas.cells[2].innerHTML='<select id="ddlTipo" name="ddlTipo"><option value="true">Banco</option><option value="false">Cliente</option></select>';
		Filas.cells[4].innerHTML='<input name="btnModificar" type="submit" class="botoncargar" value="Aceptar"/>';
		Modificar=document.getElementsByName("btnModificar");
		Modificar[Fila].setAttribute('onclick','document.getElementById("hdnId").value="'+Fila+'"');
	}
}