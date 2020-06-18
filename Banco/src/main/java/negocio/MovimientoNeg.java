package negocio;

import entidad.Movimiento;

public interface MovimientoNeg {
	public boolean agregarUno(Movimiento mov);
	public void Inicializar();
	public void Finalizar();
}
