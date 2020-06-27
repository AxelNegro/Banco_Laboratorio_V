package datos;

import java.util.List;

import entidad.Localidad;

public interface LocalidadDao {
	public boolean agregarUna(Localidad localidad);
	public Localidad leerUna(int idLocalidad);
	public List<Localidad> leerTodas();
	public List<Localidad> leerLocalidadesxProvincia(int idProvincia);
}
