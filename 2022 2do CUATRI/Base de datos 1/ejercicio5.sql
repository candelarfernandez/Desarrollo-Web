create schema if not exists ejercicio5;
use ejercicio5;
drop schema ejercicio5;

create table Auto(
patente varchar(50) primary key not null,
modelo varchar(50) not null,
año date not null
);
alter table Auto modify año varchar(50) not null;

create table Cliente(
nro_cliente int primary key,
nombre varchar(60) not null,
domicilio varchar(60) not null,
localidad varchar(60) not null 
);

create table Chofer(
nro_chofer int primary key,
nombre varchar(60) not null,
fecha_ingreso date not null,
telefono int
);

create table Viaje(
nro_chofer int,
nro_cliente int,
patente varchar(50) not null,
fecha date not null, 
km_totales double,
tiempo_espera double,
primary key(nro_chofer, nro_cliente, patente, fecha),
foreign key (nro_chofer) references Chofer(nro_chofer),
foreign key (nro_cliente) references Cliente(nro_cliente),
foreign key (patente) references Auto(patente)
);
alter table Viaje add costo double;

insert into Auto(patente, modelo, año) values ('ARG123', 'volks','2015');
insert into Auto(patente, modelo, año) values ('CVD177', 'fitito','2009');
insert into Auto(patente, modelo, año) values ('MTM869', 'tcross','2004');
insert into Auto(patente, modelo, año) values ('KEV444', 'celta','2019');
insert into Auto(patente, modelo, año) values ('AGT122', 'celta','2005');

insert into Chofer(nro_chofer, nombre, fecha_ingreso, telefono) values (1,'candela', '20210112',1131646604);
insert into Chofer(nro_chofer, nombre, fecha_ingreso, telefono) values (2,'micaela', '20190310',1131648805);
insert into Chofer(nro_chofer, nombre, fecha_ingreso, telefono) values (3,'fernanda', '20090819',1137686201);
insert into Chofer(nro_chofer, nombre, fecha_ingreso, telefono) values (4,'rocio', '20150501',1131452104);

insert into Cliente(nro_cliente, nombre, domicilio, localidad) values (1,'Liliana','Colombia 245', 'San justo');
insert into Cliente(nro_cliente, nombre, domicilio, localidad) values (2,'Guadalupe','Chenaut 315', 'Villa Luzuriaga');
insert into Cliente(nro_cliente, nombre, domicilio, localidad) values (3,'Agostina','Colonia 1583', 'Villa Luzuriaga');
insert into Cliente(nro_cliente, nombre, domicilio, localidad) values (4,'Florencia','Pellegrini 243', 'Moron');

insert into Viaje(nro_chofer, nro_cliente, patente, fecha, km_totales, tiempo_espera) 
values(1,2,'ARG123','20220501',15.0,15.06,25.0);
insert into Viaje(nro_chofer, nro_cliente, patente, fecha, km_totales, tiempo_espera) 
values(1,3,'ARG123','20220825',05.0,05.07);
insert into Viaje(nro_chofer, nro_cliente, patente, fecha, km_totales, tiempo_espera) 
values(3,1,'MTM869','20220917',03.5,20.05);
insert into Viaje(nro_chofer, nro_cliente, patente, fecha, km_totales, tiempo_espera) 
values(4,3,'KEV444','20221023',10.0,4.07);
insert into Viaje(nro_chofer, nro_cliente, patente, fecha, km_totales, tiempo_espera) 
values(1,4,'AGT122','20221015',10.0,8.07);
insert into Viaje(nro_chofer, nro_cliente, patente, fecha, km_totales, tiempo_espera) 
values(2,4,'ARG123','20221015',10.0,8.07);
insert into Viaje(nro_chofer, nro_cliente, patente, fecha, km_totales, tiempo_espera) 
values(2,4,'KEV444','20221015',10.0,8.07);
insert into Viaje(nro_chofer, nro_cliente, patente, fecha, km_totales, tiempo_espera) 
values(3,4,'MTM869','20221015',10.0,8.07);
insert into Viaje(nro_chofer, nro_cliente, patente, fecha, km_totales, tiempo_espera) 
values(3,4,'CVD177','20221015',10.0,8.07);


/*Cuál es el tiempo de espera promedio de los viajes del año 2005?*/
select avg(v.tiempo_espera) as 'promedio_tiempo_espera'
from viaje v 
where exists (select 1 from auto a where v.patente= a.patente
and a.año='2005'
);

/*Listar el nombre de los clientes que hayan viajado en todos los autos*/
select c.nombre
from cliente c
where not exists(select 1 from auto a
where not exists(select 1 from viaje v
where c.nro_cliente = v.nro_cliente
and v.patente=a.patente
));


/*Listar nombre y teléfono de los choferes que no manejaron algún vehículo de
modelo posterior al año 2010.
*/
select ch.nombre, ch.telefono
from chofer ch
where exists(
select 1 from viaje v left join auto a on v.patente=a.patente
where a.año<'2010' 
and ch.nro_chofer=v.nro_chofer
);

/*ejercicio4 Listar los kilómetros realizados en viajes por cada auto (patente y modelo)*/
select v.km_totales, a.patente, a.modelo
from auto a left join viaje v on v.patente=a.patente
group by v.km_totales, a.patente, a.modelo;

/*ejercicio5 Mostrar el el costo promedio de los viajes realizados por cada auto (patente), para
viajes de clientes de la localidad de Ramos Mejía*/
select avg(v.costo) as 'Promedio', v.patente
from viaje v 
left join auto a on v.patente=a.patente
left join cliente c on v.nro_cliente=c.nro_cliente
where c.localidad='Villa luzuriaga';


/*ejericico6 Listar el costo total de los viajes realizados por cada chofer (número y nombre)
cuyo nombre comienza con la letra A*/
select SUM(v.costo) as 'Suma_viajes', ch.nro_chofer, ch.nombre
from viaje v, chofer ch
where ch.nombre  like 'C%';

/*ejercicio7 Mostrar la fecha de ingreso, el nombre del chofer y nombre de cliente, que hayan
realizado el viaje más largo de la historia.*/
select ch.fecha_ingreso, ch.nombre as nombre_chofer, c.nombre as nombre_cliente
from chofer ch, cliente c
where exists(select 1 from viaje v where ch.nro_chofer=v.nro_chofer
and c.nro_cliente=v.nro_cliente
and v.km_totales =(select max(vi.km_totales)from viaje vi));
