package datosImpl;

import java.util.List;

import org.hibernate.Query;
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
	private Query query;
	
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
		}
		
		return res;
	}
	
	public int contarCuentas(String username) {
		Inicializar();
		Long contAux;
		int cont;
		
		try {
		query = session.createQuery("select count(*) from Cuentas_x_Usuario where usuario_Username=:username");
		query.setString("username", username);
		contAux=(Long) query.uniqueResult();
		}
		catch(Exception e){
			contAux=(long) 0;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		cont=Integer.parseInt(contAux.toString());
		return cont;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cuentas_x_Usuario> leerTodas(){
		Inicializar();
		List<Cuentas_x_Usuario> lstAccxUser;
		try {
		query=session.createQuery("from Cuentas_x_Usuario");
		lstAccxUser=(List<Cuentas_x_Usuario>) query.list();
		}
		catch(Exception e){
			lstAccxUser=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstAccxUser;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cuentas_x_Usuario> leerCuentasxUsuario(String Username) {
		Inicializar();
		List<Cuentas_x_Usuario> lstAccxUser;
		try {
			query=session.createQuery("from Cuentas_x_Usuario where usuario_Username=:Username");
			query.setString("Username", Username);
			lstAccxUser=(List<Cuentas_x_Usuario>) query.list();
		}
		catch(Exception e){
			lstAccxUser=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstAccxUser;
	}
	
	public Cuentas_x_Usuario obtenerUsuario(int CBU) {
		Inicializar();
		Cuentas_x_Usuario accxuser;
		try {
		query = session.createQuery("select accxuser from Cuentas_x_Usuario accxuser inner join accxuser.cuenta acc where acc.CBU=:CBU");
		query.setParameter("CBU", CBU);
		accxuser = (Cuentas_x_Usuario) query.uniqueResult();
		}
		catch(Exception e){
			accxuser=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		
		return accxuser;
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
