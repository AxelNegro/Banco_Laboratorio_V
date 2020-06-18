package negocioImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.ClienteDao;
import entidad.Cliente;
import negocio.ClienteNeg;

public class ClienteNegImpl implements ClienteNeg{
	
	private ApplicationContext appContext;
	private ClienteDao cliDao;
	
	public ClienteNegImpl() {
		Inicializar();
	}

	public ClienteNegImpl(ClienteDao cliDao) {
		this.cliDao = cliDao;
	}
	
	public boolean agregarUno(Cliente cli) {
		return cliDao.agregarUno(cli);
	}
	
	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		cliDao = (ClienteDao) appContext.getBean("cliDao");
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}
}
