# Banco_Laboratorio_V

Trabajo integrador de Laboratorio V

InformaciÃ³n Ãºtil:
- Uso de GitHub: https://www.youtube.com/watch?v=zkfzIGJditA
- En caso de que alguien haya hechos cambios mientras nosotros estabamos realizando cambios tambiÃ©n, habrÃ¡ que realizar un Pull y acto seguido realizar un Push para que el Commit se produzca, caso contrario, tirarÃ¡ "Rejected: Non-fast forward"

Archivos: Al dÃ­a de la fecha (02/06/2020) los archivos creados dentro de los PKGs y carpetas de Front-End hasta ahora son puramente de ejemplo y fueron para crear los PKGs y carpetas. A medida que se vayan llenando los mismos, los archivos de ejemplo irÃ¡n eliminandose.

ProgramaciÃ³n por capas:
  - En el PKG "datos" se crean las interfaces de las clases que mÃ¡s tarde tendrÃ¡n las funciones ABML a implementar en cada clase del package "datosImpl". La nomenclatura para este es "NombreDao", ejemplo: "ClienteDao".
  - En el PKG "datosImpl" se crean las clases que realizan acciones en la Base de datos. La nomenclatura de esto es "NombreDaoImpl", ejemplo: "ClienteDaoImpl".
  - En el PKG "entidad" bÃ¡sicamente se guardan las clases. La nomenclatura de esto es "Nombre", ejemplo: "Cliente".
  - En el PKG "negocio" se guardan las interfaces de las clases que mÃ¡s tarde tendran funciones que harÃ¡n uso de las clases del PKG "datosImpl". La nomenclatura de esto es "NombreNegImpl", ejemplo: "ClienteNegImpl".
  - En el PKG "negocioImpl" se guardan las clases que tendrÃ¡n funciones que harÃ¡n uso de las clases del PKG "datosImpl", obteniendo o realizando acciones en la BD. La nomenclatura de esto serÃ­a "NombreNeg", ejemplo: "ClienteNeg".
  - AÃºn no lo enseÃ±aron, pero en el PKG "presentacion" irÃ¡n todos los Servlets. La nomenclatura de esto es "ServletNombrePlural", ejemplo: "ServletClientes".
  
Front-End:
  - Las pÃ¡ginas (Archivos JSP) irÃ¡n dentro de la carpeta "webapp".
  - Los archivos CSS irÃ¡n dentro de la carpeta "webapp\CSS".
  - Los archivos JS irÃ¡n dentro de la carpeta "webapp\JS".
  - Los archivos de Multimedia (Imagenes, Audios, etc.) irÃ¡n dentro de la carpeta "webapp\Multimedia".
  
Consignas faltantes:

- La base de datos junto con las tablas y las relaciones serÃ¡n creados a partir del proyecto mediante la utilizaciÃ³n de Hibernate.

- Crear un archivo llamado main. Dentro del mismo, se pide llenar la base de datos con mÃ­nimamente 10 registros vÃ¡lidos por cada tabla. Por ejemplo, si tienen que llenar la tabla clientes coloquen nombres y apellidos correctosâ€¦ no nombre â€œfafssafsâ€� y apellido â€œfdskkjfsdâ€�.

- Las pantallas deberÃ¡n realizarse con JSP.  Se evaluarÃ¡ que controles van a utilizar, por lo que es sumamente importante que se visualicen TODOS los controles. Ejemplo, si se va a editar sobre una grillaâ€¦ dibujar una grilla y colocar en su interior el botÃ³n eliminar y modificarâ€¦. O si van a agregar sobre la grilla, dibujar los textbox respectivos.  No se pide entregar funcionalidad.

Pantallas a realizar y persona a cargo: 
- Todos:
  - Masterpage. (Hecho)
  - Login. (Hecho)
  - Pagina principal sin logear. (Hecho)
- Usuario Banco:
  - Master Page de Banco que muestre el usuario logeado. (Hecho)
  - ABML de clientes. (Hecho)
  - ABML de cuentas y asignaciÃ³n de cuentas. (Hecho)
  - AutorizaciÃ³n de prÃ©stamos, asignaciÃ³n de monto prestado, tiempo y cuotas que deberÃ¡ pagar el cliente.
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
