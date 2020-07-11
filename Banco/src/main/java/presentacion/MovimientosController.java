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
import entidad.Concepto;
import entidad.Cuenta;
import entidad.Cuentas_x_Usuario;
import entidad.Movimiento;
import entidad.Movimientos_x_Cuenta;
import negocio.ConceptoNeg;
import negocio.CuentaNeg;
import negocio.Cuentas_x_UsuarioNeg;
import negocio.MovimientoNeg;
import negocio.Movimientos_x_CuentaNeg;

@Controller
public class MovimientosController {
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
	
	@RequestMapping("realizarTransProp.do")
	public String RealizarTransferenciaPropia(String User, String ddlCuentaOrigen, String ddlCuentaDest, String txtImporte, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		Cuentas_x_UsuarioNeg accxuserNeg = (Cuentas_x_UsuarioNeg) appContextNeg.getBean("accxuserNeg");
		List<Cuentas_x_Usuario> lstAccxUser = accxuserNeg.leerCuentasxUsuario(User);
		
		if(!(ddlCuentaOrigen.trim().isEmpty()||ddlCuentaDest.trim().isEmpty()||txtImporte.trim().isEmpty())) {
			if(!(ddlCuentaOrigen.trim().equals(ddlCuentaDest.trim()))) {
				if(!(Double.parseDouble(txtImporte.trim())<=0)) {
					if(CrearMovimientos(ddlCuentaOrigen,ddlCuentaDest,txtImporte,"3", m)) {
						m.addAttribute("Msg","<script type='text/javascript'>alert('Transferencia realizada correctamente.')</script>");
					}
				}
				else {
					m.addAttribute("Msg","<script type='text/javascript'>alert('No puede transferir números negativos ni ceros.')</script>");
				}
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('No puede realizar una transferencia a la misma cuenta.')</script>");
			}
		}
		else {
			m.addAttribute("Msg","<script type='text/javascript'>alert('Complete los datos.')</script>");
		}
		
		m.addAttribute("lstAccxUser",lstAccxUser);
		m.addAttribute("Username", User);
		
		accxuserNeg.Finalizar();
		FinalizarNeg();
		FinalizarEnt();
		
		return "ClienteTransPropias";
	}
	
	public boolean CrearMovimientos(String CBUOrigen, String CBUDestino, String sImporte, String Concepto, Model m) {
		boolean res=false;
		Double Importe = Double.parseDouble(sImporte);
		
		MovimientoNeg movNeg = (MovimientoNeg) appContextNeg.getBean("movNeg");
		Movimientos_x_CuentaNeg movxaccNeg = (Movimientos_x_CuentaNeg) appContextNeg.getBean("movxaccNeg");
		CuentaNeg accNeg = (CuentaNeg) appContextNeg.getBean("accNeg");
		
		Date FechaMov = (Date) appContextEnt.getBean("FechaDefault");
		Concepto concepto = (Concepto) appContextEnt.getBean("ConceptoDefault");
		Movimiento mov = (Movimiento) appContextEnt.getBean("MovimientoDefault");
		Cuenta accOrig = (Cuenta) appContextEnt.getBean("CuentaDefault");
		Cuenta accDest = (Cuenta) appContextEnt.getBean("CuentaDefault");
		Movimientos_x_Cuenta movxacc = (Movimientos_x_Cuenta) appContextEnt.getBean("Movimientos_x_CuentaDefault");
		
		try {
			accOrig.setCBU(Integer.parseInt(CBUOrigen));
			accDest.setCBU(Integer.parseInt(CBUDestino));

			concepto.setIdConcepto(Integer.parseInt(Concepto));
			
			mov.setConcepto(concepto);
			mov.setFecha(FechaMov);
			mov.setImporte(Importe);
			
			accOrig = accNeg.leerUna(Integer.parseInt(CBUOrigen));
			accDest = accNeg.leerUna(Integer.parseInt(CBUDestino));
			
			if(accOrig.getEstado()&&accDest.getEstado()) {
				if(accOrig.getSaldo()>=Importe) {
					if(movNeg.agregarUno(mov)) 
					{
						movxacc.setCuentaOrig(accOrig);
						movxacc.setCuentaDest(accDest);
						movxacc.setMovimiento(mov);
						
						if(movxaccNeg.agregarUno(movxacc)) {
							res=true;
							accOrig.setSaldo(Math.round((accOrig.getSaldo()-Importe) * 100.0) / 100.0);
							accDest.setSaldo(Math.round((accDest.getSaldo()+Importe) * 100.0) / 100.0);
							if(accNeg.modificarUna(accOrig)) {
								if(accNeg.modificarUna(accDest)) {
									res=true;
								}
								else {
									m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al actualizar el saldo de la cuenta destino.')</script>");
									res=false;
								}
							}
							else {
								m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al actualizar el saldo de la cuenta origen.')</script>");
								res=false;
							}
						}
						else {
							m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al realizar el movimiento.')</script>");
							res=false;
						}
					}
					else {
						m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al realizar el movimiento.')</script>");
						res=false;
					}
				}
				else {
					m.addAttribute("Msg","<script type='text/javascript'>alert('El saldo de la cuenta es menor al importe.')</script>");
					res=false;
				}
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('El CBU especificado está temporalmente desactivado.')</script>");
				res=false;
			}
		}
		catch(Exception e) {
			m.addAttribute("Msg","<script type='text/javascript'>alert('Ingrese correctamente los datos.')</script>");
			res=false;
		}
		finally {
			movNeg.Finalizar();
			movxaccNeg.Finalizar();
		}
		
		return res;
	}
	
	@RequestMapping("realizarTransTerc.do")
	public String RealizarTransTerc(String User, String ddlCuentaOrigen, String txtCBUDestino, String txtImporte, String ddlConcepto, Model m) {
		boolean DestinoIgual=false;
		InicializarEnt();
		InicializarNeg();
		
		Cuentas_x_UsuarioNeg accxuserNeg = (Cuentas_x_UsuarioNeg) appContextNeg.getBean("accxuserNeg");
		ConceptoNeg conceptoNeg = (ConceptoNeg) appContextNeg.getBean("conceptoNeg");
		CuentaNeg accNeg = (CuentaNeg) appContextNeg.getBean("accNeg");
		
		List<Cuentas_x_Usuario> lstAccxUser = accxuserNeg.leerCuentasxUsuario(User);
		List<Concepto> lstConceptos = conceptoNeg.leerTodosTransferencia();
		Cuenta acc = (Cuenta) appContextEnt.getBean("CuentaDefault");
		
		if(!(ddlCuentaOrigen.trim().isEmpty()||txtCBUDestino.trim().isEmpty()||Integer.parseInt(txtCBUDestino.trim())==-1||txtImporte.trim().isEmpty()||ddlConcepto.trim().isEmpty())) {
			if(!(ddlCuentaOrigen.trim().equals(txtCBUDestino.trim()))) {
				for(Cuentas_x_Usuario accxuser : lstAccxUser) {
					if(Integer.parseInt(txtCBUDestino)==accxuser.getCuenta().getCBU()) {
						DestinoIgual=true;
					}
				}
				if(!DestinoIgual) {
					acc=accNeg.leerUna(Integer.parseInt(txtCBUDestino.trim()));
					if(acc!=null) {
						if(!(Double.parseDouble(txtImporte.trim())<=0)) {
							if(CrearMovimientos(ddlCuentaOrigen,txtCBUDestino,txtImporte,ddlConcepto, m)) {
								m.addAttribute("Msg","<script type='text/javascript'>alert('Transferencia realizada correctamente.')</script>");
							}
						}
						else {
							m.addAttribute("Msg","<script type='text/javascript'>alert('No puede transferir números negativos ni ceros.')</script>");
						}
					}
					else {
						m.addAttribute("Msg","<script type='text/javascript'>alert('La CBU especificada no existe.')</script>");
					}
				}
				else {
					m.addAttribute("Msg","<script type='text/javascript'>alert('No puede transferir a una cuenta propia.')</script>");
				}
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('No puede transferir a la misma cuenta.')</script>");
			}
		}
		else {
			m.addAttribute("Msg","<script type='text/javascript'>alert('Complete los datos.')</script>");
		}
		
		m.addAttribute("lstConceptos",lstConceptos);
		m.addAttribute("lstAccxUser",lstAccxUser);
		m.addAttribute("Username",User);
		
		FinalizarNeg();
		FinalizarEnt();
		
		return "ClienteTransTerceros";
	}
	
	@RequestMapping("reporteMovimientos.do")
	public String MostrarMovimientos(String User, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		leerListaMovimientos(null,null,m);
		
		m.addAttribute("Username",User);
		
		FinalizarNeg();
		FinalizarEnt();
		return "BancoReportesMovimientos";
	}
	
	public void leerListaMovimientos(Date Fecha1, Date Fecha2, Model m) {
		Movimientos_x_CuentaNeg movxaccNeg = (Movimientos_x_CuentaNeg) appContextNeg.getBean("movxaccNeg");
		
		List <Movimientos_x_Cuenta> lstMovxAcc = movxaccNeg.obtenerHistorialBanco(Fecha1, Fecha2);
		
		m.addAttribute("lstMovxAcc",lstMovxAcc);
		
		movxaccNeg.Finalizar();
	}
	
	@RequestMapping("filtrarMovimientos.do")
	public String FiltrarMovimientos(String User,String txtFecha1, String txtFecha2, Model m) {
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
						leerListaMovimientos(Fecha1,Fecha2,m);
					}
					else {
						m.addAttribute("Msg","<script type='text/javascript'>alert('La segunda fecha ingresada es menor a la primera.');</script>");
						leerListaMovimientos(null,null,m);
					}
				}
				else {
					leerListaMovimientos(Fecha1,Fecha2,m);
				}
			}
			else {
				leerListaMovimientos(null,null,m);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			leerListaMovimientos(null,null,m);
			m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al filtrar los movimientos.');</script>");
		}
		
		
		m.addAttribute("Username",User);
		
		FinalizarNeg();
		FinalizarEnt();
		return "BancoReportesMovimientos";
	}
	
}
