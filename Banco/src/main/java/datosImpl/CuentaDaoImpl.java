package datosImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.CuentaDao;
import entidad.Cuenta;

public class CuentaDaoImpl implements CuentaDao{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
	@SuppressWarnings("finally")
	public boolean agregarUna(Cuenta cuenta) {
		Inicializar();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(cuenta);
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
	
	public Cuenta leerUna(int CBU) {
		Inicializar();
		Cuenta acc;;
		try {
			session.beginTransaction();
			acc=(Cuenta) session.get(Cuenta.class, CBU);
		}
		catch(Exception e) {
			acc=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		if(acc!=null) {
			return acc;
		}
		else {
			return null;
		}
	}
	
	public boolean tipoCuentaUsado(String Username, int codTipo) {
		Inicializar();
		Long contAux;
		int cont;
		
		try {
		query = session.createQuery("select count(*) from Cuentas_x_Usuario accxuser inner join accxuser.cuenta acc where accxuser.usuario=:Username and acc.CodTipoCuenta=:codTipo");
		query.setString("Username", Username);
		query.setString("codTipo", String.valueOf(codTipo));
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
		
		if(cont>=1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean modificarUna(Cuenta cuenta) {
		Boolean res=false;
		Inicializar();
		
		try {
			session.beginTransaction();
			session.update(cuenta);
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
	
	public int contarTodas() {
		Inicializar();
		
		Long contAux;
		int cont;
		
		try {
		query = session.createQuery("select count(*) from Cuenta");
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
