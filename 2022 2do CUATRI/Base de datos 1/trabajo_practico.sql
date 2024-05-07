CREATE SCHEMA IF NOT EXISTS trabajo_practico;
use trabajo_practico;

create table Ranking(
id_ranking int primary key auto_increment,
id_influencer int /*foreign key de influencer*/
);

 create table Tipo (
 id_tipo int primary key auto_increment,
 descripcion varchar(40) not null,
 id_ranking int, /*foregin key de ranking*/
 foreign key (id_ranking) references Ranking(id_ranking)
 );
 
 create table Lista_compra(
 id_lista int primary key,
 descripcion varchar(60) not null);
 
 create table Frecuencia(
 id_frecuencia int primary key,
 frecuencia varchar(50)
 );
 
create table Menu(
id_menu int primary key auto_increment,
id_frecuencia int, /*foreign key  de frecuencia*/
id_lista int, /*foreign key de lista compra*/
fecha_desde date not null,
fecha_hasta date not null,
foreign key (id_frecuencia) references Frecuencia(id_frecuencia),
foreign key (id_lista) references Lista_Compra(id_lista)
);

 create table Comensal(
 id_comensal int primary key auto_increment,
 fech_nac date not null,
 cantidad int,
 id_menu int,
 foreign key (id_menu) references Menu(id_menu)
 );
 
 create table Marca(
 id_marca int primary key,
 nombre varchar(50) 
 );
 
 create table Ingredientes(
 id_ingredientes int primary key,
 foto varchar(50) not null,
 nombre varchar(50) not null,
 cantidad int,
 nombre_comercial varchar(50) not null,
 precio double,
 id_alternativo int, /*foreign key de alternativo*/
 id_marca int, /*foreign key de marca*/
 foreign key (id_marca) references Marca(id_marca),
 foreign key (id_alternativo) references Ingredientes(id_ingredientes)
 );
 
 create table Pasos(
 id_receta int,
 id_pasos int, /*fk de receta*/
 acciones varchar(100),
 primary key (id_receta, id_pasos)
 /*foreign key (id_receta) references Receta(id_receta)*/
 );
 
 /*tabla ranking*/
 insert into Ranking(id_ranking, id_influencer) 
values (1,1);
 insert into Ranking(id_ranking, id_influencer) 
values (2,4);
 insert into Ranking(id_ranking, id_influencer) 
values (3,3);
 insert into Ranking(id_ranking, id_influencer) 
values (4,2);

/*tabla tipo*/
 insert into Tipo(id_tipo, descripcion, id_ranking) 
values (1, 'desayuno', 3);
 insert into Tipo(id_tipo, descripcion, id_ranking) 
values (2, 'cena', 4);
 insert into Tipo(id_tipo, descripcion, id_ranking) 
values (3, 'cena', 1);
 insert into Tipo(id_tipo, descripcion, id_ranking) 
values (4, 'almuerzo', 2);

/*tabla lista compra*/
 insert into Lista_compra(id_lista, descripcion) 
values (1, 'azucar, galletitas');
 insert into Lista_compra(id_lista, descripcion) 
values (2, 'fideos, manteca');
 insert into Lista_compra(id_lista, descripcion) 
values (3, 'harina, levadura');
 insert into Lista_compra(id_lista, descripcion) 
values (4, 'queso, pan');

/*tabla frecuencia*/
 insert into Frecuencia(id_frecuencia, frecuencia) 
values (1, 'semanal');
 insert into Frecuencia(id_frecuencia, frecuencia) 
values (2, 'semanal');
 insert into Frecuencia(id_frecuencia, frecuencia) 
values (3, 'diario');
 insert into Frecuencia(id_frecuencia, frecuencia) 
values (4, 'quincenal');

/*tabla menu*/
 insert into Menu(id_menu, id_frecuencia, id_lista, fecha_desde, fecha_hasta) 
values (1, 2, 1, '20221029', '20230504' );
 insert into Menu(id_menu, id_frecuencia, id_lista, fecha_desde, fecha_hasta) 
values (2, 4, 3, '20221115', '20230302' );
 insert into Menu(id_menu, id_frecuencia, id_lista, fecha_desde, fecha_hasta) 
values (3, 1, 2, '20220520', '20230401' );
 insert into Menu(id_menu, id_frecuencia, id_lista, fecha_desde, fecha_hasta) 
values (4, 3, 4, '20220101', '20230204' );

/*tabla comensal*/
 insert into Comensal(id_comensal, fech_nac, cantidad, id_menu) 
values (1, '19670102', 4, 1);
 insert into Comensal(id_comensal, fech_nac, cantidad, id_menu) 
values (2, '19900708', 8, 3);
 insert into Comensal(id_comensal, fech_nac, cantidad, id_menu) 
values (3, '20050904', 3, 3);
 insert into Comensal(id_comensal, fech_nac, cantidad, id_menu) 
values (4, '20021023', 2, 2);

/*tabla marca*/
insert into Marca(id_marca, nombre) 
values (1, 'La serenisima');
insert into Marca(id_marca, nombre) 
values (2, 'Sancor');
insert into Marca(id_marca, nombre) 
values (3, 'Arcor');
insert into Marca(id_marca, nombre) 
values (4, 'Veronica');

/*tabla ingredientes*/
insert into Ingredientes(id_ingredientes, foto, nombre, cantidad,
 nombre_comercial, precio, id_alternativo, id_marca) 
values (1, 'dos','fideos de trigo', 4, 'fideos luchetti', 145.0, 1,1);
insert into Ingredientes(id_ingredientes, foto, nombre, cantidad,
 nombre_comercial, precio, id_alternativo, id_marca) 
values (2, 'dos','harina integral', 2, 'harina int', 100.0, 2,2);
insert into Ingredientes(id_ingredientes, foto, nombre, cantidad,
 nombre_comercial, precio, id_alternativo, id_marca) 
values (3, 'uno','yogur', 5, 'yogurisimo', 110.0, 3,1);
insert into Ingredientes(id_ingredientes, foto, nombre, cantidad,
 nombre_comercial, precio, id_alternativo, id_marca) 
values (4, 'uno','queso crema', 1, 'finlandia', 300.0, 4,4);

/*tabla pasos*/
insert into Pasos(id_receta, id_pasos, acciones) 
values (1, 1, 'Batir');
insert into Pasos(id_receta, id_pasos, acciones) 
values (4, 2, 'Al horno');
insert into Pasos(id_receta, id_pasos, acciones) 
values (3, 3, 'Cremar');
insert into Pasos(id_receta, id_pasos, acciones) 
values (1, 4, 'Tostar');



