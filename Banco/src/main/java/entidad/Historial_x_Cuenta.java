package entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="HistorialCuenta")
public class Historial_x_Cuenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CodigoMovimiento")
	private int CodigoMovimiento;
	@Column(name="Importe")
	private double Importe;
	@Column(name="Concepto")
	private String Concepto;
	@Column(name="Fecha")
	private Date Fecha;
	
	public Historial_x_Cuenta(int codigoMovimiento, double importe, String concepto, Date fecha) {
		super();
		CodigoMovimiento = codigoMovimiento;
		Importe = importe;
		Concepto = concepto;
		Fecha = fecha;
	}

	public Historial_x_Cuenta() {
		super();
	}

	public int getCodigoMovimiento() {
		return CodigoMovimiento;
	}

	public void setCodigoMovimiento(int codigoMovimiento) {
		CodigoMovimiento = codigoMovimiento;
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
