package datos;

import java.util.List;

import entidad.Concepto;

public interface ConceptoDao {
	public boolean agregarUno(Concepto concepto);
	public Concepto leerUno(int IdConcepto);
	public List<Concepto> leerTodosTransferencia();
}
