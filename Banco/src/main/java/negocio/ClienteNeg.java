package negocio;

import java.util.List;

import entidad.Cliente;

public interface ClienteNeg {
	public boolean agregarUno(Cliente cli);
	public Cliente leerUno(int DNI);
	public boolean tieneUsuario(String Username);
	public List<Cliente> leerTodos();
	public boolean modificar(Cliente cli);
	public void Inicializar();
	public void Finalizar();
}
