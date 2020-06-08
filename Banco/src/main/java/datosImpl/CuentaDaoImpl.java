package datosImpl;

import org.hibernate.Session;

import datos.CuentaDao;
import entidad.Cuenta;

public class CuentaDaoImpl implements CuentaDao{

	private Conexion con = new Conexion();
	
	@SuppressWarnings("finally")
	public boolean agregarUna(Cuenta cuenta) {
		Session session=con.abrirConexion();
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
			con.cerrarSession();
			return res;
		}
		
	}
	
}
