package entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Prestamos")
public class Prestamos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CodigoPrestamo")
	private int CodigoPrestamo;
	@Column(name="Fecha")
	private Date Fecha;
	@Column(name="Importe")
	private double Importe;
	@Column(name="Cuotas")
	private int Cuotas;
	@Column(name="Plazo_x_Meses")
	private int Plazo_x_Meses;
	@Column(name="Importe_x_Mes")
	private double Importe_x_Mes;
	
	public Prestamos(int codigoPrestamo, Date fecha, double importe, int cuotas, int plazo_x_Meses,
			double importe_x_Mes) {
		super();
		CodigoPrestamo = codigoPrestamo;
		Fecha = fecha;
		Importe = importe;
		Cuotas = cuotas;
		Plazo_x_Meses = plazo_x_Meses;
		Importe_x_Mes = importe_x_Mes;
	}

	public Cliente_x_Movimiento() {
		super();
	}

	public int getCodigoPrestamo() {
		return CodigoPrestamo;
	}

	public void setCodigoPrestamo(int codigoPrestamo) {
		CodigoPrestamo = codigoPrestamo;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public double getImporte() {
		return Importe;
	}

	public void setImporte(double importe) {
		Importe = importe;
	}

	public int getCuotas() {
		return Cuotas;
	}

	public void setCuotas(int cuotas) {
		Cuotas = cuotas;
	}

	public int getPlazo_x_Meses() {
		return Plazo_x_Meses;
	}

	public void setPlazo_x_Meses(int plazo_x_Meses) {
		Plazo_x_Meses = plazo_x_Meses;
	}

	public double getImporte_x_Mes() {
		return Importe_x_Mes;
	}

	public void setImporte_x_Mes(double importe_x_Mes) {
		Importe_x_Mes = importe_x_Mes;
	}
}
