let etiquetasH = document.getElementsByTagName("h2"); //selecciona por etiqueta

let materia = document.getElementById("materia"); //selecciona por ID

let opciones = document.getElementsByName("opcion"); //selecciona por name 
//opciones[0].checked  -  si clickie o no en ese elemento

let textos = document.getElementsByClassName("texto"); //selecciona por clase

let selector = document.querySelector(".texto");
//query selector - es un selector avanzado que lo que hace es tener una sintaxis mas similar a lo que nosotros sabemos de css
//me trae el primer elemento que coincida con los parametros

let selectores = document.querySelectorAll(".texto")//query selector all - trae todos los nodos