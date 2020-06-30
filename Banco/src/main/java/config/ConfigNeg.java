package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import negocio.ClienteNeg;
import negocio.CuentaNeg;
import negocio.Cuentas_x_UsuarioNeg;
import negocio.LocalidadNeg;
import negocio.MovimientoNeg;
import negocio.Movimientos_x_CuentaNeg;
import negocio.ProvinciaNeg;
import negocio.TipoCuentaNeg;
import negocio.UsuarioNeg;
import negocioImpl.ClienteNegImpl;
import negocioImpl.CuentaNegImpl;
import negocioImpl.Cuentas_x_UsuarioNegImpl;
import negocioImpl.LocalidadNegImpl;
import negocioImpl.MovimientoNegImpl;
import negocioImpl.Movimientos_x_CuentaNegImpl;
import negocioImpl.ProvinciaNegImpl;
import negocioImpl.TipoCuentaNegImpl;
import negocioImpl.UsuarioNegImpl;

@Configuration
public class ConfigNeg {
	@Bean
	public UsuarioNeg userNeg() {
		UsuarioNeg userNeg = new UsuarioNegImpl();
		return userNeg;
	}
	
	@Bean 
	public ClienteNeg cliNeg() {
		ClienteNeg cliNeg = new ClienteNegImpl();
		return cliNeg;
	}
	
	@Bean 
	public CuentaNeg accNeg() {
		CuentaNeg accNeg = new CuentaNegImpl();
		return accNeg;
	}
	
	@Bean
	public TipoCuentaNeg tcNeg() {
		TipoCuentaNeg tcNeg = new TipoCuentaNegImpl();
		return tcNeg;
	}
	
	@Bean
	public Cuentas_x_UsuarioNeg accxuserNeg() {
		Cuentas_x_UsuarioNeg accxuserNeg = new Cuentas_x_UsuarioNegImpl();
		return accxuserNeg;
	}
	
	@Bean
	public ProvinciaNeg provNeg() {
		ProvinciaNeg provNeg = new ProvinciaNegImpl();
		return provNeg;
	}
	
	@Bean
	public LocalidadNeg locNeg() {
		LocalidadNeg locNeg = new LocalidadNegImpl();
		return locNeg;
	}
	
	@Bean
	public MovimientoNeg movNeg() {
		MovimientoNeg movNeg = new MovimientoNegImpl();
		return movNeg;
	}
	
	@Bean
	public Movimientos_x_CuentaNeg movxaccNeg() {
		Movimientos_x_CuentaNeg movxaccNeg = new Movimientos_x_CuentaNegImpl();
		return movxaccNeg;
	}
}
