package entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Prestamo")
public class Prestamo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CodPrestamo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CodPrestamo;
	@ManyToOne
	@JoinColumn(name="CBU")
	private Cuenta cuenta;
	@Column(name="FechaPedido")
	@Type(type="date")
	private Date FechaPedido;
	@Column(name="FechaRespuesta")
	@Type(type="date")
	private Date FechaRespuesta;
	@Column(name="ImporteBruto")
	private double ImporteBruto;
	@Column(name="ImporteNeto")
	private double ImporteNeto;
	@Column(name="PlazoenMeses")
	private int PlazoenMeses;
	@Column(name="Estado")
	private int Estado;
	
	public Prestamo() {
	}

	public Prestamo(int codPrestamo, Cuenta cuenta, Date fechaPedido, Date fechaRespuesta, double importeBruto,
			double importeNeto, int plazoenMeses, int estado) {
		CodPrestamo = codPrestamo;
		this.cuenta = cuenta;
		FechaPedido = fechaPedido;
		FechaRespuesta = fechaRespuesta;
		ImporteBruto = importeBruto;
		ImporteNeto = importeNeto;
		PlazoenMeses = plazoenMeses;
		Estado = estado;
	}

	public int getCodPrestamo() {
		return CodPrestamo;
	}

	public void setCodPrestamo(int codPrestamo) {
		CodPrestamo = codPrestamo;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Date getFechaPedido() {
		return FechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		FechaPedido = fechaPedido;
	}

	public Date getFechaRespuesta() {
		return FechaRespuesta;
	}

	public void setFechaRespuesta(Date fechaAprobado) {
		FechaRespuesta = fechaAprobado;
	}

	public double getImporteBruto() {
		return ImporteBruto;
	}

	public void setImporteBruto(double importeBruto) {
		ImporteBruto = importeBruto;
	}

	public double getImporteNeto() {
		return ImporteNeto;
	}

	public void setImporteNeto(double importeNeto) {
		ImporteNeto = importeNeto;
	}

	public int getPlazoenMeses() {
		return PlazoenMeses;
	}

	public void setPlazoenMeses(int plazoenMeses) {
		PlazoenMeses = plazoenMeses;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}
	
}
