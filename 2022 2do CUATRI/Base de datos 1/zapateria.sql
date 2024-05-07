CREATE SCHEMA IF NOT EXISTS Zapateria;
Use Zapateria;

CREATE TABLE Calzado(
cod_calzado INT PRIMARY KEY,
nombre varchar(50) not null,
precio decimal(9.2)
);

CREATE TABLE Talle(
cod_talle INT PRIMARY KEY,
nro INT not null
);

CREATE TABLE Genero(
cod_genero INT PRIMARY KEY,
descripcion varchar(40) not null
);

CREATE TABLE Categoria(
cod_categoria INT PRIMARY KEY,
descripcion varchar(40) not null
);

CREATE TABLE Pais(
id_pais INT PRIMARY KEY,
nombre varchar(40)
);

CREATE TABLE Componente(
cod_componente INT PRIMARY KEY,
descripcion varchar(40) not null,
fech_venc date not null,
id_pais INT,
foreign key(id_pais) references Pais(id_pais)
);

CREATE TABLE Proveedor(
cuit INT PRIMARY KEY,
razon_social VARCHAR(60),
fech_inicio date not null,
cod_prov INT,
cod_pais INT,
id_tel INT,
foreign key(cod_pais) references Pais(id_pais),
foreign key(cod_prov) references Proveedor(cuit)
);

CREATE TABLE Componente_Proveedor(
cod_componente INT,
cod_prov INT,
primary key(cod_componente, cod_prov),
foreign key (cod_componente) references Componente(cod_componente),
foreign key (cod_prov) references Proveedor(cod_prov)
);

CREATE TABLE Calzado_Componente(
cod_componente INT,
cod_calzado INT,
primary key(cod_componente, cod_calzado),
foreign key (cod_componente) references Componente(cod_componente),
foreign key (cod_calzado) references Calzado(cod_calzado)
);

CREATE TABLE Zapatilla(
cod_calzado int primary key,
fech_ingreso date not null,
foreign key (cod_calzado) references Calzado(cod_calzado)
);
CREATE TABLE Zapatos(
cod_calzado int primary key,
cod_categoria INT,
foreign key (cod_calzado) references Calzado(cod_calzado),
foreign key (cod_categoria) references Categoria(cod_categoria)
);
