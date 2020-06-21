package negocio;

import java.util.List;

import entidad.Usuario;

public interface UsuarioNeg {
	public boolean agregarUno(Usuario user);
	public Usuario leerUno(String username);
	public List<Usuario> leerTodos();
	public boolean Modificar(Usuario user);
	public void Inicializar();
	public void Finalizar();
}
