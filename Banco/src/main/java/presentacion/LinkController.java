package presentacion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import config.ConfigDao;
import datosImpl.Conexion;

@Controller
public class LinkController {
	
	/* TODOS */
	
	@RequestMapping("TodosInicio.do")
	public String TodosInicio(Model m) {
		//CrearBD();
		return "index";
	}
	
	public void CrearBD() {
		ApplicationContext appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		Conexion con = (Conexion) appContext.getBean("ConexionBD");
		((ConfigurableApplicationContext)(appContext)).close();
	}
	
	@RequestMapping("TodosLogin.do")
	public String TodosLogin(Model m) {
		return "TodosLogin";
	}
	
	/* CLIENTE */
	
	@RequestMapping("ClienteInicio.do")
	public String ClienteInicio(String User,Model m) {
		m.addAttribute("Username",User);
		return "ClienteMasterPage";
	}
	
	@RequestMapping("ClienteMovimientos.do")
	public String ClienteMovimientos(String User,Model m) {
		m.addAttribute("Username",User);
		return "ClienteMovimientos";
	}
	
	@RequestMapping("ClientePagoPrestamos.do")
	public String ClientePagoPrestamos(String User, Model m) {
		m.addAttribute("Username",User);
		return "ClientePagoPrestamos";
	}
	
	@RequestMapping("ClientePedidoPrestamos.do")
	public String ClientePedidoPrestamos(String User, Model m) {
		m.addAttribute("Username",User);
		return "ClientePedidoPrestamos";
	}
	
	@RequestMapping("ClientePrestamos.do")
	public String ClientePrestamos(String User, Model m) {
		m.addAttribute("Username",User);
		return "ClientePrestamos";
	}
	
	@RequestMapping("ClienteTransTerceros.do")
	public String ClienteTransTerceros(String User, Model m) {
		m.addAttribute("Username",User);
		return "ClienteTransTerceros";
	}
	
	@RequestMapping("ClienteTransPropias.do")
	public String ClienteTransPropias(String User, Model m) {
		m.addAttribute("Username",User);
		return "ClienteTransPropias";
	}
	
	@RequestMapping("ClienteTransInfo.do")
	public String ClienteTransInfo(String User, Model m) {
		m.addAttribute("Username",User);
		return "ClienteTransInfo";
	}
	
	/* BANCO */
	
	@RequestMapping("BancoInicio.do")
	public String BancoInicio(String User, Model m) {
		m.addAttribute("Username",User);
		return "BancoMasterPage";
	}
	
	@RequestMapping("BancoAltaCliente.do")
	public String BancoAltaCliente(String User, Model m) {
		m.addAttribute("Username",User);
		return "BancoAltaCliente";
	}
	
	@RequestMapping("BancoAltaCuenta.do")
	public String BancoAltaCuenta(String User, Model m) {
		m.addAttribute("Username",User);
		return "BancoAltaCuenta";
	}
	
	@RequestMapping("BancoAltaUsuario.do")
	public String BancoAltaUsuario(String User, Model m) {
		m.addAttribute("Username",User);
		return "BancoAltaUsuario";
	}
	
	@RequestMapping("BancoAprobarPrestamos.do")
	public String BancoAprobarPrestamos(String User, Model m) {
		m.addAttribute("Username",User);
		return "BancoAprobarPrestamos";
	}
	
	@RequestMapping("BancoByMClientes.do")
	public String BancoByMClientes(String User,Model m) {
		m.addAttribute("Username",User);
		return "BancoByMClientes";
	}
	
	@RequestMapping("BancoByMCuentas.do")
	public String BancoByMCuentas(String User,Model m) {
		m.addAttribute("Username",User);
		return "BancoByMCuentas";
	}
	
	@RequestMapping("BancoByMUsuarios.do")
	public String BancoByMUsuarios(String User,Model m) {
		m.addAttribute("Username",User);
		return "";
	}
	
	@RequestMapping("BancoReportes.do")
	public String BancoReportes(String User,Model m) {
		m.addAttribute("Username",User);
		return "BancoReportes";
	}
	
}
