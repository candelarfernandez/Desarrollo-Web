
<?php

//EJERCICIO 1.A
function semaforo_a($color){
    if($color == "rojo" || $color == "verde" || $color == "amarillo"){
        if($color == "rojo"){
            return " <br> frene";
        }
        if($color == "amarillo"){
            return "<br> precaucion";
        }
        if($color == "verde"){
            return "<br> avance";
        }
    }else{
        return "<br> estado desconocido";
    }
}


//EJERCICIO 1.B
function semaforo_b($color){
  //  $variable = (condición) ? valor_si_verdadero : valor_si_falso;
  return ($color == "rojo") ? " <br> frene" : 
  (($color == "verde") ?  "<br> avance" : 
  (($color == "amarillo") ? "<br> precaucion" : "<br> estado desconocido"));
}


  

//EJERCICIO 1.C
function semaforo_c($color){
    switch($color){
        case $color =="rojo":
            return " <br> frene";
        break;
        case $color =="verde":
            return " <br> avance";
        break;
        case $color =="amarillo":
            return " <br> precaucion";
        break;
        default:
        return "<br> estado desconocido";
        break;
    }
}


?>