package negocioImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.TipoCuentaDao;
import entidad.TipoCuenta;
import negocio.TipoCuentaNeg;

public class TipoCuentaNegImpl implements TipoCuentaNeg{
	
	private ApplicationContext appContext;
	private TipoCuentaDao tipoaccDao;
	
	public TipoCuentaNegImpl() {
		Inicializar();
	}
	
	public TipoCuentaNegImpl(TipoCuentaDao tipoaccDao) {
		this.tipoaccDao = tipoaccDao;
	}

	public boolean agregarUna(TipoCuenta tipoacc) {
		return tipoaccDao.agregarUna(tipoacc);
	}
	
	public TipoCuenta leerUna(int ID) {
		return tipoaccDao.leerUna(ID);
	}
	
	public List<TipoCuenta> leerTodas(){
		return tipoaccDao.leerTodas();
	}
	
	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		tipoaccDao = (TipoCuentaDao) appContext.getBean("tipoaccDao");
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}
}
