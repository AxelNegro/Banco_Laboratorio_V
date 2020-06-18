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
	@Column(name="TipoUsuario")
	private Boolean TipoUsuario;
	@Column(name="Estado")
	private Boolean Estado;
	
	
	public Usuario(String username, String password, Boolean tipoUsuario, Boolean estado) {
		Username = username;
		Password = password;
		TipoUsuario = tipoUsuario;
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
	
	public Boolean getTipoUsuario() {
		return TipoUsuario;
	}

	public void setTipoUsuario(Boolean tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}

	public Boolean getEstado() {
		return Estado;
	}

	public void setEstado(Boolean estado) {
		Estado = estado;
	}

	@Override
	public String toString() {
		return "Usuario [Username=" + Username + ", Password=" + Password + ", TipoUsuario=" + TipoUsuario + ", Estado="
				+ Estado + "]";
	}
	
}
