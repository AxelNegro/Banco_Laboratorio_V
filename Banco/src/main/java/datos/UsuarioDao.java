package datos;

import java.util.List;

import entidad.Usuario;

public interface UsuarioDao {
	public boolean agregarUno(Usuario user);
	public Usuario leerUno(String username);
	public List<Usuario> leerTodos();
	public boolean Modificar(Usuario user);
}
