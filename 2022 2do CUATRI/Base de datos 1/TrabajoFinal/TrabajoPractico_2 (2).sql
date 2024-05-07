CREATE SCHEMA IF NOT EXISTS TrabajoPracticoFinal;
USE TrabajoPracticoFinal;


CREATE TABLE IA(
codigo int primary key,
nombre varchar(40) not null,
url int not null,
algoritmo varchar(40) not null,
lista_seguidos int 
);

CREATE TABLE red_social(
id_red_social int primary key not null,
descripcion varchar(40) not null,
cod_ia int references IA(codigo)
);


CREATE TABLE Influencer(
id_influencer int primary key not null,
porcentaje_nutricion decimal (9.7) not null,
nombre varchar(40) not null,
cuenta varchar(40) not null,
id_red_social int references red_social(id_red_social)
);

CREATE TABLE Fuentes(
id_fuentes int primary key not null,
descripcion varchar(40) not null,
cod_ia int references IA(codigo)
);

CREATE TABLE Tipo_coccion(
id_tipo_coccion int primary key not null,
descripcion varchar(40) not null
);

CREATE TABLE Receta(
id_receta int primary key not null,
comentario varchar(40) not null,
tiempo decimal(9.7) not null,
dato varchar(500) not null,
id_fuentes int references Fuentes(id_fuentes),
id_marca int references Marca(id_marca),
id_tipo_coccion int references Tipo_coccion(id_tipo_coccion),
id_tipo_receta int references Tipo_receta(id_tipo_receta),
id_influencer int references Influencer(id_influencer),
precio decimal (9.7) not null,
nivel  varchar(40) not null
);

create table Ranking(
id_ranking int primary key not null auto_increment,
id_influencer int references Influencer(id_influencer)
);

 create table Tipo (
 id_tipo_comida int primary key not null auto_increment,
 descripcion varchar(40) not null,
 id_ranking int, /*foregin key de ranking*/
 foreign key (id_ranking) references Ranking(id_ranking)
 );
 
 create table Lista_compra(
 id_lista_compra int primary key not null,
 descripcion varchar(60) not null);
 
 CREATE TABLE Comida(
id_comida int primary key not null,
precio decimal(9.7) not null,
id_tipo_comida int references Tipo(tipo_comida)
);

 create table Frecuencia(
 id_frecuencia int primary key not null,
 frecuencia varchar(50) not null
 );
 
create table Menu(
id_menu int primary key auto_increment,
id_frecuencia int,
id_lista int,
fecha_desde date not null,
fecha_hasta date not null,
inflacion decimal(9,7),
precio decimal(9,7),
foreign key (id_frecuencia) references Frecuencia(id_frecuencia),
foreign key (id_lista) references Lista_compra(id_lista_compra)
);


 create table Comensal(
 id_comensal int primary key auto_increment,
 fech_nac date not null,
 cantidad int,
 id_menu int,
 id_tipo_receta int references Tipo_receta(id_tipo_receta),
 foreign key (id_menu) references Menu(id_menu)
 );
 
 CREATE TABLE Tipo_receta(
id_tipo_receta int primary key not null,
descripcion varchar(40) not null
);

 create table Marca(
 id_marca int primary key,
 nombre varchar(50) not null
 );
 
 create table Ingredientes(
 id_ingredientes int primary key,
 foto varchar(50) not null,
 nombre varchar(50) not null,
 cantidad int,
 nombre_comercial varchar(50) not null,
 precio decimal (9.7),
 id_alternativo int references Ingredientes(id_ingredientes),
 id_marca int references Marca(id_marca)
 );
 
 CREATE TABLE Pasos(
 id_receta int references Receta(id_receta),
 id_pasos int not null,
 acciones varchar(40),
 primary key (id_receta,id_pasos)
 );

 
 CREATE TABLE Preparacion(
 id_preparacion int primary key not null,
 video boolean not null,
 tiempo int not null
 );
 
 CREATE TABLE Influencer_ranking(
 id_influencer int references Influencer(id_influencer),
 id_ranking int references Ranking(id_ranking),
 primary key(id_influencer,id_ranking)
 );
 
 CREATE TABLE Receta_comida(
 id_receta int references Receta(id_receta),
 id_comida  int references Comida (id_comida),
 porciones int not null,
 primary key ( id_receta ,id_comida)
 );
 
 CREATE TABLE Comida_comensal(
 id_comida  int references Comida (id_comida),
 id_comensal int references Comensal(id_comensal),
 cantidad int not null,
 primary key(id_comida,id_comensal)
 );
 
 CREATE TABLE Receta_menu(
 id_receta int references Receta(id_receta),
 id_menu int references Menu (id_menu),
 primary key (id_receta, id_menu)
 );
 
 CREATE TABLE Menu_comida(
 id_comida  int references Comida (id_comida),
 id_menu int references Menu (id_menu),
 primary key(id_comida,id_menu)
 );
 
 CREATE TABLE Ingredientes_lista_compra(
 id_ingredientes int references Ingredientes(id_ingredientes),
 id_lista_compra int references Lista_compra(id_lista_compra),
 comprado boolean,
 cantidad int,
 primary key (id_ingredientes, id_lista_compra)
 );

 
 CREATE TABLE Integra(
 id_red_social int references Red_social(id_red_social),
 id_fuentes int references Fuentes(id_fuentes),
id_influencer int references Influencer(id_influencer),
primary key(id_red_social,id_fuentes,id_influencer)
 );
 
 CREATE TABLE Lleva(
 id_pasos int references Pasos(id_pasos),
 id_receta int references Pasos(id_receta),
 id_preparacion int references Preparacion(id_preparacion),
 id_ingredientes int references Ingredientes(id_ingredientes),
primary key (id_pasos,id_receta,id_preparacion,id_ingredientes)
 );

 
 /*tabla ia*/
 insert into IA(codigo, nombre, url, algoritmo, lista_seguidos)
 values (1, "a-1", 123,"primer algoritmo",25),(2, "a-2", 456, "segundo algoritmo",25),(3, "a-3", 789, "tercer algoritmo",25),(4, "a-4", 101112,"cuartor algoritmo",25);
 
 /*tabla red social*/
 insert into red_social (id_red_social, descripcion, cod_ia) 
values (1,'Instagram',2) ,(2,'Instagram',1),(3,'Instagram',4), (4,'Instagram',3);

/*tabla influencer*/
insert into influencer (id_influencer, porcentaje_nutricion, nombre, cuenta, id_red_social)
values (1,40.0,'Rocio','@rochiiespa',2),(2,65.0,'Cande','@candelafernandez',3), (3,25.0,'Luchi','@luchi_murillo',4),
(4,50.0,'Brenda','@bren_bustos',1);

/*tabla de fuentes*/
insert into fuentes (id_fuentes,descripcion,cod_ia)
values (121, 'publicacion', 101), (122, 'reels', 102), (123, 'reels', 103), (124, 'historia', 104);

/*tabla de coccion*/
insert into tipo_coccion (id_tipo_coccion, descripcion) values
(11, 'sofreir'), (12, 'horno'), (13, 'guisar'), (14, 'plancha'),(15, 'vapor');


insert into receta (id_receta, comentario, tiempo, dato,id_fuentes,id_marca,id_tipo_coccion,id_tipo_receta,id_influencer,precio, nivel)
values (114,'Albondigas de Pollo',32.0,'una receta muy sencilla, nutritiva y ligera.',121,2,11,33,1,1000.0,'intermedio'),
(112,'Lasagna de verduras al horno',50.0,' Aunque lo más habitual es prepararla con carne picada, esta es versión más saludable y apta también para vegetarianos.',122,4,12,55,2,960.0,'experto'),
(113,'Lomo salteado peruano',44.0,'Esta es una de las recetas de carne más elaboradas en Perú, su país de origen.',124,1,14,44,1,1030.0,'facil');

update receta set dato = 'nutritivo' where id_receta =113;  
update receta set dato = 'poco nutritivo' where id_receta =112; 
update receta set dato = 'altamente nutritivo' where id_receta =114; 


 /*tabla ranking*/
 insert into Ranking(id_ranking, id_influencer) 
values (1,1);
 insert into Ranking(id_ranking, id_influencer) 
values (2,4);
 insert into Ranking(id_ranking, id_influencer) 
values (3,3);
 insert into Ranking(id_ranking, id_influencer) 
values (4,2);

/*tabla tipo_comida*/
insert into Tipo(descripcion,id_ranking)  
values ('desayuno', 3),  ('cena', 4), ('cena', 1), ('almuerzo', 2);


/*tabla lista compra*/
 insert into Lista_compra(id_lista_compra, descripcion) 
values (1, 'azucar, galletitas'), (2, 'fideos, manteca'), (3, 'harina, levadura'), (4, 'queso, pan');

/*tabla de comida*/
insert into comida (id_comida, precio, id_tipo_comida) values
(110, 1450.0, 4), (120, 1050.0, 1), (130, 2450.0, 3), (140, 1850.0, 4);

/*tabla frecuencia*/
 insert into Frecuencia(id_frecuencia, frecuencia) 
values (1, 'semanal'), (2, 'semanal'), (3, 'diario'), (4, 'quincenal');

DELETE FROM frecuencia WHERE (id_frecuencia = '2');
UPDATE menu SET id_frecuencia = '1' WHERE (id_menu = '1');

/*tabla menu*/ -- AGREGAR PRECIO A MENU!!!!!
 insert into Menu(id_menu, id_frecuencia, id_lista, fecha_desde, fecha_hasta, inflacion, precio)  
values (1, 1, 1, '20221029', '20230504',0.3,14.0), (2, 4, 3, '20221115', '20230302',0.0,15.0),
(3, 1, 2, '20220520', '20230401',0.5,20.0), (4, 3, 4, '20220101', '20230204',0.2,12.0);

/*tabla comensal*/
 insert into Comensal(id_comensal, fech_nac, cantidad, id_menu, id_tipo_receta) 
values (1, '19670102', 4, 1,33), (2, '19900708', 8, 3,55), (3, '20050904', 3, 3,66), (4, '20021023', 2, 2,44);

/*tabla tipo receta*/
insert into tipo_receta (id_tipo_receta, descripcion) values
(33, 'No-veggie'), (44, 'No-veggie'), (55, 'veggie'), (66, 'celiaco');

/*tabla marca*/
insert into Marca(id_marca, nombre) 
values (1, 'La serenisima'), (2, 'Sancor'), (3, 'Arcor'), (4, 'Veronica');

/*tabla ingredientes*/
insert into Ingredientes(id_ingredientes, foto, nombre, cantidad,
 nombre_comercial, precio, id_alternativo, id_marca) 
values (1, 'dos','fideos de trigo', 4, 'fideos luchetti', 145.0, 1,1),
 (2, 'dos','harina integral', 2, 'harina int', 100.0, 2,2),
 (3, 'uno','yogur', 5, 'yogurisimo', 110.0, 3,1),
 (4, 'uno','queso crema', 1, 'finlandia', 300.0, 4,4);
 
 insert into Ingredientes(id_ingredientes, foto, nombre, cantidad,
 nombre_comercial, precio, id_alternativo, id_marca) 
values
(5,'tres','leche',2,'descremada',120.0,5,2), (6,'uno','queso rallado',1,'queso',90.0,6,2);


/*tabla pasos*/
insert into Pasos(id_receta, id_pasos, acciones) 
values (1, 1, 'Batir'), (4, 2, 'Al horno'),(3, 3, 'Cremar'),(1, 4, 'Tostar');

/*tabla preparacion*/
insert into preparacion (id_preparacion, video, tiempo) values
(555, true, 33.0), (556, true, 26.0), (557, false, 50.0), (558, false, 20.0), (559, true, 18.0);

/*tabla influencer_ranking*/
insert into influencer_ranking (id_influencer, id_ranking) values
 (1,4), (2,3),(3,2), (4,1);
 
/*tabla rectea_comida*/
 insert into receta_comida (id_receta, id_comida, porciones) values 
 (113,140,4),(111,120,2),(112,110,2);
 insert into receta_comida (id_receta, id_comida, porciones) values 
 (113,120,4),(113,110,2),(112,120,2);
 
 
 /*tabla de comida_comensal*/
  insert into comida_comensal (id_comida,id_comensal,cantidad) values
  (140,2,2),(110,3,2),(120,4,1),(130,1,4);
  
  /*tabla de rectea_menu*/
   insert into receta_menu (id_receta,id_menu) values
   (111,2) , (113,4) , (112, 1);
    insert into receta_menu (id_receta,id_menu) values
    (111,3);
   
   update receta_menu set id_receta = 112 where id_receta = 111;
   
insert into menu_comida (id_comida, id_menu) values
(140,3),(110,2),(120,4),(130,1);
insert into menu_comida (id_comida, id_menu) values
(110,3),(120,3),(110,1),(120,1); 
insert into menu_comida (id_comida, id_menu) values
(120,2),(140,2),(110,4),(130,4); 


 insert into ingredientes_lista_compra( id_ingredientes, id_lista_compra, comprado, cantidad) values
 (1,4,true,2),(2,3,false,5),(3,2,true,4),(4,1,false,1);
 
 insert into integra (id_red_social,id_fuentes,id_influencer) values
 (1,122,4),(2,121,3),(3,124,2),(4,123,1);
 
 insert into lleva (id_pasos, id_receta, id_preparacion,id_ingredientes) values
 (2,1,555,1),(4,2,556,2),(1,3,557,3),(3,4,558,4);
 
 
 /*PUNTO EXTRA
 Indicadores que muestren si los menúes que elijo nos aportan una dieta balanceada
y variada*/
select m.id_menu, r.dato
from menu m, receta r 
where exists( select 1 from receta_menu rc 
join receta r on rc.id_receta = r.id_receta
where r.dato like '%altamente%'
and rc.id_menu = m.id_menu);
/*El resultado nos da vacio porque no existe ningun menu con receta altamente nutritivo*/
 
/*lista compra activa */
select * 
from lista_compra lc 
where exists(select 1 from ingredientes_lista_compra ilc
where ilc.comprado=false
and lc.id_lista_compra=ilc.id_lista_compra);

/*historial menus*/
select mc.id_menu as menu, mc.id_comida as comida
from menu_comida mc
order by mc.id_menu;

/*recetas favoritas*/
select r.id_receta as Receta, r.comentario
from receta r join receta_comida rc on r.id_receta = rc.id_receta
join receta_menu rm on rm.id_receta = r.id_receta
group by r.id_receta, r.comentario
having count(rm.id_receta)>1 and count(rc.id_receta)>1;
  
  
/*reporte de ingredientes por tipo de comida del ultimo mes*/
select i.nombre, t.descripcion
from ingredientes i
join ingredientes_lista_compra ilc  on i.id_ingredientes=ilc.id_ingredientes
join lista_compra lc on ilc.id_lista_compra=lc.id_lista_compra
join menu m on id_lista= lc.id_lista_compra
join menu_comida mc on m.id_menu=mc.id_menu
join comida c on mc.id_comida=c.id_comida
join tipo t on c.id_tipo_comida=t.id_tipo_comida
where m.fecha_desde between '20221001' and '20221031'
group by t.id_tipo_comida, t.descripcion, i.nombre;
  
  
 /*Reporte de costo por menú del mes en curso, con la posibilidad de ingresar el factor
inflacionario para poder conocer el presupuesto para el mes que viene.*/
select m.id_menu, sum(c.precio + (c.precio* m.inflacion)) as 'costo_menu'
from menu m join menu_comida mc on m.id_menu=mc.id_menu
join comida c on mc.id_comida= c.id_comida
where m.fecha_desde between '20221001' and '20221031';

/*Conocer mis marcas favoritas, es decir, las que más compro.*/
select m.nombre as 'Marca Fav'
from marca m 
join ingredientes i on m.id_marca=i.id_marca
group by m.nombre
having count(i.id_marca) = 
(select max(i.total)
from (select count(i2.id_marca) as total from ingredientes i2
group by i2.id_marca)i);

  /*¿En qué lapso del año (mes, semana, período de tiempo) preparé todas las recetas
de algún influencer?*/

 select i.id_influencer, r.id_receta, 
 datediff(max(m.fecha_hasta),min(m.fecha_desde))
 from influencer i
 join receta r on i.id_influencer=r.id_influencer
 join receta_menu rm on r.id_receta=rm.id_receta
 join menu m on rm.id_menu=m.id_menu;


/*¿Cuáles son las recetas más utilizadas en los menúes del último año?*/
select r.id_receta as idReceta, r.comentario as nombreReceta
from receta r
join receta_menu rm on  r.id_receta=rm.id_receta
join  menu m on rm.id_menu=m.id_menu
where m.fecha_desde between '2022-01-01' and '2022-12-31'
group by r.id_receta , r.comentario
having count(rm.id_receta) = (
select max(mas) 
from (select count(rm2.id_receta) as mas from receta_menu rm2
group by rm2.id_receta)r);


/*¿Cuántas comidas por semana preparo en promedio?*/
select count(c.id_comida) as comidas
from comida c
join menu_comida mc on c.id_comida = mc.id_comida
join menu m on m.id_menu = mc.id_menu
where exists(select 1 from frecuencia f where f.id_frecuencia = m.id_frecuencia
and f.frecuencia like '%semanal%');


/*Cuál es el costo por comensal en promedio, en un mes*/
select cl.id_comensal, avg(c.precio/cc.cantidad) as promedio
from comensal cl
join menu m on m.id_menu = cl.id_menu
join menu_comida mc on mc.id_menu = m.id_menu
join comida c on c.id_comida = mc.id_comida
join comida_comensal cc on cc.id_comensal = cl.id_comensal
where (m.fecha_desde between  '20221001' and '20221031')
group by cl.id_comensal;


