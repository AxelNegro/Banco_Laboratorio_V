package presentacion;

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
import entidad.Cuotas_x_Prestamo;
import entidad.Movimiento;
import entidad.Movimientos_x_Cuenta;
import entidad.Prestamo;
import negocio.CuentaNeg;
import negocio.Cuentas_x_UsuarioNeg;
import negocio.Cuotas_x_PrestamoNeg;
import negocio.MovimientoNeg;
import negocio.Movimientos_x_CuentaNeg;
import negocio.PrestamoNeg;

@Controller
public class Cuotas_x_PrestamoController {
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
	
	@RequestMapping("leerCuotasxPrestamo.do")
	public String ObtenerCuotasxPrestamo(String CodPrestamo, String User, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		LeerCuotasxPrestamo(CodPrestamo,m);
		LeerCuentasxUsuario(User,m);
		
		m.addAttribute("Username",User);
		
		FinalizarNeg();
		FinalizarEnt();
		return "ClientePagoPrestamos";
	}
	
	public void LeerCuotasxPrestamo(String CodPrestamo, Model m) {
		Cuotas_x_PrestamoNeg cuotxprestNeg = (Cuotas_x_PrestamoNeg) appContextNeg.getBean("cuotxprestNeg");
		
		List<Cuotas_x_Prestamo> lstCuotxPrest = cuotxprestNeg.leerCuotasxPrestamo(Integer.parseInt(CodPrestamo));
		
		if(lstCuotxPrest!=null&&lstCuotxPrest.size()>0) {
			if(TodasPagas(lstCuotxPrest)) { //Todas las cuotas fueron pagadas
				if(ActualizarPrestamo(lstCuotxPrest.get(0).getPrestamo())) {
					m.addAttribute("Msg2","<script type='text/javascript'>alert('El prestamo tiene todas las cuotas pagadas.');window.opener.location.reload();window.close()</script>");
				}
				else {
					m.addAttribute("Msg2","<script type='text/javascript'>alert('Hubo un error al actualizar el prestamo.');window.close()</script>");
				}
			}
			else { //Hay cuotas impagas
				m.addAttribute("lstCuotxPrest",lstCuotxPrest);
				m.addAttribute("CodPrestamo",CodPrestamo);
			}
		}
		
		cuotxprestNeg.Finalizar();
	}
	
	public void LeerCuentasxUsuario(String User, Model m) {
		Cuentas_x_UsuarioNeg accxuserNeg = (Cuentas_x_UsuarioNeg) appContextNeg.getBean("accxuserNeg");
		
		List<Cuentas_x_Usuario> lstAccxUser = accxuserNeg.leerCuentasxUsuario(User);
		
		m.addAttribute("lstAccxUser",lstAccxUser);
		
		accxuserNeg.Finalizar();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("pagarCuotas.do")
	public String PagarCuotas(String hdnUser, String hdnCodPrestamo, String hdnImporteTotal, String[] chkPagar, String ddlCuenta, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		Cuotas_x_PrestamoNeg cuotxprestNeg = (Cuotas_x_PrestamoNeg) appContextNeg.getBean("cuotxprestNeg");
		
		List<Integer> lstIdCuota = (List<Integer>) appContextEnt.getBean("LstIntegersDefault");
		Double ImporteT;
		
		if(!ddlCuenta.trim().isEmpty()) {
			if(chkPagar!=null) {
				for(String Cuota : chkPagar) {
					lstIdCuota.add(Integer.parseInt(Cuota));
				}
				ImporteT=Double.parseDouble(hdnImporteTotal)*chkPagar.length;
				if(ActualizarSaldo(ddlCuenta,ImporteT)) {
					if(cuotxprestNeg.pagarCuotasxPrestamo(lstIdCuota)>0) {
						if(CrearMovimientos(Integer.parseInt(ddlCuenta),ImporteT)) {
							m.addAttribute("Msg","<script type='text/javascript'>alert('Se pagaron las cuotas seleccionadas.')</script>");
						}
						else {
							m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al crear los movimientos para la cuenta.')</script>");
						}
					}
					else {
						m.addAttribute("Msg","<script type='text/javascript'>alert('Hubo un error al pagar las cuotas.')</script>");	
					}
				}
				else {
					m.addAttribute("Msg","<script type='text/javascript'>alert('No tiene suficiente saldo en la cuenta.')</script>");
				}
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('Seleccione las cuotas a pagar.')</script>");
			}
		}
		else {
			m.addAttribute("Msg","<script type='text/javascript'>alert('Seleccione la cuenta con la que pagará las cuotas.')</script>");
		}
		
		LeerCuotasxPrestamo(hdnCodPrestamo,m);
		LeerCuentasxUsuario(hdnUser,m);
		
		m.addAttribute("Username",hdnUser);
		
		
		cuotxprestNeg.Finalizar();
		FinalizarNeg();
		FinalizarEnt();
		return "ClientePagoPrestamos";
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
			accOrig.setCBU(CBU);
			accDest.setCBU(-1);
			concepto.setIdConcepto(5);
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
	
	public boolean ActualizarSaldo(String CBU, Double Importe) {
		CuentaNeg accNeg = (CuentaNeg) appContextNeg.getBean("accNeg");
		
		Cuenta acc = accNeg.leerUna(Integer.parseInt(CBU));
		boolean res=false;
		
		if(acc.getSaldo()>=Importe) {
			acc.setSaldo(Math.round((acc.getSaldo()-Importe) * 100.0) / 100.0);
			if(accNeg.modificarUna(acc)) {
				res=true;
			}
			else {
				res=false;
			}
		}
		else {
				res=false;
		}
		
		accNeg.Finalizar();
		return res;
	}
	
	public boolean TodasPagas(List<Cuotas_x_Prestamo> lstCuotxPrest) {
		boolean res=true;
		
		for(Cuotas_x_Prestamo cuotxprest : lstCuotxPrest) {
			if(!cuotxprest.isEstado()) { //Esta impaga
				res=false;
			}
		}
		
		return res;
	}
	
	public boolean ActualizarPrestamo(Prestamo prest) {
		PrestamoNeg prestNeg = (PrestamoNeg) appContextNeg.getBean("prestNeg");
		
		boolean res=false;
		
		try {
			prest.setEstado(3);
			if(prestNeg.modificarUno(prest)) {
				res=true;
			}
			else {
				res=false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			res=false;
		}
		finally {
			prestNeg.Finalizar();
		}
		return res;
	}
}
