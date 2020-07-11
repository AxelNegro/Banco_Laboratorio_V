package datosImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.Cuotas_x_PrestamoDao;
import entidad.Cuotas_x_Prestamo;

public class Cuotas_x_PrestamoDaoImpl implements Cuotas_x_PrestamoDao{

	private ApplicationContext appContext;
	private Conexion con;
	private Session session;
	private Query query;
	
	public boolean agregarUna(Cuotas_x_Prestamo cuotxprest) {
		Inicializar();
		 
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
			Finalizar();
			
		}
		
		return res;
	}
	
	public Cuotas_x_Prestamo leerUna(int IdCuota) {
		Inicializar();
		Cuotas_x_Prestamo cuotxprest;
		try {
			session.beginTransaction();
			cuotxprest=(Cuotas_x_Prestamo) session.get(Cuotas_x_Prestamo.class, IdCuota);
		}
		catch(Exception e) {
			cuotxprest=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return cuotxprest;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cuotas_x_Prestamo> leerCuotasxPrestamo(int CodPrestamo) {
		Inicializar();
		List<Cuotas_x_Prestamo> lstCuotxPrest;
		try {
			query=session.createQuery("Select cuotxprest from Cuotas_x_Prestamo cuotxprest inner join cuotxprest.prestamo prest where prest.CodPrestamo=:CodPrestamo ");
			query.setParameter("CodPrestamo", CodPrestamo);
			lstCuotxPrest=(List<Cuotas_x_Prestamo>) query.list();
		}
		catch(Exception e){
			lstCuotxPrest=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstCuotxPrest;
	}
	
	public int pagarCuotasxPrestamo(List<Integer> lstIdCuota) {
		int datosAct = 0;
		String update = "update Cuotas_x_Prestamo cuotxprest set cuotxprest.Estado=1, cuotxprest.FechaPago=:FechaHoy where cuotxprest.IdCuota IN (:lstIdCuota)";
		Inicializar();
		
		try {
			session.beginTransaction();
			query=session.createQuery(update);
			query.setDate("FechaHoy", new Date());
			query.setParameterList("lstIdCuota", lstIdCuota);
			datosAct = query.executeUpdate();
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			datosAct = 0;
		}
		finally {
			Finalizar();
		}
		return datosAct;
	}
	
	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		con = (Conexion) appContext.getBean("ConexionBD");
		session=con.abrirConexion();
	}
	
	public void Finalizar() {
		con.cerrarSession();
		((ConfigurableApplicationContext)(appContext)).close();
	}

}
