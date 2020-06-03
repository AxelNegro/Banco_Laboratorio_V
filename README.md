# Banco_Laboratorio_V

Trabajo integrador de Laboratorio V

Información útil:
- Uso de GitHub: https://www.youtube.com/watch?v=zkfzIGJditA

Archivos: Al día de la fecha (02/06/2020) los archivos creados dentro de los PKGs y carpetas de Front-End hasta ahora son puramente de ejemplo y fueron para crear los PKGs y carpetas. A medida que se vayan llenando los mismos, los archivos de ejemplo irán eliminandose.

Programación por capas:
  - En el PKG "datos" se crean las interfaces de las clases que más tarde tendrán las funciones ABML a implementar en cada clase del package "datosImpl". La nomenclatura para este es "NombreDao", ejemplo: "ClienteDao".
  - En el PKG "datosImpl" se crean las clases que realizan acciones en la Base de datos. La nomenclatura de esto es "NombreDaoImpl", ejemplo: "ClienteDaoImpl".
  - En el PKG "entidad" básicamente se guardan las clases. La nomenclatura de esto es "Nombre", ejemplo: "Cliente".
  - En el PKG "negocio" se guardan las interfaces de las clases que más tarde tendran funciones que harán uso de las clases del PKG "datosImpl". La nomenclatura de esto es "NombreNegImpl", ejemplo: "ClienteNegImpl".
  - En el PKG "negocioImpl" se guardan las clases que tendrán funciones que harán uso de las clases del PKG "datosImpl", obteniendo o realizando acciones en la BD. La nomenclatura de esto sería "NombreNeg", ejemplo: "ClienteNeg".
  - Aún no lo enseñaron, pero en el PKG "presentacion" irán todos los Servlets. La nomenclatura de esto es "ServletNombrePlural", ejemplo: "ServletClientes".
  
Front-End:
  - Las páginas (Archivos JSP) irán dentro de la carpeta "webapp".
  - Los archivos CSS irán dentro de la carpeta "webapp\CSS".
  - Los archivos JS irán dentro de la carpeta "webapp\JS".
  - Los archivos de Multimedia (Imagenes, Audios, etc.) irán dentro de la carpeta "webapp\Multimedia".
  
Consignas faltantes:

- La base de datos junto con las tablas y las relaciones serán creados a partir del proyecto mediante la utilización de Hibernate.

- Crear un archivo llamado main. Dentro del mismo, se pide llenar la base de datos con mínimamente 10 registros válidos por cada tabla. Por ejemplo, si tienen que llenar la tabla clientes coloquen nombres y apellidos correctos… no nombre “fafssafs” y apellido “fdskkjfsd”.

- Las pantallas deberán realizarse con JSP.  Se evaluará que controles van a utilizar, por lo que es sumamente importante que se visualicen TODOS los controles. Ejemplo, si se va a editar sobre una grilla… dibujar una grilla y colocar en su interior el botón eliminar y modificar…. O si van a agregar sobre la grilla, dibujar los textbox respectivos.  No se pide entregar funcionalidad.

Pantallas a realizar y persona a cargo: 
- Master Page que muestre el usuario logeado.
- Login.
- (Usuario Banco) ABML de clientes.
- (Usuario Banco) ABML de cuentas y asignación de cuentas.
- (Usuario Banco) Autorización de préstamos, asignación de monto prestado, tiempo y cuotas que deberá pagar el cliente.
- (Usuario Banco) Informe de actividades en un determinado rango de fechas.
- (Usuario Cliente) Historial de movimientos de una cuenta seleccionada.
- (Usuario Cliente) Transferencia a otros clientes.
- (Usuario Cliente) Pedido de prestamos.
- (Usuario Cliente) Menú de pago de prestamos.

Clases:
- Cliente: DNI -  Nombre - Apellido - Sexo - Nacionalidad - Fecha de Nacimiento - Direccion - Localidad - Provincia.
- Cliente x Usuario: DNI - Usuario.
- Usuario: Usuario - Contraseña - Tipo de usuario (Banco/Cliente).
- Cliente x Cuentas: DNI - CBU.
- Cuenta: CBU - Fecha de creación - Tipo de Cuenta - Numero de Cuenta - Nombre - Saldo.
- Cuenta x Movimiento: CBU Origen - CBU Destino (Nulo si no es necesario) - Nro. Movimiento.
  - Movimientos: Nro. Movimiento - Importe - Concepto - Fecha.
- Cliente x Prestamos: Cliente - Nro. Prestamo.
- Prestamo: Nro. Prestamo - Ult. Fecha de cuota Pagada - Importe prestado - Cuotas - Plazo de Pago en Meses - Monto a pagar por mes.
