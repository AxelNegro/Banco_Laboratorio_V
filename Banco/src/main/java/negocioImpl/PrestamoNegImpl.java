package negocioImpl;

import datos.PrestamoDao;
import datosImpl.PrestamoDaoImpl;
import entidad.Prestamo;
import negocio.PrestamoNeg;

public class PrestamoNegImpl implements PrestamoNeg{
	
	private PrestamoDao prestDao = new PrestamoDaoImpl();
	
	public PrestamoNegImpl() {
	}
	
	public PrestamoNegImpl(PrestamoDao prestDao) {
		this.prestDao = prestDao;
	}

	public boolean agregarUno(Prestamo prest) {
		return prestDao.agregarUno(prest);
	}
	
}
