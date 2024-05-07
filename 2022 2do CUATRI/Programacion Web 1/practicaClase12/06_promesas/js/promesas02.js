let cursos = [
    {
        id:1,
        titulo: 'javascript',
        modalidad:'virtual' 
    }, 
    {
        id:2,
        titulo: 'java',
        modalidad:'virtual' 
    }
]
let instituciones=[
    {
        id:1,
        telefono:'UNLAM'
    },
    {
        id:2,
        telefono:'UBA'
    }
    
];
function obtenerCurso (id){
    return new Promise((resolve, reject)=>{
        if(cursos.find(curso=>curso.id===id)){
            console.log('El curso existe');
            resolve(obtenerInstitucion(id));
        }else{
            reject ('El curso no existe');
        }
    });
};
function obtenerInstitucion(id){
    return new Promise((resolve, reject)=>{
        if(instituciones.find(institucion=>institucion.id===id)){
            resolve('La institucion existe');
        }else{
            reject ('La institucion no existe');
        }
    });
};

obtenerCurso(1)
.then(success =>{
    return success;
})
.then(mensaje =>{
    console.log(mensaje);
})
.catch(error =>{
    console.log(error);
});