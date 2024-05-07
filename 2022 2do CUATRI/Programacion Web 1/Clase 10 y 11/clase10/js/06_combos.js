let colores=["azul","verde","naranja"];
let paises=["Argentina","Brazil","Chile"];
let universidades=["UNLAM","UADE","UNTREF"];

const inicial=document.querySelector("#inicial");
const secundario=document.querySelector("#secundario");
inicial.addEventListener("change",()=>{
    secundario.innerHTML="";
    if(inicial.value==1){
        colores.forEach((item)=>{
            let option=document.createElement("option");
            option.value=item;
            let texto=document.createTextNode(item);
            option.appendChild(texto);
            secundario.appendChild(option);
        });
    }
    else if(inicial.value==2){
        paises.forEach((item)=>{
            let option=document.createElement("option");
            option.value=item;
            let texto=document.createTextNode(item);
            option.appendChild(texto);
            secundario.appendChild(option);
        });
    }else if(inicial.value==3){
        universidades.forEach((item)=>{
            let option=document.createElement("option");
            option.value=item;
            let texto=document.createTextNode(item);
            option.appendChild(texto);
            secundario.appendChild(option);
        });
    }
});

/*
    Opcion innerHTML    
    secundario.innerHTML+=`<option value="${item}">${item}</option>`;

    let option=document.createElement("option"); esto crea un nodo de tipo etiqueta
    option.value=item;
    let texto=document.createTextNode(item); esto crea un nodo de texto
    option.appendChild(texto);
    secundario.appendChild(option);s

*/