package ar.edu.unlam.cuenta;

public class Titular {
	private String apellido;
	private Integer dni;
	private String nombre;
	
	
	

	public Titular(String apellido, Integer dni, String nombre) {
		super();
		this.apellido=apellido;
		this.dni=dni;
		this.nombre=nombre;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	

}
