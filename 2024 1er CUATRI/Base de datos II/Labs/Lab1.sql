/*
LAB 1
*/
use AdventureWorks2014;
/*1. Listar los c�digos y descripciones de todos los productos
(Ayuda: Production.Product)*/
SELECT ProductID, Name
From Production.Product;
/*2- Listar los datos de la subcategor�a n�mero 17 (Ayuda:
Production.ProductSubCategory)*/
SELECT *
FROM Production.ProductSubcategory
Where ProductSubcategoryID = 17;
/*3- Listar los productos cuya descripci�n comience con D (Ayuda:
like �D%�)*/
SELECT * 
From Production.Product 
where Name like 'D%';
/*4- Listar las descripciones de los productos cuyo n�mero finalice
con 8 (Ayuda: ProductNumber like �%8�)*/
select Name
from Production.Product 
where ProductNumber like '%8';
/*5- Listar aquellos productos que posean un color asignado. Se
deber�n excluir todos aquellos que no posean ning�n valor
(Ayuda: is not null)*/
select *
from Production.Product 
where Color is not null;
/*6- Listar el c�digo y descripci�n de los productos de color Black
(Negro) y que posean el nivel de stock en 500. (Ayuda:
SafetyStockLevel = 500)*/
select Name, ProductNumber
from Production.Product 
where color like '%Black%' and SafetyStockLevel = 500;
/*7- Listar los productos que sean de color Black (Negro) � Silver
(Plateado).*/
select *
from Production.Product 
where Color like '%Black%' or Color like '%Silver%';
/*8- Listar los diferentes colores que posean asignados los
productos. S�lo se deben listar los colores. (Ayuda: distinct)*/
select distinct Color
from Production.Product
where Color is not null;
/*9- Contar la cantidad de categor�as que se encuentren cargadas
en la base. (Ayuda: count)*/
select count(ProductCategoryID) as 'Cantidad de categorias cargadas'
from Production.ProductCategory;
/*10- Contar la cantidad de subcategor�as que posee asignada la
categor�a 2.*/
select count(ProductSubcategoryID) as 'Cantidad de subcategor�as con la categoria 2 asignada'
FROM Production.ProductSubcategory
where ProductCategoryID = 2;
/*11- Listar la cantidad de productos que existan por cada uno de los
colores.*/
select count(ProductID) as 'Cantidad de productos', Color
from Production.Product
where Color is not null
group by Color;
/*12- Sumar todos los niveles de stocks aceptables que deben existir
para los productos con color Black. (Ayuda: sum)*/
select  sum(SafetyStockLevel) as 'Suma de stock de productos black'
from Production.Product
where Color like '%Black%';
/*13- Calcular el promedio de stock que se debe tener de todos los
productos cuyo c�digo se encuentre entre el 316 y 320.
(Ayuda: avg)*/
select avg(SafetyStockLevel) as 'Promedio de stock'
from Production.Product
where ProductID between 316 and 320;
/*14- Listar el nombre del producto y descripci�n de la subcategor�a
que posea asignada. (Ayuda: inner join)*/
select pp.Name as 'Nombre del producto', ps.Name as 'Nombre de la subcategoria'
from Production.Product pp
inner join Production.ProductSubcategory ps on pp.ProductSubcategoryID = ps.ProductSubcategoryID;
/*15- Listar todas las categor�as que poseen asignado al menos una
subcategor�a. Se deber�n excluir aquellas que no posean
ninguna.*/
select distinct c.Name
from Production.ProductCategory c
inner join Production.ProductSubcategory ps on c.ProductCategoryID=ps.ProductCategoryID;
/*16- Listar el c�digo y descripci�n de los productos que posean fotos
asignadas. (Ayuda: Production.ProductPhoto)*/
Select pp.ProductNumber, pp.Name
from Production.Product pp
inner join Production.ProductProductPhoto pppp on pp.ProductID = pppp.ProductID 
inner join Production.ProductPhoto ppp on pppp.ProductPhotoID = ppp.ProductPhotoID;
/*17- Listar la cantidad de productos que existan por cada una de las
Clases (Ayuda: campo Class)*/
select Class, count(*) AS 'Cantidad de productos'
from Production.Product 
where Class is not null
group by Class;
/*18- Listar la descripci�n de los productos y su respectivo color. S�lo
nos interesa caracterizar al color con los valores: Black, Silver
u Otro. Por lo cual si no es ni silver ni black se debe indicar
Otro. (Ayuda: utilizar case).*/
select Name, Color,
case 
when Color like '%Black%' then 'Black'
when Color like '%Silver%' then 'Silver'
else 'Otro'
end as FiltroPorColor
from Production.Product;
/*19- Listar el nombre de la categor�a, el nombre de la subcategor�a
y la descripci�n del producto. (Ayuda: join)*/
select c.Name as 'NombreCategoria', sc.Name as 'NombreSubcategoria', p.Name as 'NombreProducto'
from Production.Product p
join Production.ProductSubcategory sc on sc.ProductSubcategoryID=p.ProductSubcategoryID
join Production.ProductCategory c on c.ProductCategoryID=sc.ProductCategoryID;
/*20- Listar la cantidad de subcategor�as que posean asignado los
productos. (Ayuda: distinct). */
select count(distinct pps.Name) as 'Cantidad de subcategorias'
from Production.ProductSubcategory pps
inner join Production.Product pp on pp.ProductSubcategoryID=pps.ProductSubcategoryID;

