package datosImpl;

import org.hibernate.Session;

import datos.ClienteDao;
import entidad.Cliente;

public class ClienteDaoImpl implements ClienteDao{
	
	private Conexion con = new Conexion();
	
	@SuppressWarnings("finally")
	public boolean agregarUno(Cliente cli) {
		Session session=con.abrirConexion();
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
			con.cerrarSession();
			return res;
		}
		
	}
}
