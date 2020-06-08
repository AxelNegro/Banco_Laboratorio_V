package datosImpl;

import org.hibernate.Session;

import datos.Prestamos_x_ClienteDao;
import entidad.Prestamos_x_Cliente;

public class Prestamos_x_ClienteDaoImpl implements Prestamos_x_ClienteDao{
	
private Conexion con = new Conexion();
	
	@SuppressWarnings("finally")
	public boolean agregarUno(Prestamos_x_Cliente prestxcli) {
		Session session=con.abrirConexion();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(prestxcli);
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
