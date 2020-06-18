package negocioImpl;

import datos.Cuotas_x_PrestamoDao;
import datosImpl.Cuotas_x_PrestamoDaoImpl;
import entidad.Cuotas_x_Prestamo;
import negocio.Cuotas_x_PrestamoNeg;

public class Cuotas_x_PrestamoNegImpl implements Cuotas_x_PrestamoNeg{
	
	private Cuotas_x_PrestamoDao cuotxprestDao;

	public boolean agregarUna(Cuotas_x_Prestamo cuotxprest) {
		return cuotxprestDao.agregarUna(cuotxprest);
	}	
	
}
