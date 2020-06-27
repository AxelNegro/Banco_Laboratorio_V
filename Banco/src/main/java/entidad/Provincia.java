package entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Provincia")
public class Provincia {
	@Id
	@Column(name="IdProvincia")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdProvincia;
	@Column(name="Descripcion")
	private String Descripcion;
	
	public Provincia() {
	}

	public Provincia(int idProvincia, String descripcion) {
		IdProvincia = idProvincia;
		Descripcion = descripcion;
	}
	
	public int getIdProvincia() {
		return IdProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		IdProvincia = idProvincia;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Provincia [IdProvincia=" + IdProvincia + ", Descripcion=" + Descripcion + "]";
	}
	
}
