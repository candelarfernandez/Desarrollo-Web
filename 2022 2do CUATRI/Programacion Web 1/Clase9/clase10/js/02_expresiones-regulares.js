let regexEmail=/^[0-9a-zA-Z._.-]+\@[0-9a-zA-Z._.-]+\.[0-9a-zA-Z]+$/;
let regexNumero=/^[0-9]+$/;
let regexTexto=/^[a-zA-Z]+$/;
let patenteVieja=/^[A-Z]{3}[0-9]{3}$/;
let patenteNueva=/^[A-Z]{2}[0-9]{3}[A-Z]{2}$/;
//+cuaquier cantidad y numero entre {} la cant de num que queremos

const form=document.querySelector("form");
form.addEventListener("submit", (e)=>{
    e.preventDefault(); //previene que el form se envie
    validar();
})
function validar(){
    let error=false;
    let mensajeError="";
    const email=document.querySelector("#email").value;


    if(!regexEmail.test(email)){
        error=true;
        mensajeError+="<p>El formato no es correcto</p>"
    }

    if(error){
        document.querySelector("#mensaje").innerHTML=mensajeError;
    }else{
        form.submit();
    }

}