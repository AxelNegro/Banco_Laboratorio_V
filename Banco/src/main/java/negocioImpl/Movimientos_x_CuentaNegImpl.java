package negocioImpl;

import datos.Movimientos_x_CuentaDao;
import datosImpl.Movimientos_x_CuentaDaoImpl;
import entidad.Movimientos_x_Cuenta;
import negocio.Movimientos_x_CuentaNeg;

public class Movimientos_x_CuentaNegImpl implements Movimientos_x_CuentaNeg{
	
	private Movimientos_x_CuentaDao movxaccDao = new Movimientos_x_CuentaDaoImpl();
	
	public Movimientos_x_CuentaNegImpl() {
	}
	
	public Movimientos_x_CuentaNegImpl(Movimientos_x_CuentaDao movxaccDao) {
		this.movxaccDao = movxaccDao;
	}

	public boolean agregarUno(Movimientos_x_Cuenta movxacc) {
		return movxaccDao.agregarUno(movxacc);
	}
	
}
