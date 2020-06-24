package negocioImpl;

import java.util.List;

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
	
	public Cliente leerUno(int DNI) {
		return cliDao.leerUno(DNI);
	}
	
	public List<Cliente> leerTodos() {
		return cliDao.leerTodos();
	}
	
	public boolean tieneUsuario(String Username) {
		return cliDao.tieneUsuario(Username);
	}
	
	public boolean modificar(Cliente cli) {
		return cliDao.modificar(cli);
	}
	
	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		cliDao = (ClienteDao) appContext.getBean("cliDao");
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}

}
