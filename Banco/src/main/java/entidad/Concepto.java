package entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Concepto")
public class Concepto implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="IdConcepto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdConcepto;
	@Column(name="Descripcion")
	private String Descripcion;
	
	public Concepto() {
	}

	public Concepto(int idConcepto, String descripcion) {
		IdConcepto = idConcepto;
		Descripcion = descripcion;
	}

	public int getIdConcepto() {
		return IdConcepto;
	}

	public void setIdConcepto(int idConcepto) {
		IdConcepto = idConcepto;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
}
