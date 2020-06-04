package entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
@Table(name="Cliente_x_Movimiento")
public class Cliente_x_Movimiento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="DNI")
	private int DNI;
	@Column(name="CBU")
	private int CBU;
	@Column(name="CodMovimiento")
	private int CodMovimiento;
	
	public Cliente_x_Movimiento(int dNI, int cBU, int codMovimiento) {
		super();
		DNI = dNI;
		CBU = cBU;
		CodMovimiento = codMovimiento;
	}

	public Cliente_x_Movimiento() {
		super();
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public int getCBU() {
		return CBU;
	}

	public void setCBU(int cBU) {
		CBU = cBU;
	}

	public int getCodMovimiento() {
		return CodMovimiento;
	}

	public void setCodMovimiento(int codMovimiento) {
		CodMovimiento = codMovimiento;
	}
	
	
}
