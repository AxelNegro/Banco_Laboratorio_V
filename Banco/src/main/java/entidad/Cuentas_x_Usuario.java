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
@Table(name="Cuentas_x_Usuario")
public class Cuentas_x_Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@OneToOne(cascade= {CascadeType.ALL})
	@PrimaryKeyJoinColumn(name="CBU")
	private Cuenta cuenta;
	@ManyToOne(cascade= {CascadeType.ALL})
	@PrimaryKeyJoinColumn(name="Usuario")
	private Usuario usuario;
	
	public Cuentas_x_Usuario() {
	}

	public Cuentas_x_Usuario(Cuenta cuenta, Usuario usuario) {
		this.cuenta = cuenta;
		this.usuario = usuario;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
