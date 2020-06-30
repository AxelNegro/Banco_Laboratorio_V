package presentacion;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import config.ConfigEnt;
import config.ConfigNeg;
import entidad.Cuenta;
import entidad.Cuentas_x_Usuario;
import entidad.Movimientos_x_Cuenta;
import negocio.Cuentas_x_UsuarioNeg;
import negocio.Movimientos_x_CuentaNeg;

@Controller
public class CuentaClienteController {
	private ApplicationContext appContextEnt;
	private ApplicationContext appContextNeg;
	
	public void InicializarEnt() {
		appContextEnt=new AnnotationConfigApplicationContext(ConfigEnt.class);
	}
	
	public void InicializarNeg() {
		appContextNeg=new AnnotationConfigApplicationContext(ConfigNeg.class);
	}
	
	public void FinalizarEnt() {
		((ConfigurableApplicationContext)(appContextEnt)).close();
	}
	
	public void FinalizarNeg() {
		((ConfigurableApplicationContext)(appContextNeg)).close();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("estadoCuentas.do")
	public String ObtenerHistorial(String User, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		Cuentas_x_UsuarioNeg accxuserNeg = (Cuentas_x_UsuarioNeg) appContextNeg.getBean("accxuserNeg");
		Movimientos_x_CuentaNeg movxaccNeg = (Movimientos_x_CuentaNeg) appContextNeg.getBean("movxaccNeg");
		List<Cuentas_x_Usuario> lstAccxUser=accxuserNeg.leerCuentasxUsuario(User);
		List<Cuenta> lstCBUs= (List<Cuenta>) appContextEnt.getBean("LstCuentasDefault");
		
		for(Cuentas_x_Usuario accxuser : lstAccxUser){
			lstCBUs.add(accxuser.getCuenta());
		}
		
		//CBUs+="";
		
		List<Movimientos_x_Cuenta> lstMovxAcc = movxaccNeg.obtenerHistorialCuenta(lstCBUs);
		
		for(Movimientos_x_Cuenta mov : lstMovxAcc) {
			System.out.println(mov.toString());
		}
		
		m.addAttribute("lstAccxUser",lstAccxUser);
		m.addAttribute("lstMovxAcc",lstMovxAcc);
		m.addAttribute("Username", User);
		
		accxuserNeg.Finalizar();
		movxaccNeg.Finalizar();
		FinalizarNeg();
		FinalizarEnt();
		
		return "ClienteMovimientos";
	}
}
