package entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
@Table(name="Cliente_x_Movimiento")
public class Cliente_x_Movimiento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="DNI")
	private int DNI;
	@Column(name="CBU")
	private int CBU;
	@Column(name="CodigoMovimiento")
	private int CodigoMovimiento;
	
	
}
