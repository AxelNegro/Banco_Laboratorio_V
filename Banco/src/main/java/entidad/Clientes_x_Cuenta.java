package entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
@Table(name="Clientes_x_Cuenta")
public class Clientes_x_Cuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CBU")
	private int CBU;
	@Column(name="DNI")
	private int DNI;
	
	public int getCBU() {
		return CBU;
	}
	public void setCBU(int cBU) {
		CBU = cBU;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	public Clientes_x_Cuenta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clientes_x_Cuenta(int cBU, int dNI) {
		super();
		CBU = cBU;
		DNI = dNI;
	}
	

}
