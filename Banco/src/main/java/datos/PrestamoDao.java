package datos;

import entidad.Prestamo;

public interface PrestamoDao {
	public boolean agregarUno(Prestamo prest);
	public Prestamo leerUno(int CodPrestamo);
	public boolean modificarUno(Prestamo prest);
}
