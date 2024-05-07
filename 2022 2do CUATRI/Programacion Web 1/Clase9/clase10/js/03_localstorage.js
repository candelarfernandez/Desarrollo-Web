//crea una variable en local storage
localStorage.setItem("universidad","Unlam") //1.nombre de la variable, 2.el valor de la variable
//vive paa todas las paginas, no solo en este html

//obtiene el dato de una variale de local storage
localStorage.getItem("universidad")

//borrar de local storage
//localStorage.removeItem("universidad")

//array de objetos
let productos=[
    { //entre llave y llave tengo un objeto
        nombre:"Gaseosa", 
        cantidad:2,
        precio:300
    },
    {
        nombre:"Galletitas Oreo", 
        cantidad:4,
        precio:100
    }
];

//creo un producto nuevo, y lo agrego al array
let productoNuevo = {
    nombre:"Fideo",
    cantiad:4,
    precio:200
}

productos.push(productoNuevo)

//localStorage almacena lo datos como String
//convertir arrau de datos en json en string
localStorage.setItem("listaProductos", JSON.stringify(productos)) //COMVIRTE EL JSON(int) EN STRING(usar para guardar)
 //y para obtener el string en json(int)
let productosObtenidos =  JSON.parse(localStorage.getItem("listaProductos"));

