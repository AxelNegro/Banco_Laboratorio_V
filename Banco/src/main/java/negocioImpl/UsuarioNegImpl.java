package negocioImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.UsuarioDao;
import entidad.Usuario;
import negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg{
	
	private ApplicationContext appContext;
	private UsuarioDao userDao;
	
	public UsuarioNegImpl() {
		Inicializar();
	}

	public UsuarioNegImpl(UsuarioDao userDao) {
		this.userDao = userDao;
	}

	public boolean agregarUno(Usuario user) {
		return userDao.agregarUno(user);
	}

	public Usuario leerUno(String username) {
		return userDao.leerUno(username);
	}
	
	public List<Usuario> leerTodos(){
		return userDao.leerTodos();
	}
	
	public boolean Modificar(Usuario user) {
		return userDao.Modificar(user);
	}

	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		userDao = (UsuarioDao) appContext.getBean("userDao");
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}
}
