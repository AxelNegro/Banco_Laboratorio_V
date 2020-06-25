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
		CrearBD();
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
	public String ClienteInicio(String user,Model m) {
		m.addAttribute("Username",user);
		return "ClienteMovimientos";
	}
	
	@RequestMapping("ClientePagoPrestamos.do")
	public String ClientePagoPrestamos(String user, Model m) {
		m.addAttribute("Username",user);
		return "ClientePagoPrestamos";
	}
	
	@RequestMapping("ClientePedidoPrestamos.do")
	public String ClientePedidoPrestamos(String user, Model m) {
		m.addAttribute("Username",user);
		return "ClientePedidoPrestamos";
	}
	
	@RequestMapping("ClienteTransBancaria.do")
	public String ClienteTransBancaria(String user, Model m) {
		m.addAttribute("Username",user);
		return "ClienteTransBancaria";
	}
	
	/* BANCO */
	
	@RequestMapping("BancoInicio.do")
	public String BancoInicio(String user, Model m) {
		m.addAttribute("Username",user);
		return "BancoAltaCliente";
	}
	
	@RequestMapping("BancoAltaCliente.do")
	public String BancoAltaCliente(String user, Model m) {
		m.addAttribute("Username",user);
		return "BancoAltaCliente";
	}
	
	@RequestMapping("BancoAltaCuenta.do")
	public String BancoAltaCuenta(String user, Model m) {
		m.addAttribute("Username",user);
		return "BancoAltaCuenta";
	}
	
	@RequestMapping("BancoAltaUsuario.do")
	public String BancoAltaUsuario(String user, Model m) {
		m.addAttribute("Username",user);
		return "BancoAltaUsuario";
	}
	
	@RequestMapping("BancoAprobarPrestamos.do")
	public String BancoAprobarPrestamos(String user, Model m) {
		m.addAttribute("Username",user);
		return "BancoAprobarPrestamos";
	}
	
	@RequestMapping("BancoByMClientes.do")
	public String BancoByMClientes(String user,Model m) {
		m.addAttribute("Username",user);
		return "BancoByMClientes";
	}
	
	@RequestMapping("BancoByMCuentas.do")
	public String BancoByMCuentas(String user,Model m) {
		m.addAttribute("Username",user);
		return "BancoByMCuentas";
	}
	
	@RequestMapping("BancoByMUsuarios.do")
	public String BancoByMUsuarios(String user,Model m) {
		m.addAttribute("Username",user);
		return "";
	}
	
	@RequestMapping("BancoReportes.do")
	public String BancoReportes(String user,Model m) {
		m.addAttribute("Username",user);
		return "BancoReportes";
	}
	
}
