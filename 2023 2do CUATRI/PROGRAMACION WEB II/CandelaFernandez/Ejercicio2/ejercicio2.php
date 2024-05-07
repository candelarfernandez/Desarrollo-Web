<?php
//Ejercicio 2-a

function binomioCuadradoPerfecto_a($a, $b){
    $primer = pow($a, "2");
    $segundo = "2"*$a*$b;
    $tercer = pow($b, "2");
    return $resultadoFinal = ($primer + $segundo + $tercer);
}


//EJERCICIO 2.B
function binomioCuadradoPerfecto_b($a, $b){
    $primer = ($a*$a);
    $segundo = "2"*$a*$b;
    $tercer = ($b*$b);
    return $resultadoFinal = ($primer + $segundo + $tercer);
}




?>