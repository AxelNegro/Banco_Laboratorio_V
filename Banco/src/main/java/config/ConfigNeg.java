package config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import negocio.ClienteNeg;
import negocio.ConceptoNeg;
import negocio.CuentaNeg;
import negocio.Cuentas_x_UsuarioNeg;
import negocio.Cuotas_x_PrestamoNeg;
import negocio.LocalidadNeg;
import negocio.MovimientoNeg;
import negocio.Movimientos_x_CuentaNeg;
import negocio.PrestamoNeg;
import negocio.Prestamos_x_ClienteNeg;
import negocio.ProvinciaNeg;
import negocio.TipoCuentaNeg;
import negocio.UsuarioNeg;
import negocioImpl.ClienteNegImpl;
import negocioImpl.ConceptoNegImpl;
import negocioImpl.CuentaNegImpl;
import negocioImpl.Cuentas_x_UsuarioNegImpl;
import negocioImpl.Cuotas_x_PrestamoNegImpl;
import negocioImpl.LocalidadNegImpl;
import negocioImpl.MovimientoNegImpl;
import negocioImpl.Movimientos_x_CuentaNegImpl;
import negocioImpl.PrestamoNegImpl;
import negocioImpl.Prestamos_x_ClienteNegImpl;
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
	
	@Bean
	public ConceptoNeg conceptoNeg() {
		ConceptoNeg conceptoNeg = new ConceptoNegImpl();
		return conceptoNeg;
	}
	
	@Bean
	public PrestamoNeg prestNeg() {
		PrestamoNeg prestNeg = new PrestamoNegImpl();
		return prestNeg;
	}
	
	@Bean
	public Prestamos_x_ClienteNeg prestxcliNeg() {
		Prestamos_x_ClienteNeg prestxcliNeg = new Prestamos_x_ClienteNegImpl();
		return prestxcliNeg;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Cuotas_x_PrestamoNeg cuotxprestNeg() {
		Cuotas_x_PrestamoNeg cuotxprestNeg = new Cuotas_x_PrestamoNegImpl();
		return cuotxprestNeg;
	}
}
