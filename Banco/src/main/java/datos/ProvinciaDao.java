package datos;

import java.util.List;

import entidad.Provincia;

public interface ProvinciaDao {
	public boolean agregarUna(Provincia provincia);
	public Provincia leerUna(int idProvincia);
	public List<Provincia> leerTodas();
}
