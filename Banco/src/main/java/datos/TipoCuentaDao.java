package datos;

import java.util.List;

import entidad.TipoCuenta;

public interface TipoCuentaDao {
	public boolean agregarUna(TipoCuenta tipoacc);
	public TipoCuenta leerUna(int ID);
	public List<TipoCuenta> leerTodas();
}
