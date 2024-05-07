let num= 50;

/*una promesa tiene dos parametros, resolve y reject
que son parte de una funcion*/
const promesa1= new Promise ((resolve,reject)=>{
    if(num==50){
        resolve('perfecto!');
    }else{
        reject('incorrecto');
    }
});

//ejecutamos la promesa
promesa1.then( success =>{
    console.log('success: '+success)
}) //cuando el valor sea positivo
.catch(error =>{
    console.log('error: '+error)
}); //cuando sea negativo o haya un error