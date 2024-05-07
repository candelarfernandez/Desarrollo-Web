const producto=document.querySelector("#producto");
const codigo=document.querySelector("#codigo");
const repetirCodigo=document.querySelector("#repetirCodigo");
var tipo=document.querySelector("#tipo");
const email=document.querySelector("#email");
const form =document.querySelector(".form");
var regexemail = /^[0-9a-zA-Z._.-]+\@[0-9a-zA-Z._.-]+\.[0-9a-zA-Z]+$/;
var regexcodigo = /^[0-9]{6}$/;
var regex 

form.addEventListener("submit", (e) =>{
    e.preventDefault();
    validar();
})
function validar(){
    let error =false;
    let mensaje ="";
    if(producto.value == "" || producto.value.length <=3 || producto.value.length>=20){
        error=true;
        mensaje+="<p>El campo producto es obligatorio y debet tener entre 3 y 20 caracteres</p>"
    }
    if(codigo.value == "" && !regexcodigo.test(codigo.value)){
        error=true;
        mensaje+="<p>El campo codigo es obligatorio</p>"
    }
    if(repetirCodigo.value == "" && repetirCodigo.value != codigo.value){
        error=true;
        mensaje+="<p>El campo repetir Codigo es obligatorio</p>"
    }
    if(email.value == "" && !regexemail.test(email.value)){
        error=true;
        mensaje+="<p>El campo email es obligatorio</p>"
    }
    if(error){
       document.querySelector("#mensaje").innerHTML=mensaje;
        mensaje.style.color='red';
    }else{
        form.submit();
    }
    

}


