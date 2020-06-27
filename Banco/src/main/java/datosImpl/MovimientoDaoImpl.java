package datosImpl;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.MovimientoDao;
import entidad.Movimiento;

public class MovimientoDaoImpl implements MovimientoDao{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	
	public boolean agregarUno(Movimiento mov) {
		Inicializar();
		 
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(mov);
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
