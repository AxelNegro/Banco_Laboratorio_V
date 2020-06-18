package entidad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import datosImpl.Conexion;

@Configuration
public class Config {
	@Bean
	public Conexion ConexionBD() {
		Conexion conn = new Conexion();
		return conn;
	}
}
