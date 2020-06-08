package negocioImpl;

import datos.Cuentas_x_UsuarioDao;
import datosImpl.Cuentas_x_UsuarioDaoImpl;
import entidad.Cuentas_x_Usuario;
import negocio.Cuentas_x_UsuarioNeg;

public class Cuentas_x_UsuarioNegImpl implements Cuentas_x_UsuarioNeg{
	
	private Cuentas_x_UsuarioDao accxuserDao = new Cuentas_x_UsuarioDaoImpl();

	public Cuentas_x_UsuarioNegImpl() {
	}

	public Cuentas_x_UsuarioNegImpl(Cuentas_x_UsuarioDao accxuserDao) {
		this.accxuserDao = accxuserDao;
	}

	public boolean agregarUna(Cuentas_x_Usuario accxuser) {
		return accxuserDao.agregarUna(accxuser);
	}
	
}
