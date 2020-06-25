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
import entidad.TipoCuenta;
import entidad.Usuario;
import negocio.ClienteNeg;
import negocio.TipoCuentaNeg;
import negocio.UsuarioNeg;

@Controller
public class UsuarioController {
	private ApplicationContext appContextEnt;
	private ApplicationContext appContextNeg;
	private boolean TipoUsuario;
	private Usuario user;
	
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
		InicializarEnt();
		InicializarNeg();
		
		String User=txtUsuario;
		String Pass=txtContrasenia;
		String msg;
		AgregarUsuarioAdmin();
		InsertarTipoCuenta();
		if(!(User.trim().isEmpty()||Pass.trim().isEmpty())) {
			if(EsCorrecto(User,Pass)) {
				if(user.getEstado()) {
					if(TieneClienteAsignado(User)) {
						m.addAttribute("Username",User);
						FinalizarEnt();
						FinalizarNeg();
						if(TipoUsuario) {
							return "BancoMasterPage";
						}
						else {
							return "ClienteMasterPage";
						}
					}
					else {
						msg="<script type='text/javascript'>alert('El usuario no tiene un cliente asignado.');</script>";
					}
				}
				else {
					msg="<script type='text/javascript'>alert('El usuario está inactivo.');</script>";
				}
			}
			else {
				msg="<script type='text/javascript'>alert('Usuario y/o contraseña incorrectos.');</script>";
				m.addAttribute("Msg",msg);
			}
		}
		else {
			msg="<script type='text/javascript'>alert('Ingrese un usuario y contraseña validos.');</script>";
		}
		
		m.addAttribute("Msg",msg);
		FinalizarEnt();
		FinalizarNeg();
		return "TodosLogin";
	}
	
	public void AgregarUsuarioAdmin() {
		
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
	
	public void InsertarTipoCuenta() {
			TipoCuenta tc = (TipoCuenta) appContextEnt.getBean("TipoCuentaDefault");
		
			tc.setCodTipoCuenta(1);
			tc.setTipoCuenta("Caja de ahorro en pesos");
			AgregarTC(tc);
			
			tc = (TipoCuenta) appContextEnt.getBean("TipoCuentaDefault");
			
			tc.setCodTipoCuenta(2);
			tc.setTipoCuenta("Caja de ahorro en dólares");
			AgregarTC(tc);
			
			tc = (TipoCuenta) appContextEnt.getBean("TipoCuentaDefault");
			
			tc.setCodTipoCuenta(3);
			tc.setTipoCuenta("Cuenta corriente");
			AgregarTC(tc);
			
			tc = (TipoCuenta) appContextEnt.getBean("TipoCuentaDefault");
			
			tc.setCodTipoCuenta(4);
			tc.setTipoCuenta("Cuenta corriente especial en pesos");
			AgregarTC(tc);
			
			tc = (TipoCuenta) appContextEnt.getBean("TipoCuentaDefault");
			
			tc.setCodTipoCuenta(5);
			tc.setTipoCuenta("Cuenta corriente especial en dólares");
			AgregarTC(tc);
		}
	
	public void AgregarTC(TipoCuenta tc) {
		TipoCuentaNeg tcNeg = (TipoCuentaNeg) appContextNeg.getBean("tcNeg");
		if(tcNeg.leerUna(tc.getCodTipoCuenta())==null) {
			tcNeg.agregarUna(tc);
		}
		tcNeg.Finalizar();
	}
	
	public boolean EsCorrecto(String User, String Pass) {
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		this.user = userNeg.leerUno(User);
		if(user!=null) {
			if(user.getPassword().equals(Pass)) {
				TipoUsuario=user.getTipoUsuario();
				userNeg.Finalizar();
				return true;
			}
			else
			{
				userNeg.Finalizar();
				return false;
			}
		}
		else {
			userNeg.Finalizar();
			return false;
		}
	}
	
	public boolean TieneClienteAsignado(String Username) {
		ClienteNeg cliNeg = (ClienteNeg) appContextNeg.getBean("cliNeg");
		return cliNeg.tieneUsuario(Username);
	}
	
	@RequestMapping("agregarUser.do")
	public String agregarUno(String User, String txtUsuario, String txtContrasenia, String rdTipo, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		
		Usuario user = (Usuario) appContextEnt.getBean("UsuarioDefault");
		
		if(!(txtUsuario.trim().isEmpty()||txtContrasenia.trim().isEmpty()||rdTipo==null)) {
			
			if(userNeg.leerUno(txtUsuario.trim())==null) {
				
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
		
		m.addAttribute("Username",User);
		
		userNeg.Finalizar();
		FinalizarEnt();
		FinalizarNeg();
		
		return "BancoAltaUsuario";
	}
	
	@RequestMapping("leerTodosUser.do")
	public String LeerTodos(String User, Model m) {
		InicializarNeg();
		InicializarEnt();
		
		ObtenerLista(m);
		
		FinalizarEnt();
		FinalizarNeg();
		
		m.addAttribute("Username", User);
		
		return "BancoByMUsuarios";
	}
	
	public void ObtenerLista(Model m) {
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		List<Usuario> lstUsers=userNeg.leerTodos();
		
		m.addAttribute("lstUsers", lstUsers);
		
		userNeg.Finalizar();
	}
	
	@RequestMapping("modificarUser.do")
	public String ModificarUno(String User, String hdnId, String[] btnModificar, String[] btnDesactivar, String[] hdnUser, String[] hdnPass, String[] hdnTipo, String[] hdnEstado, String[] txtPassword, String[] ddlTipo, Model m) {
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
		
		m.addAttribute("Username",User);
		
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
		
		userNeg.Finalizar();
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
		
		userNeg.Finalizar();
	}
}
