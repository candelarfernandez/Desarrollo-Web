/*1. Crear la base de datos MusicaDB a través del siguiente script:
Nota: Tener en cuenta los paths en donde se encuentran creados los archivos de log y data. En este
caso, se deberá localizar dónde se encuentra instalado el producto para determinar si son correctos los
paths o deben adaptarlo a nuestro entorno.*/
CREATE DATABASE MusicaDB ON PRIMARY
( NAME = 'Musica',
FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\Musica.mdf' ,
SIZE = 4096KB ,
MAXSIZE = 20480KB ,
FILEGROWTH = 1024KB
)
 LOG ON
( NAME = 'Musica_log',
FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\Musica_log.ldf' ,
SIZE = 2048KB ,
MAXSIZE = 10240KB ,
FILEGROWTH = 10%
)
/*2. Responder la siguientes preguntas verificando cómo ha quedado la base de
datos creada:
2.1. ¿Qué se ha definido como política de retención de log?
Se definio como Simple
2.2. ¿Se crearán estadísticas automáticamente?
Si
2.3. ¿Será compatible con una base de datos de SQL Server 2000?
No, es compatible hasta el 2008
2.4. ¿Cuál es el juego de caracteres que se utilizará y qué significa?
SQL_Latin1_General_CP1_CI_AS
Indica que es un juego de caracteres para SQL Server, basado en el alfabeto latino,códigos predeterminada para el inglés en Windows, que es Case Insensitive
y Accent Sensitive*/
use MusicaDB;
/*3. Crear el esquema discos.*/
CREATE SCHEMA discos;
/*4. Se desea crear el siguiente modelo relacional. Recordar que se deben crear
cada una de las tablas involucradas y de sus relaciones
Por ejemplo:
CREATE TABLE Discos.Artista(
 artno smallint NOT NULL,
 nombre varchar(50) NULL,
 clasificacion char(1) NULL,
 bio text NULL,
 foto image null,
 CONSTRAINT PK_Artista PRIMARY KEY CLUSTERED (artno)
)*/
CREATE TABLE Discos.Artista(
 artno smallint NOT NULL,
 nombre varchar(50) NULL,
 clasificacion char(1) NULL,
 bio text NULL,
 foto image null,
 CONSTRAINT PK_Artista PRIMARY KEY CLUSTERED (artno)
)
CREATE TABLE Discos.Concierto(
 artno smallint NOT NULL,
 fecha datetime NOT NULL,
 ciudad varchar(25) NULL,
  CONSTRAINT FK_Concierto Foreign KEY (artno) references Discos.Artista(artno)
)
CREATE TABLE Discos.Stock(
 itemnro smallint NOT NULL,
 tipo char(1) NOT NULL,
 precio decimal(5,2) NULL,
 cantidad int NULL,
 CONSTRAINT PK_Stock PRIMARY KEY CLUSTERED (itemnro)
)
CREATE TABLE Discos.Orden(
 itemnro smallint NOT NULL,
 timestamp timestamp NOT NULL,
   CONSTRAINT FK_Orden Foreign KEY (itemnro) references Discos.Stock(itemnro)
)
CREATE TABLE Discos.Album(
 titulo smallint NOT NULL,
  artno smallint NOT NULL,
  itemnro smallint NOT NULL,
   CONSTRAINT FK_Album_Stock Foreign KEY (itemnro) references Discos.Stock(itemnro),
   CONSTRAINT FK_Album_Concierto Foreign KEY (artno) references Discos.Artista(artno)
)

/*5. Crear un diagrama con el modelo relacional generado.
CREADO*/

/*6. Realizar los siguientes cambios en el modelo:
6.1. Cambiar el tamaño de campo ciudad en la tabla ciudad para que sea de
30 en lugar de 25.
6.2. En la tabla de Stock, colocar el precio con un valor por defecto en 0
(cero).
6.3. En la tabla de álbumes el nombre del título no puede ser nulo.*/
alter table Discos.Concierto
alter column ciudad varchar(30);
alter table Discos.Stock
add CONSTRAINT DF_precio default(0) for precio;
alter table Discos.Album
alter column titulo varchar(100) not NULL;
/*7. Agregar los siguientes registros dentro de la base de datos creada:
- 3 artistas
- 2 conciertos por cada uno de los artistas en diferentes fechas y ciudades
- 2 álbumes por cada uno de los artistas
- Stock sólo de 2 álbumes de diferentes artistas */
insert into Discos.Artista(artno, nombre, clasificacion, bio, foto) values (1,'Taylor Swift', 'P','artista pop internacional', null),
(2,'Babasonicos', 'R','artista rock nacional', null),
(3,'Ariana grande', 'P','artista pop internacional', null);
insert into Discos.Concierto(artno, fecha, ciudad) values (1, '2023-11-11', 'Buenos Aires'),
(1, '2023-11-10', 'Buenos Aires'),
(2, '2024-06-14', 'Buenos Aires'),
(2, '2023-06-14', 'Buenos Aires'),
(3, '2015-10-23', 'Buenos Aires'),
(3, '2017-07-05', 'Buenos Aires');
insert into Discos.Stock(itemnro, tipo, precio,cantidad) values (1, 'P', 300.00, 250),
(2, 'P', 250.00, 250),
(3, 'R', 200.00, 250),
(4, 'R', 150.00, 250),
(5, 'P', 300.00, 250),
(6, 'P', 250.00, 330);
insert into Discos.Album(titulo, artno, itemnro) values ('The torture poets department', 1, 1),
('Folklore', 1, 2),
('Trinchera Avanzada', 2, 3),
('Irresponsables', 2, 4),
('Eternal sunshine', 3, 5),
('Positions', 3, 6);