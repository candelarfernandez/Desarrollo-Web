const agregar=document.querySelector("#agregar");
agregar.addEventListener("click", ()=>{
    //1. obtener el valor del campo item
    const item=document.querySelector("#item").value;

    //2.crear un nodo li 
    const nodoli= document.createElement("li");

    //3.crear un nodo de texto cn el valor obtenido en el campo
    const nodoTexto=document.createTextNode(item);

    //4.hacer hijo el nodo texto del li
    nodoli.appendChild(nodoTexto);

    //5.hacer hijo al li del ul
    const leguajes=document.querySelector("#lenguajes");
    lenguajes.appendChild(nodoLi);

})