const cursos = [
    {
        titulo: 'javascript',
        modalidad:'virtual' 
    }, 
    {
        titulo: 'java',
        modalidad:'virtual' 
    }, 
    {
        titulo: 'html 5',
        modalidad:'presencial' 
    }
]

/*const resultado = cursos.filter(curso => curso.titulo.length > 4);

console.log(resultado);*/
const resultado=document.querySelector("#resultado");
cursos.forEach((item)=>{
    resultado.innerHTML+=`<article>
        <p>Título: ${item.titulo}</p>
        <p>Modalidad: ${item.modalidad}</p>
    </article>`;
});
const buscador=document.querySelector("#buscador");
buscador.addEventListener("keyup",()=>{
    const valor=buscador.value;
    let cursosFiltrados=cursos.filter(curso => curso.titulo.indexOf(valor)>-1);
    resultado.innerHTML=""; // vaciar el section de resultados
    cursosFiltrados.forEach((item)=>{
        resultado.innerHTML+=`<article>
            <p>Título: ${item.titulo}</p>
            <p>Modalidad: ${item.modalidad}</p>
        </article>`; 
    });
});