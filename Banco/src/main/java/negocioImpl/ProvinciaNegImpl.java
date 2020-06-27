package negocioImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.ProvinciaDao;
import entidad.Provincia;
import negocio.ProvinciaNeg;

public class ProvinciaNegImpl implements ProvinciaNeg{

	private ApplicationContext appContext;
	private ProvinciaDao provDao;

	public ProvinciaNegImpl() {
		Inicializar();
	}

	public ProvinciaNegImpl(ProvinciaDao provDao) {
		this.provDao = provDao;
	}

	public boolean agregarUna(Provincia provincia) {
		return provDao.agregarUna(provincia);
	}

	public Provincia leerUna(int idProvincia) {
		return provDao.leerUna(idProvincia);
	}
	
	public List<Provincia> leerTodas() {
		return provDao.leerTodas();
	}

	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		provDao = (ProvinciaDao) appContext.getBean("provDao");
	}

	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}
	
}
