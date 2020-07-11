package negocio;

import java.util.List;

import entidad.Cuotas_x_Prestamo;

public interface Cuotas_x_PrestamoNeg {
	public boolean agregarUna(Cuotas_x_Prestamo cuotxprest);
	public Cuotas_x_Prestamo leerUna(int IdCuota);
	public List<Cuotas_x_Prestamo> leerCuotasxPrestamo(int CodPrestamo);
	public int pagarCuotasxPrestamo(List<Integer> lstIdCuota);
	public void Inicializar();
	public void Finalizar();
}
