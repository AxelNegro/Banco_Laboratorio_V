package negocio;

import entidad.Prestamo;

public interface PrestamoNeg {
	public boolean agregarUno(Prestamo prest);
	public Prestamo leerUno(int CodPrestamo);
	public boolean modificarUno(Prestamo prest);
	public void Inicializar();
	public void Finalizar();
}
