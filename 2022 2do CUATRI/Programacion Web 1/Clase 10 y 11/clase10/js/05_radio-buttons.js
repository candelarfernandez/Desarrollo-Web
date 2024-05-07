let etiquetaH1=document.querySelector("h1");
/*etiquetaH1.style.backgroundColor="#000";
etiquetaH1.style.color="#fff";*/



    //agrega una clase
   // element.classList.add("clase");
    etiquetaH1.classList.add("violeta")

    //elimina una clase
   // element.classList.remove("clase");
    etiquetaH1.classList.remove("violeta")

    //elimina una clase
   // element.classList.toggle("clase");
    etiquetaH1.classList.toggle("violeta")

    //me dice si contine esa clase
    etiquetaH1.classList.contains("violeta")

    //cuando quiero pisar todas las clases por una sola
    etiquetaH1.className="violeta";

    const opciones = document.querySelector("#opciones");
    const texto1=document.querySelector("#texto1")
    const texto2=document.querySelector("#texto2")

    opciones.addEventListener("change", ()=>{
        texto1.classList.add("oculto");
        texto2.classList.add("oculto");
        if(opciones.value==1){
            texto1.classList.remove("oculto")
        }
        if(opciones.value==2){
            texto2.classList.remove("oculto")
        }
        

    })

