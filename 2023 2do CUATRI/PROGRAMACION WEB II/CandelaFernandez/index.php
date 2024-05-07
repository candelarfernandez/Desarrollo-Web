<?php
require_once ('Ejercicio1/ejercicio1.php');
require_once ('Ejercicio2/ejercicio2.php');
require_once ('Ejercicio3/ejercicio3.php');
require_once ('Ejercicio4/ejercicio4.php');
require_once ('Ejercicio5/ejercicio5.php');
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Candela Fernandez</title>
</head>
<body>
    <h1>Candela Fernandez</h1>

    <h2>Ejercicio1</h2>
    <div class="ejercicio">Cree una función llamada Semaforo, que recibe por parametro un cólor cómo texto (“rojo”
“amarillo”,”verde”). 
<br>Dicha función devolverá el estado que corresponde: “frene”, “precaución”,
“avance” o “estado desconocido” ante un caso no esperado.
<br>a) función semaforo_a($color): Resuelva la solución utilizando if else
<br>b) función semaforo_b($color): Resuelva la solución utilizando if inline (return ?: )
<br>c) función semaforo_c($color): Resuelva la solución utilizando switch
</div>

    <div class="contenedor">
    <div class="resultado">
    Ejecuto el ejercicio 1-A con las variables rojo, verde, amarillo y estado desconocido, y el resultado del mismo es
    <?php echo semaforo_a("rojo")?>
    </div>
    <div class="resultado">
    Ejecuto el ejercicio 1-B con las variables rojo, verde, amarillo y estado desconocido, y el resultado del mismo es
    <?php echo semaforo_b("naranja")?>
    </div>
    <div class="resultado">
    Ejecuto el ejercicio 1-C con las variables rojo, verde, amarillo y estado desconocido, y el resultado del mismo es
    <?php echo semaforo_c("amarillo")?>
    </div>
    </div>

    <h2>Ejercicio2</h2>
    <div class="ejercicio">Cree una función llamada binomioCuadradoPerfecto que realice la ecuación de dicha problemática:
recibe dos parámetros y devuelve el cuadrado de la suma de ambos (a+b)
2
<br>a) función binomioCuadradoPerfecto_a($a, $b): Resuelva la solución utilizando la función de
potencia
<br>b) función binomioCuadradoPerfecto_b($a, $b): Resuelva la solución utilizando la fórmula
desarrollada del binomio: a
2 + 2*a*b + b</div>

    <div class="contenedor">
        <div class="resultado">
        Ejecuto el ejercicio 2-A con las variables 4, 5 y el resultado del mismo es
            <?php echo "<br>", binomioCuadradoPerfecto_a(4, 5);?>
        </div>
        <div class="resultado">
        Ejecuto el ejercicio 2-B con las variables 4, 5 y el resultado del mismo es
            <?php echo "<br>", binomioCuadradoPerfecto_b(4, 5);?>
        </div>
    </div>

    <h2>Ejercicio3</h2>
    <div class="ejercicio">Cree una función concatenar($texto1, $texto2) que reciba dos textos como parámetro y devuelva
ambos textos concatenados como uno solo.</div>

    <div class="contenedor">
        <div class="resultado">
        Ejecuto el ejercicio 3 con las variables "buenos", "dias" y el resultado del mismo es
            <?php echo concatenar("buenos", "dias");?>
        </div>
    </div>

    <h2>Ejercicio4</h2>
    <div class="ejercicio"> Cree una función llamada incrementar, que reciba una variable y sin devolver nada como retorno de
la función, el valor del parámetro haya sido incrementado en 1
(Ver pasaje de parámetros por referencia)</div>

    <div class="contenedor">
        <div class="resultado">
        Ejecuto el ejercicio 4 con la variable 1 y el resultado del mismo es
            <?php 
            $variable =1;
            incrementar($variable);?>
        </div>
    </div>

    <h2>Ejercicio5</h2>
    <div class="ejercicio">Cree una función sumatoria que reciba un vector cómo parámetro, y devuelva la suma de todos sus
valores.
<br>a) función sumatoria_a( $array ): Resuelva la solución utilizando la estructura de control for
<br>b) función sumatoria_b( $array ): Resuelva la solución utilizando la estructura for each
<br>c) función sumatoria_c( $array ): Resuelva la solución utilizando la estructura de control while</div>

    <div class="contenedor">
        <div class="resultado">
        Ejecuto el ejercicio 5-A con la variable 1,2,3 y el resultado del mismo es
            <?php echo "<br>", sumatoria_a(array(1,2,3));?>
        </div>
        <div class="resultado">
        Ejecuto el ejercicio 5-B con la variable 1,2,3 y el resultado del mismo es
            <?php  echo "<br>", sumatoria_b(array(1,2,3));?>
        </div>
        <div class="resultado">
        Ejecuto el ejercicio 5-C con la variable 1,2,3 y el resultado del mismo es
            <?php echo "<br>", sumatoria_c(array(1,2,3));?>
        </div>
    </div>
    




    
</body>
</html>

<style>
    *{
        font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    }
    h1{
        text-align:center;
        padding:50px;
    }
    h2{
        text-align:center;
    }
    .ejercicio, .resultado{
        text-align:center;
    }
    .contenedor{
        display:flex;
    }
    .resultado{ 
        width:100%;
        margin:15px;
        padding: 15px;
        background-color: rgb(199, 204, 204);
    }
</style>
