const direccion = document.querySelector("#direccion");
const texto = document.querySelector(".texto");
const seleccionar = document.querySelector("#seleccionar");
const caja = document.querySelector(".caja1");
const color = document.getElementsByName("color");
const form = document.getElementsByClassName("form");

form.addEventListener("submit", (e)=>{
    e.preventDefault();    
   validar();
})
function validar(){
    let mensaje ="";
    let error =false;
    let usuario = document.querySelector("#usuario")
    let contrasenia =document.querySelector("#contrasenia");

if(usuario.value == ""){
    error=true;
    mensaje="<p>El campo es obligatorio</p>"
}
if(contrasenia.value == ""){
    error=true;
    mensaje="<p>El campo es obligatorio</p>"
}
if(error){
    document.querySelector("#mensaje").innerHTML=mensaje;
}else{
    form.submit();
    mensaje="<p>Se guardaron los datos</p>"
}
}

direccion.addEventListener("keyup", () =>{
    texto.innerHTML="";
    texto.innerHTML=direccion.value;
});

seleccionar.addEventListener("change", ()=>{
    //caja.classList.remove("azul", "rojo", "verde");
    if(seleccionar.value == 1){
        caja.classList.add("azul");
    }
    if(seleccionar.value == 2){
        caja.classList.add("rojo");
    }
    if(seleccionar.value == 3){
        caja.classList.add("verde");
    }
    if(seleccionar.value == 4){
        caja.classList.remove("azul", "rojo", "verde")
    }
})

color.forEach((item) =>{
    item.addEventListener("click", ()=>{
        texto.classList.remove("negro", "blanco")
        if(item.checked){
            texto.classList.add(item.value);
        }
    })
})


