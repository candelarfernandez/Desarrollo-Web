
//const apellido = document.querySelector("#apellido");

//Evento foco
/*apellido.addEventListener("focus",()=>{
    alert("hiciste foco en este campo")
})*/

const form = document.querySelector("form");
form.addEventListener("submit",(e)=>{ //e: guarda informacion sobre el evento que se mando(se puede poner cualquier
    //nomre de variable)
    e.preventDefault(); //que se envie el evento
    validar();
});

function validar(){
    let error = false;
    let mensajeError = '';
    const nombre=document.querySelector("#nombre");
    const apellido=document.querySelector("#apellido");
    const provincia =document.querySelector("#provincia");
    const opciones=document.getElementsByName("sexo");
    const condiciones=document.querySelector("#condiciones");
    console.log(opciones);
    let seleccionado= false;

    if(nombre.value==""){
        error=true;
        mensajeError+="<p>El campo nombre es obligatorio</p>"; //perimte insertar etiquetas html
    }
    if(apellido.value.length<3 || apellido.value.length>10){
        error=true;
        mensajeError+="<p>El apellido tiene que tener mas de tres caractres y menos de 10</p>"
    }
    if(provincia.value==0){
        error=true;
        mensajeError+="<p>El campo provincia es obligatorio</p>";
    }
    opciones.forEach((item)=>{
        if(item.checked){ //si esta checked
          seleccionado=true;
        }
    })
    if(!seleccionado){
        error=true;
        mensajeError+="<p>Tenes que seleccionar una opcion</p>";
    }
    if(!condiciones.checked){
        error=true;
        mensajeError+="<p>Es oligatorio que aceptes los terminos y condiciones</p>";
    }

    if(error){  //lo mismo que error== true//
       document.querySelector("#mensaje").innerHTML=mensajeError;
    }else{
        form.submit();
    } 
    
}

