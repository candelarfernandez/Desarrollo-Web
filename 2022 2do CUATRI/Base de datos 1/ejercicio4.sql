create schema if not exists ejercicio4;
use ejercicio4;

create table Persona(
nro_persona int primary key,
nombre varchar(50) not null,
calle varchar(100) not null,
ciudad varchar(60) not null,
nro_supervisor int,
foreign key (nro_supervisor) references Persona(nro_persona)
);

create table Empresa(
nro_empresa int primary key,
razon_social varchar(80),
calle varchar(100),
ciudad varchar(60)
);

create table Trabaja (
nro_persona int,
nro_empresa int,
salario double,
fecha_ingreso date not null,
primary key (nro_persona, nro_empresa),
foreign key (nro_persona) references Persona(nro_persona),
foreign key (nro_empresa) references Empresa (nro_empresa)
);

insert into Persona(nro_persona, nombre, calle, ciudad, nro_supervisor)
values(1, 'candela', 'sarratea 248', 'moron',1);
insert into Persona(nro_persona, nombre, calle, ciudad, nro_supervisor)
values(2, 'rocio', 'sarachaga 3161 ', 'caste', 2);
insert into Persona(nro_persona, nombre, calle, ciudad, nro_supervisor)
values(3, 'agostina', 'lincol 315', 'caste', 1);
insert into Persona(nro_persona, nombre, calle, ciudad, nro_supervisor)
values(4, 'candela', 'damico 2568', 'el palomar', 2);
insert into Persona(nro_persona, nombre, calle, ciudad, nro_supervisor)
values(5, 'florencia', 'damico 2568', 'el palomar', 2);

insert into Empresa(
nro_empresa, razon_social, calle, ciudad)
values(1, 'lili sa', 'rivadavia 4586', 'moron');
insert into Empresa(
nro_empresa, razon_social, calle, ciudad)
values(2, 'salgo', 'corrientes 45', 'caba');
insert into Empresa(
nro_empresa, razon_social, calle, ciudad)
values(3, 'ferroluc', 'cordoba 2332', 'banfield');
insert into Empresa(
nro_empresa, razon_social, calle, ciudad)
values(4, 'la tablada trucks', 'arieta 4567', 'san justo');
insert into Empresa(
nro_empresa, razon_social, calle, ciudad)
values(5, 'Banelco', 'arieta 4587', 'san justo');

insert into Trabaja(nro_persona, nro_empresa, salario, fecha_ingreso)
values (2, 4,250000.00,'20210512');
insert into Trabaja(nro_persona, nro_empresa, salario, fecha_ingreso)
values (1, 2,210000.00,'20220622');
insert into Trabaja(nro_persona, nro_empresa, salario, fecha_ingreso)
values (3, 2,180000.00,'20210802');
insert into Trabaja(nro_persona, nro_empresa, salario, fecha_ingreso)
values (4, 1,100000.00,'20220412');
insert into Trabaja(nro_persona, nro_empresa, salario, fecha_ingreso)
values (5, 5,120000.00,'20220412');

/*ejercicio1: Listar el nombre y ciudad de todas las personas que trabajan en la empresa
“Banelco”*/
select p.nombre, p.ciudad
from persona p
where exists(select 1 from trabaja t join empresa e on t.nro_empresa= e.nro_empresa
where e.razon_social='Banelco'
and p.nro_persona=t.nro_persona
);

/*ejercicio2: Listar el nombre, calle y ciudad de todas las personas que trabajan para la
empresa “Paulinas” y ganan más de $1500.*/
select p.nombre, p.calle, p.ciudad
from persona p
where exists (
select 1 from trabaja t join empresa e on t.nro_empresa= e.nro_empresa
where e.razon_social='Paulinas'
and t.salario>1500.0
and p.nro_persona=t.nro_persona
);
/*ejercicio3 Listar el nombre de personas que viven en la misma ciudad en la que se halla la
empresa en donde trabajan.
*/
select p.nombre
from persona p
where exists (select 1 from trabaja t join empresa e on t.nro_empresa= e.nro_empresa
where p.ciudad=e.ciudad);

/*ejercicio4 Listar número y nombre de todas las personas que viven en la misma ciudad y en
la misma calle que su superviso*/


/*ejercicio5 Listar el nombre y ciudad de todas las personas que ganan más que cualquier
empleado de la empresa “Tecnosur”*/
select p.nombre, p.ciudad
from persona p
where exists(
select 1 from trabaja t join empresa e on t.nro_empresa= e.nro_empresa
having t.salario > (MAX(t.salario) and e.razon_social = 'Mercosur'
));

/*ejercicio6 Listar las ciudades en las que todos los trabajadores que vienen en ellas ganan
más de $1000*/
select distinct p.ciudad 
from persona p 
where exists (select 1 from trabaja t where p.nro_persona=t.nro_persona
and t.salario > 1000);

/*ejercicio7 Listar el nombre de los empleados que hayan ingresado en mas de 4 Empresas en
el periodo 01-01-2000 y 31-03-2004
*/








