package datosImpl;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.PrestamoDao;
import entidad.Prestamo;

public class PrestamoDaoImpl implements PrestamoDao{
	
	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	
	public boolean agregarUno(Prestamo prest) {
		Inicializar();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(prest);
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
	
	public Prestamo leerUno(int CodPrestamo) {
		Inicializar();
		Prestamo prest;
		try {
			session.beginTransaction();
			prest=(Prestamo) session.get(Prestamo.class, CodPrestamo);
		}
		catch(Exception e) {
			prest=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return prest;
	}

	public boolean modificarUno(Prestamo prest) {
		Boolean res=false;
		Inicializar();
		
		try {
			session.beginTransaction();
			session.update(prest);
			session.getTransaction().commit();
			res=true;
		}
		catch(Exception e) {
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
