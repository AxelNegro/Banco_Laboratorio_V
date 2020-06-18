package negocioImpl;

import datos.CuentaDao;
import datosImpl.CuentaDaoImpl;
import entidad.Cuenta;
import negocio.CuentaNeg;

public class CuentaNegImpl implements CuentaNeg{
	
	private CuentaDao cuentaDao;
	
	public CuentaNegImpl() {
	}

	public CuentaNegImpl(CuentaDao cuentaDao) {
		this.cuentaDao = cuentaDao;
	}

	public boolean agregarUna(Cuenta cuenta) {
		return cuentaDao.agregarUna(cuenta);
	}
	
}
