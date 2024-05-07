const agregar=document.querySelector("#agregar");
const eliminar=document.querySelector("#eliminar");
const lista=document.querySelector("#lista");

agregar.addEventListener("click",()=>{
    const elemento=lista.lastChild;
    const clon=elemento.cloneNode(true);
    lista.appendChild(clon); 
});
eliminar.addEventListener("click",()=>{
    lista.removeChild(lista.lastChild);
});