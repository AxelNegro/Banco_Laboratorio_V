package entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
@Table(name="Clientes_x_Cuenta")
public class Clientes_x_Cuenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="CBU")
	private int CBU;
	@Column(name="DNI")
	private int DNI;
	

}
