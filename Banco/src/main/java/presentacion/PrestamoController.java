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
import entidad.Cuotas_x_Prestamo;
import entidad.Movimiento;
import entidad.Movimientos_x_Cuenta;
import entidad.Prestamo;
import entidad.Prestamos_x_Cliente;
import negocio.ClienteNeg;
import negocio.CuentaNeg;
import negocio.Cuentas_x_UsuarioNeg;
import negocio.Cuotas_x_PrestamoNeg;
import negocio.MovimientoNeg;
import negocio.Movimientos_x_CuentaNeg;
import negocio.PrestamoNeg;
import negocio.Prestamos_x_ClienteNeg;

@Controller
public class PrestamoController {
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
	
	@RequestMapping("pedidoPrestamo.do")
	public String PedirPrestamo(String User, String ddlCuenta, String txtImporte, String ddlPlazo, String hdnImporteTotal, String hdnImporteCuotas, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		Prestamo prest = (Prestamo) appContextEnt.getBean("PrestamoDefault");
		Cliente cli = (Cliente) appContextEnt.getBean("ClienteDefault");
		Prestamos_x_Cliente prestxcli = (Prestamos_x_Cliente) appContextEnt.getBean("Prestamos_x_ClienteDefault");
		
		Cuentas_x_UsuarioNeg accxuserNeg = (Cuentas_x_UsuarioNeg) appContextNeg.getBean("accxuserNeg");
		PrestamoNeg prestNeg = (PrestamoNeg) appContextNeg.getBean("prestNeg");
		ClienteNeg cliNeg = (ClienteNeg) appContextNeg.getBean("cliNeg");
		Prestamos_x_ClienteNeg prestxcliNeg = (Prestamos_x_ClienteNeg) appContextNeg.getBean("prestxcliNeg");
		
		List<Cuentas_x_Usuario> lstAccxUser = accxuserNeg.leerCuentasxUsuario(User);
		
		if(!(User.trim().isEmpty()||ddlCuenta==null||ddlCuenta.trim().isEmpty()||txtImporte.trim().isEmpty()||ddlPlazo==null||ddlPlazo.trim().isEmpty()||hdnImporteTotal.trim().isEmpty()||hdnImporteCuotas.trim().isEmpty())) {
			if(Double.parseDouble(txtImporte)>=1000) {
				prest=EstablecerDatos(ddlCuenta,txtImporte,hdnImporteTotal,ddlPlazo);
				if(prest!=null) {
					if(prestNeg.agregarUno(prest)) {
						cli=cliNeg.obtenerCliente(User);
						prestxcli.setCliente(cli);
						prestxcli.setPrestamo(prest);
						if(cli!=null&&prestxcli!=null) {
							if(prestxcliNeg.agregarUno(prestxcli)) {
								m.addAttribute("Msg", "<script type='text/javascript'>alert('Se envió el pedido de prestamo correctamente.')</script>");
							}
							else {
								m.addAttribute("Msg", "<script type='text/javascript'>alert('Hubo un error al vincular el prestamo con el cliente.')</script>");
							}
						}
					}
					else {
						m.addAttribute("Msg", "<script type='text/javascript'>alert('Hubo un error al enviar el prestamo.')</script>");
					}
				}
				else {
					m.addAttribute("Msg", "<script type='text/javascript'>alert('Ingrese correctamente los datos.')</script>");
				}
			}
			else {
				m.addAttribute("Msg", "<script type='text/javascript'>alert('No puede pedir prestamos de menores a $1000.')</script>");
			}
		}
		else {
			m.addAttribute("Msg", "<script type='text/javascript'>alert('Complete los campos.')</script>");
		}
		
		
		m.addAttribute("lstAccxUser",lstAccxUser);
		
		m.addAttribute("Username", User);
		
		accxuserNeg.Finalizar();
		
		FinalizarNeg();
		FinalizarEnt();
		return "ClientePedidoPrestamos";
	}
	
	public Prestamo EstablecerDatos(String Cuenta, String ImporteBruto, String ImporteNeto, String Plazo) {
		Cuenta acc = (Cuenta) appContextEnt.getBean("CuentaDefault");
		Prestamo prest = (Prestamo) appContextEnt.getBean("PrestamoDefault");
		Date FechaAsig=(Date) appContextEnt.getBean("FechaDefault");
		
		try {
			acc.setCBU(Integer.parseInt(Cuenta));
			prest.setCuenta(acc);
			prest.setFechaPedido(FechaAsig);
			prest.setImporteBruto(Double.parseDouble(ImporteBruto));
			prest.setImporteNeto(Double.parseDouble(ImporteNeto));
			prest.setPlazoenMeses(Integer.parseInt(Plazo));
			prest.setEstado(0);
		}
		catch (Exception e) {
			return null;
		}
		
		return prest;
	}
	
	@RequestMapping("leerTodosPrestamos.do")
	public String LeerTodosPrestamos(String User, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		ObtenerListaPrestamos(m);
		
		m.addAttribute("Username",User);
		
		FinalizarNeg();
		FinalizarEnt();
		return "BancoAprobarPrestamos";
	}
	
	public void ObtenerListaPrestamos(Model m) {
		Prestamos_x_ClienteNeg prestxcliNeg = (Prestamos_x_ClienteNeg) appContextNeg.getBean("prestxcliNeg");
		
		List<Prestamos_x_Cliente> lstPrestxCli=prestxcliNeg.leerTodosPendientes();
		
		m.addAttribute("lstPrestxCli", lstPrestxCli);
		
		prestxcliNeg.Finalizar();
	}
	
	@RequestMapping("aprobarPrestamos.do")
	public String AprobarPrestamos(String User, String hdnCodPrestamo, String hdnFila, String btnAprobar, String btnRechazar,  Model m) {
		InicializarEnt();
		InicializarNeg();
		
		PrestamoNeg prestNeg = (PrestamoNeg) appContextNeg.getBean("prestNeg");
		Cuotas_x_PrestamoNeg cuotxprestNeg = (Cuotas_x_PrestamoNeg) appContextNeg.getBean("cuotxprestNeg");
		
		Prestamo prest = (Prestamo) appContextEnt.getBean("PrestamoDefault");
		Cuotas_x_Prestamo cuotxprest;
		Double ImporteN;
		Double ImporteB;
		Double ImporteC;
		int Cuotas;
		boolean Resultado=true;
		Date FechaRespuesta = (Date) appContextEnt.getBean("FechaDefault");
		
		if(!hdnCodPrestamo.trim().isEmpty()) {
			prest = prestNeg.leerUno(Integer.parseInt(hdnCodPrestamo));
			if(prest!=null) {
				if(btnAprobar!=null) {
					if(prest.getCuenta().getEstado()) {
						prest.setEstado(1);
						prest.setFechaRespuesta(FechaRespuesta);
						ImporteN=prest.getImporteNeto();
						ImporteB=prest.getImporteBruto();
						Cuotas=prest.getPlazoenMeses();
						ImporteC=ImporteN/Cuotas;
						if(prestNeg.modificarUno(prest)) {
							for(int i=0;i<Cuotas;i++) {
								cuotxprest = (Cuotas_x_Prestamo) appContextEnt.getBean("Cuotas_x_PrestamoDefault");
								cuotxprest = EstablecerDatos_2(prest,ImporteC,false);
								if(!cuotxprestNeg.agregarUna(cuotxprest)) {
									Resultado=false;
								}
							}
							if(Resultado) {
								if(ActualizarSaldo(prest.getCuenta(),ImporteB)) {
									if(CrearMovimientos(prest.getCuenta().getCBU(),ImporteB)) {
										m.addAttribute("Msg","<script type='text/javascript'>alert('Se aprobó el prestamo.');</script>");
									}
									else {
										m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al crear los movimientos.');</script>");
									}
								}
								else {
									m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al agregar el saldo a la cuenta.');</script>");
								}
							}
							else {
								m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al crear las cuotas del prestamos.');</script>");	
							}
						}
						else {
							m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al modificar el estado del Prestamo.');</script>");	
						}
					}
					else {
						m.addAttribute("Msg","<script type='text/javascript'>alert('No puede aprobar prestamos a cuentas desactivadas.');</script>");	
					}
				}
				else {
					prest.setEstado(2);
					prest.setFechaRespuesta(FechaRespuesta);
					if(prestNeg.modificarUno(prest)) {
						m.addAttribute("Msg","<script type='text/javascript'>alert('Se rechazó el prestamo.');</script>");
					}
					else {
						m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al rechazar el prestamo.');</script>");
					}
				}
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al obtener la información del prestamo.');</script>");
			}
		}
		
		ObtenerListaPrestamos(m);
		
		m.addAttribute("Username", User);
			
		FinalizarNeg();
		FinalizarEnt();
		return "BancoAprobarPrestamos";
	}
	
	public Cuotas_x_Prestamo EstablecerDatos_2(Prestamo prest, Double ImporteC, boolean Estado) {
		Cuotas_x_Prestamo cuotxprest = (Cuotas_x_Prestamo) appContextEnt.getBean("Cuotas_x_PrestamoDefault");
		try {
			cuotxprest.setPrestamo(prest);
			cuotxprest.setImporteMensual(Math.round(ImporteC * 100.0) / 100.0);
			cuotxprest.setEstado(Estado);
		}
		catch(Exception e) {
			cuotxprest=null;
			e.printStackTrace();
		}
		
		return cuotxprest;
	}
	
	public boolean CrearMovimientos(int CBU, double Saldo) {
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
			concepto.setIdConcepto(4);
			mov.setConcepto(concepto);
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
	
	public boolean ActualizarSaldo(Cuenta acc, Double Importe) {
		CuentaNeg accNeg = (CuentaNeg) appContextNeg.getBean("accNeg");
		boolean res=false;
		
		acc.setSaldo(Math.round((acc.getSaldo()+Importe) * 100.0) / 100.0);
		if(accNeg.modificarUna(acc)) {
			res=true;
		}
		else {
			res=false;
		}
		
		accNeg.Finalizar();
		return res;
	}
	
	@RequestMapping("leerPrestamosaPagar.do")
	public String LeerPrestamosaPagar(String User, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		ObtenerListaPrestamosUsuario(User, m);
		
		m.addAttribute("Username",User);
		
		FinalizarNeg();
		FinalizarEnt();
		return "ClientePrestamos";
	}
	
	public void ObtenerListaPrestamosUsuario(String User, Model m) {
		ClienteNeg cliNeg = (ClienteNeg) appContextNeg.getBean("cliNeg");
		Prestamos_x_ClienteNeg prestxcliNeg = (Prestamos_x_ClienteNeg) appContextNeg.getBean("prestxcliNeg");
		
		Cliente cli = cliNeg.obtenerCliente(User);
		
		List<Prestamos_x_Cliente> lstPrestxCli = prestxcliNeg.leerTodosPorCliente(cli.getDNI());
		
		m.addAttribute("lstPrestxCli",lstPrestxCli);
		
		cliNeg.Finalizar();
		prestxcliNeg.Finalizar();
	}
	
	@RequestMapping("cancelarPrestamo.do")
	public String CancelarPrestamo(String User, String hdnCodPrestamo, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		PrestamoNeg prestNeg = (PrestamoNeg) appContextNeg.getBean("prestNeg");
		
		Prestamo prest = (Prestamo) appContextEnt.getBean("PrestamoDefault");
		
		if(!hdnCodPrestamo.trim().isEmpty()) {
			prest=prestNeg.leerUno(Integer.parseInt(hdnCodPrestamo));
			if(prest.getEstado()==0) {
				prest.setEstado(-1);
				if(prestNeg.modificarUno(prest)) {
					m.addAttribute("Msg","<script type='text/javascript'>alert('Se canceló el pedido del prestamo.');</script>");
				}
				else {
					m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al modificar el estado del prestamo.');</script>");
				}
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al obtener la información del prestamo.');</script>");
			}
		}
		else {
			m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al obtener la información del prestamo.');</script>");
		}
		
		ObtenerListaPrestamosUsuario(User, m);
		
		m.addAttribute("Username",User);
		
		FinalizarNeg();
		FinalizarEnt();
		return "ClientePrestamos";
	}
	
	@RequestMapping("reportePrestamos.do")
	public String ReportePrestamos(String User, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		leerListaPrestamos(null,null,m);
		
		m.addAttribute("Username",User);
		
		FinalizarNeg();
		FinalizarEnt();
		
		return "BancoReportesPrestamos";
	}
	
	public void leerListaPrestamos(Date Fecha1, Date Fecha2, Model m) {
		Prestamos_x_ClienteNeg prestxcliNeg = (Prestamos_x_ClienteNeg) appContextNeg.getBean("prestxcliNeg");
		
		List<Prestamos_x_Cliente> lstPrestxCli = prestxcliNeg.obtenerHistorialPrestamos(Fecha1, Fecha2);
		
		m.addAttribute("lstPrestxCli",lstPrestxCli);
		
		prestxcliNeg.Finalizar();
	}
	
	@RequestMapping("filtrarPrestamos.do")
	public String FiltrarPrestamos(String User, String txtFecha1, String txtFecha2, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		Date Fecha1;
		Date Fecha2;
		
		try {
			if(!(txtFecha1.trim().isEmpty()&&txtFecha2.trim().isEmpty())) {
				if(!txtFecha1.trim().isEmpty()) {
					Fecha1=new SimpleDateFormat("yyyy-MM-dd").parse(txtFecha1);  
				}
				else {
					Fecha1=null;
				}
				if(!txtFecha2.trim().isEmpty()) {
					Fecha2=new SimpleDateFormat("yyyy-MM-dd").parse(txtFecha2);
				}
				else {
					Fecha2=null;
				}
				if(Fecha1!=null&Fecha2!=null) {
					if(Fecha1.compareTo(Fecha2)!=1) {
						leerListaPrestamos(Fecha1,Fecha2,m);
					}
					else {
						m.addAttribute("Msg","<script type='text/javascript'>alert('La segunda fecha ingresada es menor a la primera.');</script>");
						leerListaPrestamos(null,null,m);
					}
				}
				else {
					leerListaPrestamos(Fecha1,Fecha2,m);
				}
			}
			else {
				leerListaPrestamos(null,null,m);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			leerListaPrestamos(null,null,m);
			m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al filtrar los prestamos.');</script>");
		}
		
		
		m.addAttribute("Username",User);
		
		FinalizarNeg();
		FinalizarEnt();
		return "BancoReportesPrestamos";
	}
}
