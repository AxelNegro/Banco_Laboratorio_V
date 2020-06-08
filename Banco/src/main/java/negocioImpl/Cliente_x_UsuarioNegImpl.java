package negocioImpl;

import datos.Cliente_x_UsuarioDao;
import datosImpl.Cliente_x_UsuarioDaoImpl;
import entidad.Cliente_x_Usuario;
import negocio.Cliente_x_UsuarioNeg;

public class Cliente_x_UsuarioNegImpl implements Cliente_x_UsuarioNeg{
	
	private Cliente_x_UsuarioDao clixuserDao = new Cliente_x_UsuarioDaoImpl();
	
	public Cliente_x_UsuarioNegImpl() {
	}

	public Cliente_x_UsuarioNegImpl(Cliente_x_UsuarioDao clixuserDao) {
		this.clixuserDao = clixuserDao;
	}

	public boolean agregarUno(Cliente_x_Usuario clixuser) {
		return clixuserDao.agregarUno(clixuser);
	}
	
}
