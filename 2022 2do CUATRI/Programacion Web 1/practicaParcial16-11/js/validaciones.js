let nombre=document.getElementById("nombre");
let direccionnueva = document.getElementById("direccionNueva");
let seleccionar = document.getElementById("seleccionar");
let caja = document.querySelector(".caja-1");
let texto =document.querySelector(".texto")


direccionnueva.addEventListener("keyup", ()=>{
    nombre.innerHTML="";
    nombre.innerHTML=direccionnueva.value;
});

seleccionar.addEventListener("change", ()=>{
   caja.classList.remove("azul", "verde", "rojo");
   if(seleccionar.value == "1"){
    caja.classList.add("azul");
    console.log("azulll");
   }
   if(seleccionar.value == "2"){
    caja.classList.add("verde");
   }
   if(seleccionar.value == "3"){
    caja.classList.add("rojo");
   }
})