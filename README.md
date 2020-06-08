# Banco_Laboratorio_V

Trabajo integrador de Laboratorio V

Información útil:
- Uso de GitHub: https://www.youtube.com/watch?v=zkfzIGJditA
- En caso de que alguien haya hechos cambios mientras nosotros estabamos realizando cambios también, habrá que realizar un Pull y acto seguido realizar un Push para que el Commit se produzca, caso contrario, tirará "Rejected: Non-fast forward"

Archivos: Al día de la fecha (02/06/2020) los archivos creados dentro de los PKGs y carpetas de Front-End hasta ahora son puramente de ejemplo y fueron para crear los PKGs y carpetas. A medida que se vayan llenando los mismos, los archivos de ejemplo irán eliminandose.

Programación por capas:
  - En el PKG "datos" se crean las interfaces de las clases que más tarde tendrán las funciones ABML a implementar en cada clase del package "datosImpl". La nomenclatura para este es "NombreDao", ejemplo: "ClienteDao".
  - En el PKG "datosImpl" se crean las clases que realizan acciones en la Base de datos. La nomenclatura de esto es "NombreDaoImpl", ejemplo: "ClienteDaoImpl".
  - En el PKG "entidad" básicamente se guardan las clases. La nomenclatura de esto es "Nombre", ejemplo: "Cliente".
  - En el PKG "negocio" se guardan las interfaces de las clases que mÃ¡s tarde tendran funciones que harán uso de las clases del PKG "datosImpl". La nomenclatura de esto es "NombreNegImpl", ejemplo: "ClienteNegImpl".
  - En el PKG "negocioImpl" se guardan las clases que tendrán funciones que harán uso de las clases del PKG "datosImpl", obteniendo o realizando acciones en la BD. La nomenclatura de esto será "NombreNeg", ejemplo: "ClienteNeg".
  - Aún no lo enseñaron, pero en el PKG "presentacion" irán todos los Servlets. La nomenclatura de esto es "ServletNombrePlural", ejemplo: "ServletClientes".
  
Front-End:
  - Las pÃ¡ginas (Archivos JSP) irán dentro de la carpeta "webapp".
  - Los archivos CSS irán dentro de la carpeta "webapp\CSS".
  - Los archivos JS irán dentro de la carpeta "webapp\JS".
  - Los archivos de Multimedia (Imagenes, Audios, etc.) irán dentro de la carpeta "webapp\Multimedia".
  
Consignas faltantes:

- La base de datos junto con las tablas y las relaciones serÃ¡n creados a partir del proyecto mediante la utilización de Hibernate.

- Crear un archivo llamado main. Dentro del mismo, se pide llenar la base de datos con mínimamente 10 registros validos por cada tabla. Por ejemplo, si tienen que llenar la tabla clientes coloquen nombres y apellidos correctos y no nombres como "afssafs" y apellido "fdskkjfsd".

- Las pantallas deberán realizarse con JSP.  Se evaluará que controles van a utilizar, por lo que es sumamente importante que se visualicen TODOS los controles. Ejemplo, si se va a editar sobre una grilla dibujar una grilla y colocar en su interior el botón eliminar y modificar. O si van a agregar sobre la grilla, dibujar los textbox respectivos.  No se pide entregar funcionalidad.

Pantallas a realizar y persona a cargo: 
- Todos:
  - Masterpage. (Hecho)
  - Login. (Hecho)
  - Pagina principal sin logear. (Hecho)
- Usuario Banco:
  - Master Page de Banco que muestre el usuario logeado. (Hecho)
  - ABML de clientes. (Hecho)
  - ABML de cuentas y asignación de cuentas. (Hecho)
  - Autorización de prestamos, asignación de monto prestado, tiempo y cuotas que deberá pagar el cliente.
  - Informe de actividades en un determinado rango de fechas.
- Usuario Cliente:
  - Master Page de Cliente que muestre el usuario logeado. (Hecho)
  - Historial de movimientos de una cuenta seleccionada.
  - Transferencia a otros clientes.
  - Pedido de prestamos.
  - MenÃº de pago de prestamos.

Clases:
- Cliente x Usuario:
  - DNI.
  - Usuario.
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
  - Fecha de creaciÃ³n.
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
  - ContraseÃ±a.
  - Tipo de Usuario (Banco/Cliente).
  - Estado.
