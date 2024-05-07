CREATE SCHEMA IF NOT EXISTS Clase11;

USE Clase11;

CREATE TABLE Empleado (
   nro INT primary key /*AUTO_INCREMENT*/,
   nombre VARCHAR(40) not null,
   cod_esp SMALLINT,
   nro_jefe smallint /*foreign key*/ references EMPLEADO(nro),
   sueldo decimal(9,2) not null,
   f_ingreso date not null
);

ALTER TABLE Empleado
  CHANGE COLUMN nro_jefe nro_jefe int null
  /*NO VA references Empleado(nro)*/;
 
ALTER TABLE empleado
  ADD constraint FK_jefe foreign key (nro_jefe) references Empleado(nro);

CREATE TABLE especialidad(
   cod_esp smallint primary key,
   descripcion varchar(40) not null
);

ALTER TABLE empleado
  ADD foreign key (cod_esp) references especialidad(cod_esp);

CREATE TABLE area(
   cod_area char(2) primary key,
   descripcion varchar(40) not null
);

CREATE TABLE trabaja(
   nro_emp int not null,
   cod_area char(2),
   primary key (nro_emp,cod_area),
   foreign key(nro_emp) references empleado(nro),
   foreign key(cod_area) references area(cod_area)
);

/*Ejercicio 1*/

SELECT nombre
FROM empleado;

/*Ejercicio 2*/
SELECT nro, nombre
FROM empleado;

/*Ejercicio 3*/
SELECT nro, nombre,cod_esp,nro_jefe,sueldo,f_ingreso
FROM empleado;

/*Ejercicio 4*/
SELECT nombre
FROM empleado
ORDER BY sueldo;

/*Ejercicio 5*/
SELECT *
FROM empleado
ORDER BY sueldo, f_ingreso DESC;

/*Ejercicio 6*/
SELECT nro, nombre
FROM empleado
WHERE sueldo>3000;

/*Ejercicio 7*/
SELECT nro, nombre
FROM empleado
WHERE sueldo > 3000
AND nombre = 'Pedro';

/*Ejercicio 8*/
/*WHERE f_ingreso >= '20080101'
AND f_ingreso <= '20081231';*/
SELECT nro, nombre
FROM empleado
WHERE f_ingreso BETWEEN '20080101' AND '20081231';

/*Ejercicio 9*/
SELECT nombre
FROM empleado
WHERE nro_jefe IS NULL;

/*Ejercicio 10*/
SELECT nombre
FROM empleado
WHERE nombre LIKE 'A%';

/*Ejercicio 11*/
SELECT nombre, sueldo
FROM empleado
WHERE nro IN (1,2,5,7,9);


/*Ejercicio 12*/
SELECT DISTINCT nro_jefe
FROM Empleado
WHERE nro_jefe IS NOT NULL;



