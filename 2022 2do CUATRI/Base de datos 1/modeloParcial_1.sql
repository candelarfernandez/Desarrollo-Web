CREATE schema IF NOT exists modeloParcial;
use modeloParcial;

create table Producto(
idProducto int primary key auto_increment,
nombre varchar(40) not null unique, /*unique: no permite nombres repetidos*/
fecha_creacion date not null,
precio decimal(7.9) not null
);

create table Temas_Producidos(
idTema int not null,
idProducto int not null references Producto(idProducto),
primary key(idTema,idProducto)
);

create table Componente(
idComponente int primary key not null,
descripcion varchar(40) not null unique,
idColorPredominante int not null,
esPersonalizado boolean,
costo decimal(7.9) not null
);

create table Composicion(
idProducto int not null references Producto(idProducto),
idComponente int not null references Componente(idComponente),
vencimiento date not null,
cantidad_componente int,
primary key(idProducto,idComponente)
);

create table Ingrediente(
idIngrediente int primary key not null,
nombre varchar(40) not null unique
);

create table Color(
idColor int primary key  auto_increment,
nombre varchar(40) not null unique
);

create table Tema(
idTema int primary key,
nombre varchar(40) not null unique,
color1 int not null references Color(idColor),
color2 int not null references Color(idColor),
color3 int not null references Color(idColor)
);

create table Receta(
idComponente int references Componente(idComponente),
paso int not null,
idIngrediente int references Ingrediente(idIngrediente),
medida decimal(9.7) not null, -- default: espera al menos 1 valor
cantidad int not null,
elaboracion text not null,
primary key(idComponente,paso,idIngrediente)
);

/****ABM*****/

idTema int primary key,
nombre varchar(40) not null unique
);
INSERT INTO Producto(nombre,fecha_creacion,precio) values
('Box de Cumpleaños','2022-11-05',5399.99),
('Canasta Feliz Dia','2022-08-05',2399.99);

/*b.	Eliminar todas las recetas del componente llamado “Alfajor de maicena” que tiene id=4.*/
delete from Receta
where idComponente = 4;

-- suponiendo que no nos dan el ID 
delete from receta
where exists( select 1 from commponente where componente.idComponente = receta.idComponente
and nombre like 'Alfajor de Maicena');

/*c.	Actualizar todos los productos que tienen tema de “Unicornios“ a “Alicornios”.*/

update Tema_producido set idTema = 4 where idTema =3; -- 4:Alicornios, 3: unicornios

update Tema_producido set idTema = (select idTema from Tema where Nombre like 'Alicornio')
where idTema = (select idTema from Tema where Nombre like 'Unicornio');

/****DML*****/

/*a.	Obtener todas las recetas por componente, paso e ingrediente.*/
SELECT c.descripcion, r.paso, i.nombre FROM Receta r
join componente c on c.idComponente = r.idComponente
join Ingrediente I on I.idComponente = r.idComponente
order by r.idComponente, r.idIngrediente, r.paso;

/*b.	Listar todos los productos que sean deslactosados o sin lactosa.
 Se entiende que contengan ingredientes “sin lactosa” o “deslactosado”. 
O bien que NO contengan ingredientes que sean leche o derivados*/
select * from producto p
join composicion cp on p.idComposicion = cp.idComposicion

where exists(
select 1 from receta r join ingrediente i on i.id_ingrediente=r.idIngrediente
where r.idComponente=cp.idComponente
and i.nombre  like '%sin lactosa%' 
or i.nombre = '%deslactosado%'
)
and not exists(
  select 1 from receta r join ingrediente i on i.id_ingrediente=r.idIngrediente
where r.idComponente=cp.idComponente
  and i.nombre  like '%leche%' 
   or i.nombre = '%queso%' or i.nombre like '%yogurt%'
);


/*c.Mostrar todos los productos que fabrica Caro, con cantidades por componente.*/
select p.nombre, c.descripcion, cp.cantidad_componente
from producto p
join composicion cp on cp.idProducto =p.idProducto
join componente c on c.idComponente=cp.idComponente;
/*cantidad de componente en cada producto*/
select p.nombre, count(cp.idComponente), SUM(cp.cantidad_componente)
from producto p join composicion cp on cp.idProducto =p.idProducto
group by p.idProducto, p.nombre;


/*d.¿Cuáles son los productos que se elaboran con recetas que usan todos los ingredientes?*/
/*si en vez de productos son componentes*/
-- division
select c.*
from componente c
where not exists(select 1 from ingrediente i
where not exists(select 1 from receta r where r.idComponente=c.idComponente
and r.idIngrediente=i.idIngrediente)
); 

-- con productos
select p.*
from producto p
where exists(select 1 from ingrediente i
where exists(select 1 from composicion c join receta r on r.idComponent=c.idComponente 
where c.idProducto=p.idProducto
and r.idIngrediente=i.idIngrediente)
); 


/*e.¿Cuáles son las recetas con más alto costo?*/
-- componente con mas alto costo
select c.*
from componente c 
where c.costo =(
select max(cm.costo) from componente cm);

-- si es receta


/*f.¿Qué productos temáticos (nombre de producto y nombre de tema) 
tienen componentes personalizados cuyo color predominante está entre los colores del tema asociado?*/
select p.nombre, t.nombre
from producto p join tema_producido tp on tp.idProducto=p.idPdrocuto
join tema t on t.idTema = tp.idTema
where exists (select 1 from componente c 
join composicion cp on cp.idComponente=c.idComponente
where cp.idProducto = p.idProducto
and c.esPersonalizado=true
and c.colorPredominante IS NOT NULL -- en caso de que algun color sea null
and c.idColorPredominante IN (t.color1, t.color2, t.color3)
);


/*g.Mostrar la ganancia que tiene Caro por producto.*/
-- ganancia? precio menos el costo
select p.nombre, p.precio, SUM(c.costo * co.cantidad_componente) as costoTotal, 
p.precio - sum(c.costo * co.cantidad_componente) as Ganancia
from producto p
join composicion cp on cp.idProducto=p.idProducto
join componente c on c.idComponene = cp.idComponente
group by p.idProducto, p.nombre, p.precio;



