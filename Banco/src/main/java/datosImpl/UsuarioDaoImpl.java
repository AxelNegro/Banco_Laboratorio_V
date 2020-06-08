package datosImpl;

import org.hibernate.Session;

import datos.UsuarioDao;
import entidad.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{
	private Conexion con = new Conexion();
	
	@SuppressWarnings("finally")
	public boolean agregarUno(Usuario user) {
		Session session=con.abrirConexion();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(user);
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
