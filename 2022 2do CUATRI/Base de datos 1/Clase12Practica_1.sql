CREATE SCHEMA if NOT EXISTS clase12Practica;
use clase12Practica;

create table Almacen(nro int primary key,
nombre varchar(40) not null,
responsable varchar(40) not null);

create table Articulo(
cod_art int primary key,
descripcion varchar(40) not null,
precio decimal(7,2)); -- hacerlo not null

create table Material(cod_mat int primary key,
descripcion varchar(40) not null);

create table ciudad(cod_ciu int primary key,
nombre varchar(40) not null);

create table proveedor(cod_prov int primary key,
nombre varchar(40) not null,
domicilio varchar(40) not null,
cod_ciu int references ciudad(cod_ciu),
f_alta date not null);

CREATE TABLE contiene (
    nro INT references Almacen(nro),
    cod_art INT references articulo(cod_art),
    PRIMARY KEY (nro , cod_art));
    
  
    
    create table Compuesto_por(cod_art int references Articulo(cod_art),
    cod_mat int references Material(cod_mat),
    constraint pk_compuesto_por primary key(cod_art,cod_mat));
    
  
    
    create table Provisto_por(cod_mat int references Material(cod_mat),
    cod_prov int references proveedor (cod_prov),
    constraint pk_Porvisto_por primary key(cod_prov,cod_mat));
    
    SELECT 
    *
FROM
    information_schema.table_constraints
WHERE
    constraint_schema = 'ejercicio1_practica';   
    
    insert into Almacen (nro,nombre,responsable) values (1,'el chino','esteban');
    insert into Almacen (nro,nombre,responsable) values (2,'VEA','PATRICIA');
    insert into Almacen (nro,nombre,responsable) values (3,'CARREFOUR','esteban');
    insert into Almacen (nro,nombre,responsable) values (4,'JUMBO','esteban');

update Almacen set nombre = 'Fifo' where nro = 2;
    
    INSERT INTO Articulo (cod_art,descripcion,precio) values (1,'A1',20);
    INSERT INTO Articulo (cod_art,descripcion,precio) values (2,'A2',30);
    INSERT INTO Articulo (cod_art,descripcion,precio) values (3,'A3',40);
    
    -- actualizar datos de una tabla
    update Articulo set precio = 100 where cod_art = 1 or cod_art = 3;
	-- update Articulo set precio = 100 where cod_art in (1,3);
    
      insert into Compuesto_por (cod_art, cod_mat) values
    (1,2), (2,1), (3,2);
    
	insert into contiene (nro, cod_art) values 
    (10, 2) ,(11,1), (12,3);
    
    insert into Material (cod_mat,descripcion) values (1,'M1');
    insert into Material (cod_mat,descripcion) values (2,'M2');
    insert into Material (cod_mat,descripcion) values (3,'M3');
    
    -- otra forma de insert
    
    insert into Ciudad (cod_ciu, nombre) values (1,'CABA');
    insert into Ciudad (cod_ciu, nombre) values (2,'CABA');
    insert into Ciudad (cod_ciu, nombre) values (3,'MORON');
    insert into Ciudad (cod_ciu, nombre) values (4,'MERLO');
    insert into Ciudad (cod_ciu, nombre) values (5,'La Plata');
    insert into Ciudad (cod_ciu, nombre) values (6,'ROSARIO');

    
    insert into proveedor (cod_prov, nombre, domicilio, cod_ciu, f_alta)
    values (1,'Alimentos','Av. Rivadavia 1456',1,'2022-10-04');
     insert into proveedor (cod_prov, nombre, domicilio, cod_ciu, f_alta)
    values (2,'Bebidas','Suipacha 2022',3,'2001-10-04');
      insert into proveedor (cod_prov, nombre, domicilio, cod_ciu, f_alta)
    values (3,'Bebidas','Suipacha 25',3,'2008-10-04');
    insert into proveedor (cod_prov, nombre, domicilio, cod_ciu, f_alta)
    values (4,'Limpieza','Suipacha 25',5,'2008-10-04');
    insert into proveedor (cod_prov, nombre, domicilio, cod_ciu, f_alta)
    values (5,'Comida Perro','Av. Rivadavia 1456',6,'2022-10-04');
    insert into proveedor (cod_prov, nombre, domicilio, cod_ciu, f_alta)
    values (6,'Comida Perro','Av. Rivadavia 1456',6,'2022-10-04');
    
    
    insert into provisto_por (cod_mat, cod_prov) values (1,6),(2,5),(3,6);
    


/* consulta 1: Listar los números de artículos cuyo precio se encuentre entre $100 y $1000 y su
descripción comience con la letra A.*/ 
select cod_art, precio, descripcion
from Articulo
where precio between 100 and 1000 and descripcion like 'A%';

/* consulta 2: Listar todos los datos de todos los proveedores.*/
select *
from proveedor;

/*consulta 3: Listar la descripción de los materiales de código 1, 3, 6, 9 y 18.*/
select descripcion
from Material
where cod_mat in (1,3,6,9,18);

/*consulta 4: Listar código y nombre de proveedores de la calle Suipacha, que hayan sido dados
de alta en el año 2001.*/
select cod_prov, nombre
from proveedor
where domicilio like '%Suipacha%' and year (f_alta) = 2001;/*f_alta between '2001-01-01' and '2001-12-31'*/



-- 5) Listar nombre de todos los proveedores y de su ciudad 

SELECT p.nombre, c.nombre as "Ciudad"
FROM proveedor p LEFT JOIN ciudad c ON p.cod_ciu = c.cod_ciu;

-- 6) Listar los nombres de los proveedores de la ciudad de La Plata

select pr.nombre,  c.nombre as "Ciudad" 
from proveedor pr join ciudad c on pr.cod_ciu = c.cod_ciu
where c.nombre like '%La Plata';
-- c.nombre = 'La Plata'

-- 7) Listar los números de almacenes que almacenan el artículo de descripción A

select distinct a.nro
from almacen a join contiene c on 
a.nro = c.nro join 
articulo ar on ar.cod_art = c.cod_art
WHERE ar.descripcion = 'A%'; 

SELECT DISTINCT tie.nro
 FROM contiene tie JOIN articulo art on (tie.cod_art = art.cod_art)
 WHERE art.descripcion = 'A%'; 

-- 8) Listar los materiales (código y descripción) provistos por proveedores de la ciudad de Rosario

select distinct m.cod_mat , m.descripcion
from material m 
join provisto_por pp on m.cod_mat = pp.cod_mat
join proveedor p on pp.cod_prov = p.cod_prov
join ciudad c on p.cod_ciu = c.cod_ciu
where c.nombre like 'ROSARIO';

-- 9) Listar los nombres de los proveedores que proveen materiales para artículos
-- ubicados en almacenes que Martín Gómez tiene a su cargo

select distinct p. cod_prov, p.nombre 
from proveedor p 
join provisto_por pp on p.cod_prov = pp.cod_prov
JOIN compuesto_por cp ON cp.cod_mat = pp.cod_mat
JOIN contiene tie ON tie.cod_art = cp.cod_art
JOIN almacen alm ON alm.nro = tie.nro
WHERE alm.responsable like '%esteban';

/*12. Indicar la cantidad de proveedores que comienzan con la letra F*/

select count(*) as 'Cant_prov'
from proveedor p 
where p.nombre like 'F%';

/*13.“Listar el promedio de precios de los artículos por cada almacén (nombre)*/
select al.nombre, AVG(art.precio)
FROM almacen al join contiene con on al.nro=con.nro
join articulo art on con.cod_art=art.cod_art
group by al.nro, al.nombre;

/*14.“Listar la descripción de artículos compuestos por al menos 2 materiales”
*/
select art.descripcion
from articulo art join compuesto_por cp on art.cod_art=cp.cod_art
group by art.cod_art, art.descripcion
HAVING COUNT(*)>=2;

/*15.“Listar cantidad de materiales que provee cada proveedor (código, nombre y domicilio)”*/
select p.cod_prov, p.nombre, p.domicilio, count(m.cod_mat) as 'cant_mat'
from proveedor p left join provisto_por pp on p.cod_prov=pp.cod_prov
left join material m on pp.cod_mat=m.cod_mat
group by p.cod_prov, p.nombre, p.domicilio;

/*select p.cod_prov, p.nombre, p.domicilio, count(pp.cod_mat) as 'cant_mat'
from proveedor p join provisto_por pp on p.cod_prov=pp.cod_prov
group by p.cod_prov, p.nombre, p.domicilio; */ /*OPCION PERO AMBOS DAN EL MISMO RESULT*/

/*16. Cuál es el precio máximo de los artículos que proveen los proveedores de la
ciudad de Zárate*/
select MAX( art.precio)
from proveedor p join provisto_por pp on p.cod_prov=pp.cod_prov
join compuesto_por cp on pp.cod_mat=cp.cod_mat
join articulo art on cp.cod_art=art.cod_art
join ciudad c on p.cod_ciu= c.cod_ciu
where c.nombre='CABA';

/*17.Listar los nombres de aquellos proveedores que no proveen ningún material”
*/
select p.nombre
from proveedor p left join provisto_por pp on p.cod_prov=pp.cod_prov
left join material m on pp.cod_mat=m.cod_mat
group by p.cod_prov, p.nombre
having count(m.cod_mat)=0;



