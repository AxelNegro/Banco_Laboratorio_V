package entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Cuenta")
public class Cuenta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CBU")
	private int CBU;
	@Column(name="Fecha")
	private Date Fecha;
	@Column(name="TipoCuenta")
	private int TipoCuenta;
	@Column(name="NumeroCuenta")
	private int NumeroCuenta;
	@Column(name="Nombre")
	private String Nombre;
	@Column(name="Saldo")
	private Double Saldo;
	
	public Cuenta(int cbu, Date fecha, int tipoCuenta, int numeroCuenta, String nombre, Double saldo) {
		super();
		CBU = cbu;
		Fecha = fecha;
		TipoCuenta = tipoCuenta;
		NumeroCuenta = numeroCuenta;
		Nombre = nombre;
		Saldo = saldo;
	}

	public Cuenta() {
		super();
	}

	public int getCBU() {
		return CBU;
	}

	public void setCBU(int cBU) {
		CBU = cBU;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public int getTipoCuenta() {
		return TipoCuenta;
	}

	public void setTipoCuenta(char tipoCuenta) {
		TipoCuenta = tipoCuenta;
	}

	public int getNumeroCuenta() {
		return NumeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		NumeroCuenta = numeroCuenta;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Double getSaldo() {
		return Saldo;
	}

	public void setSaldo(Double saldo) {
		Saldo = saldo;
	}

	
}
