package datosImpl;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.Cuotas_x_PrestamoDao;
import entidad.Cuotas_x_Prestamo;

public class Cuotas_x_PrestamoDaoImpl implements Cuotas_x_PrestamoDao{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	
	public boolean agregarUna(Cuotas_x_Prestamo cuotxprest) {
		Inicializar();
		 
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(cuotxprest);
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
