# Banco_Laboratorio_V

Trabajo integrador de Laboratorio V

Cosas a tener en cuenta:

- Archivos: Al día de la fecha (02/06/2020) los archivos creados dentro de los PKGs hasta ahora son puramente de ejemplo, a medida que se vayan llenando los PKG, los archivos de ejemplo estos irán eliminandose.

- Programación por capas:
  ○ En el PKG "datos" se crean las interfaces de las clases que más tarde tendrán las funciones ABML a implementar en cada clase del package "datosImpl". La nomenclatura para este es "<Nombre>Dao", ejemplo: "ClienteDao".
  ○ En el PKG "datosImpl" se crean las clases que realizan acciones en la Base de datos. La nomenclatura de esto es <Nombre>DaoImpl, ejemplo: "ClienteDaoImpl".
  ○ En el PKG "entidad" básicamente se guardan las clases. La nomenclatura de esto es <Nombre>, ejemplo: "Cliente".
  ○ En el PKG "negocio" se guardan las interfaces de las clases que más tarde tendran funciones que harán uso de las clases del PKG "datosImpl". La nomenclatura de esto es <Nombre>NegImpl, ejemplo: "ClienteNegImpl".
  ○ En el PKG "negocioImpl" se guardan las clases que tendrán funciones que harán uso de las clases del PKG "datosImpl", obteniendo o realizando acciones en la BD. La nomenclatura de esto sería <Nombre>Neg, ejemplo: "ClienteNeg".
  ○ Aún no lo enseñaron, pero en el PKG "presentacion" irán todos los Servlets. La nomenclatura de esto es Servlet<NombrePlural>, ejemplo: "ServletClientes".
  
- Front-End:
  ○ Las páginas (Archivos JSP) irán dentro de la carpeta "webapp".
  ○ Los archivos CSS irán dentro de la carpeta "webapp\CSS".
  ○ Los archivos JS irán dentro de la carpeta "webapp\JS".
  ○ Los archivos de Multimedia (Imagenes, Audios, etc.) irán dentro de la carpeta "webapp\Multimedia".
  
Consignas faltantes:

- Crear un archivo llamado main. Dentro del mismo, se pide llenar la base de datos con mínimamente 10 registros válidos por cada tabla. Por ejemplo, si tienen que llenar la tabla clientes coloquen nombres y apellidos correctos… no nombre “fafssafs” y apellido “fdskkjfsd”.

- Las pantallas deberán realizarse con JSP.  Se evaluará que controles van a utilizar, por lo que es sumamente importante que se visualicen TODOS los controles. Ejemplo, si se va a editar sobre una grilla… dibujar una grilla y colocar en su interior el botón eliminar y modificar…. O si van a agregar sobre la grilla, dibujar los textbox respectivos.  No se pide entregar funcionalidad.

Pantallas a realizar:
