package presentacion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import config.ConfigEnt;
import config.ConfigNeg;
import entidad.Cliente;
import entidad.Usuario;
import negocio.ClienteNeg;
import negocio.UsuarioNeg;

@Controller
public class ClienteController {
	private ApplicationContext appContextEnt;
	private ApplicationContext appContextNeg;
	
	public void InicializarEnt() {
		appContextEnt=new AnnotationConfigApplicationContext(ConfigEnt.class);
	}
	
	public void InicializarNeg() {
		appContextNeg=new AnnotationConfigApplicationContext(ConfigNeg.class);
	}
	
	public void FinalizarEnt() {
		((ConfigurableApplicationContext)(appContextEnt)).close();
		
	}
	
	public void FinalizarNeg() {
		((ConfigurableApplicationContext)(appContextNeg)).close();
	}
	
	public Cliente EstablecerDatos(String User, String DNI, String Nombre, String Apellido, String Sexo, String Fecha,
								   String Nacionalidad, String Provincia, String Localidad, String Direccion) {

		Cliente cli = (Cliente) appContextEnt.getBean("ClienteDefault");
		Usuario user = (Usuario) appContextEnt.getBean("UsuarioDefault");
		Date FechaNac;
		
		try {
		FechaNac=new SimpleDateFormat("yyyy-mm-dd").parse(Fecha);  
		user.setUsername(User);
		cli.setDNI(Integer.parseInt(DNI));
		cli.setNombre(Nombre);
		cli.setApellido(Apellido);
		cli.setFecha(FechaNac);
		cli.setLocalidad(Localidad);
		cli.setNacionalidad(Nacionalidad);
		cli.setProvincia(Provincia);
		cli.setSexo(Sexo);
		cli.setDireccion(Direccion);
		cli.setUsuario(user);
		}
		catch(Exception e){
			e.printStackTrace();
			cli=null;
		}
		
		return cli;
	}
	
	@RequestMapping("agregarCliente.do")
	public String AgregarCliente(String txtDocumento, String txtNombre, String txtApellido, String ddlSexo, String txtUsuario, 
								 String txtNacionalidad, String txtProvincia, String txtLocalidad, String txtDireccion, String dtFechaNac, Model m) {
		InicializarEnt();
		InicializarNeg();
		ClienteNeg cliNeg = (ClienteNeg) appContextNeg.getBean("cliNeg");
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		Cliente cli;
		if(!(txtDocumento.trim().isEmpty()||txtNombre.trim().isEmpty()||txtApellido.trim().isEmpty()||ddlSexo.trim().isEmpty()||txtUsuario.trim().isEmpty())) {
			if(!(txtNacionalidad.trim().isEmpty()||txtProvincia.trim().isEmpty()||txtLocalidad.trim().isEmpty()||txtDireccion.trim().isEmpty()||dtFechaNac.trim().isEmpty())) {
				if(cliNeg.leerUno(Integer.parseInt(txtDocumento))==null) {
					if(userNeg.leerUno(txtUsuario)!=null) {
						if(!cliNeg.tieneUsuario(txtUsuario)) {
						cli=EstablecerDatos(txtUsuario,txtDocumento,txtNombre,txtApellido,ddlSexo, dtFechaNac,txtNacionalidad,txtProvincia,txtLocalidad,txtDireccion);
							if(cli!=null) {
								if(cliNeg.agregarUno(cli)) {
									m.addAttribute("Msg","<script type='text/javascript'>alert('Cliente agregado correctamente.');</script>");
								}
								else {
									m.addAttribute("Msg","<script type='text/javascript'>alert('Ocurrió un error al agregar el usuario.');</script>");
								}
							}
							else {
								m.addAttribute("Msg","<script type='text/javascript'>alert('Ingrese los datos correctamente.');</script>");
							}
						}
						else {
							m.addAttribute("Msg","<script type='text/javascript'>alert('El usuario especificado ya está asignado a un cliente.');</script>");
						}
					}
					else {
						m.addAttribute("Msg","<script type='text/javascript'>alert('El usuario especificado no existe.');</script>");
					}
				}
				else {
					m.addAttribute("Msg","<script type='text/javascript'>alert('Ya existe un cliente con el DNI especificado.');</script>");
				}
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('Complete todos los datos para continuar.');</script>");
			}
		}
		else {
			m.addAttribute("Msg","<script type='text/javascript'>alert('Complete todos los datos para continuar.');</script>");
		}
		FinalizarEnt();
		FinalizarNeg();
		return "BancoAltaCliente";
	}
	
	@RequestMapping("leerTodosClientes.do")
	public String LeerTodos(String user, Model m) {
		InicializarNeg();
		InicializarEnt();
		
		ObtenerLista(m);
		
		FinalizarEnt();
		FinalizarNeg();
		
		m.addAttribute("Username", user);
		
		return "BancoByMClientes";
	}
	
	public void ObtenerLista(Model m) {
		ClienteNeg cliNeg = (ClienteNeg) appContextNeg.getBean("cliNeg");
		List<Cliente> lstClientes=cliNeg.leerTodos();
		
		m.addAttribute("lstClientes", lstClientes);
		
		cliNeg.Finalizar();
	}
	
	@RequestMapping("modificarCliente.do")
	public String ModificarUno(String hdnId, String[] hdnDNI, String[] txtUsuario, String[] txtNombre, String[] txtApellido, String[] ddlSexo, String[] txtFecha, 
								String[] txtNacionalidad, String[] txtProvincia, String[] txtLocalidad, String[] txtDireccion, Model m) {
		InicializarNeg();
		InicializarEnt();
		
		ClienteNeg cliNeg = (ClienteNeg) appContextNeg.getBean("cliNeg");
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		int Id = Integer.parseInt(hdnId);
		
		if(!(hdnDNI[Id].trim().isEmpty()||txtNombre[Id].trim().isEmpty()||txtApellido[Id].trim().isEmpty()||ddlSexo[Id].trim().isEmpty()||txtUsuario[Id].trim().isEmpty())) {
			if(!(txtNacionalidad[Id].trim().isEmpty()||txtProvincia[Id].trim().isEmpty()||txtLocalidad[Id].trim().isEmpty()||txtDireccion[Id].trim().isEmpty()||txtFecha[Id].trim().isEmpty())) {
				if(userNeg.leerUno(txtUsuario[Id])!=null) {
					Cliente cli=EstablecerDatos(txtUsuario[Id], hdnDNI[Id], txtNombre[Id], txtApellido[Id], ddlSexo[Id], txtFecha[Id], 
							txtNacionalidad[Id], txtProvincia[Id], txtLocalidad[Id], txtDireccion[Id]);
					if(cli!=null) {
						if(cliNeg.modificar(cli)) {
							m.addAttribute("Msg","<script type='text/javascript'>alert('Cliente modificado correctamente.');</script>");
						}
						else {
							m.addAttribute("Msg","<script type='text/javascript'>alert('Ocurrió un error al modificar el usuario.');</script>");
						}
					}
					else {
						m.addAttribute("Msg","<script type='text/javascript'>alert('Ingrese los datos correctamente.');</script>");
					}
				}
				else {
					m.addAttribute("Msg","<script type='text/javascript'>alert('El usuario especificado no existe.');</script>");
				}
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('Complete todos los datos para continuar.');</script>");
			}
		}
		else {
			m.addAttribute("Msg","<script type='text/javascript'>alert('Complete todos los datos para continuar.');</script>");
		}
		
		ObtenerLista(m);
		
		FinalizarEnt();
		FinalizarNeg();
		return "BancoByMClientes";
	}
	
}
