package entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

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
	@Column(name="Concepto")
	private String Concepto;
	@Column(name="Fecha")
	private Date Fecha;

	public Movimiento(int codMovimiento, double importe, String concepto, Date fecha) {
		CodMovimiento = codMovimiento;
		Importe = importe;
		Concepto = concepto;
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

	public String getConcepto() {
		return Concepto;
	}

	public void setConcepto(String concepto) {
		Concepto = concepto;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	
	
	
	
}
