/*Lab2*/

/*Temas:
- Insert /Delete /Update
- Inner Join / Left Join / Right Join / Full Join / Cross Join
- Exists / In / not exists / not in
- Group by / Having*/
use AdventureWorks2014;
/*1. Listar los nombres de los productos y el nombre del modelo
que posee asignado. Solo listar aquellos que tengan asignado
algún modelo.*/
select p.Name as 'NombreProducto', pm.Name as 'NombreModelo'
from Production.Product p
inner join Production.ProductModel pm on p.ProductModelID = pm.ProductModelID;
/*2. Mostrar “todos” los productos junto con el modelo que tenga
asignado. En el caso que no tenga asignado ningún modelo,
mostrar su nulidad.*/
select p.Name as 'NombreProducto', pm.Name as 'NombreModelo'
from Production.Product p
left join Production.ProductModel pm on p.ProductModelID = pm.ProductModelID;
/*3. Ídem Ejercicio2, pero en lugar de mostrar nulidad, mostrar la
palabra “Sin Modelo” para indicar que el producto no posee un
modelo asignado.*/
select p.Name as 'NombreProducto',
case
when p.ProductModelID is null then 'Sin Modelo'
else pm.Name
end as NombreModelo
from Production.Product p
left join Production.ProductModel pm on p.ProductModelID = pm.ProductModelID;
/*4. Contar la cantidad de Productos que poseen asignado cada
uno de los modelos.*/
select pm.Name, count(*) as 'CantidadDeProductos'
from Production.Product p
inner join Production.ProductModel pm on p.ProductModelID = pm.ProductModelID
group by pm.Name;
/*5. Contar la cantidad de Productos que poseen asignado cada
uno de los modelos, pero mostrar solo aquellos modelos que
posean asignados 2 o más productos.*/
select pm.Name, count(*) as 'CantidadDeProductos'
from Production.Product p
inner join Production.ProductModel pm on p.ProductModelID = pm.ProductModelID
group by pm.Name
having count(*)>2;
/*6. Contar la cantidad de Productos que poseen asignado un
modelo valido, es decir, que se encuentre cargado en la tabla
de modelos. Realizar este ejercicio de 3 formas posibles:
“exists” / “in” / “inner join”.*/
select count(*) as 'CantidadDeProductos'
from Production.Product p
inner join Production.ProductModel pm on p.ProductModelID = pm.ProductModelID;
select count(*) as 'CantidadDeProductos'
from Production.Product p
where exists(
select 1
from Production.ProductModel pm 
where p.ProductModelID = pm.ProductModelID
);
select count(*) as 'CantidadDeProductos'
from Production.Product p
where ProductModelID in(select ProductModelID pm from Production.ProductModel);
/*7. Contar cuantos productos poseen asignado cada uno de los
modelos, es decir, se quiere visualizar el nombre del modelo y
la cantidad de productos asignados. Si algún modelo no posee
asignado ningún producto, se quiere visualizar 0 (cero).*/
select pm.Name, 
case
when count(p.ProductID) is null then '0'
else count(p.ProductID)
end as CantidadDeProductos
from Production.ProductModel pm 
left join Production.Product p  on p.ProductModelID = pm.ProductModelID
group by pm.Name;
/*8. Se quiere visualizar, el nombre del producto, el nombre
modelo que posee asignado, la ilustración que posee asignada
y la fecha de última modificación de dicha ilustración y el
diagrama que tiene asignado la ilustración. Solo nos interesan
los productos que cuesten más de $150 y que posean algún
color asignado.*/
select p.Name, pm.Name, i.IllustrationID, i.Diagram, i.ModifiedDate
from Production.Product p
inner join Production.ProductModel pm on p.ProductModelID=pm.ProductModelID
inner join Production.ProductModelIllustration pml on pml.ProductModelID = pm.ProductModelID
inner join Production.Illustration i on pml.IllustrationID = i.IllustrationID
where p.ListPrice>150 and p.Color is not null;
/*9. Mostrar aquellas culturas que no están asignadas a ningún
producto/modelo.
(Production.ProductModelProductDescriptionCulture)*/
select pmpdc.CultureID
from Production.ProductModelProductDescriptionCulture pmpdc
where not exists (
select 1
from Production.ProductModel pm 
where pm.ProductModelID = pmpdc.ProductModelID
and not exists (select 1 from Production.Product p where pm.ProductModelID = p.ProductModelID));
/*10. Agregar a la base de datos el tipo de contacto “Ejecutivo de
Cuentas” (Person.ContactType)*/
insert into Person.ContactType(Name, ModifiedDate) values ('EjecutivoDeCuentas',getDate());
/*11. Agregar la cultura llamada “nn” – “Cultura Moderna”.*/
insert into Production.Culture(CultureID,Name, ModifiedDate) values ('nn','Cultura Moderna',getDate());
/*12. Cambiar la fecha de modificación de las culturas Spanish,
French y Thai para indicar que fueron modificadas hoy.*/
UPDATE Production.Culture
SET ModifiedDate = getDate()
WHERE Name = 'Spanish'or Name = 'French'or Name = 'Thai';
/*13. En la tabla Production.CultureHis agregar todas las culturas
que fueron modificadas hoy. (Insert/Select).*/
/*14. Al contacto con ID 10 colocarle como nombre “Juan Perez”.*/
Update Person.Person
set FirstName = 'Juan', LastName = 'Perez'
WHERE BusinessEntityID = 10;
/*15. Agregar la moneda “Peso Argentino” con el código “PAR”
(Sales.Currency)*/
insert into Sales.Currency(CurrencyCode,Name,ModifiedDate)
values('PAR','Peso Argentino', GETDATE());
/*16. ¿Qué sucede si tratamos de eliminar el código ARS
correspondiente al Peso Argentino? ¿Por qué?*/
delete from Sales.Currency where CurrencyCode='ARS'; /*ocurre ya que se encuentra como fk de otras tablas*/
/*17. Realice los borrados necesarios para que nos permita eliminar
el registro de la moneda con código ARS.*/
delete from Sales.CountryRegionCurrency where CurrencyCode='ARS';
delete from Sales.CurrencyRate where ToCurrencyCode='ARS';
delete from Sales.Currency where CurrencyCode='ARS';
/*18. Eliminar aquellas culturas que no estén asignadas a ningún
producto (Production.ProductModelProductDescriptionCulture) */
delete from Production.ProductModelProductDescriptionCulture  
where not exists(
select 1
from Production.ProductModel pm
where pm.ProductModelID = ProductModelID);