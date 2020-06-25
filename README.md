# Banco_Laboratorio_V

Trabajo integrador de Laboratorio V

Información útil:
- Uso de GitHub: https://www.youtube.com/watch?v=zkfzIGJditA
- HTML Formatter: https://www.freeformatter.com/html-formatter.html
- Tutorial Spring MVC: https://www.javatpoint.com/spring-mvc-tutorial
- En caso de que alguien haya hechos cambios mientras nosotros estabamos realizando cambios también, habrá que realizar un Pull y acto seguido realizar un Push para que el Commit se produzca, caso contrario, tirará "Rejected: Non-fast forward".
- Va a haber casos donde Hibernate, a pesar de tener el hbm2ddl.auto en create, no va a crear la base de datos y te va a decir "Unknown database 'nombre'", la manera que encontré de solucionar esto, fue creando la base de datos (y solo la base de datos) a mano en MySQL.

- Creación correcta de la BD:
1. Ejecutar en MySQL "CREATE DATABASE Banco;"
2. Con el hibernate.cfg.xml en "create" ejecutar el proyecto.
3. Logearse con la cuenta de usuario "admin" y contraseña "admin".
4. Parar la ejecución del proyecto y pasar el hibernate.cfg.xml a "update".
5. Descomentar la linea 62 del UsuarioController.java y comentar la linea 61.
6. Ejecutar el proyecto hasta luego de logearse y luego comentar la linea 62 (Opcional).

Archivos: Al día de la fecha (02/06/2020) los archivos creados dentro de los PKGs y carpetas de Front-End hasta ahora son puramente de ejemplo y fueron para crear los PKGs y carpetas. A medida que se vayan llenando los mismos, los archivos de ejemplo irán eliminandose.

Programación por capas:
  - En el PKG "datos" se crean las interfaces de las clases que más tarde tendrán las funciones ABML a implementar en cada clase del package "datosImpl". La nomenclatura para este es "NombreDao", ejemplo: "ClienteDao".
  - En el PKG "datosImpl" se crean las clases que realizan acciones en la Base de datos. La nomenclatura de esto es "NombreDaoImpl", ejemplo: "ClienteDaoImpl".
  - En el PKG "entidad" básicamente se guardan las clases. La nomenclatura de esto es "Nombre", ejemplo: "Cliente".
  - En el PKG "negocio" se guardan las interfaces de las clases que mÃ¡s tarde tendran funciones que harán uso de las clases del PKG "datosImpl". La nomenclatura de esto es "NombreNegImpl", ejemplo: "ClienteNegImpl".
  - En el PKG "negocioImpl" se guardan las clases que tendrán funciones que harán uso de las clases del PKG "datosImpl", obteniendo o realizando acciones en la BD. La nomenclatura de esto será "NombreNeg", ejemplo: "ClienteNeg".
  - Aún no lo enseñaron, pero en el PKG "presentacion" irán todos los Servlets. La nomenclatura de esto es "ServletNombrePlural", ejemplo: "ServletClientes".
  
Front-End:
  - Las páginas (Archivos JSP) irán dentro de la carpeta "webapp".
  - Los archivos CSS irán dentro de la carpeta "webapp\CSS".
  - Los archivos JS irán dentro de la carpeta "webapp\JS".
  - Los archivos de Multimedia (Imagenes, Audios, etc.) irán dentro de la carpeta "webapp\Multimedia".
  
Consignas faltantes:

- Dada la entrega número uno, se agregará la siguiente funcionalidad del administrador: ABML de cliente, ABML de cuentas y asignación de cuenta a cliente. (Hecho)

- Todas las instancias deben ser manejadas mediante SPRING CORE. Utilizar SPRING MVC para las peticiones (No servlets). (Hecho)

- La pantalla principal debe llamarse Index.jsp (Ejecutare el código desde esta pantalla para probar así la funcionalidad) (Hecho)

Clases:
- Cliente: 
  - DNI.
  - Nombre.
  - Apellido.
  - Sexo.
  - Nacionalidad.
  - Fecha de Nacimiento.
  - Direccion.
  - Localidad.
  - Provincia.
- Cuenta:
  - CBU.
  - Fecha de creación.
  - Cod. Tipo de Cuenta.
  - Numero de Cuenta.
  - Nombre.
  - Saldo.
  - Estado.
- Cuentas x Usuario:
  - CBU.
  - Usuario.
- Cuotas x Prestamo:
  - Cod. Prestamo.
  - Importe Mensual.
  - Fecha de Pago.
  - Estado. (0 - A pagar, 1 - Pagado)
- Movimiento:
  - Cod. Movimiento.
  - Importe.
  - Concepto.
  - Fecha.
- Movimientos x Cuenta:
  - Cod. Movimiento.
  - CBU Origen (Nulo en caso de Prestamos y Alta de Cuentas).
  - CBU Destino (Nulo en caso de pago de Prestamos).
- Prestamo:
  - Cod. Prestamo.
  - CBU Destino.
  - Ult. Fecha de cuota Pagada.
  - Importe prestado.
  - Cuotas.
  - Plazo de Pago en Meses.
  - Monto a pagar por mes.
  - Estado (-1 - Cancelado, 0 - Pendiente, 1 - Aceptado, 2 - Rechazado).
- Prestamos x Cliente:
  - Cliente.
  - CBU Destino en caso de ser aceptado.
- Tipo de Cuenta:
  - Cod. de tipo de cuenta.
  - Tipo de Cuenta.
- Usuario: 
  - Usuario.
  - Contraseña.
  - Tipo de Usuario (1 - Banco, 0 - Cliente).
  - Estado.
