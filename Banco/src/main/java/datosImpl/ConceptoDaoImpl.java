package datosImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.ConceptoDao;
import entidad.Concepto;

public class ConceptoDaoImpl implements ConceptoDao{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
	public boolean agregarUno(Concepto concepto) {
		Inicializar();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(concepto);
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
	
	public Concepto leerUno(int IdConcepto) {
		Inicializar();
		Concepto concepto;
		try {
			session.beginTransaction();
			concepto=(Concepto) session.get(Concepto.class, IdConcepto);
		}
		catch(Exception e) {
			concepto=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		if(concepto!=null) {
			return concepto;
		}
		else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Concepto> leerTodosTransferencia() {
		Inicializar();
		List<Concepto> lstConceptos;
		try {
		query=session.createQuery("FROM Concepto where IdConcepto not IN (1,2,3,4,5)");
		lstConceptos=query.list();
		}
		catch(Exception e){
			lstConceptos=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstConceptos;
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
