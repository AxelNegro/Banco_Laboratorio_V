package negocio;

import java.util.List;

import entidad.Cuentas_x_Usuario;

public interface Cuentas_x_UsuarioNeg {
	public boolean agregarUna(Cuentas_x_Usuario accxuser);
	public int contarCuentas(String username);
	public List<Cuentas_x_Usuario> leerTodas();
	public List<Cuentas_x_Usuario> leerCuentasxUsuario(String Username);
	public void Inicializar();
	public void Finalizar();
}
