package ar.edu.unlam.pb2;

import java.time.LocalDate;
import java.util.ArrayList;


public class Empleado implements Comparable<Empleado>{
	
	private Integer id;
	private String nombre;
	private LocalDate fecha_ingreso;
	private Rol rol;
	private Generacion generacion;
	private ArrayList<Ausencias> vacaciones;
	
	public Empleado(Integer id, String nombre, LocalDate fecha_ingreso, Rol rol, Generacion generacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha_ingreso = fecha_ingreso;
		this.rol = rol;
		this.generacion = generacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(LocalDate fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Generacion getGeneracion() {
		return generacion;
	}

	public void setGeneracion(Generacion generacion) {
		this.generacion = generacion;
	}

	//compara los empleados de esa coleccion de manera automatica
	@Override
	public int compareTo(Empleado e) {
		return this.id.compareTo(e.id); //si devuelve 0 son iguales
	}
	
	
	
	
	

}
