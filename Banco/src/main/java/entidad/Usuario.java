package entidad;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Usuarios")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DNI")
	private int DNI;
	@Column(name="Nombre")
	private String Nombre;
	@Column(name="Apellido")
	private String Apellido;
	@Column(name="Sexo")
	private String Sexo;
	@Column(name="Nacionalidad")
	private String Nacionalidad;
	@Column(name="Fecha")
	private Date Fecha;
	@Column(name="Direccion")
	private String Direccion;
	@Column(name="Localidad")
	private String Localidad;
	@Column(name="Provincia")
	private String Provincia;
	
	
	
	public Usuario() {
		super();
	}
	public Usuario(int dni, String nombre, String apellido, String sexo, String nacionalidad, Date fecha,
			String direccion, String localidad, String provincia) {
		super();
		DNI = dni;
		Nombre = nombre;
		Apellido = apellido;
		Sexo = sexo;
		Nacionalidad = nacionalidad;
		Fecha = fecha;
		Direccion = direccion;
		Localidad = localidad;
		Provincia = provincia;
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
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getLocalidad() {
		return Localidad;
	}
	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	
	
}
