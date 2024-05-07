let contador=0;
let tiempo=setInterval(()=>{
                contador++;
                console.log(contador);
            },1000);
setTimeout(()=>{
    clearInterval(tiempo);
    console.log("pasaron 5 segundos");
},5000);