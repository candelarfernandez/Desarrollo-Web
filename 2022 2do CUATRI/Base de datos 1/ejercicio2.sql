CREATE SCHEMA IF NOT exists ejercicio2;
use ejercicio2;

CREATE TABLE Vuelo (
nro_vuelo int primary key,
desde varchar(50),
hasta varchar(50),
fecha date not null
);

CREATE TABLE Avion (
nro_avion int primary key,
tipo_avion varchar(50),
modelo varchar(50)
);

CREATE TABLE Pasajero(
nro_vuelo int,
documento int,
nombre varchar(50),
primary key (nro_vuelo, documento),
foreign key(nro_vuelo) references Vuelo(nro_vuelo)
);
ALTER TABLE Vuelo ADD COLUMN nro_avion int;
ALTER TABLE Vuelo ADD FOREIGN KEY (nro_avion) references Avion(nro_avion);

insert into Avion (nro_avion, tipo_avion, modelo) values (1, 'nuevo','a-25');
insert into Avion (nro_avion, tipo_avion, modelo) values (2, 'viejo','b-83');
insert into Avion (nro_avion, tipo_avion, modelo) values (3, 'nuevo','d-45');
insert into Avion (nro_avion, tipo_avion, modelo) values (4, 'nuevo','B-777');

insert into Vuelo (nro_vuelo, desde, hasta, fecha, nro_avion) values (1, 'buenos aires','madrid','20220802',1);
insert into Vuelo (nro_vuelo, desde, hasta, fecha, nro_avion) values (2, 'cordoba','montevideo','20220903',1);
insert into Vuelo (nro_vuelo, desde, hasta, fecha, nro_avion) values (3, 'lima','miami','20220504',2);
insert into Vuelo (nro_vuelo, desde, hasta, fecha, nro_avion) values (4, 'A','F','20220104',3);
insert into Vuelo (nro_vuelo, desde, hasta, fecha, nro_avion) values (5, 'A','D','20220104',1);
insert into Vuelo (nro_vuelo, desde, hasta, fecha, nro_avion) values (6, 'C','D','20220404',2);
insert into Vuelo (nro_vuelo, desde, hasta, fecha, nro_avion) values (7, 'C','5','20220404',1);
insert into Vuelo (nro_vuelo, desde, hasta, fecha, nro_avion) values (8, 'C','H','20220404',1);
insert into Vuelo (nro_vuelo, desde, hasta, fecha, nro_avion) values (9, 'G','H','20220404',4);

insert into Pasajero (nro_vuelo, documento, nombre) values (2, 44424896,'candela');
insert into Pasajero (nro_vuelo, documento, nombre) values (3, 21535991,'liliana');
insert into Pasajero (nro_vuelo, documento, nombre) values (1, 18257959,'nito');
insert into Pasajero (nro_vuelo, documento, nombre) values (5, 18257959,'nito');
insert into Pasajero (nro_vuelo, documento, nombre) values (9, 18257959,'flor');

/*ejercicio1*/
select v.nro_vuelo
from Vuelo v
where v.desde like 'A%' and v.hasta like 'F%';

/*ejercicio2*/
select p.nombre, p.nro_vuelo
from pasajero p left join vuelo v on p.nro_vuelo=v.nro_vuelo
where v.desde like 'A%' and v.hasta like 'D%';

/*ejercicio3*/
select a.tipo_avion
from avion a left join vuelo v on a.nro_avion=v.nro_avion
where v.desde like 'C%';

/*ejercicio4*/
select a.tipo_avion, a.nro_avion
from avion a left join vuelo v on a.nro_avion=v.nro_avion
where v.hasta like 'H%'
group by a.tipo_avion, a.nro_avion;

/*ejercicio5*/
select a.nro_avion, a.modelo, COUNT(v.nro_vuelo) as 'cant_vuelos'
from avion a left join vuelo v on a.nro_avion=v.nro_avion
group by a.nro_avion, a.modelo;

/*ejercicio6*/
select count(*) as 'cantidad_pasajeros'
from pasajero p left join vuelo v on p.nro_vuelo=v.nro_vuelo
left join avion a on v.nro_avion=a.nro_avion
where a.modelo = 'B-777';

/*ejercicio7*/

select avion.tipo_avion, avg(AA.cant_pasajeros) as promedioCantidadPasajeros
from (
    select nro_vuelo, count(*) as cant_pasajeros
    from pasajero
    group by nro_vuelo
    ) AA join Vuelo on AA.nro_vuelo=Vuelo.nro_vuelo
    join Avion on Avion.nro_avion= Vuelo.nro_avion
group by Avion.tipo_avion

/*ejercicio8*/


