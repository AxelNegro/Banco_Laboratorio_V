package entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name="Cuotas_x_Prestamo")
public class Cuotas_x_Prestamo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdCuota;
	@ManyToOne
	@JoinColumn(name="CodPrestamo")
	private Prestamo prestamo;
	@Column(name="ImporteMensual")
	private double ImporteMensual;
	@Column(name="FechaPago")
	@Type(type="date")
	private Date FechaPago;
	@Column(name="Estado")
	private boolean Estado;
	
	public Cuotas_x_Prestamo() {
	}
	
	public Cuotas_x_Prestamo(int idCuota, Prestamo prestamo, double importeMensual, Date fechaPago, boolean estado) {
		super();
		IdCuota = idCuota;
		this.prestamo = prestamo;
		ImporteMensual = importeMensual;
		FechaPago = fechaPago;
		Estado = estado;
	}

	public int getIdCuota() {
		return IdCuota;
	}

	public void setIdCuota(int idCuota) {
		IdCuota = idCuota;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public double getImporteMensual() {
		return ImporteMensual;
	}

	public void setImporteMensual(double importeMensual) {
		ImporteMensual = importeMensual;
	}

	public Date getFechaPago() {
		return FechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		FechaPago = fechaPago;
	}

	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}
	
	
	
}
