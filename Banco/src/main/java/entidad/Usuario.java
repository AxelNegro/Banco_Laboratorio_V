package entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Username")
	private String Username;
	@Column(name="Password")
	private String Password;
	@Column(name="Estado")
	private Boolean Estado;
	
	public Usuario(String username, String password, Boolean estado) {
		Username = username;
		Password = password;
		Estado = estado;
	}
	
	public Usuario() {
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

	public Boolean getEstado() {
		return Estado;
	}

	public void setEstado(Boolean estado) {
		Estado = estado;
	}
	
	
	
}
