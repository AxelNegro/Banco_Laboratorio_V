package config;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import entidad.Cliente;
import entidad.Concepto;
import entidad.Cuenta;
import entidad.Cuentas_x_Usuario;
import entidad.Cuotas_x_Prestamo;
import entidad.Localidad;
import entidad.Movimiento;
import entidad.Movimientos_x_Cuenta;
import entidad.Prestamo;
import entidad.Prestamos_x_Cliente;
import entidad.Provincia;
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
		Provincia prov = new Provincia();
		Localidad loc = new Localidad();
		
		user.setUsername("admin");
		user.setPassword("admin");
		user.setTipoUsuario(true);
		user.setEstado(true);
		prov.setIdProvincia(1);
		loc.setProvincia(prov);
		loc.setIdLocalidad(1);
		
		cli.setDNI(22222);
		cli.setNombre("Lucas");
		cli.setApellido("Fernandez");
		cli.setFecha(Fecha);
		cli.setNacionalidad("Argentino");
		cli.setProvincia(prov);
		cli.setLocalidad(loc);
		cli.setSexo("Masculino");
		cli.setDireccion("Chile 3093");
		cli.setUsuario(user);
		
		return cli;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Cuenta CuentaDefault() {
		Cuenta acc = new Cuenta();
		return acc;
	}
	
	@Bean
	public Cuenta CuentaAdmin() {
		Cuenta acc = new Cuenta();
		Date Fecha = new Date(); 
		acc.setCBU(-1);
		acc.setCodTipoCuenta(-1);
		acc.setEstado(true);
		acc.setFecha(Fecha);
		acc.setNombre("Banco");
		acc.setNumeroCuenta(-1);
		acc.setSaldo(Double.parseDouble("-1"));
		
		return acc;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Cuentas_x_Usuario Cuenta_x_UsuarioDefault() {
		Cuentas_x_Usuario accxuser = new Cuentas_x_Usuario();
		return accxuser;
	}
	
	@Bean
	public Cuentas_x_Usuario Cuentas_x_UsuarioAdmin() {
		Cuentas_x_Usuario accxuser = new Cuentas_x_Usuario();
		Cuenta acc = new Cuenta();
		Usuario user = new Usuario();
		
		acc.setCBU(-1);
		user.setUsername("admin");
		accxuser.setCuenta(acc);
		accxuser.setUsuario(user);
		
		return accxuser;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public TipoCuenta TipoCuentaDefault() {
		TipoCuenta tipoacc = new TipoCuenta();
		return tipoacc;
	}
	
	@Bean
	public List<Usuario> LstUserDefault(){
		List<Usuario> lstUsuario = new ArrayList<Usuario>();
		return lstUsuario;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Provincia ProvinciaDefault() {
		Provincia prov = new Provincia();
		return prov;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Localidad LocalidadDefault() {
		Localidad loc = new Localidad();
		return loc;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Movimiento MovimientoDefault() {
		Movimiento mov = new Movimiento();
		return mov;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Movimientos_x_Cuenta Movimientos_x_CuentaDefault() {
		Movimientos_x_Cuenta movxacc = new Movimientos_x_Cuenta();
		return movxacc;
	}
	
	@Bean
	public List<Cuenta> LstCuentasDefault(){
		List<Cuenta> lstCuentas = new ArrayList<Cuenta>();
		return lstCuentas;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Concepto ConceptoDefault() {
		Concepto concepto = new Concepto();
		return concepto;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public List<Cliente> LstClientesDefault() {
		List<Cliente> lstClientes = new ArrayList<Cliente>();
		return lstClientes;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Prestamo PrestamoDefault() {
		Prestamo prest = new Prestamo();
		return prest;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Prestamos_x_Cliente Prestamos_x_ClienteDefault() {
		Prestamos_x_Cliente prestxcli = new Prestamos_x_Cliente();
		return prestxcli;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Cuotas_x_Prestamo Cuotas_x_PrestamoDefault() {
		Cuotas_x_Prestamo cuotxprest = new Cuotas_x_Prestamo();
		return cuotxprest;
	}
	
	@Bean
	public List<Integer> LstIntegersDefault(){
		List<Integer> lstIntegers = new ArrayList<Integer>();
		return lstIntegers;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public String CadenaDefault() {
		String cadena = "";
		return cadena;
	}
}
