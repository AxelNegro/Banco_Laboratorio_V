package negocio;

import java.util.List;

import entidad.TipoCuenta;

public interface TipoCuentaNeg {
	public boolean agregarUna(TipoCuenta tipoacc);
	public TipoCuenta leerUna(int ID);
	public List<TipoCuenta> leerTodas();
	public void Inicializar();
	public void Finalizar();
}
