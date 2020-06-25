package negocioImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import datos.Cuentas_x_UsuarioDao;
import entidad.Cuentas_x_Usuario;
import negocio.Cuentas_x_UsuarioNeg;

public class Cuentas_x_UsuarioNegImpl implements Cuentas_x_UsuarioNeg{
	
	private ApplicationContext appContext;
	private Cuentas_x_UsuarioDao accxuserDao;

	public Cuentas_x_UsuarioNegImpl() {
		Inicializar();
	}

	public Cuentas_x_UsuarioNegImpl(Cuentas_x_UsuarioDao accxuserDao) {
		this.accxuserDao = accxuserDao;
	}

	public boolean agregarUna(Cuentas_x_Usuario accxuser) {
		return accxuserDao.agregarUna(accxuser);
	}
	
	public int contarCuentas(String username) {
		return accxuserDao.contarCuentas(username);
	}
	
	public List<Cuentas_x_Usuario> leerTodas(){
		return accxuserDao.leerTodas();
	}
	
	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		accxuserDao = (Cuentas_x_UsuarioDao) appContext.getBean("accxuserDao");
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}
}
