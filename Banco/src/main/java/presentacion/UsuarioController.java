package presentacion;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import config.ConfigEntidad;
import config.ConfigNeg;
import entidad.Cliente;
import entidad.Usuario;
import negocio.ClienteNeg;
import negocio.UsuarioNeg;

@Controller
public class UsuarioController {
	private ApplicationContext appContextEnt;
	private ApplicationContext appContextNeg;
	private boolean TipoUsuario;
	@RequestMapping("Login.do")
	public String Login(HttpServletRequest req,Model m) {
		String User=req.getParameter("txtUsuario");
		String Pass=req.getParameter("txtContrasenia");
		String msg;
		AgregarUsuarioAdmin();
		if(!(User.trim().isEmpty()||Pass.trim().isEmpty())) {
			if(EsCorrecto(User,Pass)) {
				if(TipoUsuario) {
					Finalizar();
					return "BancoAltaCliente";
				}
				else {
					Finalizar();
					return "ClienteMovimientos";
				}
			}
			else {
				msg="<script type='text/javascript'>alert('Usuario y/o contraseña incorrectos.');</script>";
				m.addAttribute("Msg",msg);
				Finalizar();
				return "TodosLogin";
			}
		}
		else {
			msg="<script type='text/javascript'>alert('Ingrese un usuario y contraseña validos.');</script>";
			m.addAttribute("Msg",msg);
			Finalizar();
			return "TodosLogin";
		}
	}
	
	public void AgregarUsuarioAdmin() {
		InicializarEnt();
		InicializarNeg();
		
		Usuario user = (Usuario) appContextEnt.getBean("UsuarioAdmin");
		Cliente cli = (Cliente) appContextEnt.getBean("ClienteAdmin");
		
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		ClienteNeg cliNeg = (ClienteNeg) appContextNeg.getBean("cliNeg");
	
		Usuario userAux = userNeg.leerUno(user.getUsername());
		
		try {
			if(userAux==null) 
			{
				userNeg.agregarUno(user);
				cliNeg.agregarUno(cli);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			userNeg.Finalizar();
			cliNeg.Finalizar();
		}
	}
	
	public boolean EsCorrecto(String User, String Pass) {
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		Usuario user = userNeg.leerUno(User);
		if(user!=null) {
			if(user.getPassword().equals(Pass)) {
				TipoUsuario=user.getTipoUsuario();
				return true;
			}
			else
			{
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public void InicializarEnt() {
		appContextEnt=new AnnotationConfigApplicationContext(ConfigEntidad.class);
	}
	
	public void InicializarNeg() {
		appContextNeg=new AnnotationConfigApplicationContext(ConfigNeg.class);
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContextEnt)).close();
		((ConfigurableApplicationContext)(appContextNeg)).close();
	}
}
