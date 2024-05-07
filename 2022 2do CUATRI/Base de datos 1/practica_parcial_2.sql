Create schema if not exists parcial;
use parcial;

create table Producto(
codProd int primary key,
descripcion varchar(50) not null
);

create table Plato(
idPlato int primary key,
descripcion varchar(50) not null,
precio decimal(9.7)
);

create table Composicion(
codComposicion int primary key,
idPlato int references Plato(idPlato),
codProd int references Producto(codProd)
);


create table Localidad(
idLocalidad int primary key,
descripcion varchar(50) not null);

create table Cliente(
idCliente int primary key,
nombre varchar(50) not null,
apellido varchar(50) not null, 
calle  varchar(50) not null,
nro int,
idLocalidad int references Localidad(idLocalidad)
);
create table PedidoEncabezado(
idPedido int primary key not null, 
idCliente int references Cliente(idCliente),
fecha date not null
);
create table PedidoDetalle(
idDetalle int primary key not null,
idPedido int references PedidoEncabezado(idPedido),
idPlato int references Plato(idPlato),
cantidad int 
);
alter table PedidoDetalle change cantidad cantidades int;

insert into PedidoDetalle (idDetalle, idPedido, idPlato, cantidades) values
(1,2,1,4), (2,3,4,5), (3,1,2,2), (4,5,6,1);

select p.descripcion
from plato p
where exists(select 1 from composicion cp 
join producto pro on cp.codProd=pro.codProd
where pro.descripcion like '%Harinas%'
and p.idPlato=cp.idPlato)
and exists (select 1 from composicion cp 
join producto pro on cp.codProd=pro.codProd
where pro.descripcion like '%Legumbres%'
and p.idPlato=cp.idPlato
);

select p.descripcion, p.precio
from plato p
where not exists(select 1
from pedidoDetalle pd join pedidoEncabezado pe on pd.idPedido=pe.idPedido
where pd.idPlato=p.idPlato);

select c.idCliente
from cliente c
where exists(select 1 from pedidoEncabezado pe
where pe.fecha between '20220101' and '20220131'
and c.idCliente=pe.idCliente 
and not exists(
select 1 from pedidoEncabezado pe2
where pe2.fecha between '20220301' and '20220331'
and c.idCliente=pe2.idCliente ));

select p.descripcion
from plato p
where not exists(select 1 from producto pr
where not exists(
select 1 from composicion c where c.idPlato = p.idPlato
and pr.codProd=c.codProd ));

