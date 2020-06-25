package negocio;

import entidad.Cuenta;

public interface CuentaNeg {
	public boolean agregarUna(Cuenta cuenta);
	public Cuenta leerUna(int CBU);
	public boolean tipoCuentaUsado(String Username, int codTipo);
	public boolean modificarUna(Cuenta cuenta);
	public void Inicializar();
	public void Finalizar();
}
