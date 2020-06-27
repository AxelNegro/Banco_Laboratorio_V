package negocioImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.LocalidadDao;
import entidad.Localidad;
import negocio.LocalidadNeg;

public class LocalidadNegImpl implements LocalidadNeg{

	private ApplicationContext appContext;
	private LocalidadDao locDao;
	
	public LocalidadNegImpl() {
		Inicializar();
	}
	
	public LocalidadNegImpl(LocalidadDao locDao) {
		this.locDao = locDao;
	}

	public boolean agregarUna(Localidad localidad) {
		return locDao.agregarUna(localidad);
	}

	public Localidad leerUna(int idLocalidad) {
		return locDao.leerUna(idLocalidad);
	}
	
	public List<Localidad> leerLocalidadesxProvincia(int idProvincia) {
		return locDao.leerLocalidadesxProvincia(idProvincia);
	}
	
	public List<Localidad> leerTodas() {
		return locDao.leerTodas();
	}

	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		locDao = (LocalidadDao) appContext.getBean("locDao");
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}

}
