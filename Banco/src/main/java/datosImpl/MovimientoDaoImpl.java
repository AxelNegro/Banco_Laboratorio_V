package datosImpl;

import org.hibernate.Session;

import datos.MovimientoDao;
import entidad.Movimiento;

public class MovimientoDaoImpl implements MovimientoDao{

private Conexion con = new Conexion();
	
	@SuppressWarnings("finally")
	public boolean agregarUno(Movimiento mov) {
		Session session=con.abrirConexion();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(mov);
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
