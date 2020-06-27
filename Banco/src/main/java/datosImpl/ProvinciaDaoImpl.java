package datosImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.ProvinciaDao;
import entidad.Provincia;

public class ProvinciaDaoImpl implements ProvinciaDao{
	
	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
	public boolean agregarUna(Provincia provincia) {
		Inicializar();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(provincia);
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
	
	public Provincia leerUna(int idProvincia) {
		Inicializar();
		Provincia prov;
		try {
			session.beginTransaction();
			prov=(Provincia) session.get(Provincia.class, idProvincia);
		}
		catch(Exception e) {
			prov=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		if(prov!=null) {
			return prov;
		}
		else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Provincia> leerTodas() {
		Inicializar();
		List<Provincia> lstProvincias;
		try {
		query=session.createQuery("FROM Provincia");
		lstProvincias=query.list();
		}
		catch(Exception e){
			lstProvincias=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstProvincias;
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
