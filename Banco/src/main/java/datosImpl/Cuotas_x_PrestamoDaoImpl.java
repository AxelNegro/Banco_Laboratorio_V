package datosImpl;

import org.hibernate.Session;

import datos.Cuotas_x_PrestamoDao;
import entidad.Cuotas_x_Prestamo;

public class Cuotas_x_PrestamoDaoImpl implements Cuotas_x_PrestamoDao{

private Conexion con = new Conexion();
	
	@SuppressWarnings("finally")
	public boolean agregarUna(Cuotas_x_Prestamo cuotxprest) {
		Session session=con.abrirConexion();
		Boolean res=false;
		
		try {
			session.beginTransaction();
			session.save(cuotxprest);
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
