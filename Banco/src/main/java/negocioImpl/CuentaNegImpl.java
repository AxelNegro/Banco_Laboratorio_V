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
	
	public Cuenta leerUna(int CBU) {
		return cuentaDao.leerUna(CBU);
	}
	
	public boolean tipoCuentaUsado(String Username, int codTipo) {
		return cuentaDao.tipoCuentaUsado(Username, codTipo);
	}
	
	public boolean modificarUna(Cuenta cuenta) {
		return cuentaDao.modificarUna(cuenta);
	}
	
	public int contarTodas() {
		return cuentaDao.contarTodas();
	}
	
	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		cuentaDao = (CuentaDao) appContext.getBean("accDao");
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}
}
