package negocioImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.Movimientos_x_CuentaDao;
import entidad.Cuenta;
import entidad.Movimientos_x_Cuenta;
import negocio.Movimientos_x_CuentaNeg;

public class Movimientos_x_CuentaNegImpl implements Movimientos_x_CuentaNeg{
	
	private ApplicationContext appContext;
	private Movimientos_x_CuentaDao movxaccDao;
	
	public Movimientos_x_CuentaNegImpl() {
		Inicializar();
	}
	
	public Movimientos_x_CuentaNegImpl(Movimientos_x_CuentaDao movxaccDao) {
		this.movxaccDao = movxaccDao;
	}

	public boolean agregarUno(Movimientos_x_Cuenta movxacc) {
		return movxaccDao.agregarUno(movxacc);
	}
	
	public List<Movimientos_x_Cuenta> obtenerHistorialCuenta(List<Cuenta> lstCBUs) {
		return movxaccDao.obtenerHistorialCuenta(lstCBUs);
	}
	
	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		movxaccDao = (Movimientos_x_CuentaDao) appContext.getBean("movxaccDao");
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}
	
}
