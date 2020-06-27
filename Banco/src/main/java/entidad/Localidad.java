package entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Localidad")
public class Localidad {
	@Id
	@Column(name="IdLocalidad")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdLocalidad;
	@ManyToOne
	@JoinColumn(name="IdProvincia")
	private Provincia provincia;
	@Column(name="Descripcion")
	private String Descripcion;
	
	public Localidad() {
	}

	public Localidad(Provincia provincia, int idLocalidad, String descripcion) {
		this.provincia = provincia;
		IdLocalidad = idLocalidad;
		Descripcion = descripcion;
	}
	
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public int getIdLocalidad() {
		return IdLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		IdLocalidad = idLocalidad;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
}
