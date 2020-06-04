package entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
@Table(name="PrestamosCliente")
public class Prestamos_x_Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CodigoPrestamo")
	private int CodigoPrestamo;
	@Column(name="DNI")
	private int DNI;
	
	
	
	public Prestamos_x_Cliente() {
		super();
	}

	public Prestamos_x_Cliente(int codigoPrestamo, int dNI) {
		super();
		CodigoPrestamo = codigoPrestamo;
		DNI = dNI;
	}

	public int getCodigoPrestamo() {
		return CodigoPrestamo;
	}

	public void setCodigoPrestamo(int codigoPrestamo) {
		CodigoPrestamo = codigoPrestamo;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}
	
	
	

}
