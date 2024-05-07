const nombre=document.querySelector("#nombre");
const texto=document.querySelector("#texto");
const tipografia=document.querySelector("#tipografia");
const colores=document.getElementsByName("color");
const fondos=document.getElementsByName("fondo");
const vistaPrevia=document.querySelector(".vista-previa");

nombre.addEventListener("keyup",()=>{
    texto.innerHTML=nombre.value;
});
tipografia.addEventListener("change",()=>{
    texto.classList.remove("fuente-roboto","fuente-yanone");
    if(tipografia.value=="roboto"){
        texto.classList.add("fuente-roboto");
    }else if(tipografia.value=="yanone"){
        texto.classList.add("fuente-yanone");
    }
});
colores.forEach((item)=>{
    item.addEventListener("click",()=>{
        texto.classList.remove("blanco","negro");
        if(item.checked){
            texto.classList.add(item.value);
        }
    });
});
fondos.forEach((item)=>{
    item.addEventListener("click",()=>{
        vistaPrevia.classList.remove("fondo1", "fondo2","fondo3");

        if(item.checked){
            vistaPrevia.classList.add(`fondo${item.value}`);
            //vistaPrevia.classList.add("fondo"+item.value);
        }
    });
});
