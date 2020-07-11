package negocioImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.Cuotas_x_PrestamoDao;
import entidad.Cuotas_x_Prestamo;
import negocio.Cuotas_x_PrestamoNeg;

public class Cuotas_x_PrestamoNegImpl implements Cuotas_x_PrestamoNeg{
	
	private ApplicationContext appContext;
	private Cuotas_x_PrestamoDao cuotxprestDao;
	
	public Cuotas_x_PrestamoNegImpl() {
		Inicializar();
	}

	public Cuotas_x_PrestamoNegImpl(Cuotas_x_PrestamoDao cuotxprestDao) {
		this.cuotxprestDao = cuotxprestDao;
	}

	public boolean agregarUna(Cuotas_x_Prestamo cuotxprest) {
		return cuotxprestDao.agregarUna(cuotxprest);
	}	
	
	public Cuotas_x_Prestamo leerUna(int IdCuota) {
		return cuotxprestDao.leerUna(IdCuota);
	}
	
	public List<Cuotas_x_Prestamo> leerCuotasxPrestamo(int CodPrestamo) {
		return cuotxprestDao.leerCuotasxPrestamo(CodPrestamo);
	}
	
	public int pagarCuotasxPrestamo(List<Integer> lstIdCuota) {
		return cuotxprestDao.pagarCuotasxPrestamo(lstIdCuota);
	}
	
	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		cuotxprestDao = (Cuotas_x_PrestamoDao) appContext.getBean("cuotxprestDao");
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}
	
}
