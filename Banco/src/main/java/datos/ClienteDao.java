package datos;

import java.util.List;

import entidad.Cliente;

public interface ClienteDao {
	public boolean agregarUno(Cliente cli);
	public Cliente leerUno(int DNI);
	public boolean tieneUsuario(String Username);
	public List<Cliente> leerTodos();
	public boolean modificar(Cliente cli);
}
