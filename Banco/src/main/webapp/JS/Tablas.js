function Modificar(NombreTabla,Fila){
	var Tabla=document.getElementById(NombreTabla);
	var Filas=Tabla.rows[Fila+1];
	var Modificar;
	switch(NombreTabla){
	case 'tablaUsuarios':
		Filas.cells[1].innerHTML='<input type="text" id="txtPassword" name="txtPassword" placeholder="Contraseña"/>';
		Filas.cells[2].innerHTML='<select id="ddlTipo" name="ddlTipo"><option value="true">Banco</option><option value="false">Cliente</option></select>';
		Filas.cells[4].innerHTML='<input name="btnModificar" type="submit" class="boton" value="Aceptar"/>';
		Modificar=document.getElementsByName("btnModificar");
		Modificar[Fila].setAttribute('onclick','document.getElementById("hdnId").value="'+Fila+'"');
		LlenarDatos(NombreTabla,Fila);
	break;
	case 'tablaClientes':
		LlenarDescolgable(Filas.cells[1],'ddlUsuario', Fila);//<input type="text" id="txtUsuario" name="txtUsuario" placeholder="Usuario"/>';
		Filas.cells[2].innerHTML='<input type="text" id="txtNombre" name="txtNombre" placeholder="Nombre"/>';
		Filas.cells[3].innerHTML='<input type="text" id="txtApellido" name="txtApellido" placeholder="Apellido"/>';
		Filas.cells[4].innerHTML='<select id="ddlSexo" name="ddlSexo"><option value="Hombre">Hombre</option><option value="Mujer">Mujer</option></select>';
		Filas.cells[5].innerHTML='<input type="date" id="txtFecha" name="txtFecha"/>';
		Filas.cells[6].innerHTML='<input type="text" id="txtNacionalidad" name="txtNacionalidad" placeholder="Nacionalidad"/>';
		LlenarDescolgable(Filas.cells[7],'ddlProvincia', Fila);//Filas.cells[7].innerHTML='<input type="text" id="txtProvincia" name="txtProvincia" placeholder="Provincia"/>';
		LlenarDescolgable(Filas.cells[8],'ddlLocalidad', Fila);//Filas.cells[8].innerHTML='<select id="ddlLocalidad" name="ddlLocalidad" placeholder="Localidad"><option><option></select>';
		Filas.cells[9].innerHTML='<input type="text" id="txtDireccion" name="txtDireccion" placeholder="Dirección"/>';
		Filas.cells[10].innerHTML='<input name="btnModificar" type="submit" class="boton" value="Aceptar"/>';
		Modificar=document.getElementsByName("btnModificar");
		Modificar[Fila].setAttribute('onclick','document.getElementById("hdnId").value="'+Fila+'"');
		LlenarDatos(NombreTabla,Fila);
	break;
	case 'tablaCuentas':
		Filas.cells[3].innerHTML='<input type="text" id="txtNombre" name="txtNombre" placeholder="Nombre"/>';
		Filas.cells[4].innerHTML='<select id="ddlTipo" name="ddlTipo"><option value="1">Caja de ahorro en pesos</option><option value="2">Caja de ahorro en dólares</option><option value="3">Cuenta corriente</option><option value="4">Cuenta corriente especial en pesos</option><option value="5">Cuenta corriente especial en dólares</option></select>';
		Filas.cells[5].innerHTML='<input type="number" id="txtSaldo" name="txtSaldo" placeholder="Saldo" step="0.01"/>';
		Filas.cells[8].innerHTML='<input name="btnModificar" type="submit" class="boton" value="Aceptar"/>';
		Modificar=document.getElementsByName("btnModificar");
		Modificar[Fila].setAttribute('onclick','document.getElementById("hdnId").value="'+Fila+'"');
		LlenarDatos(NombreTabla,Fila);
	break;
	}
}

function LlenarDatos(NombreTabla, Fila){
	var Tabla=document.getElementById(NombreTabla);
	var Filas=Tabla.rows[Fila+1];
	switch(NombreTabla){
	case 'tablaUsuarios':
		Filas.cells[1].children[0].value=document.getElementsByName('hdnPass')[Fila].value;
		Filas.cells[2].children[0].value=document.getElementsByName('hdnTipo')[Fila].value;
	case 'tablaClientes':
		Filas.cells[1].children[0].value=document.getElementsByName('hdnUsuario')[Fila].value;
		Filas.cells[2].children[0].value=document.getElementsByName('hdnNombre')[Fila].value;
		Filas.cells[3].children[0].value=document.getElementsByName('hdnApellido')[Fila].value;
		Filas.cells[4].children[0].value=document.getElementsByName('hdnSexo')[Fila].value;
		Filas.cells[5].children[0].value=document.getElementsByName('hdnFecha')[Fila].value;
		Filas.cells[6].children[0].value=document.getElementsByName('hdnNacionalidad')[Fila].value;
		Filas.cells[7].children[0].value=document.getElementsByName('hdnProvincia')[Fila].value;
		Filas.cells[8].children[0].value=document.getElementsByName('hdnLocalidad')[Fila].value;
		Filas.cells[9].children[0].value=document.getElementsByName('hdnDireccion')[Fila].value;
	break;
	case 'tablaCuentas':
		Filas.cells[3].children[0].value=document.getElementsByName('hdnNombre')[Fila].value;
		Filas.cells[4].children[0].value=document.getElementsByName('hdnTipo')[Fila].value;
		Filas.cells[5].children[0].value=document.getElementsByName('hdnSaldo')[Fila].value;
	break;
	}
}

function Seleccionar(NombreTabla, Fila){
	switch(NombreTabla){
	case 'tablaAltaCuenta':
		document.getElementById("txtDNICli").value=document.getElementsByName("hdnDNI")[Fila].value;
		document.getElementById("hdnDNICli").value=document.getElementsByName("hdnDNI")[Fila].value;
		document.getElementById("txtUsuario").value=document.getElementsByName("hdnUsuario")[Fila].value;
		document.getElementById("hdnUser").value=document.getElementsByName("hdnUsuario")[Fila].value;
	break;
	}
}

function LlenarDescolgable(Celda, Nombre, Fila){
	var Cadena
	switch(Nombre){
		case 'ddlUsuario':
			var div = document.getElementById('hdnUsers');
			var usuarios = div.childElementCount;
			var usuario=document.getElementsByName('hdnUsuario')[Fila].value;
			var valor;
			Cadena='<select id="ddlUsuario" name="ddlUsuario" placeholder="Usuario"><option value="'+usuario+'">'+usuario+'</option>'
			for(var i=0;i<usuarios;i++){
				valor=div.children[i].value;
				Cadena+='<option value="'+valor+'">'+valor+'</option>';
			}
			Cadena+='</select>';
			Celda.innerHTML=Cadena;
		break;
		case 'ddlProvincia':
			var div = document.getElementById('hdnProvincias');
			var provincias = div.childElementCount;
			var nombre;
			var valor;
			Cadena='<select id="ddlProvincia" name="ddlProvincia" onchange="sacarHidden(this.value,1,'+Fila+')" placeholder="Provincia"><option></option>';
			for(var i=0;i<provincias;i++){
				nombre=div.children[i].getAttribute("name");
				valor=div.children[i].value;
				Cadena+='<option value="'+nombre+'">'+valor+'</option>';
			}
			Cadena+='</select>';
			Celda.innerHTML=Cadena;
		break;
		case 'ddlLocalidad':
			var div = document.getElementById('hdnLocalidades');
			var localidades = div.childElementCount;
			var nombre;
			var valor;
			Cadena='<select id="ddlLocalidad" name="ddlLocalidad" placeholder="Localidad"><option></option>';
			for(var i=0;i<localidades;i++){
				id=div.children[i].getAttribute("id");
				nombre=div.children[i].getAttribute("name");
				valor=div.children[i].value;
				Cadena+='<option name="'+nombre+'" value="'+id+'" hidden>'+valor+'</option>';
			}
			Cadena+='</select>';
			Celda.innerHTML=Cadena;
		break;
	}
}