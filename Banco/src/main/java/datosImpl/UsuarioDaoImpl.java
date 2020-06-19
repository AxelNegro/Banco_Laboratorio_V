package datosImpl;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.UsuarioDao;
import entidad.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{
	
	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	
	@SuppressWarnings("finally")
	public boolean agregarUno(Usuario user) {
		Inicializar();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(user);
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
	
	public Usuario leerUno(String username) {
		Inicializar();
		Usuario user;
		try {
			session.beginTransaction();
			user=(Usuario) session.get(Usuario.class, username);
		}
		catch(Exception e) {
			user=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		if(user!=null) {
			return user;
		}
		else {
			return null;
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
