package presentacion;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LinkController {
	
	/* TODOS */
	
	@RequestMapping("TodosInicio.do")
	public String TodosInicio(HttpServletRequest req,Model m) {
		return "index";
	}
	
	@RequestMapping("TodosLogin.do")
	public String TodosLogin(HttpServletRequest req,Model m) {
		return "TodosLogin";
	}
	
	/* CLIENTE */
	
	@RequestMapping("ClienteInicio.do")
	public String ClienteInicio(HttpServletRequest req,Model m) {
		return "ClienteMovimientos";
	}
	
	@RequestMapping("ClientePagoPrestamos.do")
	public String ClientePagoPrestamos(HttpServletRequest req,Model m) {
		return "ClientePagoPrestamos";
	}
	
	@RequestMapping("ClientePedidoPrestamos.do")
	public String ClientePedidoPrestamos(HttpServletRequest req,Model m) {
		return "ClientePedidoPrestamos";
	}
	
	@RequestMapping("ClienteTransBancaria.do")
	public String ClienteTransBancaria(HttpServletRequest req,Model m) {
		return "ClienteTransBancaria";
	}
	
	/* BANCO */
	
	@RequestMapping("BancoInicio.do")
	public String BancoInicio(HttpServletRequest req,Model m) {
		return "BancoAltaCliente";
	}
	
	@RequestMapping("BancoAltaCliente.do")
	public String BancoAltaCliente(HttpServletRequest req,Model m) {
		return "BancoAltaCliente";
	}
	
	@RequestMapping("BancoAltaCuenta.do")
	public String BancoAltaCuenta(HttpServletRequest req,Model m) {
		return "BancoAltaCuenta";
	}
	
	@RequestMapping("BancoAltaUsuario.do")
	public String BancoAltaUsuario(HttpServletRequest req,Model m) {
		return "BancoAltaUsuario";
	}
	
	@RequestMapping("BancoAprobarPrestamos.do")
	public String BancoAprobarPrestamos(HttpServletRequest req,Model m) {
		return "BancoAprobarPrestamos";
	}
	
	@RequestMapping("BancoByMClientes.do")
	public String BancoByMClientes(HttpServletRequest req,Model m) {
		return "BancoByMClientes";
	}
	
	@RequestMapping("BancoByMCuentas.do")
	public String BancoByMCuentas(HttpServletRequest req,Model m) {
		return "BancoByMCuentas";
	}
	
	@RequestMapping("BancoByMUsuarios.do")
	public String BancoByMUsuarios(HttpServletRequest req,Model m) {
		return "BancoByMUsuarios";
	}
	
	@RequestMapping("BancoReportes.do")
	public String BancoReportes(HttpServletRequest req,Model m) {
		return "BancoReportes";
	}
	
}
