package negocioImpl;

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
	
	
	public void Inicializar() {
		appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		accxuserDao = (Cuentas_x_UsuarioDao) appContext.getBean("accxuserDao");
	}
	
	public void Finalizar() {
		((ConfigurableApplicationContext)(appContext)).close();
	}
}
