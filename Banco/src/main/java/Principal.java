import java.util.Date;
import java.util.GregorianCalendar;

import entidad.Cliente;
import entidad.Usuario;
import negocio.ClienteNeg;
import negocio.UsuarioNeg;
import negocioImpl.ClienteNegImpl;
import negocioImpl.UsuarioNegImpl;

public class Principal {
	
	public static void main(String[] args) {
		
		//Crear BD
		Crear();
		
		//Pasar hibernate a Update
		Insertar();
		
		
	}
	
	public static void Crear() {
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
	}
	
	public static void Insertar() {
		Usuario user = new Usuario();
		UsuarioNeg userNeg = new UsuarioNegImpl();
		
		user.setUsername("Usuario");
		user.setPassword("1234");
		user.setEstado(true);
		
		if(userNeg.agregarUno(user)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
	}
	
}
