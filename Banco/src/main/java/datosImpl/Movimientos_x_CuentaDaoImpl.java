package datosImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import config.ConfigEnt;
import datos.Movimientos_x_CuentaDao;
import entidad.Cuenta;
import entidad.Movimientos_x_Cuenta;

public class Movimientos_x_CuentaDaoImpl implements Movimientos_x_CuentaDao{
	private ApplicationContext appContextDao;
	private ApplicationContext appContextEnt;
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
		
		try {
			query = session.createQuery("from Movimientos_x_Cuenta movxacc where movxacc.cuentaDest IN (:lstCBUs) or movxacc.cuentaOrig IN (:lstCBUs)");
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
	
	@SuppressWarnings("unchecked")
	public List<Movimientos_x_Cuenta> obtenerHistorialBanco(Date Fecha1, Date Fecha2) {
		Inicializar();
		List<Movimientos_x_Cuenta> lstMovxAcc;
		String cons = (String) appContextEnt.getBean("CadenaDefault");
		int Tipo = 0;
		
		if(Fecha1==null&&Fecha2==null) {
			cons="select movxacc from Movimientos_x_Cuenta movxacc inner join movxacc.cuentaDest dest inner join movxacc.cuentaOrig orig where dest.CBU=-1 or orig.CBU=-1";
			Tipo=0;
		}
		else if(Fecha1!=null&&Fecha2!=null) {
			cons="select movxacc from Movimientos_x_Cuenta movxacc inner join movxacc.cuentaDest dest inner join movxacc.cuentaOrig orig inner join movxacc.movimiento mov"
					+ " where (dest.CBU=-1 or orig.CBU=-1) and mov.Fecha BETWEEN :Fecha1 AND :Fecha2";
			Tipo=1;
		}
		else if(Fecha1!=null) {
			cons="select movxacc from Movimientos_x_Cuenta movxacc inner join movxacc.cuentaDest dest inner join movxacc.cuentaOrig orig inner join movxacc.movimiento mov"
					+ " where (dest.CBU=-1 or orig.CBU=-1) and mov.Fecha >= :Fecha1";
			Tipo=2;
		}
		else {
			cons="select movxacc from Movimientos_x_Cuenta movxacc inner join movxacc.cuentaDest dest inner join movxacc.cuentaOrig orig inner join movxacc.movimiento mov"
					+ " where (dest.CBU=-1 or orig.CBU=-1) and mov.Fecha <= :Fecha2";
			Tipo=3;
		}

		try {
			query = session.createQuery(cons);
			switch(Tipo) {
				case 1:
					query.setDate("Fecha1",Fecha1);
					query.setDate("Fecha2", Fecha2);
				break;
				case 2:
					query.setDate("Fecha1",Fecha1);
				break;
				case 3:
					query.setDate("Fecha2", Fecha2);
				break;
			}
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
		appContextDao=new AnnotationConfigApplicationContext(ConfigDao.class);
		con = (Conexion) appContextDao.getBean("ConexionBD");
		session=con.abrirConexion();
		
		appContextEnt=new AnnotationConfigApplicationContext(ConfigEnt.class);
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContextEnt)).close();
		con.cerrarSession();
		((ConfigurableApplicationContext)(appContextDao)).close();
	}
	
}
