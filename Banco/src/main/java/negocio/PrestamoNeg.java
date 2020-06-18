package negocio;

import entidad.Prestamo;

public interface PrestamoNeg {
	public boolean agregarUno(Prestamo prest);
	public void Inicializar();
	public void Finalizar();
}
