package negocioImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.PrestamoDao;
import entidad.Prestamo;
import negocio.PrestamoNeg;

public class PrestamoNegImpl implements PrestamoNeg{
	
	private ApplicationContext appContext;
	private PrestamoDao prestDao;
	
	public PrestamoNegImpl() {
		Inicializar();
	}
	
	public PrestamoNegImpl(PrestamoDao prestDao) {
		this.prestDao = prestDao;
	}

	public boolean agregarUno(Prestamo prest) {
		return prestDao.agregarUno(prest);
	}
	
	
	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		prestDao = (PrestamoDao) appContext.getBean("prestDao");
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}
	
}
