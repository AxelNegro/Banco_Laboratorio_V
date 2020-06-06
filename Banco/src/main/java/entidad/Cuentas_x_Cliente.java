package entidad;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import java.io.Serializable;

@Entity
@Table(name="Cuentas_x_Cliente")
public class Cuentas_x_Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@OneToOne(cascade= {CascadeType.ALL})
	@PrimaryKeyJoinColumn(name="CBU")
	private Cuenta cuenta;
	@ManyToOne(cascade= {CascadeType.ALL})
	@PrimaryKeyJoinColumn(name="DNI")
	private Cliente cliente;
	
	public Cuentas_x_Cliente() {
	}

	public Cuentas_x_Cliente(Cuenta cuenta, Cliente cliente) {
		this.cuenta = cuenta;
		this.cliente = cliente;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
