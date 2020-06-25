package presentacion;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import entidad.Cuenta;
import entidad.Cuentas_x_Usuario;
import entidad.TipoCuenta;
import entidad.Usuario;
import negocio.ClienteNeg;
import negocio.CuentaNeg;
import negocio.Cuentas_x_UsuarioNeg;
import negocio.TipoCuentaNeg;
import negocio.UsuarioNeg;

@Controller
public class CuentaController {
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
	
	public Cuenta EstablecerDatos(String CBU, String Nombre, String CodTipo, String Saldo, int Nro) {
		Cuenta acc=(Cuenta) appContextEnt.getBean("CuentaDefault");
		Date FechaAsig=(Date) appContextEnt.getBean("FechaDefault");
		
		try {
			acc.setCBU(Integer.parseInt(CBU));
			acc.setCodTipoCuenta(Integer.parseInt(CodTipo));
			acc.setFecha(FechaAsig);
			acc.setNombre(Nombre);
			acc.setNumeroCuenta(Nro);
			acc.setSaldo(Double.parseDouble(Saldo));	
			acc.setEstado(true);
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		return acc;
	}
	
	public Cuentas_x_Usuario EstablecerDatos_2(Cuenta Acc, String Usuario) {
		Cuentas_x_Usuario accxuser=(Cuentas_x_Usuario) appContextEnt.getBean("Cuenta_x_UsuarioDefault");
		Usuario user=(Usuario) appContextEnt.getBean("UsuarioDefault");
		try {
			user.setUsername(Usuario);
			accxuser.setCuenta(Acc);
			accxuser.setUsuario(user);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return accxuser;
	}
	
	public Cuenta EstablecerDatos_3(String CBU, String NroCuenta, String Nombre, String Tipo, String Saldo, String Fecha, String Estado) {
		Cuenta acc=(Cuenta) appContextEnt.getBean("CuentaDefault");
		
		try {
			acc.setCBU(Integer.parseInt(CBU));
			acc.setNumeroCuenta(Integer.parseInt(NroCuenta));
			acc.setCodTipoCuenta(Integer.parseInt(Tipo));
			acc.setFecha(new SimpleDateFormat("yyyy-mm-dd").parse(Fecha));
			acc.setNombre(Nombre);
			acc.setSaldo(Double.parseDouble(Saldo));	
			acc.setEstado(Boolean.parseBoolean(Estado));
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		return acc;
	}
	
	@RequestMapping("agregarCuenta.do")
	public String AgregarCuenta(String User, String txtCBU, String txtNombre, String ddlTipo, String txtSaldo, String hdnUser, Model m) {
		InicializarEnt();
		InicializarNeg();
		Cuenta acc;
		Cuentas_x_Usuario accxuser;
		
		CuentaNeg accNeg = (CuentaNeg) appContextNeg.getBean("accNeg");
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		Cuentas_x_UsuarioNeg accxuserNeg = (Cuentas_x_UsuarioNeg) appContextNeg.getBean("accxuserNeg");
		
		if(!(txtCBU.trim().isEmpty()||txtNombre.trim().isEmpty()||txtSaldo.trim().isEmpty()||ddlTipo.trim().isEmpty()||hdnUser.trim().isEmpty())) {
			if(Integer.parseInt(txtCBU)>=0&&Double.parseDouble(txtSaldo)>=0) {
				acc=EstablecerDatos(txtCBU,txtNombre,ddlTipo,txtSaldo, accNeg.contarTodas());
				if(acc!=null) {
					if(accNeg.leerUna(Integer.parseInt(txtCBU))==null) {
						if(userNeg.leerUno(hdnUser)!=null) {
							accxuser=EstablecerDatos_2(acc,hdnUser);
							if(accxuser!=null) {
								if(!(accNeg.tipoCuentaUsado(hdnUser, Integer.parseInt(ddlTipo)))) {
									if(accxuserNeg.contarCuentas(hdnUser)<4) {
										if(accNeg.agregarUna(acc)) {
											if(accxuserNeg.agregarUna(accxuser)){
												m.addAttribute("Msg","<script type='text/javascript'>alert('Cuenta agregada y vinculada correctamente.');</script>");
											}
											else {
												m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al vincular la cuenta con el usuario.');</script>");
											}
										}
										else {
											m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al agregar la cuenta.');</script>");
										}
									}
									else {
										m.addAttribute("Msg","<script type='text/javascript'>alert('El usuario no puede tener más de cuatro cuentas.');</script>");
									}
								}
								else {
									m.addAttribute("Msg","<script type='text/javascript'>alert('El usuario no puede tener dos cuentas de igual tipo.');</script>");
								}
							}
							else {
								m.addAttribute("Msg","<script type='text/javascript'>alert('Ingrese los datos correctamente.');</script>");
							}
						}
						else {
							m.addAttribute("Msg","<script type='text/javascript'>alert('El usuario especificado no existe.');</script>");
						}
					}
					else {
						m.addAttribute("Msg","<script type='text/javascript'>alert('El CBU especificado ya existe.');</script>");
					}
				}
				else {
					m.addAttribute("Msg","<script type='text/javascript'>alert('Ingrese los datos correctamente.');</script>");
				}
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('No se permiten valores negativos en campos númericos.');</script>");
			}
		}
		else {
			m.addAttribute("Msg","<script type='text/javascript'>alert('Complete todos los datos para continuar.');</script>");
		}
		
		ObtenerLista(m);
		ObtenerListaTipoCuentas(m);
		
		m.addAttribute("Username",User);
		
		accNeg.Finalizar();
		userNeg.Finalizar();
		accxuserNeg.Finalizar();
		FinalizarNeg();
		FinalizarEnt();
		return "BancoAltaCuenta";
	}
	
	public void ObtenerLista(Model m) {
		ClienteNeg cliNeg = (ClienteNeg) appContextNeg.getBean("cliNeg");
		List<Cliente> lstClientes=cliNeg.leerTodos();
		
		m.addAttribute("lstClientes", lstClientes);
		
		cliNeg.Finalizar();
	}
	
	public void ObtenerListaTipoCuentas(Model m) {
		TipoCuentaNeg tipoaccNeg = (TipoCuentaNeg) appContextNeg.getBean("tcNeg");
		List<TipoCuenta> lstTipoAcc=tipoaccNeg.leerTodas();
		
		m.addAttribute("lstTipoAcc",lstTipoAcc);
		
		tipoaccNeg.Finalizar();
	}
	
	public void ObtenerListaCuentas(Model m) {
		Cuentas_x_UsuarioNeg accxuserNeg = (Cuentas_x_UsuarioNeg) appContextNeg.getBean("accxuserNeg");
		List<Cuentas_x_Usuario> lstAccxUser = accxuserNeg.leerTodas();
		
		m.addAttribute("lstAccxUser",lstAccxUser);
		
		accxuserNeg.Finalizar();
	}
	
	@RequestMapping("leerTodosCuenta.do")
	public String LeerTodas(String User, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		ObtenerListaCuentas(m);
		
		m.addAttribute("Username",User);
		
		FinalizarNeg();
		FinalizarEnt();
		
		return "BancoByMCuentas";
	}
	
	@RequestMapping("modificarCuenta.do")
	public String ModificarUno(String User, String hdnId, String[] btnModificar, String[] btnDesactivar, String[] hdnCBU, String[] hdnUsuario, 
								String[] hdnNroCuenta, String[] hdnNombre, String[] hdnTipo, String[] hdnSaldo, String[] hdnFecha,
								String[] hdnEstado, String[] txtNombre, String[] ddlTipo, String[] txtSaldo, Model m) {
		InicializarNeg();
		InicializarEnt();
		
		int Id = Integer.parseInt(hdnId);
		
		Cuenta cuenta=EstablecerDatos_3(hdnCBU[Id], hdnNroCuenta[Id], hdnNombre[Id], hdnTipo[Id], hdnSaldo[Id], hdnFecha[Id], hdnEstado[Id]);
		
		if(btnModificar!=null) {
			Modificar(cuenta, txtNombre[Id], ddlTipo[Id], txtSaldo[Id], m);
		}
		else if(btnDesactivar!=null) {
			CambiarEstado(cuenta,m);
		}
		
		m.addAttribute("Username",User);
		
		ObtenerListaCuentas(m);
		
		FinalizarEnt();
		FinalizarNeg();
		return "BancoByMCuentas";
	}
	
	public void CambiarEstado(Cuenta cuenta, Model m) {
		CuentaNeg cuentaNeg = (CuentaNeg) appContextNeg.getBean("accNeg");
		String Estado;
		if(cuenta.getEstado()) {
			cuenta.setEstado(false);
		}
		else {
			cuenta.setEstado(true);
		}
		
		if(cuentaNeg.modificarUna(cuenta)) {
			if(cuenta.getEstado()){
				Estado="Activo";
			}
			else {
				Estado="Inactivo";
			}
			m.addAttribute("Msg","<script type='text/javascript'>alert('El estado de la cuenta de CBU "+cuenta.getCBU()+" es actualmente "+Estado+"')</script>");
		}
		else {
			m.addAttribute("Msg","<script type='text/javascript'>alert('Ocurrió un error al modificar el estado.')</script>");
		}
	}
	
	public void Modificar(Cuenta cuenta, String Nombre, String Tipo, String Saldo, Model m) {
		CuentaNeg cuentaNeg = (CuentaNeg) appContextNeg.getBean("accNeg");
		if(!(Nombre.trim().isEmpty()||Saldo.trim().isEmpty())) {
			cuenta.setNombre(Nombre);
			cuenta.setCodTipoCuenta(Integer.parseInt(Tipo));
			cuenta.setSaldo(Double.parseDouble(Saldo));
			if(cuentaNeg.modificarUna(cuenta)) {
				m.addAttribute("Msg","<script type='text/javascript'>alert('Se modificó la cuenta correctamente.')</script>");
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('Ocurrió un error al modificar la cuenta.')</script>");
			}
		}
		else {
			m.addAttribute("Msg","<script type='text/javascript'>alert('No puede insertar datos vacíos.')</script>");
		}
	}
	
}
