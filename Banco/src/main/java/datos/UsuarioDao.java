package datos;

import entidad.Usuario;

public interface UsuarioDao {
	public boolean agregarUno(Usuario user);
	public Usuario leerUno(String username);
}
