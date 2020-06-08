package datosImpl;

import org.hibernate.Session;

import datos.TipoCuentaDao;
import entidad.TipoCuenta;

public class TipoCuentaDaoImpl implements TipoCuentaDao{

	private Conexion con = new Conexion();
	
	@SuppressWarnings("finally")
	public boolean agregarUna(TipoCuenta tipoacc) {
		Session session=con.abrirConexion();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(tipoacc);
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
