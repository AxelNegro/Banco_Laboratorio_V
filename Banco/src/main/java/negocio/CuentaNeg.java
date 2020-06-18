package negocio;

import entidad.Cuenta;

public interface CuentaNeg {
	public boolean agregarUna(Cuenta cuenta);
	public void Inicializar();
	public void Finalizar();
}
