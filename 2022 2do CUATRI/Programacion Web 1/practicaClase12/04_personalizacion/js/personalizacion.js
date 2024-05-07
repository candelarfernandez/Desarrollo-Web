const colores = document.getElementsByName("color");
const nombre = document.querySelector("#nombre");
const texto = document.querySelector("#texto");
const tipografia = document.querySelector("#tipografia");
const fondos = document.getElementsByName("fondo");
const vistaPrevia = document.querySelector(".vista-previa");

nombre.addEventListener("keyup", ()=>{
    texto.innerHTML=nombre.value;
});
colores.forEach((item) =>{
    item.addEventListener("click", () =>{
        texto.classList.remove("blanco");
        texto.classList.remove("negro");
        if(item.checked){
            texto.classList.add(item.value);
        }
    })
});
tipografia.addEventListener("change", ()=>{
        texto.classList.remove("roboto");
        texto.classList.remove("yanone");
        if(tipografia.value=="roboto"){
            texto.classList.add("fuente-roboto");
        }
        else if(tipografia.value=="yanone"){
            texto.classList.add("fuente-yanone");
        }
    });
fondos.forEach((item) =>{
    item.addEventListener("click",() =>{
        vistaPrevia.classList.remove("fondo1", "fondo2", "fondo3");
        if(item.checked){
            vistaPrevia.classList.add("fondo"+item.value);
          }
        });
    });    
