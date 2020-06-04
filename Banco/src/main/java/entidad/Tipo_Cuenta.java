package entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
@Table(name="Tipo_Cuenta")
public class Tipo_Cuenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Tc")
	private int Tc;
	@Column(name="Detalle")
	private String Detalle;
	
	public Tipo_Cuenta(int tc, String detalle) {
		super();
		Tc = tc;
		Detalle = detalle;
	}

	public Tipo_Cuenta() {
		super();
	}

	public int getTc() {
		return Tc;
	}

	public void setTc(int tc) {
		Tc = tc;
	}

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}
	
	
	
}
