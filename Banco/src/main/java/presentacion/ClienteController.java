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
import entidad.Localidad;
import entidad.Provincia;
import entidad.TipoCuenta;
import entidad.Usuario;
import negocio.ClienteNeg;
import negocio.LocalidadNeg;
import negocio.ProvinciaNeg;
import negocio.TipoCuentaNeg;
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
		Provincia prov = (Provincia) appContextEnt.getBean("ProvinciaDefault");
		Localidad loc = (Localidad) appContextEnt.getBean("LocalidadDefault");
		Date FechaNac;
		
		try {
			FechaNac=new SimpleDateFormat("yyyy-mm-dd").parse(Fecha);  
			user.setUsername(User);
			prov.setIdProvincia(Integer.parseInt(Provincia));
			loc.setProvincia(prov);
			loc.setIdLocalidad(Integer.parseInt(Localidad));
			cli.setDNI(Integer.parseInt(DNI));
			cli.setNombre(Nombre);
			cli.setApellido(Apellido);
			cli.setFecha(FechaNac);
			cli.setLocalidad(loc);
			cli.setNacionalidad(Nacionalidad);
			cli.setProvincia(prov);
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
	public String AgregarCliente(String User, String txtDocumento, String txtNombre, String txtApellido, String ddlSexo, String ddlUsuario, 
								 String txtNacionalidad, String ddlProvincia, String ddlLocalidad, String txtDireccion, String dtFechaNac, Model m) {
		InicializarEnt();
		InicializarNeg();
		ClienteNeg cliNeg = (ClienteNeg) appContextNeg.getBean("cliNeg");
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		Cliente cli;
		
		try {
			if(!(txtDocumento.trim().isEmpty()||txtNombre.trim().isEmpty()||txtApellido.trim().isEmpty()||ddlSexo.trim().isEmpty()||ddlUsuario==null||ddlUsuario.trim().isEmpty())) {
				if(!(txtNacionalidad.trim().isEmpty()||ddlProvincia==null||ddlProvincia.trim().isEmpty()||ddlLocalidad==null||ddlLocalidad.trim().isEmpty()||txtDireccion.trim().isEmpty()||dtFechaNac.trim().isEmpty())) {
					if(Integer.parseInt(txtDocumento)>=0) {
						if(cliNeg.leerUno(Integer.parseInt(txtDocumento))==null) {
							if(userNeg.leerUno(ddlUsuario)!=null) {
								if(!cliNeg.tieneUsuario(ddlUsuario)) {
								cli=EstablecerDatos(ddlUsuario,txtDocumento,txtNombre,txtApellido,ddlSexo, dtFechaNac,txtNacionalidad,ddlProvincia,ddlLocalidad,txtDireccion);
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
						m.addAttribute("Msg","<script type='text/javascript'>alert('No se permiten valores negativos en campos númericos.');</script>");
					}
				}
				else {
					m.addAttribute("Msg","<script type='text/javascript'>alert('Complete todos los datos para continuar.');</script>");
				}
			}
			else {
				m.addAttribute("Msg","<script type='text/javascript'>alert('Complete todos los datos para continuar.');</script>");
			}
		}
		catch (Exception e){
			e.printStackTrace();
			m.addAttribute("Msg","<script type='text/javascript'>alert('Complete todos los datos para continuar.');</script>");
		}
		ObtenerListaUserSinUsar(m);
		ObtenerProvincias(m);
		ObtenerLocalidades(m);

		m.addAttribute("Username",User);
		
		cliNeg.Finalizar();
		userNeg.Finalizar();
		FinalizarEnt();
		FinalizarNeg();
		return "BancoAltaCliente";
	}
	
	@RequestMapping("leerTodosClientes.do")
	public String LeerTodos(String User, String origen, Model m) {
		String Destino;
		
		InicializarNeg();
		InicializarEnt();
		
		ObtenerLista(origen, m);
		ObtenerListaUserSinUsar(m);
		ObtenerProvincias(m);
		ObtenerLocalidades(m);
		
		m.addAttribute("Username", User);
		
		switch(Integer.parseInt(origen)) {
			case 0:
				Destino="BancoByMClientes";
			break;
			case 1:
				ObtenerListaTipoCuentas(m);
				Destino="BancoAltaCuenta";
			break;
			default:
				Destino="TodosLogin";
			break;
		}
		
		FinalizarEnt();
		FinalizarNeg();
		
		return Destino;
	}
	
	@SuppressWarnings("unchecked")
	public void ObtenerLista(String Origen, Model m) {
		ClienteNeg cliNeg = (ClienteNeg) appContextNeg.getBean("cliNeg");
		
		List<Cliente> lstClientes = (List<Cliente>) appContextEnt.getBean("LstClientesDefault");
		
		switch(Integer.parseInt(Origen)) {
		case 0:
			lstClientes=cliNeg.leerTodos();
		break;
		case 1:
			lstClientes=cliNeg.leerTodosSinBanco();
		break;
		}
		
		m.addAttribute("lstClientes", lstClientes);
		
		cliNeg.Finalizar();
	}
	
	public void ObtenerListaTipoCuentas(Model m) {
		TipoCuentaNeg tipoaccNeg = (TipoCuentaNeg) appContextNeg.getBean("tcNeg");
		List<TipoCuenta> lstTipoAcc=tipoaccNeg.leerTodas();
		
		m.addAttribute("lstTipoAcc",lstTipoAcc);
		
		tipoaccNeg.Finalizar();
	}
	
	@RequestMapping("modificarCliente.do")
	public String ModificarUno(String User, String hdnId, String[] hdnDNI, String[] ddlUsuario, String[] txtNombre, String[] txtApellido, String[] ddlSexo, String[] txtFecha, 
								String[] txtNacionalidad, String[] ddlProvincia, String[] ddlLocalidad, String[] txtDireccion, Model m) {
		InicializarNeg();
		InicializarEnt();
		
		ClienteNeg cliNeg = (ClienteNeg) appContextNeg.getBean("cliNeg");
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		int Id = Integer.parseInt(hdnId);
		
		try {
			if(!(hdnDNI[Id].trim().isEmpty()||txtNombre[Id].trim().isEmpty()||txtApellido[Id].trim().isEmpty()||ddlSexo[Id].trim().isEmpty()||ddlUsuario==null||ddlUsuario[Id].equals(null)||ddlUsuario[Id].trim().isEmpty())) {
				if(!(txtNacionalidad[Id].trim().isEmpty()||ddlProvincia==null||ddlProvincia[Id].trim().isEmpty()||ddlLocalidad==null||ddlLocalidad[Id].trim().isEmpty()||txtDireccion[Id].trim().isEmpty()||txtFecha[Id].trim().isEmpty())) {
					if(userNeg.leerUno(ddlUsuario[Id])!=null) {
						Cliente cli=EstablecerDatos(ddlUsuario[Id], hdnDNI[Id], txtNombre[Id], txtApellido[Id], ddlSexo[Id], txtFecha[Id], 
								txtNacionalidad[Id], ddlProvincia[Id], ddlLocalidad[Id], txtDireccion[Id]);
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
		}
		catch(Exception e) {
			e.printStackTrace();
			m.addAttribute("Msg","<script type='text/javascript'>alert('Complete todos los datos para continuar.');</script>");
		}
		
		ObtenerLista("0", m);
		ObtenerListaUserSinUsar(m);
		ObtenerProvincias(m);
		ObtenerLocalidades(m);
		
		m.addAttribute("Username",User);
		
		cliNeg.Finalizar();
		userNeg.Finalizar();
		FinalizarEnt();
		FinalizarNeg();
		return "BancoByMClientes";
	}
	
	
	@RequestMapping("leerUserSinCli.do")
	public String LeerUserSinCli(String User, Model m) {
		InicializarEnt();
		InicializarNeg();
		
		ObtenerListaUserSinUsar(m);
		ObtenerProvincias(m);
		ObtenerLocalidades(m);
		
		m.addAttribute("Username", User);
		
		FinalizarNeg();
		FinalizarEnt();
		return "BancoAltaCliente";
	}
	
	@SuppressWarnings("unchecked")
	public void ObtenerListaUserSinUsar(Model m) {
		ClienteNeg cliNeg = (ClienteNeg) appContextNeg.getBean("cliNeg");
		UsuarioNeg userNeg = (UsuarioNeg) appContextNeg.getBean("userNeg");
		
		List<Cliente> lstCli=cliNeg.leerTodos();
		List<Usuario> lstUser=userNeg.leerTodos();
		List<Usuario> lstUserSinCli = (List<Usuario>) appContextEnt.getBean("LstUserDefault");
		
		Boolean comp=false;
		
		for(Usuario user : lstUser) {
			comp=false;
			for(Cliente cli : lstCli){
				if(user.equals(cli.getUsuario())) { //Existe cliente con el usuario?
					comp=true;
				}
			}
			if(comp==false) {
			lstUserSinCli.add(user);
			}
		}
		
		m.addAttribute("lstUserSinCli",lstUserSinCli);
		
		cliNeg.Finalizar();
		userNeg.Finalizar();
	}
	
	public void ObtenerProvincias(Model m) {
		ProvinciaNeg provNeg = (ProvinciaNeg) appContextNeg.getBean("provNeg");
		List<Provincia> lstProv = provNeg.leerTodas();
		
		m.addAttribute("lstProv",lstProv);
		
		provNeg.Finalizar();
	}
	
	public void ObtenerLocalidades(Model m) {
		LocalidadNeg locNeg = (LocalidadNeg) appContextNeg.getBean("locNeg");
		List<Localidad> lstLoc = locNeg.leerTodas();
	
		m.addAttribute("lstLoc",lstLoc);
		
		locNeg.Finalizar();
	}
}
