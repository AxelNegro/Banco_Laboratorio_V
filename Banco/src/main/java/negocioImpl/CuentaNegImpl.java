package negocioImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.CuentaDao;
import entidad.Cuenta;
import negocio.CuentaNeg;

public class CuentaNegImpl implements CuentaNeg{
	
	private ApplicationContext appContext;
	private CuentaDao cuentaDao;
	
	public CuentaNegImpl() {
		Inicializar();
	}

	public CuentaNegImpl(CuentaDao cuentaDao) {
		this.cuentaDao = cuentaDao;
	}

	public boolean agregarUna(Cuenta cuenta) {
		return cuentaDao.agregarUna(cuenta);
	}
	
	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		cuentaDao = (CuentaDao) appContext.getBean("accDao");
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}
}
