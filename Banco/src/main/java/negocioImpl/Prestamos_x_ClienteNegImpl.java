package negocioImpl;

import datos.Prestamos_x_ClienteDao;
import datosImpl.Prestamos_x_ClienteDaoImpl;
import entidad.Prestamos_x_Cliente;
import negocio.Prestamos_x_ClienteNeg;

public class Prestamos_x_ClienteNegImpl implements Prestamos_x_ClienteNeg{

	private Prestamos_x_ClienteDao prestxcliDao;
	
	public Prestamos_x_ClienteNegImpl() {
	}
	
	public Prestamos_x_ClienteNegImpl(Prestamos_x_ClienteDao prestxcliDao) {
		this.prestxcliDao = prestxcliDao;
	}

	public boolean agregarUno(Prestamos_x_Cliente prestxcli) {
		return prestxcliDao.agregarUno(prestxcli);
	}
	
}
