package entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DNI")
	private int DNI;
	@OneToOne
	@JoinColumn(name="Username")
	private Usuario usuario;
	@Column(name="Nombre")
	private String Nombre;
	@Column(name="Apellido")
	private String Apellido;
	@Column(name="Sexo")
	private String Sexo;
	@Column(name="Nacionalidad")
	private String Nacionalidad;
	@Column(name="Fecha_Nac")
	@Type(type="date")
	private Date Fecha_Nac;
	@Column(name="Direccion")
	private String Direccion;
	@ManyToOne
	@JoinColumn(name="IdProvincia")
	private Provincia provincia;
	@ManyToOne
	@JoinColumn(name="IdLocalidad")
	private Localidad localidad;
	
	
	public Cliente() {
		
	}
	public Cliente(int dni, Usuario user , String nombre, String apellido, String sexo, String nacionalidad, Date fecha,
			String direccion, Localidad localidad, Provincia provincia) {
		DNI = dni;
		usuario = user;
		Nombre = nombre;
		Apellido = apellido;
		Sexo = sexo;
		Nacionalidad = nacionalidad;
		Fecha_Nac = fecha;
		Direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public Date getFecha() {
		return Fecha_Nac;
	}
	public void setFecha(Date fecha) {
			Fecha_Nac = fecha;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public Localidad getLocalidad() {
		return this.localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public Provincia getProvincia() {
		return this.provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
