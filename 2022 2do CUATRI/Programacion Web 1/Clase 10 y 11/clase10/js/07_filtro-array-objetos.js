const btnFiltrar=document.querySelector("#filtrar");
btnFiltrar.addEventListener("click", ()=>{
    filtrar();
});
function filtrar(){
    //1.obtener los valores de los selects con value
    const establecimiento=document.querySelector("#establecimiento").value;
    const idioma=document.querySelector("#idioma").value;
    const cursosCont=document.querySelector("#cursos");

    //2.filtrar el array de objetos
    let filtrado=cursos.filter(cursos=>cursos.establecimiento==establecimiento&&cursos.idioma==idioma);

    //3.vaciar el section de cursos con innerHTML
    cursosCont.innerHTML="";

    //4.recorrer el array y lo va a llenar de datos con appendChild
    filtrado.forEach(curso => {
        cursosCont.innerHTML+=`
            <article>
                <p>Establecimiento:${curso.establecimiento}</p>
                <p>Idioma:${curso.idioma}</p>
                <p>Horario:${curso.horario}</p>
            </article>
        `;
    });
}