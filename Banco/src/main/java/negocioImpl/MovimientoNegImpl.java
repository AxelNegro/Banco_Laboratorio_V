package negocioImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.MovimientoDao;
import entidad.Movimiento;
import negocio.MovimientoNeg;

public class MovimientoNegImpl implements MovimientoNeg{
	
	private ApplicationContext appContext;
	private MovimientoDao movDao;
	
	public MovimientoNegImpl() {
		Inicializar();
	}
	
	public MovimientoNegImpl(MovimientoDao movDao) {
		this.movDao = movDao;
	}

	public boolean agregarUno(Movimiento mov) {
		return movDao.agregarUno(mov);
	}
	
	
	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		movDao = (MovimientoDao) appContext.getBean("movDao");
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}
	
}
