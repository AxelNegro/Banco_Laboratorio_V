package datos;

import java.util.Date;
import java.util.List;

import entidad.Prestamos_x_Cliente;

public interface Prestamos_x_ClienteDao {
	public boolean agregarUno (Prestamos_x_Cliente prestxcli);
	public List<Prestamos_x_Cliente> leerTodosPendientes();
	public List<Prestamos_x_Cliente> leerTodosPorCliente(int DNI);
	public List<Prestamos_x_Cliente> obtenerHistorialPrestamos(Date Fecha1, Date Fecha2);
}
