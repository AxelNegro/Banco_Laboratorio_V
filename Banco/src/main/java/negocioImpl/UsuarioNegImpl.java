package negocioImpl;

import datos.UsuarioDao;
import datosImpl.UsuarioDaoImpl;
import entidad.Usuario;
import negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg{
	
	private UsuarioDao userDao;
	
	public UsuarioNegImpl() {
	}

	public UsuarioNegImpl(UsuarioDao userDao) {
		this.userDao = userDao;
	}

	public boolean agregarUno(Usuario user) {
		return userDao.agregarUno(user);
	}

}
