package entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
@Table(name="TipoCuenta")
public class TipoCuenta implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CodTipoCuenta")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CodTipoCuenta;
	@Column(name="TipoCuenta")
	private String TipoCuenta;
	
	public TipoCuenta() {
	}

	public TipoCuenta(int codTipoCuenta, String tipoCuenta) {
		CodTipoCuenta = codTipoCuenta;
		TipoCuenta = tipoCuenta;
	}

	public int getCodTipoCuenta() {
		return CodTipoCuenta;
	}

	public void setCodTipoCuenta(int codTipoCuenta) {
		CodTipoCuenta = codTipoCuenta;
	}

	public String getTipoCuenta() {
		return TipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		TipoCuenta = tipoCuenta;
	}
	
}
