package entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
@Table(name="UsuarioCliente")
public class Usuario_Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="DNI")
	private int DNI;
	@Column(name="Username")
	private String Username;
	@Column(name="Password")
	private String Password;
	
	public Usuario_Cliente(int dNI, String username, String password) {
		super();
		DNI = dNI;
		Username = username;
		Password = password;
	}

	public Usuario_Cliente() {
		super();
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	
}
