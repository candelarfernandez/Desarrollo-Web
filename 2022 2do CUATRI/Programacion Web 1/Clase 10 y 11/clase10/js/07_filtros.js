const section=document.querySelector("#cursos");
cursos.forEach((item) => {
    section.innerHTML+=`<article>
        <p>Establecimiento: ${item.establecimiento}</p>
        <p>Idioma: ${item.idioma}</p>
        <p>Horario: ${item.horario}</p>
    </article>`;
});
const filtrar=document.querySelector("#filtrar");
filtrar.addEventListener("click",()=>{
    section.innerHTML="";
    const combo1=document.querySelector("#establecimiento").value;
    const combo2=document.querySelector("#idioma").value;
    let cursosFiltrados=cursos.filter(curso => curso.establecimiento==combo1 && curso.idioma==combo2);
    cursosFiltrados.forEach((item) => {
        section.innerHTML+=`<article>
            <p>Establecimiento: ${item.establecimiento}</p>
            <p>Idioma: ${item.idioma}</p>
            <p>Horario: ${item.horario}</p>
        </article>`;
    });
});
