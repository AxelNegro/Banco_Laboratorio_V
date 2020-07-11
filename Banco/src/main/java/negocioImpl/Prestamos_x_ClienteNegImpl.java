package negocioImpl;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.Prestamos_x_ClienteDao;
import entidad.Prestamos_x_Cliente;
import negocio.Prestamos_x_ClienteNeg;

public class Prestamos_x_ClienteNegImpl implements Prestamos_x_ClienteNeg{

	private ApplicationContext appContext;
	private Prestamos_x_ClienteDao prestxcliDao;
	
	public Prestamos_x_ClienteNegImpl() {
		Inicializar();
	}
	
	public Prestamos_x_ClienteNegImpl(Prestamos_x_ClienteDao prestxcliDao) {
		this.prestxcliDao = prestxcliDao;
	}

	public boolean agregarUno(Prestamos_x_Cliente prestxcli) {
		return prestxcliDao.agregarUno(prestxcli);
	}
	
	public List<Prestamos_x_Cliente> leerTodosPendientes() {
		return prestxcliDao.leerTodosPendientes();
	}
	
	public List<Prestamos_x_Cliente> leerTodosPorCliente(int DNI) {
		return prestxcliDao.leerTodosPorCliente(DNI);
	}
	
	public List<Prestamos_x_Cliente> obtenerHistorialPrestamos(Date Fecha1, Date Fecha2) {
		return prestxcliDao.obtenerHistorialPrestamos(Fecha1, Fecha2);
	}
	
	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		prestxcliDao = (Prestamos_x_ClienteDao) appContext.getBean("prestxcliDao");
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}

}
