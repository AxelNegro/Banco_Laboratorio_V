package datosImpl;

import org.hibernate.Session;

import datos.PrestamoDao;
import entidad.Prestamo;

public class PrestamoDaoImpl implements PrestamoDao{
	
private Conexion con = new Conexion();
	
	@SuppressWarnings("finally")
	public boolean agregarUno(Prestamo prest) {
		Session session=con.abrirConexion();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(prest);
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
