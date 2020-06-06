package entidad;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import java.io.Serializable;

@Entity
@Table(name="Cliente_x_Usuario")
public class Cliente_x_Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	@OneToOne(cascade= {CascadeType.ALL})
	@PrimaryKeyJoinColumn(name="DNI")
	private Cliente cliente;
	@OneToOne(cascade = {CascadeType.ALL},
			  orphanRemoval = true)
	@JoinColumn(name="Username")
	private Usuario usuario;
	
	public Cliente_x_Usuario() {
	}
	public Cliente_x_Usuario(Cliente cliente, Usuario usuario) {
		this.cliente = cliente;
		this.usuario = usuario;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
