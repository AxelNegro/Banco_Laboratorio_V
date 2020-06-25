package config;

import java.util.Date;
import java.util.GregorianCalendar;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import entidad.Cliente;
import entidad.Cuenta;
import entidad.Cuentas_x_Usuario;
import entidad.TipoCuenta;
import entidad.Usuario;



public class ConfigEnt {
	
	@Bean
	public Usuario UsuarioDefault() {
		Usuario user = new Usuario();
		return user;
	}
	
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
		Date Fecha = new Date(); 
		return Fecha;
	}
	
	@Bean
	public Cliente ClienteDefault() {
		Cliente cli = new Cliente();
		return cli;
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
	
	@Bean
	public Cuenta CuentaDefault() {
		Cuenta acc = new Cuenta();
		return acc;
	}
	
	@Bean
	public Cuentas_x_Usuario Cuenta_x_UsuarioDefault() {
		Cuentas_x_Usuario accxuser = new Cuentas_x_Usuario();
		return accxuser;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public TipoCuenta TipoCuentaDefault() {
		TipoCuenta tipoacc = new TipoCuenta();
		return tipoacc;
	}
	
}
