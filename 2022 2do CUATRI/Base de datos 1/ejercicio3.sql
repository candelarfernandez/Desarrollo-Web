CREATE SCHEMA IF NOT EXISTS ejercicio3;
use ejercicio3;
create table Proveedor(
id_proveedor int primary key,
nombre varchar(50),
cuit bigint
);
create table producto(
id_producto int primary key,
descripcion varchar(100),
estado varchar(100),
id_proveedor int,
foreign key (id_proveedor) references Proveedor(id_proveedor)
);
create table cliente(
id_cliente int primary key,
nombre varchar(50)
);
create table vendedor(
id_empleado int primary key,
nombre varchar(50),
apellido varchar(50),
dni bigint
);
create table Venta(
nro_factura int primary key,
id_cliente int,
fecha date not null,
id_empleado int,
foreign key (id_cliente) references Cliente(id_cliente),
foreign key (id_empleado) references Vendedor(id_empleado)
);
create table Detalle_venta(
nro_factura int,
nro_detalle varchar(40),
id_producto int,
cantidad int,
precio_unitario int,
primary key (nro_factura, nro_detalle),
foreign key (nro_factura) references Venta(nro_factura),
foreign key (id_producto) references Producto(id_producto) 
);

insert into Producto (id_producto, descripcion, estado, id_proveedor) 
values (1, 'lentejas','en stock', 1);
insert into Producto (id_producto, descripcion, estado, id_proveedor) 
values (2, 'arvejas','sin stock', 3);
insert into Producto (id_producto, descripcion, estado, id_proveedor) 
values (3, 'garbanzos','en stock', '4');
insert into Producto (id_producto, descripcion, estado, id_proveedor) 
values (4, 'porotos','sin stock', 2);

insert into Proveedor (id_proveedor, nombre, cuit) 
values (1, 'candela',44424);
insert into Proveedor (id_proveedor, nombre, cuit) 
values (2, 'rocio',43344);
insert into Proveedor (id_proveedor, nombre, cuit) 
values (3, 'agostina',43555);
insert into Proveedor (id_proveedor, nombre, cuit) 
values (4, 'candela',43655);

insert into Cliente (id_cliente, nombre) 
values (1, 'candela');
insert into Cliente (id_cliente, nombre) 
values (2, 'julieta');
insert into Cliente (id_cliente, nombre) 
values (3, 'florencia');
insert into Cliente (id_cliente, nombre) 
values (4, 'liliana');

insert into Vendedor (id_empleado, nombre, apellido, dni) 
values (1, 'liliana', 'lo duca', 2158);
insert into Vendedor (id_empleado, nombre, apellido, dni) 
values (2, 'analia', 'lo duca', 2858);
insert into Vendedor (id_empleado, nombre, apellido, dni) 
values (3, 'javier', 'lo duca', 3258);
insert into Vendedor (id_empleado, nombre, apellido, dni) 
values (4, 'leonildes', 'miras', 15458);

insert into Venta (nro_factura, id_cliente, fecha, id_empleado) 
values (1, 2, '20221001', 2);
insert into Venta (nro_factura, id_cliente, fecha, id_empleado) 
values (2, 4, '20221002', 1);
insert into Venta (nro_factura, id_cliente, fecha, id_empleado) 
values (3, 1, '20221003', 3);
insert into Venta (nro_factura, id_cliente, fecha, id_empleado) 
values (4, 3, '20221004', 3);

insert into Detalle_Venta (nro_factura, nro_detalle, id_producto, cantidad, precio_unitario) 
values (4, 1, 2, 25, 250);
insert into Detalle_Venta (nro_factura, nro_detalle, id_producto, cantidad, precio_unitario) 
values (2, 2, 1, 5, 50);
insert into Detalle_Venta (nro_factura, nro_detalle, id_producto, cantidad, precio_unitario) 
values (1, 3, 3, 15, 150);
insert into Detalle_Venta (nro_factura, nro_detalle, id_producto, cantidad, precio_unitario) 
values (3, 4, 4, 2, 100);

/*ejercicio1*/
select count(*) as 'cant_productos'
from producto p;

/*ejercicio2*/
select p.descripcion
from producto p where p.estado='en stock';

/*ejercicio3*/
select *
from producto p left join detalle_venta dt on p.id_producto=dt.id_producto
where dt.id_producto

/*ejercicio4*/

