package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Empresa {

	private String nombre;
	private ArrayList <Empleado> empleados;
	private ArrayList<Generacion> generaciones;
	
	public Empresa(String nombre) {
		super();
		this.nombre = nombre;
		this.empleados = new ArrayList<>();
		this.generaciones = this.crearGeneraciones();
	}

	// CREO LA LISTA DE GENERACIONES EN EL CONSTRUCTOR EN VEZ DE EN EL TEST, PARA AHORRAR CODIGO 
	private ArrayList<Generacion> crearGeneraciones() {
		ArrayList<Generacion> generaciones = new ArrayList<>();
		generaciones.add(new Generacion (1,"G1"));
		generaciones.add(new Generacion (2,"G1"));
		generaciones.add(new Generacion (3,"G1"));
		return generaciones;
	}
	
	public Generacion buscarGeneracionePorId(Integer id) throws Exception{
		for(Generacion g : this.generaciones){
			if(g.getId().equals(id)){
				return g;
			}
		}
		throw new Exception ("No existe la generacion");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<Generacion> getGeneraciones() {
		return generaciones;
	}

	public void setGeneraciones(ArrayList<Generacion> generaciones) {
		this.generaciones = generaciones;
	}

	public void agregarEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
		
	}

	public Set <Empleado> ObtenerEmpleadosOrdenadosPorId() { //aca accione el compare to que instancie en empleado
		Set<Empleado> empleadosOrdenados = new TreeSet<>();
		empleadosOrdenados.addAll(this.empleados); //add all: une las dos listas
		return empleadosOrdenados;
		
	}

	public Set<Empleado> ObtenerEmpleadosOrdenadosPorNombre() {
		Set<Empleado> empleadosOrdenados = new TreeSet<>(new ordenEmpleadoPorNombre()); //creo otra clase 
		//con implements para usar otro compareTo, porque el otro no puedo modificarlo
		empleadosOrdenados.addAll(this.empleados);
		return empleadosOrdenados;
	}


	public Map<Generacion,List<Empleado>> obtenerEmpleadosAgrupadosPorGeneracion(){
		Map<Generacion,List<Empleado>> empleadoAgrupadoPorGeneracion= new TreeMap<>();
		for (Generacion g : generaciones) {
			List<Empleado> listaEmpleados = obtenerListaEmpleadosPorGeneracion(g);
			empleadoAgrupadoPorGeneracion.put(g,listaEmpleados);
		}
		
		return empleadoAgrupadoPorGeneracion;
	}

	private List<Empleado> obtenerListaEmpleadosPorGeneracion(Generacion g) {
		List <Empleado> empleadosDeLaGeneracion = new ArrayList<>();
		for (Empleado e : empleados) {
			if(e.getGeneracion().equals(g));
			empleadosDeLaGeneracion.add(e);
		}
		return empleadosDeLaGeneracion;
	}
	
	
}
