package negocioImpl;

import datos.TipoCuentaDao;
import datosImpl.TipoCuentaDaoImpl;
import entidad.TipoCuenta;
import negocio.TipoCuentaNeg;

public class TipoCuentaNegImpl implements TipoCuentaNeg{
	
	private TipoCuentaDao tipoaccDao = new TipoCuentaDaoImpl();
	
	public TipoCuentaNegImpl() {
	}
	
	public TipoCuentaNegImpl(TipoCuentaDao tipoaccDao) {
		this.tipoaccDao = tipoaccDao;
	}

	public boolean agregarUna(TipoCuenta tipoacc) {
		return tipoaccDao.agregarUna(tipoacc);
	}
}
