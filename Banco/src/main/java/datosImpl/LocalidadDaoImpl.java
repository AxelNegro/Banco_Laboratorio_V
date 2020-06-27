package datosImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.LocalidadDao;
import entidad.Localidad;

public class LocalidadDaoImpl implements LocalidadDao{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
	public boolean agregarUna(Localidad localidad) {
		Inicializar();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(localidad);
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

	public Localidad leerUna(int idLocalidad) {
		Inicializar();
		Localidad loc;
		try {
			session.beginTransaction();
			loc=(Localidad) session.get(Localidad.class, idLocalidad);
		}
		catch(Exception e) {
			loc=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		if(loc!=null) {
			return loc;
		}
		else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Localidad> leerTodas() {
		Inicializar();
		List<Localidad> lstLocalidades;
		try {
		query=session.createQuery("FROM Localidad");
		lstLocalidades=query.list();
		}
		catch(Exception e){
			lstLocalidades=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstLocalidades;
	}
	
	@SuppressWarnings("unchecked")
	public List<Localidad> leerLocalidadesxProvincia(int idProvincia) {
		Inicializar();
		List<Localidad> lstLocalidades;
		try {
		query=session.createQuery("FROM Localidad where IdProvincia=:IdProvincia");
		query.setString("IdProvincia", String.valueOf(idProvincia));
		lstLocalidades=query.list();
		}
		catch(Exception e){
			lstLocalidades=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstLocalidades;
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
