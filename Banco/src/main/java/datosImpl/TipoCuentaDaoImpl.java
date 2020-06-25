package datosImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.TipoCuentaDao;
import entidad.TipoCuenta;

public class TipoCuentaDaoImpl implements TipoCuentaDao{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
	@SuppressWarnings("finally")
	public boolean agregarUna(TipoCuenta tipoacc) {
		Inicializar();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(tipoacc);
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
	
	public TipoCuenta leerUna(int ID) {
		Inicializar();
		TipoCuenta tc;
		try {
			session.beginTransaction();
			tc=(TipoCuenta) session.get(TipoCuenta.class, ID);
		}
		catch(Exception e) {
			tc=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		if(tc!=null) {
			return tc;
		}
		else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoCuenta> leerTodas(){
		Inicializar();
		List<TipoCuenta> lstTipoCuenta;
		try {
		query=session.createQuery("FROM TipoCuenta");
		lstTipoCuenta=query.list();
		}
		catch(Exception e){
			lstTipoCuenta=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstTipoCuenta;
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
