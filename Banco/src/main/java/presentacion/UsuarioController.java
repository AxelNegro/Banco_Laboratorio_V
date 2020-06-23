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
import entidad.Cliente;
import entidad.Usuario;
import negocio.ClienteNeg;
import negocio.UsuarioNeg;

@Controller
public class UsuarioController {
	private ApplicationContext appContextEnt;
	private ApplicationContext appContextNeg;
	private boolean TipoUsuario;
	
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
	
	public Usuario EstablecerDatos(String User, String Pass, String Tipo, String Estado) {
		Usuario user = (Usuario) appContextEnt.getBean("UsuarioDefault");
		
		user.setUsername(User);
		user.setPassword(Pass);
		user.setTipoUsuario(Boolean.parseBoolean(Tipo));
		user.setEstado(Boolean.parseBoolean(Estado));
		
		return user;
	}
	
	@RequestMapping("Login.do")
	public String Login(String txtUsuario, String txtContrasenia,Model m) {
		String User=txtUsuario;
		String Pass=txtContrasenia;
		String msg;
		txtUsuario="asd";
		AgregarUsuarioAdmin();
		if(!(User.trim().isEmpty()||Pass.trim().isEmpty())) {
			if(EsCorrecto(User,Pass)) {
				m.addAttribute("Username",User);
				FinalizarEnt();
				FinalizarNeg();
				if(TipoUsuario) {
					return "BancoAltaCliente";
				}
				else {
					return "ClienteMovimientos";
				}
			}
			else {
				msg="<script type='text/javascript'>alert('Usuario y/o contraseña incorrectos.');</script>";
				m.addAttribute("Msg",msg);
				FinalizarEnt();
				FinalizarNeg();
				return "TodosLogin";
			}
		}
		else {
			msg="<script type='text/javascript'>alert('Ingrese un usuario y contraseña validos.');</script>";
			m.addAttribute("Msg",msg);
			FinalizarEnt();
			FinalizarNeg();
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
	
	@RequestMapping("agregarUser.do")
	public String agregarUno(String txtUsuario, String txtContrasenia, String rdTipo, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		
		Usuario user = (Usuario) appContextEnt.getBean("UsuarioDefault");
		Usuario userAux = (Usuario) appContextEnt.getBean("UsuarioDefault");
		
		if(!(txtUsuario.trim().isEmpty()||txtContrasenia.trim().isEmpty()||rdTipo==null)) {
			
			userAux = userNeg.leerUno(txtUsuario.trim());
			
			if(userAux==null) {
				
				user=EstablecerDatos(txtUsuario.trim(),txtContrasenia.trim(),rdTipo,"true");
				
				if(userNeg.agregarUno(user)) {
					m.addAttribute("Msg","<script type='text/javascript'>alert('Usuario creado correctamente.')</script>");
				}
				else {
					m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al crear el usuario.')</script>");
				}
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('Usuario ya existente.')</script>");
			}
		}
		else {
			m.addAttribute("Msg","<script type='text/javascript'>alert('Complete los datos.')</script>");
		}
		
		userNeg.Finalizar();
		FinalizarEnt();
		FinalizarNeg();
		
		return "BancoAltaUsuario";
	}
	
	@RequestMapping("leerTodos.do")
	public String LeerTodos(Model m) {
		InicializarNeg();
		InicializarEnt();
		
		ObtenerLista(m);
		
		FinalizarEnt();
		FinalizarNeg();
		return "BancoByMUsuarios";
	}
	
	public void ObtenerLista(Model m) {
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		List<Usuario> lstUsers=userNeg.leerTodos();
		
		m.addAttribute("lstUsers", lstUsers);
		
		userNeg.Finalizar();
	}
	
	@RequestMapping("modificarUno.do")
	public String ModificarUno(String hdnId, String[] btnModificar, String[] btnDesactivar, String[] hdnUser, String[] hdnPass, String[] hdnTipo, String[] hdnEstado, String[] txtPassword, String[] ddlTipo, Model m) {
		InicializarNeg();
		InicializarEnt();
		
		int Id = Integer.parseInt(hdnId);
		
		Usuario user=EstablecerDatos(hdnUser[Id], hdnPass[Id], hdnTipo[Id], hdnEstado[Id]);
		
		if(btnModificar!=null) {
			Modificar(user,txtPassword[Id],ddlTipo[Id], m);
		}
		else if(btnDesactivar!=null) {
			CambiarEstado(user,m);
		}
		
		ObtenerLista(m);
		
		FinalizarEnt();
		FinalizarNeg();
		return "BancoByMUsuarios";
	}
	
	public void CambiarEstado(Usuario user, Model m) {
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		String Estado;
		if(user.getEstado()) {
			user.setEstado(false);
		}
		else {
			user.setEstado(true);
		}
		
		if(userNeg.Modificar(user)) {
			if(user.getEstado()){
				Estado="Activo";
			}
			else {
				Estado="Inactivo";
			}
			m.addAttribute("Msg","<script type='text/javascript'>alert('El estado del usuario "+user.getUsername()+" es actualmente "+Estado+"')</script>");
		}
		else {
			m.addAttribute("Msg","<script type='text/javascript'>alert('Ocurrió un error al modificar el estado.')</script>");
		}
	}
	
	public void Modificar(Usuario user, String Password, String Tipo, Model m) {
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		if(!(Password.trim().isEmpty())) {
			user.setPassword(Password);
			user.setTipoUsuario(Boolean.parseBoolean(Tipo.trim()));
			if(userNeg.Modificar(user)) {
				m.addAttribute("Msg","<script type='text/javascript'>alert('Se modificó el usuario correctamente.')</script>");
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('Ocurrió un error al modificar el usuario.')</script>");
			}
		}
		else {
			m.addAttribute("Msg","<script type='text/javascript'>alert('No puede insertar una contraseña vacía.')</script>");
		}
	}
}
