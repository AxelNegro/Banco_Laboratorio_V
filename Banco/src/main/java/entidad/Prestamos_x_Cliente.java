package entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Prestamos_x_Cliente")
public class Prestamos_x_Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade= {CascadeType.ALL},
			  orphanRemoval = true)
	@PrimaryKeyJoinColumn(name="CodPrestamo")
	private Prestamo prestamo;
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="DNI")
	private Cliente cliente;
	
	public Prestamos_x_Cliente() {
	}

	public Prestamos_x_Cliente(Prestamo prestamo, Cliente cliente) {
		this.prestamo = prestamo;
		this.cliente = cliente;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
