package datosImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import config.ConfigEnt;
import datos.Prestamos_x_ClienteDao;
import entidad.Prestamos_x_Cliente;

public class Prestamos_x_ClienteDaoImpl implements Prestamos_x_ClienteDao{
	
	private ApplicationContext appContextEnt;
	private ApplicationContext appContextDao;
	private Conexion con;
	private Session session;
	private Query query;
	
	public void Inicializar() {
		appContextDao=new AnnotationConfigApplicationContext(ConfigDao.class);
		con = (Conexion) appContextDao.getBean("ConexionBD");
		session=con.abrirConexion();
		
		appContextEnt=new AnnotationConfigApplicationContext(ConfigEnt.class);
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContextEnt)).close();
		con.cerrarSession();
		((ConfigurableApplicationContext)(appContextDao)).close();
	}
	
	public boolean agregarUno(Prestamos_x_Cliente prestxcli) {
		Inicializar();
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
			Finalizar();
		}
		
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Prestamos_x_Cliente> leerTodosPendientes() {
		Inicializar();
		List<Prestamos_x_Cliente> lstPrestxCli;
		try {
		query=session.createQuery("Select prestxcli FROM Prestamos_x_Cliente prestxcli inner join prestxcli.prestamo prest where prest.Estado=0");
		lstPrestxCli=query.list();
		}
		catch(Exception e){
			lstPrestxCli=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstPrestxCli;
	}
	
	@SuppressWarnings("unchecked")
	public List<Prestamos_x_Cliente> leerTodosPorCliente(int DNI){
		Inicializar();
		List<Prestamos_x_Cliente> lstPrestxCli;
		try {
		query=session.createQuery("Select prestxcli FROM Prestamos_x_Cliente prestxcli inner join prestxcli.cliente cli where cli.DNI=:DNI");
		query.setParameter("DNI", DNI);
		lstPrestxCli=query.list();
		}
		catch(Exception e){
			lstPrestxCli=null;
			e.printStackTrace();
		}
		finally {
			Finalizar();
		}
		return lstPrestxCli;
	}

	@SuppressWarnings("unchecked")
	public List<Prestamos_x_Cliente> obtenerHistorialPrestamos(Date Fecha1, Date Fecha2) {
		Inicializar();
		List<Prestamos_x_Cliente> lstPrestxAcc;
		String cons = (String) appContextEnt.getBean("CadenaDefault");
		int Tipo = 0;
		
		if(Fecha1==null&&Fecha2==null) {
			cons="select prestxcli from Prestamos_x_Cliente prestxcli";
			Tipo=0;
		}
		else if(Fecha1!=null&&Fecha2!=null) {
			cons="select prestxcli from Prestamos_x_Cliente prestxcli inner join prestxcli.prestamo prest"
					+ " where prest.FechaPedido BETWEEN :Fecha1 AND :Fecha2";
			Tipo=1;
		}
		else if(Fecha1!=null) {
			cons="select prestxcli from Prestamos_x_Cliente prestxcli inner join prestxcli.prestamo prest"
					+ " where prest.FechaRespuesta >= :Fecha1";
			Tipo=2;
		}
		else {
			cons="select prestxcli from Prestamos_x_Cliente prestxcli inner join prestxcli.prestamo prest"
					+ " where prest.FechaRespuesta <= :Fecha2";
			Tipo=3;
		}
		
		try {
			query = session.createQuery(cons);
			switch(Tipo) {
				case 1:
					query.setDate("Fecha1",Fecha1);
					query.setDate("Fecha2", Fecha2);
				break;
				case 2:
					query.setDate("Fecha1",Fecha1);
				break;
				case 3:
					query.setDate("Fecha2", Fecha2);
				break;
			}
			lstPrestxAcc=(List<Prestamos_x_Cliente>) query.list();
		}
		catch(Exception e){
			e.printStackTrace();
			lstPrestxAcc=null;
		}
		finally {
			Finalizar();
		}
		
		return lstPrestxAcc;
	}
	
}
