package datosImpl;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.CuentaDao;
import entidad.Cuenta;

public class CuentaDaoImpl implements CuentaDao{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	
	@SuppressWarnings("finally")
	public boolean agregarUna(Cuenta cuenta) {
		Inicializar();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(cuenta);
			session.getTransaction().commit();
			
			res=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			res=false;
		}
		finally {
			Finalizar();
			return res;
		}
		
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
