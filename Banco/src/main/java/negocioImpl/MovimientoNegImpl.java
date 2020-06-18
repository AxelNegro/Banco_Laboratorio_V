package negocioImpl;

import datos.MovimientoDao;
import datosImpl.MovimientoDaoImpl;
import entidad.Movimiento;
import negocio.MovimientoNeg;

public class MovimientoNegImpl implements MovimientoNeg{
	
	private MovimientoDao movDao;
	
	public MovimientoNegImpl() {
	}
	
	public MovimientoNegImpl(MovimientoDao movDao) {
		this.movDao = movDao;
	}

	public boolean agregarUno(Movimiento mov) {
		return movDao.agregarUno(mov);
	}
	
}
