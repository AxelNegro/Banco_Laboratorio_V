package negocioImpl;

import datos.ClienteDao;
import datosImpl.ClienteDaoImpl;
import entidad.Cliente;
import negocio.ClienteNeg;

public class ClienteNegImpl implements ClienteNeg{
	
	private ClienteDao cliDao;
	
	public ClienteNegImpl() {
	}

	public ClienteNegImpl(ClienteDao cliDao) {
		this.cliDao = cliDao;
	}
	
	public boolean agregarUno(Cliente cli) {
		return cliDao.agregarUno(cli);
	}
	
}
