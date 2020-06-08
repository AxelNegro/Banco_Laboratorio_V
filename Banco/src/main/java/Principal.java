import java.util.Date;
import java.util.GregorianCalendar;

import datosImpl.Conexion;
import entidad.Cliente;
import entidad.Cliente_x_Usuario;
import entidad.Usuario;
import negocio.ClienteNeg;
import negocio.Cliente_x_UsuarioNeg;
import negocio.UsuarioNeg;
import negocioImpl.ClienteNegImpl;
import negocioImpl.Cliente_x_UsuarioNegImpl;
import negocioImpl.UsuarioNegImpl;

public class Principal {
	
	public static void main(String[] args) {
		
		//Crear BD
		CrearBD();
		
		System.out.println("Base creada");
		//Pasar hibernate a Update
		//Insertar();
		
	}
	
	public static void CrearBD() {
		Conexion con=new Conexion();
	}
	
	public static void Insertar() {
		Cliente cli = new Cliente();
		ClienteNeg cliNeg = new ClienteNegImpl();
        Date Fecha = new GregorianCalendar(2000, 05, 27).getTime(); 
        
		cli.setDNI(11111111);
		cli.setNombre("Nombre");
		cli.setApellido("Apellido");
		cli.setFecha(Fecha);
		cli.setLocalidad("Localidad");
		cli.setNacionalidad("Argentino");
		cli.setProvincia("Buenos Aires");
		cli.setSexo("Masculino");
		cli.setDireccion("Direccion");
		
		if(cliNeg.agregarUno(cli)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
		
		Usuario user = new Usuario();
		UsuarioNeg userNeg = new UsuarioNegImpl();
		
		user.setUsername("Usuario2");
		user.setPassword("1234");
		user.setEstado(true);
		
		if(userNeg.agregarUno(user)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
		
		Cliente_x_Usuario clixuser = new Cliente_x_Usuario();
		Cliente_x_UsuarioNeg clixuserNeg = new Cliente_x_UsuarioNegImpl();
		
		clixuser.setCliente(cli);
		clixuser.setUsuario(user);
		
		if(clixuserNeg.agregarUno(clixuser)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
	}
	
}
