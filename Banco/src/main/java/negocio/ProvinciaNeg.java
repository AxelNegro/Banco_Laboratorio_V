package negocio;

import java.util.List;

import entidad.Provincia;

public interface ProvinciaNeg {
	public boolean agregarUna(Provincia provincia);
	public Provincia leerUna(int idProvincia);
	public List<Provincia> leerTodas();
	public void Inicializar();
	public void Finalizar();
}
