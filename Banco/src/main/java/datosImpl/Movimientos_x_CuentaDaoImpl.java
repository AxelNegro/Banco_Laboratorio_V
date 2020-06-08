package datosImpl;

import org.hibernate.Session;

import datos.Movimientos_x_CuentaDao;
import entidad.Movimientos_x_Cuenta;

public class Movimientos_x_CuentaDaoImpl implements Movimientos_x_CuentaDao{
	
private Conexion con = new Conexion();
	
	@SuppressWarnings("finally")
	public boolean agregarUno(Movimientos_x_Cuenta movxacc) {
		Session session=con.abrirConexion();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(movxacc);
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
