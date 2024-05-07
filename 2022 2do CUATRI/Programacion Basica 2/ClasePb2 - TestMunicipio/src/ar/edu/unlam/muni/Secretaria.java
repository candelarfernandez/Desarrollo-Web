package ar.edu.unlam.muni;

import java.util.ArrayList;

public class Secretaria {
	private String nombre;
	private ArrayList <Habitante> habitantes;
	
	public Secretaria(String nombre) {
		this.nombre = nombre;
		this.habitantes= new ArrayList<Habitante>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarhabitante(Habitante habitante) {
		habitantes.add(habitante);
	}

	public Integer obtenerCantidadHabitante() {
		
		return habitantes.size();
	}

	public ArrayList<Habitante> getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(ArrayList<Habitante> habitantes) {
		this.habitantes = habitantes;
	}
	
	
	

	
	

}
