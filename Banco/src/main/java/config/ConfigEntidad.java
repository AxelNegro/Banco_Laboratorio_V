package config;

import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import datosImpl.Conexion;
import entidad.Cliente;
import entidad.Usuario;
import negocio.ClienteNeg;
import negocio.UsuarioNeg;
import negocioImpl.ClienteNegImpl;
import negocioImpl.UsuarioNegImpl;



public class ConfigEntidad {
	private ApplicationContext appContext;
	
	@Bean
	public Usuario UsuarioAdmin() {
		Usuario user = new Usuario();
		
		user.setUsername("admin");
		user.setPassword("admin");
		user.setTipoUsuario(true);
		user.setEstado(true);
		
		return user;
	}
	
	@Bean
	public Date FechaDefault() {
		Date Fecha = new GregorianCalendar(2000, 05, 27).getTime(); 
		return Fecha;
	}
	
	@Bean
	public Cliente ClienteAdmin() {
		Usuario user = new Usuario();
		Date Fecha = new GregorianCalendar(2000, 05, 27).getTime(); 
		Cliente cli = new Cliente();
		
		user.setUsername("admin");
		user.setPassword("admin");
		user.setTipoUsuario(true);
		user.setEstado(true);
		
		cli.setDNI(22222);
		cli.setNombre("Lucas");
		cli.setApellido("Fernandez");
		cli.setFecha(Fecha);
		cli.setLocalidad("San Antonio Oeste");
		cli.setNacionalidad("Argentino");
		cli.setProvincia("Rio Negro");
		cli.setSexo("Masculino");
		cli.setDireccion("Direccion");
		cli.setUsuario(user);
		
		return cli;
	}

}
