package datos;

import entidad.Cuenta;

public interface CuentaDao {
	public boolean agregarUna(Cuenta cuenta);
	public Cuenta leerUna(int CBU);
	public boolean tipoCuentaUsado(String Username, int codTipo);
	public boolean modificarUna(Cuenta cuenta);
}
