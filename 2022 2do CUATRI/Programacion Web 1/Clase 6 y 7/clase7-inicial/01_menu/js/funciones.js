$(document).ready(function(){ 
  $("a.desplegable").click(function(){
    if($('.menu').is(":visible")){
        $('.menu').slideUp();
    }else{
      $('.menu').slideDown();
    }
  });
  $(window).resize(function(){
      if($(this).width()>768){
          $(".menu").show();
      } else{
          $(".menu").hide();
      }
  });
});

/*muestra texto en pop up */
/*inspeccionar: consola */
alert("Primer Script");

/**escribe adentro de un documento html */
document.write("Escribe en html");

//muestra contenido en la consola
console.log("Escribe en la consola");

//se guarda una variable, no pueden empezar con numero
//no tienen espacios en blanco ni caracteres especiale
//si el signo pesos y el guion de una variable 
var nombre="Mariano";

//concatenacion
console.log("Hola"+nombre+"!");

//igual que el alert
var nombreDos=prompt("Ingrese su nombre");

//CONSTANTES: uppercase
const PI=3.14;

//convierten numeros parseInt parseFloat String o 
//IsNaN devuelve true si no lo es, validamos un dato
var num1=paseInt(prompt("Ingrese un numero"));
var num2=parseInt(prompt("Ingrese un numero"))
if(!isNaN(num1)&&!isNaN(num2)){
  console.log(num1+num2);
}
else{
  console.log("Datos invalidos")
}

//switch
var dia=prompt("Ingrese un numero entre 1 y 7");
switch(dia){
  case "1":
    document.write("Lunes");
    break;

}