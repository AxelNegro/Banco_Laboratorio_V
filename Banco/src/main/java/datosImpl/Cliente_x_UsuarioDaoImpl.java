package datosImpl;

import org.hibernate.Session;

import datos.Cliente_x_UsuarioDao;
import entidad.Cliente_x_Usuario;

public class Cliente_x_UsuarioDaoImpl implements Cliente_x_UsuarioDao{
	
	private Conexion con = new Conexion();

	@SuppressWarnings("finally")
	public boolean agregarUno(Cliente_x_Usuario clixuser) {
		Session session=con.abrirConexion();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(clixuser);
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
