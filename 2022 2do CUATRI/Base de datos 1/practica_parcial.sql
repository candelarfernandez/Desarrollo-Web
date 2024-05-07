CREATE SCHEMA IF NOT EXISTS ejercicio_parcial;
use ejercicio_parcial;

create table Cliente(
cod_cliente int primary key auto_increment,
nombre varchar(50) not null,
apellido varchar(50) not null, 
direccion varchar(50) not null,
fech_nac date not null,
edad int,
sexo varchar(50),
ciudad varchar(50),
provincia varchar(50),
pais varchar(50)
);
create table documento(
cod_documento int primary key auto_increment,
cod_cliente int references Cliente (cod_cliente),
tipo varchar(50) not null,
numero int unique
);
create table factura_cabecera(
cod_cabecera int primary key auto_increment,
cod_cliente int references Cliente (cod_cliente),
fecha_venta date not null,
comentarios_venta varchar(60)
);
create table categoria(
cod_categoria int primary key auto_increment,
categoria varchar(50)
);

alter table categoria change categoria categorias varchar(50);

create table proveedor (
cod_proveedor int primary key auto_increment,
nombre varchar(50),
direccion varchar(50),
ciudad varchar(50)
);
create table  producto(
cod_producto int primary key auto_increment,
cod_categoria int references Categoria(cod_categoria),
cod_proveedor int references Proveedor(cod_proveedor),
producto varchar(50) not null,
marca varchar(50),
pu int,
fecha_venc date not null
);
create table factura_detalle(
cod_detalle int primary key auto_increment,
cod_cabecera int references factura_cabecera(cod_cabecera),
cod_producto int references producto(cod_producto),
cantidad int
);
insert into Producto(cod_producto, cod_categoria, cod_proveedor, producto, marca, pu, fecha_venc)
values(1, 1, 3, "galles", "terrabusi", 2, '20230102'),
(2, 2, 3, "queso", "cremon", 3, '20231011'),
(3, 3, 1, "coca", "cocacolacompany", 3, '20241011'),
(4, 1, 3, "coca", "cocacolacompany", 3, '20241011');
insert into Categoria(cod_categoria, categoria)
values(1, 'snaks'),
(2, 'lacteos'),
(3, 'bebidas');
insert into Proveedor(cod_proveedor, nombre, direccion, ciudad)
values(1, 'candela', 'sarratea 248', 'moron'),
(2, 'florencia', 'pellegrini 236', 'ramos mejia'),
(3, 'guadalupe', 'chenaut 315', 'villa luzuriaga');

/*ejercicio1*/
select count(pr.cod_producto) as cantidadProductos, count(pr.cod_categoria) as cantidadCategorias, p.cod_proveedor as deCadaProveedor
from proveedor p
join producto pr on p.cod_proveedor=pr.cod_proveedor
group by pr.cod_proveedor, p.nombre;

/*ejercicio2*/
 /*Informar la cantidad y el inporte de los producto vendidos por cada categoria*/
 select count(p.cod_producto) as 'cantidadProductos', sum(fd.cantidad*p.pu) as importe, 
 c.cod_categoria
 from producto p join categoria c on p.cod_categoria=c.cod_categoria
 join factura_detalle fd on fd.cod_producto=p.cod_producto
 group by c.cod_categoria;
 
 /*ejercicio 3
 listar los codigos de producto que distribuye el proveedor 1001 y no proveea el proveedor 100*/
 select p.cod_producto
 from producto p 
where exists (
select 1 from proveedor pv where p.cod_proveedor=pv.cod_proveedor
and pv.cod_proveedor like '1'
and  pv.cod_proveedor <> '2');

/*ejercicio4 ) hallar los codigos y nombres de los proveedores que proveen al menos un producto en alguna categoria el cual
el precio es mayor a $800*/
select p.cod_proveedor, p.nombre
from proveedor p 
where exists (select 1 from producto prod where prod.pu>2
and p.cod_proveedor=prod.cod_proveedor);