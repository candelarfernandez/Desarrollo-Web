<?php
//EJERCICIO 5

//EJERCICIO 5.A
function sumatoria_a($array){
    $length=count($array);
    $sumatoria=0;
    for($i=0;$i<=$length;$i++){
        $sumatoria += $i;
    }return $sumatoria;
}


//EJERCICIO 5.B
function sumatoria_b($array){
$suma=0;
foreach ($array as $value) {
   $suma += $value;
}return $suma;

}

//EJERCICIO 5.C
function sumatoria_c($array){
    $length=count($array);
    $sumatoria=0;
    $i=0;
    while($i<$length){
        $i++;
        $sumatoria += $i;
    } return $sumatoria;
} 

?>