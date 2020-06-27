package datosImpl;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.Movimientos_x_CuentaDao;
import entidad.Movimientos_x_Cuenta;

public class Movimientos_x_CuentaDaoImpl implements Movimientos_x_CuentaDao{
	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	
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
