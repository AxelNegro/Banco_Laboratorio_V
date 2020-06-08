package datosImpl;

import org.hibernate.Session;

import datos.Cuentas_x_UsuarioDao;
import entidad.Cuentas_x_Usuario;

public class Cuentas_x_UsuarioDaoImpl implements Cuentas_x_UsuarioDao{
	
	private Conexion con = new Conexion();
	
	@SuppressWarnings("finally")
	public boolean agregarUna(Cuentas_x_Usuario accxuser) {
		Session session=con.abrirConexion();
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
			con.cerrarSession();
			return res;
		}
		
	}
	
}
