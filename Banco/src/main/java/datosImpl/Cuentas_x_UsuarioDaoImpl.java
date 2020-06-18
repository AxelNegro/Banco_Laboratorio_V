package datosImpl;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.Cuentas_x_UsuarioDao;
import entidad.Cuentas_x_Usuario;

public class Cuentas_x_UsuarioDaoImpl implements Cuentas_x_UsuarioDao{
	
	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	
	@SuppressWarnings("finally")
	public boolean agregarUna(Cuentas_x_Usuario accxuser) {
		Inicializar();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(accxuser);
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
