package negocio;

import entidad.Usuario;

public interface UsuarioNeg {
	public boolean agregarUno(Usuario user);
	public Usuario leerUno(String username);
	public void Inicializar();
	public void Finalizar();
}
