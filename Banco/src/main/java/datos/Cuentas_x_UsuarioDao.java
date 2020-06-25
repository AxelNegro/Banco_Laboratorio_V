package datos;

import java.util.List;

import entidad.Cuentas_x_Usuario;

public interface Cuentas_x_UsuarioDao {
	public boolean agregarUna(Cuentas_x_Usuario accxuser);
	public int contarCuentas(String username);
	public List<Cuentas_x_Usuario> leerTodas();
}
