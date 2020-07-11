package datos;


import java.util.Date;
import java.util.List;

import entidad.Cuenta;
import entidad.Movimientos_x_Cuenta;

public interface Movimientos_x_CuentaDao {
	public boolean agregarUno(Movimientos_x_Cuenta movxacc);
	public List<Movimientos_x_Cuenta> obtenerHistorialCuenta(List<Cuenta> lstCBUs);
	public List<Movimientos_x_Cuenta> obtenerHistorialBanco(Date Fecha1, Date Fecha2);
}
