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
import entidad.Concepto;
import entidad.Cuenta;
import entidad.Cuentas_x_Usuario;
import entidad.Movimiento;
import entidad.Movimientos_x_Cuenta;
import entidad.TipoCuenta;
import entidad.Usuario;
import negocio.ClienteNeg;
import negocio.ConceptoNeg;
import negocio.CuentaNeg;
import negocio.Cuentas_x_UsuarioNeg;
import negocio.MovimientoNeg;
import negocio.Movimientos_x_CuentaNeg;
import negocio.TipoCuentaNeg;
import negocio.UsuarioNeg;

@Controller
public class CuentaController {
	private ApplicationContext appContextEnt;
	private ApplicationContext appContextNeg;
	
	//////////////////////////// BANCO ////////////////////////////
	
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
			acc.setSaldo(Math.round(Double.parseDouble(Saldo) * 100.0) / 100.0);	
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
			acc.setSaldo(Math.round((Double.parseDouble(Saldo)) * 100.0) / 100.0);	
			acc.setEstado(Boolean.parseBoolean(Estado));
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		return acc;
	}
	
	@RequestMapping("agregarCuenta.do")
	public String AgregarCuenta(String User, String txtCBU, String txtNombre, String ddlTipo, String hdnUser, Model m) {
		InicializarEnt();
		InicializarNeg();
		Cuenta acc;
		Cuentas_x_Usuario accxuser;
		
		CuentaNeg accNeg = (CuentaNeg) appContextNeg.getBean("accNeg");
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		Cuentas_x_UsuarioNeg accxuserNeg = (Cuentas_x_UsuarioNeg) appContextNeg.getBean("accxuserNeg");
		
		int CantCuentas = 0;
		
		if(!(txtCBU.trim().isEmpty()||txtNombre.trim().isEmpty()||ddlTipo.trim().isEmpty()||hdnUser.trim().isEmpty())) {
			if(Integer.parseInt(txtCBU)>=0) {
				acc=EstablecerDatos(txtCBU,txtNombre,ddlTipo,"10000", accNeg.contarTodas());
				if(acc!=null) {
					if(accNeg.leerUna(Integer.parseInt(txtCBU))==null) {
						if(userNeg.leerUno(hdnUser)!=null) {
							accxuser=EstablecerDatos_2(acc,hdnUser);
							if(accxuser!=null) {
								if(!(accNeg.tipoCuentaUsado(hdnUser, Integer.parseInt(txtCBU), Integer.parseInt(ddlTipo)))) {
									CantCuentas=accxuserNeg.contarCuentas(hdnUser);
									if(CantCuentas<4||(hdnUser.equals("admin")&&CantCuentas<5)) {
										if(accNeg.agregarUna(acc)) {
											if(accxuserNeg.agregarUna(accxuser)){
												if(CrearMovimientos(Integer.parseInt(txtCBU),10000.0,0)) {
													m.addAttribute("Msg","<script type='text/javascript'>alert('Cuenta agregada y vinculada correctamente.');</script>");
												}
												else {
													m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al agregar el saldo a la cuenta.');</script>");
												}
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
		List<Cliente> lstClientes=cliNeg.leerTodosSinBanco();
		
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
	
	public boolean CrearMovimientos(int CBU, double Saldo, int Origen) {
		boolean res=false;
		
		MovimientoNeg movNeg = (MovimientoNeg) appContextNeg.getBean("movNeg");
		Movimientos_x_CuentaNeg movxaccNeg = (Movimientos_x_CuentaNeg) appContextNeg.getBean("movxaccNeg");
		
		Date FechaMov = (Date) appContextEnt.getBean("FechaDefault");
		Concepto concepto = (Concepto) appContextEnt.getBean("ConceptoDefault");
		Movimiento mov = (Movimiento) appContextEnt.getBean("MovimientoDefault");
		Cuenta accOrig = (Cuenta) appContextEnt.getBean("CuentaDefault");
		Cuenta accDest = (Cuenta) appContextEnt.getBean("CuentaDefault");
		Movimientos_x_Cuenta movxacc = (Movimientos_x_Cuenta) appContextEnt.getBean("Movimientos_x_CuentaDefault");
		
		
		try {
			accOrig.setCBU(-1);
			accDest.setCBU(CBU);
			
			if(Origen==0) {
				concepto.setIdConcepto(1);
				mov.setConcepto(concepto);
			}
			else {
				concepto.setIdConcepto(2);
				mov.setConcepto(concepto);
			}
			mov.setFecha(FechaMov);
			mov.setImporte(Math.round(Saldo * 100.0) / 100.0);
			
			if(movNeg.agregarUno(mov)) 
			{
				movxacc.setCuentaOrig(accOrig);
				movxacc.setCuentaDest(accDest);
				movxacc.setMovimiento(mov);
				
				if(movxaccNeg.agregarUno(movxacc)) {
					res=true;
				}
				else {
					res=false;
				}
			}
			else {
				res=false;
			}
		}
		catch(Exception e) {
			res=false;
		}
		finally {
			movNeg.Finalizar();
			movxaccNeg.Finalizar();
		}
		
		return res;
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
			try {
				if(!(txtNombre[Id].trim().isEmpty()||ddlTipo==null||ddlTipo[Id].trim().isEmpty()||txtSaldo[Id].trim().isEmpty())) {
					if(Double.parseDouble(txtSaldo[Id])>=0){
						Modificar(cuenta, hdnUsuario[Id], txtNombre[Id], ddlTipo[Id], txtSaldo[Id], m);
					}
					else {
						m.addAttribute("Msg","<script type='text/javascript'>alert('No puede ingresar un saldo negativo.');</script>");
					}
				}
				else {
					m.addAttribute("Msg","<script type='text/javascript'>alert('Complete todos los datos para continuar.');</script>");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				m.addAttribute("Msg","<script type='text/javascript'>alert('Complete todos los datos para continuar.');</script>");
			}
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
	
	public void Modificar(Cuenta cuenta, String User, String Nombre, String Tipo, String Saldo, Model m) {
		CuentaNeg cuentaNeg = (CuentaNeg) appContextNeg.getBean("accNeg");
		if(!(Nombre.trim().isEmpty()||Saldo.trim().isEmpty())) {
			if(Double.parseDouble(Saldo)>=0){
				if(!(cuentaNeg.tipoCuentaUsado(User, cuenta.getCBU(), Integer.parseInt(Tipo)))) {
					cuenta.setNombre(Nombre);
					cuenta.setCodTipoCuenta(Integer.parseInt(Tipo));
					cuenta.setSaldo(Math.round((Double.parseDouble(Saldo)) * 100.0) / 100.0);
					if(cuentaNeg.modificarUna(cuenta)) {
						if(CrearMovimientos(cuenta.getCBU(),Double.parseDouble(Saldo),1)) {
							m.addAttribute("Msg","<script type='text/javascript'>alert('Se modificó la cuenta correctamente.')</script>");
						}
						else {
							m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al modificar el saldo.')</script>");
						}
					}
					else {
						m.addAttribute("Msg","<script type='text/javascript'>alert('Ocurrió un error al modificar la cuenta.')</script>");
					}
				}
				else {
					m.addAttribute("Msg","<script type='text/javascript'>alert('El usuario no puede tener dos cuentas del mismo tipo.')</script>");
				}
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('El usuario no puede tener saldo negativo.')</script>");
			}
		}
		else {
			m.addAttribute("Msg","<script type='text/javascript'>alert('No puede insertar datos vacíos.')</script>");
		}
	}
	
	//////////////////////////// FIN BANCO ////////////////////////////
	
	//////////////////////////// CLIENTE ////////////////////////////
	
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
		
		List<Movimientos_x_Cuenta> lstMovxAcc = movxaccNeg.obtenerHistorialCuenta(lstCBUs);
		
		m.addAttribute("Cantidad",lstAccxUser.size());
		m.addAttribute("lstAccxUser",lstAccxUser);
		m.addAttribute("lstMovxAcc",lstMovxAcc);
		m.addAttribute("Username", User);
		
		accxuserNeg.Finalizar();
		movxaccNeg.Finalizar();
		FinalizarNeg();
		FinalizarEnt();
		
		return "ClienteMovimientos";
	}
	
	@RequestMapping("leerCuentasxUsuario.do")
	public String LeerTransPropias(String User, String Origen, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		Cuentas_x_UsuarioNeg accxuserNeg = (Cuentas_x_UsuarioNeg) appContextNeg.getBean("accxuserNeg");
		
		List<Cuentas_x_Usuario> lstAccxUser = accxuserNeg.leerCuentasxUsuario(User);
		
		m.addAttribute("lstAccxUser",lstAccxUser);
		m.addAttribute("Username", User);
		
		accxuserNeg.Finalizar();
		FinalizarNeg();
		FinalizarEnt();
		
		if(Origen.equals("0")) {
			return "ClienteTransPropias";
		}
		else {
			return "ClientePedidoPrestamos";
		}
	}
	
	@RequestMapping("leerTransTerceros.do")
	public String LeerTransTerceros(String User, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		Cuentas_x_UsuarioNeg accxuserNeg = (Cuentas_x_UsuarioNeg) appContextNeg.getBean("accxuserNeg");
		ConceptoNeg conceptoNeg = (ConceptoNeg) appContextNeg.getBean("conceptoNeg");
		
		List<Cuentas_x_Usuario> lstAccxUser = accxuserNeg.leerCuentasxUsuario(User);
		List<Concepto> lstConceptos = conceptoNeg.leerTodosTransferencia();
		
		m.addAttribute("lstAccxUser",lstAccxUser);
		m.addAttribute("lstConceptos",lstConceptos);
		m.addAttribute("Username", User);
		
		accxuserNeg.Finalizar();
		conceptoNeg.Finalizar();

		FinalizarNeg();
		FinalizarEnt();
		
		return "ClienteTransTerceros";
	}
	
	@RequestMapping("obtenerInfoTransCBU.do")
	public String ObtenerInfoTransCBU(String User, String CBU, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		Cuenta acc = (Cuenta) appContextEnt.getBean("CuentaDefault");
		Cuentas_x_Usuario accxuser = (Cuentas_x_Usuario) appContextEnt.getBean("Cuenta_x_UsuarioDefault");
		Cliente cli = (Cliente) appContextEnt.getBean("ClienteDefault");
		
		CuentaNeg accNeg = (CuentaNeg) appContextNeg.getBean("accNeg");
		Cuentas_x_UsuarioNeg accxuserNeg = (Cuentas_x_UsuarioNeg) appContextNeg.getBean("accxuserNeg");
		ClienteNeg cliNeg = (ClienteNeg) appContextNeg.getBean("cliNeg");
		
		if(!CBU.trim().isEmpty()&&Integer.parseInt(CBU.trim())!=-1) {
			acc = accNeg.leerUna(Integer.parseInt(CBU));
			if(acc!=null) {
				if(acc.getEstado()) {
					m.addAttribute("Cuenta",acc);
					accxuser=accxuserNeg.obtenerUsuario(Integer.parseInt(CBU));
					if(accxuser!=null) {
						if(!User.equals(accxuser.getUsuario().getUsername())) {
							cli = cliNeg.obtenerCliente(accxuser.getUsuario().getUsername());
							if(cli!=null) {
								m.addAttribute("Cliente",cli);
							}
							else {
								m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al obtener el cliente.');window.close()</script>");
							}
						}
						else {
							m.addAttribute("Msg","<script type='text/javascript'>alert('El CBU especificado pertenece a una cuenta propia.');window.close()</script>");
						}
					}
					else {
						m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al obtener el cliente.');window.close()</script>");
					}
				}
				else {
					m.addAttribute("Msg","<script type='text/javascript'>alert('El CBU especificado está temporalmente desactivado.');window.close()</script>");
				}
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('El CBU especificado no existe.');window.close()</script>");
			}
		}
		else {
			m.addAttribute("Msg","<script type='text/javascript'>alert('El CBU está vacío.');window.close()</script>");
		}
		
		accNeg.Finalizar();
		accxuserNeg.Finalizar();
		cliNeg.Finalizar();
		
		FinalizarNeg();
		FinalizarEnt();
		
		return "ClienteTransInfo";
	}
	
}
