const form = document.querySelector(".form");
const nomyap = document.querySelector("#nomyap")
const dni = document.getElementById("dni")
const rdni = document.getElementById("rdni")
const curso = document.querySelector("#curso")
const email = document.querySelector("#email")
var regexemail = /^[0-9a-zA-Z._.-]+\@[0-9a-zA-Z._.-]+\.[0-9a-zA-Z]+$/;
var regexdni = /^[0-9]{8}$/;
var regexNomb = /^.{5,30}$/;


form.addEventListener("submit", (e)=>{
    e.preventDefault();
    validar();
})
function validar(){
    let error=false;
    let mensaje="";

    if(nomyap.value == "" && !regexNomb.test(nomyap.value)){
        error=true;
        mensaje+="<p>El campo nombre y apellido es obligatorio y debe tener entre 5 y 30 caracteres</p>"
    }
    if(dni.value == "" && !regexdni.test(dni.value)){
        error=true;
        mensaje+="<p>El dni es obligatorio</p>"
    }
    if(rdni.value="" || rdni.value != dni.value){
        error=true;
        mensaje+="<p>El dni no coincide</p>"
    }
    if(curso.value == ""){
        error=true;
        mensaje+="<p>El curso es obligatorio</p>"
    }
    if(email.value == "" && !regexemail.test(email.value)){
        error=true;
        mensaje+="<p>El email es obligatorio</p>"
    }

    if(error){
        document.querySelector("#mensaje").innerHTML=mensaje;
    }else{
        form.submit();
    }
}