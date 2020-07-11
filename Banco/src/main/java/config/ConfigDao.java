package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import datos.ClienteDao;
import datos.ConceptoDao;
import datos.CuentaDao;
import datos.Cuentas_x_UsuarioDao;
import datos.Cuotas_x_PrestamoDao;
import datos.LocalidadDao;
import datos.MovimientoDao;
import datos.Movimientos_x_CuentaDao;
import datos.PrestamoDao;
import datos.Prestamos_x_ClienteDao;
import datos.ProvinciaDao;
import datos.TipoCuentaDao;
import datos.UsuarioDao;
import datosImpl.ClienteDaoImpl;
import datosImpl.ConceptoDaoImpl;
import datosImpl.Conexion;
import datosImpl.CuentaDaoImpl;
import datosImpl.Cuentas_x_UsuarioDaoImpl;
import datosImpl.Cuotas_x_PrestamoDaoImpl;
import datosImpl.LocalidadDaoImpl;
import datosImpl.MovimientoDaoImpl;
import datosImpl.Movimientos_x_CuentaDaoImpl;
import datosImpl.PrestamoDaoImpl;
import datosImpl.Prestamos_x_ClienteDaoImpl;
import datosImpl.ProvinciaDaoImpl;
import datosImpl.TipoCuentaDaoImpl;
import datosImpl.UsuarioDaoImpl;

@Configuration
public class ConfigDao {
	@Bean
	public Conexion ConexionBD() {
		Conexion conn = new Conexion();
		return conn;
	}
	
	@Bean
	public ClienteDao cliDao() {
		ClienteDao cliDao=new ClienteDaoImpl();
		return cliDao;
	}
	
	@Bean
	public CuentaDao accDao() {
		CuentaDao accDao=new CuentaDaoImpl();
		return accDao;
	}
	
	@Bean
	public Cuentas_x_UsuarioDao accxuserDao() {
		Cuentas_x_UsuarioDao accxuserDao=new Cuentas_x_UsuarioDaoImpl();
		return accxuserDao;
	}
	
	@Bean
	public Cuotas_x_PrestamoDao cuotxprestDao() {
		Cuotas_x_PrestamoDao cuotxprestDao = new Cuotas_x_PrestamoDaoImpl();
		return cuotxprestDao;
	}
	
	@Bean
	public MovimientoDao movDao() {
		MovimientoDao movDao = new MovimientoDaoImpl();
		return movDao;
	}
	
	@Bean
	public Movimientos_x_CuentaDao movxaccDao() {
		Movimientos_x_CuentaDao movxaccDao = new Movimientos_x_CuentaDaoImpl();
		return movxaccDao;
	}
	
	@Bean
	public PrestamoDao prestDao() {
		PrestamoDao prestDao = new PrestamoDaoImpl();
		return prestDao;
	}
	
	@Bean
	public Prestamos_x_ClienteDao prestxcliDao() {
		Prestamos_x_ClienteDao prestxcliDao = new Prestamos_x_ClienteDaoImpl();
		return prestxcliDao;
	}
	
	@Bean
	public TipoCuentaDao tipoaccDao() {
		TipoCuentaDao tipoaccDao = new TipoCuentaDaoImpl();
		return tipoaccDao;
	}
	
	@Bean
	public UsuarioDao userDao() {
		UsuarioDao userDao = new UsuarioDaoImpl();
		return userDao;
	}
	
	@Bean
	public ProvinciaDao provDao() {
		ProvinciaDao provDao = new ProvinciaDaoImpl();
		return provDao;
	}
	
	@Bean
	public LocalidadDao locDao() {
		LocalidadDao locDao = new LocalidadDaoImpl();
		return locDao;
	}
	
	@Bean
	public ConceptoDao conceptoDao() {
		ConceptoDao conceptoDao = new ConceptoDaoImpl();
		return conceptoDao;
	}
}
