package ar.edu.unlam.muni;

public class Habitante {
	private Integer dni;
	private String nombre;
	


	public Habitante(Integer dni, String nombre) {
		this.nombre=nombre;
		this.dni=dni;
	}



	public Integer getDni() {
		return dni;
	}



	public void setDni(Integer dni) {
		this.dni = dni;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
