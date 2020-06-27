function sacarHidden(valor, origen, id){
	if(origen==1){
		var ddl = document.getElementsByName("ddlLocalidad")[id];
	}
	else{
		var ddl = document.getElementById("ddlLocalidad");
	}
	var ddlHijos = ddl.childElementCount;
	var idProv = valor;
	for(var i=0;i<ddlHijos;i++){
		if(ddl.children[i].getAttribute("name")==idProv){
			ddl.children[i].removeAttribute("hidden");
		}
		else{
			ddl.children[i].setAttribute("hidden","true");
		}
	}
	
	ddl.value="";
}