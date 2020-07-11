package negocio;

import java.util.List;

import entidad.Concepto;

public interface ConceptoNeg {
	public boolean agregarUno(Concepto concepto);
	public Concepto leerUno(int IdConcepto);
	public List<Concepto> leerTodosTransferencia();
	public void Inicializar();
	public void Finalizar();
}
