package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import negocio.ClienteNeg;
import negocio.UsuarioNeg;
import negocioImpl.ClienteNegImpl;
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
}
