package entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import java.io.Serializable;

@Entity
@Table(name="Movimiento")
public class Movimiento implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CodMovimiento")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CodMovimiento;
	@Column(name="Importe")
	private double Importe;
	@ManyToOne
	@PrimaryKeyJoinColumn(name="IdConcepto")
	private Concepto concepto;
	@Column(name="Fecha")
	@Type(type="date")
	private Date Fecha;

	public Movimiento(int codMovimiento, double importe, Concepto concepto, Date fecha) {
		CodMovimiento = codMovimiento;
		Importe = importe;
		this.concepto = concepto;
		Fecha = fecha;
	}

	public Movimiento() {

	}
	
	public int getCodMovimiento() {
		return CodMovimiento;
	}

	public void setCodMovimiento(int codMovimiento) {
		CodMovimiento = codMovimiento;
	}


	public double getImporte() {
		return Importe;
	}

	public void setImporte(double importe) {
		Importe = importe;
	}

	public Concepto getConcepto() {
		return concepto;
	}

	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	
}
