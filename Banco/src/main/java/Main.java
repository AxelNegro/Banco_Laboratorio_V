import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigDao;
import config.ConfigNeg;
import datosImpl.Conexion;
import entidad.Cliente;
import entidad.Cuenta;
import entidad.Usuario;
import entidad.Movimiento;
import entidad.Movimientos_x_Cuenta;
import entidad.Cuentas_x_Usuario;
import entidad.Prestamo;
import entidad.Prestamos_x_Cliente;
import entidad.TipoCuenta;
import entidad.Cuotas_x_Prestamo;
import negocio.ClienteNeg;
import negocio.CuentaNeg;
import negocio.Cuentas_x_UsuarioNeg;
import negocio.Cuotas_x_PrestamoNeg;
import negocio.MovimientoNeg;
import negocio.Movimientos_x_CuentaNeg;
import negocio.PrestamoNeg;
import negocio.Prestamos_x_ClienteNeg;
import negocio.TipoCuentaNeg;
import negocio.UsuarioNeg;
import negocioImpl.ClienteNegImpl;
import negocioImpl.UsuarioNegImpl;
import negocioImpl.CuentaNegImpl;
import negocioImpl.Cuentas_x_UsuarioNegImpl;
import negocioImpl.Cuotas_x_PrestamoNegImpl;
import negocioImpl.MovimientoNegImpl;
import negocioImpl.TipoCuentaNegImpl;
import negocioImpl.PrestamoNegImpl;
import negocioImpl.Prestamos_x_ClienteNegImpl;
import negocioImpl.Movimientos_x_CuentaNegImpl;


public class Main {
	
	public static void main(String[] args) {
		
		//Crear BD
		CrearBD();

		//Luego de crear la BD, comentar la funcion "CrearBD", pasar hibernate.cfg.xml a Update y descomentar la funcion "Insertar"
		//Insertar();
		
	}
	
	public static void CrearBD() {
		ApplicationContext appContext=new AnnotationConfigApplicationContext(ConfigDao.class);
		
		Conexion con = (Conexion) appContext.getBean("ConexionBD");
		
		System.out.println("Base de datos creada.");
		
		((ConfigurableApplicationContext)(appContext)).close();
	}
	
	static Date Fecha = new GregorianCalendar(2000, 05, 27).getTime(); 
	
	public static void Insertar() {
		InsertarUsuario();
		InsertarCliente();
		InsertarTipoCuenta();
		InsertarCuenta();
		InsertarMovimientos();
		InsertarPrestamo();
	}
	
	public static void InsertarUsuario() {
		Usuario user = new Usuario();
	
			user.setUsername("Hugo123");
			user.setPassword("Hugo1234");
			user.setEstado(true);
			AgregarUsuario(user);
			
			user = new Usuario();
			
			user.setUsername("Lucas123");
			user.setPassword("Lucas1234");
			user.setEstado(true);
			AgregarUsuario(user);
			
			user = new Usuario();
			
			user.setUsername("Martin123");
			user.setPassword("Martin1234");
			user.setEstado(true);
			AgregarUsuario(user);
			
			user = new Usuario();
			
			user.setUsername("Daniel123");
			user.setPassword("Daniel1234");
			user.setEstado(true);
			AgregarUsuario(user);
			
			user = new Usuario();
			
			user.setUsername("Pablo123");
			user.setPassword("Pablo1234");
			user.setEstado(true);
			AgregarUsuario(user);
			
			user = new Usuario();
			
			user.setUsername("Mateo123");
			user.setPassword("Mateo1234");
			user.setEstado(true);
			AgregarUsuario(user);
			
			user = new Usuario();
			
			user.setUsername("Alejandro123");
			user.setPassword("Alejandro1234");
			user.setEstado(true);
			AgregarUsuario(user);
			
			user = new Usuario();
			
			user.setUsername("Leo123");
			user.setPassword("Leo1234");
			user.setEstado(true);
			AgregarUsuario(user);
			
			user = new Usuario();
			
			user.setUsername("Paula123");
			user.setPassword("Paula1234");
			user.setEstado(true);
			AgregarUsuario(user);
			
			user = new Usuario();
			
			user.setUsername("Daniela123");
			user.setPassword("Daniela1234");
			user.setEstado(true);
			AgregarUsuario(user);
		
	}
	
	public static void InsertarCliente() {
		Cliente cli = new Cliente();
		Usuario user = new Usuario();
			
			user.setUsername("Hugo123");
			cli.setDNI(11111);
			cli.setNombre("Hugo");
			cli.setApellido("Garcia");
			cli.setFecha(Fecha);
			cli.setLocalidad("Maquinchao");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("Rio Negro");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			AgregarCliente(cli);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Lucas123");
			cli.setDNI(22222);
			cli.setNombre("Lucas");
			cli.setApellido("Fernandez");
			cli.setFecha(Fecha);
			cli.setLocalidad("San Antonio Oeste");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("Rio Negro");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			AgregarCliente(cli);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Martin123");
			cli.setDNI(33333);
			cli.setNombre("Martin");
			cli.setApellido("Gonzalez");
			cli.setFecha(Fecha);
			cli.setLocalidad("Jachal");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("San Juan");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			AgregarCliente(cli);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Daniel123");
			cli.setDNI(44444);
			cli.setNombre("Daniel");
			cli.setApellido("Rodriguez");
			cli.setFecha(Fecha);
			cli.setLocalidad("Rio Grande");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("Tierra del Fuego");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			AgregarCliente(cli);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Pablo123");
			cli.setDNI(55555);
			cli.setNombre("Pablo");
			cli.setApellido("Lopez");
			cli.setFecha(Fecha);
			cli.setLocalidad("Villa Reynolds");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("San Luis");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			AgregarCliente(cli);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Mateo123");
			cli.setDNI(66666);
			cli.setNombre("Mateo");
			cli.setApellido("Martinez");
			cli.setFecha(Fecha);
			cli.setLocalidad("Victorica");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("La Pampa");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			AgregarCliente(cli);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Alejandro123");
			cli.setDNI(77777);
			cli.setNombre("Alejandro");
			cli.setApellido("Sanchez");
			cli.setFecha(Fecha);
			cli.setLocalidad("Uspallata");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("Mendoza");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			AgregarCliente(cli);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Leo123");
			cli.setDNI(88888);
			cli.setNombre("Leo");
			cli.setApellido("Perez");
			cli.setFecha(Fecha);
			cli.setLocalidad("San Carlos");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("Buenos Aires");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			AgregarCliente(cli);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Paula123");
			cli.setDNI(99999);
			cli.setNombre("Paula");
			cli.setApellido("Martin");
			cli.setFecha(Fecha);
			cli.setLocalidad("General Pico");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("La Pampa");
			cli.setSexo("Femenino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			AgregarCliente(cli);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Daniela123");
			cli.setDNI(12345);
			cli.setNombre("Daniela");
			cli.setApellido("Gomez");
			cli.setFecha(Fecha);
			cli.setLocalidad("El Calafate");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("Santa Cruz");
			cli.setSexo("Femenino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			AgregarCliente(cli);
			
	}
	
	public static void InsertarTipoCuenta() {
		TipoCuenta tC = new TipoCuenta();		
		
			tC.setCodTipoCuenta(1);
			tC.setTipoCuenta("Caja de ahorro en pesos");
			AgregartC(tC);
			
			tC = new TipoCuenta();
			
			tC.setCodTipoCuenta(2);
			tC.setTipoCuenta("Caja de ahorro en d�lares");
			AgregartC(tC);
			
			tC = new TipoCuenta();
			
			tC.setCodTipoCuenta(3);
			tC.setTipoCuenta("Cuenta corriente");
			AgregartC(tC);
			
			tC = new TipoCuenta();
			
			tC.setCodTipoCuenta(4);
			tC.setTipoCuenta("Cuenta corriente especial en pesos");
			AgregartC(tC);
			
			tC = new TipoCuenta();
			
			tC.setCodTipoCuenta(5);
			tC.setTipoCuenta("Cuenta corriente especial en d�lares");
			AgregartC(tC);
		
		}
	
	public static void InsertarCuenta() {
		Cuenta cuenta = new Cuenta();
		Usuario user = new Usuario();
		
			user.setUsername("Hugo123");
			cuenta.setCodTipoCuenta(1);
			cuenta.setFecha(Fecha);
			cuenta.setNombre("Hugo");
			cuenta.setNumeroCuenta(12345687);
			cuenta.setSaldo(20000.55);
			cuenta.setEstado(true);		
			AgregarCuenta(cuenta);
			InsertarCuentas_x_Usuario(user,cuenta);
			
			cuenta = new Cuenta();
			user = new Usuario();
			
			user.setUsername("Lucas123");
			cuenta.setCodTipoCuenta(3);
			cuenta.setFecha(Fecha);
			cuenta.setNombre("Lucas");
			cuenta.setNumeroCuenta(234687);
			cuenta.setSaldo(4020.3);
			cuenta.setEstado(true);		
			AgregarCuenta(cuenta);
			InsertarCuentas_x_Usuario(user,cuenta);
			
			cuenta = new Cuenta();
			user = new Usuario();
			
			user.setUsername("Martin123");
			cuenta.setCodTipoCuenta(2);
			cuenta.setFecha(Fecha);
			cuenta.setNombre("Martin");
			cuenta.setNumeroCuenta(354256);
			cuenta.setSaldo(1521.55);
			cuenta.setEstado(true);		
			AgregarCuenta(cuenta);
			InsertarCuentas_x_Usuario(user,cuenta);
			
			cuenta = new Cuenta();
			user = new Usuario();
			
			user.setUsername("Daniel123");
			cuenta.setCodTipoCuenta(1);
			cuenta.setFecha(Fecha);
			cuenta.setNombre("Daniel");
			cuenta.setNumeroCuenta(4565687);
			cuenta.setSaldo(6500.1);
			cuenta.setEstado(true);		
			AgregarCuenta(cuenta);
			InsertarCuentas_x_Usuario(user,cuenta);
			
			cuenta = new Cuenta();
			user = new Usuario();
			
			user.setUsername("Pablo123");
			cuenta.setCodTipoCuenta(5);
			cuenta.setFecha(Fecha);
			cuenta.setNombre("Pablo");
			cuenta.setNumeroCuenta(22345687);
			cuenta.setSaldo(3000.55);
			cuenta.setEstado(true);		
			AgregarCuenta(cuenta);
			InsertarCuentas_x_Usuario(user,cuenta);
			
			cuenta = new Cuenta();
			user = new Usuario();
			
			user.setUsername("Mateo123");
			cuenta.setCodTipoCuenta(2);
			cuenta.setFecha(Fecha);
			cuenta.setNombre("Mateo");
			cuenta.setNumeroCuenta(54213);
			cuenta.setSaldo(4213.55);
			cuenta.setEstado(true);		
			AgregarCuenta(cuenta);
			InsertarCuentas_x_Usuario(user,cuenta);
			
			cuenta = new Cuenta();
			user = new Usuario();
			
			user.setUsername("Alejandro123");
			cuenta.setCodTipoCuenta(1);
			cuenta.setFecha(Fecha);
			cuenta.setNombre("Alejandro");
			cuenta.setNumeroCuenta(721543);
			cuenta.setSaldo(2631.55);
			cuenta.setEstado(true);		
			AgregarCuenta(cuenta);
			InsertarCuentas_x_Usuario(user,cuenta);
			
			cuenta = new Cuenta();
			user = new Usuario();
			
			user.setUsername("Leo123");
			cuenta.setCodTipoCuenta(3);
			cuenta.setFecha(Fecha);
			cuenta.setNombre("Leo");
			cuenta.setNumeroCuenta(65264);
			cuenta.setSaldo(5421.55);
			cuenta.setEstado(true);		
			AgregarCuenta(cuenta);
			InsertarCuentas_x_Usuario(user,cuenta);
			
			cuenta = new Cuenta();
			user = new Usuario();
			
			user.setUsername("Paula123");
			cuenta.setCodTipoCuenta(5);
			cuenta.setFecha(Fecha);
			cuenta.setNombre("Paula");
			cuenta.setNumeroCuenta(85412);
			cuenta.setSaldo(6852.55);
			cuenta.setEstado(true);		
			AgregarCuenta(cuenta);
			InsertarCuentas_x_Usuario(user,cuenta);
			
			cuenta = new Cuenta();
			user = new Usuario();
			
			user.setUsername("Daniela123");
			cuenta.setCodTipoCuenta(1);
			cuenta.setFecha(Fecha);
			cuenta.setNombre("Daniela");
			cuenta.setNumeroCuenta(954226);
			cuenta.setSaldo(9800.55);
			cuenta.setEstado(true);		
			AgregarCuenta(cuenta);
			InsertarCuentas_x_Usuario(user,cuenta);
	}
	
	public static void InsertarCuentas_x_Usuario(Usuario user, Cuenta c) {
		Cuentas_x_Usuario cuentasUsuario = new Cuentas_x_Usuario();
		Cuentas_x_UsuarioNeg cuentasUsuarioNeg = new Cuentas_x_UsuarioNegImpl();

			cuentasUsuario.setCuenta(c);
			cuentasUsuario.setUsuario(user); 
								
			
			if(cuentasUsuarioNeg.agregarUna(cuentasUsuario)) {
				System.out.println("Anduvo!");
			}
			else {
				System.out.println("No anduvo :(");
			}
	
		
	}
	
	public static void InsertarMovimientos() {
		Movimiento movimiento = new Movimiento();
		Cuenta cuenta1 = new Cuenta();
		Cuenta cuenta2 = new Cuenta();
		
		cuenta1.setCodTipoCuenta(1);
		cuenta1.setFecha(Fecha);
		cuenta1.setNombre("Daniela");
		cuenta1.setNumeroCuenta(954226);
		cuenta1.setSaldo(9800.55);
		cuenta1.setEstado(true);		
			
		cuenta2.setCodTipoCuenta(2);
		cuenta2.setFecha(Fecha);
		cuenta2.setNombre("Mateo");
		cuenta2.setNumeroCuenta(54213);
		cuenta2.setSaldo(4213.55);
		cuenta2.setEstado(true);			
			
			movimiento.setCodMovimiento(1);
			movimiento.setFecha(Fecha);
			movimiento.setConcepto("Concepto");
			movimiento.setImporte(200.5);							
			AgregarMovimiento(movimiento);
			InsertarMovimientos_x_Cuenta(movimiento,cuenta1,cuenta2);
			
			movimiento = new Movimiento();
			
			movimiento.setCodMovimiento(2);
			movimiento.setFecha(Fecha);
			movimiento.setConcepto("Concepto");
			movimiento.setImporte(252.5);							
			AgregarMovimiento(movimiento);
			InsertarMovimientos_x_Cuenta(movimiento,cuenta1,cuenta2);
			
			movimiento = new Movimiento();
			
			movimiento.setCodMovimiento(3);
			movimiento.setFecha(Fecha);
			movimiento.setConcepto("Concepto");
			movimiento.setImporte(450.5);							
			AgregarMovimiento(movimiento);
			InsertarMovimientos_x_Cuenta(movimiento,cuenta1,cuenta2);
			
			movimiento = new Movimiento();
			
			movimiento.setCodMovimiento(4);
			movimiento.setFecha(Fecha);
			movimiento.setConcepto("Concepto");
			movimiento.setImporte(850.5);							
			AgregarMovimiento(movimiento);
			InsertarMovimientos_x_Cuenta(movimiento,cuenta1,cuenta2);
			
			movimiento = new Movimiento();
			
			movimiento.setCodMovimiento(5);
			movimiento.setFecha(Fecha);
			movimiento.setConcepto("Concepto");
			movimiento.setImporte(1200.5);							
			AgregarMovimiento(movimiento);
			InsertarMovimientos_x_Cuenta(movimiento,cuenta1,cuenta2);
			
			movimiento = new Movimiento();
			
			movimiento.setCodMovimiento(6);
			movimiento.setFecha(Fecha);
			movimiento.setConcepto("Concepto");
			movimiento.setImporte(2000.5);							
			AgregarMovimiento(movimiento);
			InsertarMovimientos_x_Cuenta(movimiento,cuenta1,cuenta2);
			
			movimiento = new Movimiento();
			
			movimiento.setCodMovimiento(7);
			movimiento.setFecha(Fecha);
			movimiento.setConcepto("Concepto");
			movimiento.setImporte(5421.5);							
			AgregarMovimiento(movimiento);
			InsertarMovimientos_x_Cuenta(movimiento,cuenta1,cuenta2);
			
			movimiento = new Movimiento();
			
			movimiento.setCodMovimiento(8);
			movimiento.setFecha(Fecha);
			movimiento.setConcepto("Concepto");
			movimiento.setImporte(4444.5);							
			AgregarMovimiento(movimiento);
			InsertarMovimientos_x_Cuenta(movimiento,cuenta1,cuenta2);
			
			movimiento = new Movimiento();
			
			movimiento.setCodMovimiento(9);
			movimiento.setFecha(Fecha);
			movimiento.setConcepto("Concepto");
			movimiento.setImporte(5856.65);							
			AgregarMovimiento(movimiento);
			InsertarMovimientos_x_Cuenta(movimiento,cuenta1,cuenta2);
			
			movimiento = new Movimiento();
			
			movimiento.setCodMovimiento(10);
			movimiento.setFecha(Fecha);
			movimiento.setConcepto("Concepto");
			movimiento.setImporte(8744.5);							
			AgregarMovimiento(movimiento);
			InsertarMovimientos_x_Cuenta(movimiento,cuenta1,cuenta2);
			
			movimiento = new Movimiento();
	}
	
	public static void InsertarMovimientos_x_Cuenta(Movimiento m, Cuenta CBUDestino, Cuenta CBUOrigen) {
		Movimientos_x_Cuenta movimientos_x_Cuenta = new Movimientos_x_Cuenta();
		Movimientos_x_CuentaNeg movimientoCuentaNeg = new Movimientos_x_CuentaNegImpl();


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
	
	public static void InsertarPrestamo() {
		Prestamo prestamo = new Prestamo();
		Cliente cli = new Cliente();
		Usuario user = new Usuario();
		
		user.setUsername("Mateo123");
		cli.setDNI(66666);
		cli.setNombre("Mateo");
		cli.setApellido("Martinez");
		cli.setFecha(Fecha);
		cli.setLocalidad("Victorica");
		cli.setNacionalidad("Argentino");
		cli.setProvincia("La Pampa");
		cli.setSexo("Masculino");
		cli.setDireccion("Direccion");
		cli.setUsuario(user);
		
			prestamo.setCodPrestamo(1);
			prestamo.setFecha(Fecha);
			prestamo.setCuotas(1);
			prestamo.setImporte(200.5);
			prestamo.setImporte_x_Mes(prestamo.getImporte()/prestamo.getCuotas());
			prestamo.setPlazo_en_Meses(20);
			prestamo.setEstado(1);
			AgregarPrestamo(prestamo);
			InsertarCuotas_x_Prestamo(prestamo);
			InsertarPrestamos_x_Cliente(prestamo,cli);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Hugo123");
			cli.setDNI(11111);
			cli.setNombre("Hugo");
			cli.setApellido("Garcia");
			cli.setFecha(Fecha);
			cli.setLocalidad("Maquinchao");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("Rio Negro");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			
			prestamo = new Prestamo();
			
			prestamo.setCodPrestamo(2);
			prestamo.setFecha(Fecha);
			prestamo.setCuotas(1);
			prestamo.setImporte(2502.5);
			prestamo.setImporte_x_Mes(prestamo.getImporte()/prestamo.getCuotas());
			prestamo.setPlazo_en_Meses(20);
			prestamo.setEstado(1);
			AgregarPrestamo(prestamo);
			InsertarCuotas_x_Prestamo(prestamo);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Lucas123");
			cli.setDNI(22222);
			cli.setNombre("Lucas");
			cli.setApellido("Fernandez");
			cli.setFecha(Fecha);
			cli.setLocalidad("San Antonio Oeste");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("Rio Negro");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			
			prestamo = new Prestamo();
			
			prestamo.setCodPrestamo(3);
			prestamo.setFecha(Fecha);
			prestamo.setCuotas(1);
			prestamo.setImporte(420.5);
			prestamo.setImporte_x_Mes(prestamo.getImporte()/prestamo.getCuotas());
			prestamo.setPlazo_en_Meses(20);
			prestamo.setEstado(1);
			AgregarPrestamo(prestamo);
			InsertarCuotas_x_Prestamo(prestamo);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Mateo123");
			cli.setDNI(66666);
			cli.setNombre("Mateo");
			cli.setApellido("Martinez");
			cli.setFecha(Fecha);
			cli.setLocalidad("Victorica");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("La Pampa");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			
			prestamo = new Prestamo();
			
			prestamo.setCodPrestamo(4);
			prestamo.setFecha(Fecha);
			prestamo.setCuotas(1);
			prestamo.setImporte(654.5);
			prestamo.setImporte_x_Mes(prestamo.getImporte()/prestamo.getCuotas());
			prestamo.setPlazo_en_Meses(20);
			prestamo.setEstado(1);
			AgregarPrestamo(prestamo);
			InsertarCuotas_x_Prestamo(prestamo);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Alejandro123");
			cli.setDNI(77777);
			cli.setNombre("Alejandro");
			cli.setApellido("Sanchez");
			cli.setFecha(Fecha);
			cli.setLocalidad("Uspallata");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("Mendoza");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			
			prestamo = new Prestamo();
			
			prestamo.setCodPrestamo(5);
			prestamo.setFecha(Fecha);
			prestamo.setCuotas(1);
			prestamo.setImporte(6545.5);
			prestamo.setImporte_x_Mes(prestamo.getImporte()/prestamo.getCuotas());
			prestamo.setPlazo_en_Meses(20);
			prestamo.setEstado(1);
			AgregarPrestamo(prestamo);
			InsertarCuotas_x_Prestamo(prestamo);
			
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Leo123");
			cli.setDNI(88888);
			cli.setNombre("Leo");
			cli.setApellido("Perez");
			cli.setFecha(Fecha);
			cli.setLocalidad("San Carlos");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("Buenos Aires");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			
			prestamo = new Prestamo();
			
			prestamo.setCodPrestamo(6);
			prestamo.setFecha(Fecha);
			prestamo.setCuotas(1);
			prestamo.setImporte(4541.5);
			prestamo.setImporte_x_Mes(prestamo.getImporte()/prestamo.getCuotas());
			prestamo.setPlazo_en_Meses(20);
			prestamo.setEstado(1);
			AgregarPrestamo(prestamo);
			InsertarCuotas_x_Prestamo(prestamo);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Paula123");
			cli.setDNI(99999);
			cli.setNombre("Paula");
			cli.setApellido("Martin");
			cli.setFecha(Fecha);
			cli.setLocalidad("General Pico");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("La Pampa");
			cli.setSexo("Femenino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			
			prestamo = new Prestamo();
			
			prestamo.setCodPrestamo(7);
			prestamo.setFecha(Fecha);
			prestamo.setCuotas(1);
			prestamo.setImporte(200.5);
			prestamo.setImporte_x_Mes(prestamo.getImporte()/prestamo.getCuotas());
			prestamo.setPlazo_en_Meses(20);
			prestamo.setEstado(1);
			AgregarPrestamo(prestamo);
			InsertarCuotas_x_Prestamo(prestamo);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Martin123");
			cli.setDNI(33333);
			cli.setNombre("Martin");
			cli.setApellido("Gonzalez");
			cli.setFecha(Fecha);
			cli.setLocalidad("Jachal");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("San Juan");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			
			prestamo = new Prestamo();
			
			prestamo.setCodPrestamo(8);
			prestamo.setFecha(Fecha);
			prestamo.setCuotas(1);
			prestamo.setImporte(5555.5);
			prestamo.setImporte_x_Mes(prestamo.getImporte()/prestamo.getCuotas());
			prestamo.setPlazo_en_Meses(20);
			prestamo.setEstado(1);
			AgregarPrestamo(prestamo);
			InsertarCuotas_x_Prestamo(prestamo);
			
			AgregarCliente(cli);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Daniela123");
			cli.setDNI(12345);
			cli.setNombre("Daniela");
			cli.setApellido("Gomez");
			cli.setFecha(Fecha);
			cli.setLocalidad("El Calafate");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("Santa Cruz");
			cli.setSexo("Femenino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			
			prestamo = new Prestamo();
			
			prestamo.setCodPrestamo(9);
			prestamo.setFecha(Fecha);
			prestamo.setCuotas(1);
			prestamo.setImporte(6874.5);
			prestamo.setImporte_x_Mes(prestamo.getImporte()/prestamo.getCuotas());
			prestamo.setPlazo_en_Meses(20);
			prestamo.setEstado(1);
			AgregarPrestamo(prestamo);
			InsertarCuotas_x_Prestamo(prestamo);
			
			cli = new Cliente();
			user = new Usuario();
			
			user.setUsername("Pablo123");
			cli.setDNI(55555);
			cli.setNombre("Pablo");
			cli.setApellido("Lopez");
			cli.setFecha(Fecha);
			cli.setLocalidad("Villa Reynolds");
			cli.setNacionalidad("Argentino");
			cli.setProvincia("San Luis");
			cli.setSexo("Masculino");
			cli.setDireccion("Direccion");
			cli.setUsuario(user);
			
			prestamo = new Prestamo();
			
			prestamo.setCodPrestamo(10);
			prestamo.setFecha(Fecha);
			prestamo.setCuotas(1);
			prestamo.setImporte(9785.5);
			prestamo.setImporte_x_Mes(prestamo.getImporte()/prestamo.getCuotas());
			prestamo.setPlazo_en_Meses(20);
			prestamo.setEstado(1);
			AgregarPrestamo(prestamo);
			InsertarCuotas_x_Prestamo(prestamo);
			
			
	}
	
	public static void InsertarCuotas_x_Prestamo(Prestamo prestamo) {
		Cuotas_x_Prestamo cuotas_x_Prestamo = new Cuotas_x_Prestamo();
		Cuotas_x_PrestamoNeg cuotaPrestamoNeg = new Cuotas_x_PrestamoNegImpl();

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
	
	public static void InsertarPrestamos_x_Cliente(Prestamo prestamo, Cliente cli) {
		Prestamos_x_ClienteNeg prestxcliNeg = new Prestamos_x_ClienteNegImpl();
		Prestamos_x_Cliente prestxcli=new Prestamos_x_Cliente();
		prestxcli.setCliente(cli);
		prestxcli.setPrestamo(prestamo);
		
		if(prestxcliNeg.agregarUno(prestxcli)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
	}
	
	public static void AgregarUsuario(Usuario u) {
		UsuarioNeg userNeg = new UsuarioNegImpl(); 
		if(userNeg.agregarUno(u)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
	}
	
	public static void AgregarCliente(Cliente cli) {
		ClienteNeg cliNeg = new ClienteNegImpl(); 
		if(cliNeg.agregarUno(cli)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
	}
	
	public static void AgregartC(TipoCuenta tC) {
		TipoCuentaNeg tCNeg = new TipoCuentaNegImpl();
		if(tCNeg.agregarUna(tC)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
	}
	
	public static void AgregarCuenta(Cuenta c) {
		CuentaNeg cuentaNeg = new CuentaNegImpl(); 
		if(cuentaNeg.agregarUna(c)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
	}
	
	public static void AgregarMovimiento(Movimiento movimiento) {
		MovimientoNeg movimientoNeg = new MovimientoNegImpl();
		if(movimientoNeg.agregarUno(movimiento)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
	}
	
	public static void AgregarPrestamo(Prestamo prestamo) {
		PrestamoNeg prestamoNeg = new PrestamoNegImpl();
		if(prestamoNeg.agregarUno(prestamo)) {
			System.out.println("Anduvo!");
		}
		else {
			System.out.println("No anduvo :(");
		}
	}
	
	
}
