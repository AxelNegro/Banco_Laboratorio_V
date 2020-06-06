package entidad;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Prestamo")
public class Prestamo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CodPrestamo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CodPrestamo;
	@Column(name="Fecha")
	private Date Fecha;
	@Column(name="Importe")
	private double Importe;
	@Column(name="Cuotas")
	private int Cuotas;
	@Column(name="Plazo_en_Meses")
	private int Plazo_en_Meses;
	@Column(name="Importe_x_Mes")
	private double Importe_x_Mes;
	@Column(name="Estado")
	private int Estado;
	
	public Prestamo() {
	}

	public Prestamo(int codPrestamo, Date fecha, double importe, int cuotas,
			int plazo_en_Meses, double importe_x_Mes, int estado) {
		CodPrestamo = codPrestamo;
		Fecha = fecha;
		Importe = importe;
		Cuotas = cuotas;
		Plazo_en_Meses = plazo_en_Meses;
		Importe_x_Mes = importe_x_Mes;
		Estado = estado;
	}

	public int getCodPrestamo() {
		return CodPrestamo;
	}

	public void setCodPrestamo(int codPrestamo) {
		CodPrestamo = codPrestamo;
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

	public int getPlazo_en_Meses() {
		return Plazo_en_Meses;
	}

	public void setPlazo_en_Meses(int plazo_en_Meses) {
		Plazo_en_Meses = plazo_en_Meses;
	}

	public double getImporte_x_Mes() {
		return Importe_x_Mes;
	}

	public void setImporte_x_Mes(double importe_x_Mes) {
		Importe_x_Mes = importe_x_Mes;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}
	
}
