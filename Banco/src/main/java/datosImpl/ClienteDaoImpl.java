package datosImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.ClienteDao;
import entidad.Cliente;

public class ClienteDaoImpl implements ClienteDao{
	
	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
	@SuppressWarnings("finally")
	public boolean agregarUno(Cliente cli) {
		Inicializar();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(cli);
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
	
	public Cliente leerUno(int DNI) {
		Inicializar();
		Cliente cli;
		try {
			session.beginTransaction();
			cli=(Cliente) session.get(Cliente.class, DNI);
		}
		catch(Exception e) {
			cli=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		if(cli!=null) {
			return cli;
		}
		else {
			return null;
		}
	}
	
	public boolean tieneUsuario(String Username) {
		Inicializar();
		Long cont;
		try {
		query = session.createQuery("select count(*) from Cliente where Username=:username");
		query.setString("username", Username);
		cont=(Long) query.uniqueResult();
		}
		catch(Exception e){
			cont=(long) 0;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		
		if(Integer.parseInt(cont.toString())==1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> leerTodos() {
		Inicializar();
		List<Cliente> lstClientes;
		try {
		query=session.createQuery("FROM Cliente");
		lstClientes=query.list();
		}
		catch(Exception e){
			lstClientes=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstClientes;
	}
	
	public boolean modificar(Cliente cli) {
		Boolean res=false;
		Inicializar();
		
		try {
			session.beginTransaction();
			session.update(cli);
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
