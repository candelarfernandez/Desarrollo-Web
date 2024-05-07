CREATE SCHEMA IF NOT EXISTS Ejercicio1;
USE Ejercicio1;

CREATE TABLE Almacen(
nro INT primary key,
nombre VARCHAR(40) not null,
responsable VARCHAR(40)
);

CREATE TABLE Articulo(
cod_art INT primary key,
descripcion VARCHAR(40),
precio decimal(9,2) not null
);

CREATE TABLE Material(
cod_mat INT primary key,
descripcion VARCHAR(40)
);

CREATE TABLE Proveedor(
cod_prov INT primary key,
nombre VARCHAR(40),
domicilio VARCHAR(40),
cod_ciu INT,
fecha_alta date not null
);

CREATE TABLE Ciudad(
cod_ciu INT primary key,
nombre VARCHAR(40)
);

ALTER TABLE Proveedor
ADD constraint FK_ciudad foreign key (cod_ciu) references Ciudad(cod_ciu);

CREATE TABLE Contiene(
nro INT not null,
cod_art INT not null,
primary key(nro, cod_art),
foreign key (nro) references Almacen(nro),
foreign key (cod_art) references Articulo(cod_art)
);

CREATE TABLE Compuesto_por(
cod_mat INT not null,
cod_art INT not null,
primary key(cod_mat, cod_art),
foreign key (cod_mat) references Material(cod_mat),
foreign key (cod_art) references Articulo(cod_art)
);

CREATE TABLE Provisto_por(
cod_mat INT not null,
cod_prov INT not null,
primary key(cod_mat, cod_prov),
foreign key (cod_mat) references Material(cod_mat),
foreign key (cod_prov) references Proveedor(cod_prov)
);

select *
from information_schema.table_constraints
where constraint_schema = 'ejercicio1';

INSERT INTO Almacen (nro, nombre, responsable) values (1, 'El chino', 'Esteban');
INSERT INTO Almacen (nro, nombre, responsable) values (2, 'VEA', 'Patricia');
INSERT INTO Almacen (nro, nombre, responsable) values (3, 'Dia', 'Candela');

INSERT INTO Articulo (cod_art, descrpcion, precio) values (1, 'A1', 20);
INSERT INTO Articulo (cod_art, descrpcion, precio) values (2, 'A2', 30);
INSERT INTO Articulo (cod_art, descrpcion, precio) values (3, 'A3', 40);

update Articulo set precio=100 where cod_art=1 or cod_art=3;

INSERT INTO Material (cod_mat, descripcion) values (1, 'M1');
INSERT INTO Material (cod_mat, descripcion) values (2, 'M2');
INSERT INTO Material (cod_mat, descripcion) values (3, 'M3');

INSERT INTO Ciudad (cod_ciu, nombre) values (1, 'CABA');
INSERT INTO Ciudad (cod_ciu, nombre) values (2, 'Moron');
INSERT INTO Ciudad (cod_ciu, nombre) values (3, 'San justo');

INSERT INTO Proveedor (cod_prov, nombre, domicilio, cod_ciu, fecha_alta) 
values (1, 'Alimentos SA', 'AV Rivadavia 1456', 1, '20180201');
INSERT INTO Proveedor (cod_prov, nombre, domicilio, cod_ciu, fecha_alta) 
values (2, 'Arcor', 'Florencio Varela 123', 3, '2022-10-04');
INSERT INTO Proveedor (cod_prov, nombre, domicilio, cod_ciu, fecha_alta) 
values (3, 'Mabe', 'Suipacha 2345', 2, '2001-10-04');

/*ejercicio1*/
select cod_art, precio, descripcion
from Articulo 
where precio BETWEEN 100 and 1000 and descrpcion LIKE 'A%';

/*ejercicio2*/
select *
from proveedor;

/*ejercicio3*/
select descripcion
from material
WHERE cod_mat IN (1,3,6,9,18);

/*ejercicio4*/
select cod_prov, nombre
from proveedor
where domicilio like '%Suipacha%'
AND fecha_alta >= '20010101'
AND fecha_alta < '20020101';

/*ejercicio5 listar los nombres de proveedores y su ciudad*/
select pr.nombre, c.nombre as "Ciudad"
from proveedor pr join ciudad c on pr.cod_ciu=c.cod_ciu;

/*ejercicio6 Listar los nombres de los proveedores de la ciudad de La Plata.
*/
select pr.nombre
from proveedor pr left join ciudad c on pr.cod_ciu= c.cod_ciu
where ciudad ="La Plata";

/*ejercicio7 Listar los números de almacenes que almacenan el artículo de descripción A.
*/
select distinct con.nro
from  contiene con left join articulo art on con.cod_art=art.cod_art
where art.descripcion = "A";

/*ejercicio8 Listar los materiales (código y descripción) provistos por proveedores de la ciudad
de Rosario*/
select pp.cod_mat, m.descripcion
from provisto_por pp join material m on pp.cod_mat=m.cod_mat
join proveedor p on pp.cod_prov=p.cod_prov
join ciudad c on p.cod_ciu=c.cod_ciu
where c.nombre="Rosario";

/*ejercicio9 Listar los nombres de los proveedores que proveen materiales para artículos
ubicados en almacenes que Martín Gómez tiene a su cargo.*/
select p.nombre
from proveedor p join provisto pp on pp.cod_prov=p.cod_prov
join compuesto_por cp on pp.cod_mat=cp.cod_mat
join articulo art on cp.cod_art=art.cod_art
join contiene c on art.cod_art=c.cod_art
join almacen al on c.nro=al.nro
where al.responsable="Martin Gomez";

/*ej12 12. Indicar la cantidad de proveedores que comienzan con la letra F.
*/
select count(*)
from proveedor p
where p.nombre like '%F';

/*13. Listar el promedio de precios de los artículos por cada almacén (nombre)
*/
select agv(art.precio)
from articulo art;

/*14. Listar la descripción de artículos compuestos por al menos 2 materiales.*/

select art.descripcion 
from articulo art join compuesto_por cp on cp.cod_art=art.cod_art
group by a.cod_art, a.descripcion
HAVING COUNT(*) >=2;

/*15. Listar cantidad de materiales que provee cada proveedor (código, nombre y
domicilio)*/
select p.cod, p.nombre, p.domicilio, COUNT(pp.cod_mat) as 'cantidad materiales'
from proveedor p left join provisto_por pp on pp.cod_prov=p.cod_prov
group by p.cod_prov, p.nombre, p.domicilio;

/*16. Cuál es el precio máximo de los artículos que proveen los proveedores de la ciudad
de zarate*/
select MAX(art.precio)
from proveedor p left join provisto_por pp on pp.cod_prov=p.cod_prov
join compuesto_por cp on pp.cod_mat=cp.cod_mat
join articulo art on cp.cod_art=art.cod_art
join ciudad c on art.cod_ciu=c.cod_ciu
where c.nombre='Zarate';


