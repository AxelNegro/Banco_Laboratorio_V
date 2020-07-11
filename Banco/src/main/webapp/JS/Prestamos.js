function Asignar(Control, Origen){
	switch(Origen){
		case 0:
			if(Control.options[Control.selectedIndex].text.trim()!=""){
				document.getElementById("lblCuenta").innerText=Control.options[Control.selectedIndex].text;
			}
			else{
				document.getElementById("lblCuenta").innerText="Especifique una cuenta.";
			}
		break;
		case 1:
			if(Control.value.trim()!=""){
				document.getElementById("lblDinero").innerText=Control.value;
			}
			else{
				document.getElementById("lblDinero").innerText="Especifique un importe.";
			}
		break;
		case 2:
			if(Control.options[Control.selectedIndex].text.trim()!=""){
				document.getElementById("lblCuotas").innerText=Control.options[Control.selectedIndex].text;
				switch(Control.value){
					case '3':
						document.getElementById("lblInteres").innerText="5";
					break;
					case '6':
						document.getElementById("lblInteres").innerText="10";
					break;
					case '12':
						document.getElementById("lblInteres").innerText="20";
					break;
					case '24':
						document.getElementById("lblInteres").innerText="40";
					break;
					default:
						document.getElementById("lblInteres").innerText="Especifique la cantidad de cuotas.";
					break;
				}
			}
			else{
				document.getElementById("lblCuotas").innerText="Especifique la cantidad de cuotas.";
				document.getElementById("lblInteres").innerText="Especifique la cantidad de cuotas.";
			}
		break;
	}
}

function Calcular(Importe, Cuotas){
	var Interes;
	var ImporteTotal;
	var ImporteCuotas;
	if(Importe.value.trim()!=""&&Cuotas.options[Cuotas.selectedIndex].text.trim()!=""){
		switch(Cuotas.value){
		case '3':
			Interes=1.05;
		break;
		case '6':
			Interes=1.10;
		break;
		case '12':
			Interes=1.20;
		break;
		case '24':
			Interes=1.40;
		break;
		default:
			document.getElementById("lblImporteTotal").innerText="Especifique el importe solicitado y la cantidad de cuotas.";
			document.getElementById("lblImporteCuotas").innerText="Especifique el importe solicitado y la cantidad de cuotas.";
		break;
		}
		ImporteTotal=Importe.value*Interes;
		ImporteCuotas=ImporteTotal/Cuotas.value;
		
		document.getElementById("hdnImporteTotal").value=ImporteTotal.toFixed(2);
		document.getElementById("hdnImporteCuotas").value=ImporteCuotas.toFixed(2);
		document.getElementById("lblImporteTotal").innerText=ImporteTotal.toFixed(2);
		document.getElementById("lblImporteCuotas").innerText=ImporteCuotas.toFixed(2);
	}
	else{
		document.getElementById("hdnImporteTotal").innerText="";
		document.getElementById("hdnImporteCuotas").innerText="";
		document.getElementById("lblImporteTotal").innerText="Especifique el importe solicitado y la cantidad de cuotas.";
		document.getElementById("lblImporteCuotas").innerText="Especifique el importe solicitado y la cantidad de cuotas.";
	}
}