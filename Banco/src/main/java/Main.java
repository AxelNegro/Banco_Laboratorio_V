import java.util.Date;
import java.util.GregorianCalendar;

import datosImpl.Conexion;
import entidad.Cliente;
import entidad.Cliente_x_Usuario;
import entidad.Cuenta;
import entidad.Usuario;
import entidad.Movimiento;
import entidad.Movimientos_x_Cuenta;
import entidad.Cuentas_x_Usuario;
import entidad.Prestamo;
import entidad.TipoCuenta;
import entidad.Cuotas_x_Prestamo;
import negocio.ClienteNeg;
import negocio.Cliente_x_UsuarioNeg;
import negocio.UsuarioNeg;
import negocioImpl.ClienteNegImpl;
import negocioImpl.Cliente_x_UsuarioNegImpl;
import negocioImpl.UsuarioNegImpl;
import negocioImpl.CuentaNegImpl;
import negocioImpl.Cuentas_x_UsuarioNegImpl;
import negocioImpl.Cuotas_x_PrestamoNegImpl;
import negocioImpl.MovimientoNegImpl;
import negocioImpl.TipoCuentaNegImpl;
import negocioImpl.PrestamoNegImpl;
import negocioImpl.Movimientos_x_CuentaNegImpl;


public class Main {
	
	public static void Principal(String[] args) {
		
		//Crear BD
		CrearBD();

		//Luego de crear la BD, comentar la funcion "CrearBD", pasar hibernate.cfg.xml a Update y descomentar la funcion "Insertar"
		//Insertar();
		
	}
	
	public static void CrearBD() {
		Conexion con=new Conexion();
		System.out.println("Base creada");
	}
	
	static Date Fecha = new GregorianCalendar(2000, 05, 27).getTime(); 
	
	public static void InsertarCuenta() {
		Cuenta cuenta = new Cuenta();
		CuentaNegImpl cuentaNeg = new CuentaNegImpl(); 
		
		for(int i=1; i<=10; i++) {
			cuenta.setCBU(i);
			cuenta.setCodTipoCuenta(1);
			cuenta.setFecha(Fecha);
			cuenta.setNombre("Nombre");
			cuenta.setNumeroCuenta(12345687);
			cuenta.setSaldo(20000.55);
			cuenta.setEstado(true);
			
			if(cuentaNeg.agregarUna(cuenta)) {
				System.out.println("Anduvo!");
			}
			else {
				System.out.println("No anduvo :(");
			}
		}
		
		
	}
	

	public static void InsertarTipoCuenta() {
		TipoCuenta tC = new TipoCuenta();		
		
			tC.setCodTipoCuenta(1);
			tC.setTipoCuenta("Caja de ahorro en pesos");
			AgregartC(tC);
			tC.setCodTipoCuenta(2);
			tC.setTipoCuenta("Caja de ahorro en dólares");
			AgregartC(tC);
			tC.setCodTipoCuenta(3);
			tC.setTipoCuenta("Cuenta corriente");
			AgregartC(tC);
			tC.setCodTipoCuenta(4);
			tC.setTipoCuenta("Cuenta corriente especial en pesos");
			AgregartC(tC);
			tC.setCodTipoCuenta(5);
			tC.setTipoCuenta("Cuenta corriente especial en dólares");
			AgregartC(tC);
		
		}
		
		
	
	public static void AgregartC(TipoCuenta tC) {
		TipoCuentaNegImpl tCNeg = new TipoCuentaNegImpl();
		if(tCNeg.agregarUna(tC)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
	}
	
	
	public static void InsertarUsuario() {
		Usuario user = new Usuario();
		UsuarioNegImpl userNeg = new UsuarioNegImpl(); 
		
		for(int i=1; i<=10; i++) {
			user.setUsername("Usuario2");
			user.setPassword("1234");
			user.setEstado(true);
			
			if(userNeg.agregarUno(user)) {
				System.out.println("Anduvo!");
			}
			else {
				System.out.println("No anduvo :(");
			}
		}
		
		
	}
	
	public static void InsertarCliente() {
		Cliente cli = new Cliente();
		ClienteNegImpl cliNeg = new ClienteNegImpl(); 
		
		for(int i=1; i<=10; i++) {
			cli.setDNI(11111111);
			cli.setNombre("Nombre");
			cli.setApellido("Apellido");
			cli.setFecha(Fecha);
			cli.setLocalidad("Localidad");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("Buenos Aires");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			
			if(cliNeg.agregarUno(cli)) {
				System.out.println("Anduvo!");
			}
			else {
				System.out.println("No anduvo :(");
			}
		}
		
		
	}
	
	public static void InsertarMovimientos() {
		Movimiento movimiento = new Movimiento();
		MovimientoNegImpl movimientoNeg = new MovimientoNegImpl();

		
		for(int i=1; i<=10; i++) {

			movimiento.setCodMovimiento(i);
			movimiento.setFecha(Fecha);
			movimiento.setConcepto("Concepto");
			movimiento.setImporte(200.5);							
			
			if(movimientoNeg.agregarUno(movimiento)) {
				System.out.println("Anduvo!");
			}
			else {
				System.out.println("No anduvo :(");
			}
		}
		
		
	}
	
	public static void InsertarCuota_x_Usuario(Usuario user, Cuenta c) {
		Cuentas_x_Usuario cuotasUsuario = new Cuentas_x_Usuario();
		Cuentas_x_UsuarioNegImpl cuotasUsuarioNeg = new Cuentas_x_UsuarioNegImpl();

		
		for(int i=1; i<=10; i++) {

			cuotasUsuario.setCuenta(c);
			cuotasUsuario.setUsuario(user);
								
			
			if(cuotasUsuarioNeg.agregarUna(cuotasUsuario)) {
				System.out.println("Anduvo!");
			}
			else {
				System.out.println("No anduvo :(");
			}
		}
		
		
	}
	
	
	public static void InsertarMovimientos_x_Cuenta(Movimiento m, Cuenta CBUDestino, Cuenta CBUOrigen) {
		Movimientos_x_Cuenta movimientos_x_Cuenta = new Movimientos_x_Cuenta();
		Movimientos_x_CuentaNegImpl movimientoCuentaNeg = new Movimientos_x_CuentaNegImpl();

		
		for(int i=1; i<=10; i++) {

			movimientos_x_Cuenta.setMovimiento(m);
			movimientos_x_Cuenta.setCuentaDest(CBUDestino);
			movimientos_x_Cuenta.setCuentaOrig(CBUOrigen);
							
			
			if(movimientoCuentaNeg.agregarUno(movimientos_x_Cuenta)) {
				System.out.println("Anduvo!");
			}
			else {
				System.out.println("No anduvo :(");
			}
		}
		
		
	}
	
	public static void InsertarCuotas_x_Prestamo(Prestamo prestamo) {
		Cuotas_x_Prestamo cuotas_x_Prestamo = new Cuotas_x_Prestamo();
		Cuotas_x_PrestamoNegImpl cuotaPrestamoNeg = new Cuotas_x_PrestamoNegImpl();

		
		for(int i=1; i<=10; i++) {

			cuotas_x_Prestamo.setPrestamo(prestamo);
			cuotas_x_Prestamo.setImporte_Mensual(2500);
			cuotas_x_Prestamo.setFecha_Pago(Fecha);
			cuotas_x_Prestamo.setEstado(true);
							
			
			if(cuotaPrestamoNeg.agregarUna(cuotas_x_Prestamo)) {
				System.out.println("Anduvo!");
			}
			else {
				System.out.println("No anduvo :(");
			}
		}
		
		
	}
	
	public static void InsertarPrestamo() {
		Prestamo prestamo = new Prestamo();
		PrestamoNegImpl prestamoNeg = new PrestamoNegImpl();

		
		for(int i=1; i<=10; i++) {

			prestamo.setCodPrestamo(i);
			prestamo.setFecha(Fecha);
			prestamo.setCuotas(i);
			prestamo.setImporte(200.5);
			prestamo.setImporte_x_Mes(prestamo.getImporte()/prestamo.getCuotas());
			prestamo.setPlazo_en_Meses(20);
			prestamo.setEstado(1);
			
			if(prestamoNeg.agregarUno(prestamo)) {
				System.out.println("Anduvo!");
			}
			else {
				System.out.println("No anduvo :(");
			}
		}
		
		
	}
	
	
	public static void Insertar() {
		Cliente cli = new Cliente();
		ClienteNeg cliNeg = new ClienteNegImpl();        
        
		cli.setDNI(11111111);
		cli.setNombre("Nombre");
		cli.setApellido("Apellido");
		cli.setFecha(Fecha);
		cli.setLocalidad("Localidad");
		cli.setNacionalidad("Argentino");
		cli.setProvincia("Buenos Aires");
		cli.setSexo("Masculino");
		cli.setDireccion("Direccion");
		
		if(cliNeg.agregarUno(cli)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
		
		Usuario user = new Usuario();
		UsuarioNeg userNeg = new UsuarioNegImpl();
		
		user.setUsername("Usuario2");
		user.setPassword("1234");
		user.setEstado(true);
		
		if(userNeg.agregarUno(user)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
		
		Cliente_x_Usuario clixuser = new Cliente_x_Usuario();
		Cliente_x_UsuarioNeg clixuserNeg = new Cliente_x_UsuarioNegImpl();
		
		clixuser.setCliente(cli);
		clixuser.setUsuario(user);
		
		if(clixuserNeg.agregarUno(clixuser)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
	}
	
}
