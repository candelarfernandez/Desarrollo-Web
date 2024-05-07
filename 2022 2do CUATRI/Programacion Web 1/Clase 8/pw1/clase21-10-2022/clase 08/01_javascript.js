// var o let, var se puede correr en todas las computadoras
let nombre = "Pablo";
//comentarios igual que java
// mostrar ventana emergente
//alert("Ventana emergente"); //no hace falta usar punto y coma ;
//mostrar datos en consola
console.log("hola " + nombre + "!");
console.log(`hola ${nombre}!`) //altgr llave que cierr
//f12 consola, mmuestra que error hay y en que linea

let num1 = parseInt (prompt("Ingrese un numero"));
let num2 = parseInt (prompt("Ingrese otro numero"));
const PI = 3.14;
console.log(num1+num2);
let num3 = 5;
let num4 = "5";
console.log(num3==num4);
console.log(num3===num4);

function multiplicar (num1, num2){
    return num1*num2;
}