const texto =document.querySelector(".texto");
const direccion =document.querySelector("#direccion")
const seleccionar = document.querySelector("#seleccionar");
const caja1 =document.querySelector(".caja1");
const color =document.getElementsByName("color");

direccion.addEventListener("keyup", ()=>{
    texto.innerHTML="";
    texto.innerHTML=direccion.value;
})

seleccionar.addEventListener("click", ()=>{
    if(seleccionar.value == 1){
        caja1.classList.add("azul")
    }
    if(seleccionar.value == 2){
        caja1.classList.add("rojo")
    }
    if(seleccionar.value == 3){
        caja1.classList.add("verde")
    }
    if(seleccionar.value == 4){
        caja1.classList.remove("azul", "rojo", "verde")
    }
})
color.forEach((item)=>{
    item.addEventListener("click", ()=>{
        texto.classList.remove("blanco", "negro")
        if(item.checked){
            texto.classList.add(item.value)
        }
    })
})