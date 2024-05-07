/*LAB 3*/
use AdventureWorks2014;
/*1. Realizar una consulta que permita devolver la fecha y hora actual*/
select GETDATE();
/*2. Realizar una consulta que permita devolver únicamente el año y mes actual:
Año Mes
2010 6 */
select year(getdate()) as año, MONTH(getdate()) as mes;
/*3. Realizar una consulta que permita saber cuántos días faltan para el día de la
primavera (21-Sep) */
declare @diaARestar datetime = '2024-09-21';
declare @hoy datetime = getdate();
select DATEDIFF(day,@hoy, @diaARestar); 
/*4. Realizar una consulta que permita redondear el número 385,86 con
únicamente 1 decimal.*/
select str(385.86, 5, 1) as NumeroRedondeado;
/*5. Realizar una consulta permita saber cuánto es el mes actual al cuadrado. Por
ejemplo, si estamos en Junio, sería 62*/
declare @año int = month(getdate());
select POWER(@año,2);
/*6. Devolver cuál es el usuario que se encuentra conectado a la base de datos */
select ORIGINAL_LOGIN() as Name;
/*7. Realizar una consulta que permita conocer la edad de cada empleado
(Ayuda: HumanResources.Employee)*/
declare @añoActual int = year(getdate());
select @añoActual - year(BirthDate) as edad
from HumanResources.Employee;
/*8. Realizar una consulta que retorne la longitud de cada apellido de los
Contactos, ordenados por apellido. En el caso que se repita el apellido
devolver únicamente uno de ellos. Por ejemplo,
Apellido Longitud
Abel 4*/
select distinct LastName, LEN(LastName) as Longitud
from Person.Person;
/*9. Realizar una consulta que permita encontrar el apellido con mayor longitud.*/
select LastName, Len(LastName) as Longitud
from Person.Person
where Len(LastName) = (Select Max(Len(LastName)) from Person.Person)
/*10.Realizar una consulta que devuelva los nombres y apellidos de los contactos
que hayan sido modificados en los últimos 3 años.*/
select FirstName, LastName
from Person.Person
Where ModifiedDate >= DATEADD(YEAR, -3, GETDATE());
/*11.Se quiere obtener los emails de todos los contactos, pero en mayúscula.*/
select upper(EmailAddress) as EmailEnMayuscula
from Person.EmailAddress;
/*12.Realizar una consulta que permita particionar el mail de cada contacto,
obteniendo lo siguiente:
IDContacto email nombre Dominio
1 juanp@ibm.com juanp ibm*/
select EmailAddressID, EmailAddress,
 LEFT(EmailAddress, CHARINDEX('@', EmailAddress)-1) AS nombre,
 SUBSTRING(EmailAddress, CHARINDEX('@', EmailAddress) + 1, CHARINDEX('.', EmailAddress, CHARINDEX('@', EmailAddress)) - CHARINDEX('@', EmailAddress) - 1) AS Dominio
from Person.EmailAddress;
/*13. Devolver los últimos 3 dígitos del NationalIDNumber de cada empleado */
select right(NationalIDNumber,3) as ultimosDigitos
from HumanResources.Employee;
/*14.Se desea enmascarar el NationalIDNumbre de cada empleado, de la
siguiente forma ###-####-##:
ID Numero Enmascarado
36 113695504 113-6955-04 */
select NationalIDNumber,
CONCAT(
        SUBSTRING(NationalIDNumber, 1, 3), '-', 
        SUBSTRING(NationalIDNumber, 4, 4), '-', 
        SUBSTRING(NationalIDNumber, 8, 2)
    ) AS Enmascarado
from HumanResources.Employee;
/*15. Listar la dirección de cada empleado “supervisor” que haya nacido hace más
de 30 años. Listar todos los datos en mayúscula. Los datos a visualizar son:
nombre y apellido del empleado, dirección y ciudad.*/
select DATEDIFF(YEAR, e.BirthDate, GETDATE()) as Edad, UPPER(pp.FirstName) as Nombre,
 UPPER(pp.LastName) as Apellido, UPPER(pa.AddressLine1) as direccion, UPPER(pa.City) as ciudad
from HumanResources.Employee e 
join Person.Person pp on pp.BusinessEntityID = e.BusinessEntityID
join Person.BusinessEntity pb on pp.BusinessEntityID = pb.BusinessEntityID
join Person.BusinessEntityAddress pba on pb.BusinessEntityID = pba.BusinessEntityID
join Person.Address pa on pba.AddressID = pa.AddressID
where e.JobTitle like '%Supervisor%'
and DATEDIFF(YEAR, e.BirthDate, GETDATE()) >30 ;
/*16. Listar la cantidad de empleados hombres y mujeres, de la siguiente forma:
Sexo Cantidad
Femenino 47
Masculino 56
Nota: Debe decir, Femenino y Masculino de la misma forma que se muestra. */
select count(*) as Cantidad,
case 
when Gender='F' then 'Femenino'
when Gender='M' then 'Masculino'
end as Sexo
from HumanResources.Employee
group by Gender;
/*17.Categorizar a los empleados según la cantidad de horas de vacaciones,
según el siguiente formato:
Alto = más de 50 / medio= entre 20 y 50 / bajo = menos de 20
Empleado Horas
Juan Perez Alto
Ana Sanchez Bajo
Julio Gomez Medio*/
select 
case
when VacationHours > 50 then 'Alto'
when VacationHours between 20 and 50 then 'Medio'
when VacationHours < 20 then 'Bajo'
end as CategoriaVacaciones
from HumanResources.Employee;
