package datosImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.Movimientos_x_CuentaDao;
import entidad.Cuenta;
import entidad.Movimientos_x_Cuenta;

public class Movimientos_x_CuentaDaoImpl implements Movimientos_x_CuentaDao{
	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
	public boolean agregarUno(Movimientos_x_Cuenta movxacc) {
		Inicializar();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(movxacc);
			session.getTransaction().commit();
			
			res=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			res=false;
		}
		finally {
			Finalizar();
		}
		
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Movimientos_x_Cuenta> obtenerHistorialCuenta(List<Cuenta> lstCBUs) {
		Inicializar();
		List<Movimientos_x_Cuenta> lstMovxAcc;
		
		try {//movxacc.cuentaOrig IN :CBUs OR
			query = session.createQuery("from Movimientos_x_Cuenta movxacc where movxacc.cuentaDest IN (:lstCBUs)");
			query.setParameterList("lstCBUs", lstCBUs);
			lstMovxAcc=(List<Movimientos_x_Cuenta>) query.list();
		}
		catch(Exception e){
			e.printStackTrace();
			lstMovxAcc=null;
		}
		finally {
			Finalizar();
		}
		
		return lstMovxAcc;
	}
	
	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		con = (Conexion) appContext.getBean("ConexionBD");
		session=con.abrirConexion();
	}
	
	public void Finalizar() {
		con.cerrarSession();
		((ConfigurableApplicationContext)(appContext)).close();
	}
	
}
