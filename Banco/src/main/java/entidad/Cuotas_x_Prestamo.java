package entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;


@Entity
@Table(name="Cuotas_x_Prestamo")
public class Cuotas_x_Prestamo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="CodPrestamo")
	private Prestamo prestamo;
	@Column(name="Importe_Mensual")
	private double Importe_Mensual;
	@Column(name="Fecha_Pago")
	private Date Fecha_Pago;
	@Column(name="Estado")
	private boolean Estado;
	
	public Cuotas_x_Prestamo() {
	}

	public Cuotas_x_Prestamo(Prestamo prestamo, double importe_Mensual, Date fecha_Pago, boolean estado) {
		this.prestamo = prestamo;
		Importe_Mensual = importe_Mensual;
		Fecha_Pago = fecha_Pago;
		Estado = estado;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public double getImporte_Mensual() {
		return Importe_Mensual;
	}

	public void setImporte_Mensual(double importe_Mensual) {
		Importe_Mensual = importe_Mensual;
	}

	public Date getFecha_Pago() {
		return Fecha_Pago;
	}

	public void setFecha_Pago(Date fecha_Pago) {
		Fecha_Pago = fecha_Pago;
	}

	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}
	
}
