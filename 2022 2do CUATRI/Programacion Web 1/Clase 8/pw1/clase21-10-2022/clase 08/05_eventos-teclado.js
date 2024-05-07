let campoNombre = document.getElementById("nombre");
//let campoNombre=document.querySelecto("#nombre");

campoNombre.addEventListener("keyup", (e) => {
    // para saber que tecla presiono, y en base a eso se hace una funcion, guarda la funcion del evento - console.log(e);
    //console.log(campoNombre.value);

    let nombre = campoNombre.value;
    document.getElementById("saludo").innerHTML = nombre;
});

//campoNombre.keyup=function(){}