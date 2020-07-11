package negocioImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.ConceptoDao;
import entidad.Concepto;
import negocio.ConceptoNeg;

public class ConceptoNegImpl implements ConceptoNeg{

	private ApplicationContext appContext;
	private ConceptoDao conceptoDao;
		
	public ConceptoNegImpl() {
		Inicializar();
	}

	public boolean agregarUno(Concepto concepto) {
		return conceptoDao.agregarUno(concepto);
	}

	public Concepto leerUno(int IdConcepto) {
		return conceptoDao.leerUno(IdConcepto);
	}
	
	public List<Concepto> leerTodosTransferencia() {
		return conceptoDao.leerTodosTransferencia();
	}

	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		conceptoDao = (ConceptoDao) appContext.getBean("conceptoDao");
	}

	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}

}
