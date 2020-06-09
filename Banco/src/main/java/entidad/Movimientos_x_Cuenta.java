package entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Movimientos_x_Cuenta")
public class Movimientos_x_Cuenta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne(cascade= {CascadeType.ALL},
			  orphanRemoval = true)
	@JoinColumn(name="CodMovimiento")
	private Movimiento movimiento;
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="CBU_Origen")
	private Cuenta cuentaOrig;
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="CBU_Destino")
	private Cuenta cuentaDest;
	
	public Movimientos_x_Cuenta() {
	}
	
	public Movimientos_x_Cuenta(Movimiento movimiento, Cuenta cuentaOrig, Cuenta cuentaDest) {
		this.movimiento = movimiento;
		this.cuentaOrig = cuentaOrig;
		this.cuentaDest = cuentaDest;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public Cuenta getCuentaOrig() {
		return cuentaOrig;
	}

	public void setCuentaOrig(Cuenta cuentaOrig) {
		this.cuentaOrig = cuentaOrig;
	}

	public Cuenta getCuentaDest() {
		return cuentaDest;
	}

	public void setCuentaDest(Cuenta cuentaDest) {
		this.cuentaDest = cuentaDest;
	}

}
