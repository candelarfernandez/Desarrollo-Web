package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Batalla {
	private String nombre;
	private Double latitud;
	private Double longitud;
	private TipoDeBatalla tipo;
	Set<Vehiculo> vehiculosEnLaBatalla = new HashSet<>();
	
	
	public Batalla(String nombre, Double latitud, Double longitud, TipoDeBatalla tipo) {
		this.nombre=nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.tipo = tipo;
		
	}
	


	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public Double getLatitud() {
		return latitud;
	}


	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}


	public Double getLongitud() {
		return longitud;
	}


	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}


	public TipoDeBatalla getTipo() {
		return tipo;
	}


	public void setTipo(TipoDeBatalla tipo) {
		this.tipo = tipo;
	}


	public Set<Vehiculo> getVehiculosEnLaBatalla() {
		return vehiculosEnLaBatalla;
	}


	public void setVehiculosEnLaBatalla(Set<Vehiculo> vehiculosEnLaBatalla) {
		this.vehiculosEnLaBatalla = vehiculosEnLaBatalla;
	}


	@Override
	public String toString() {
		return "Batalla [latitud=" + latitud + ", longitud=" + longitud + ", tipo=" + tipo + ", vehiculosEnLaBatalla="
				+ vehiculosEnLaBatalla + "]";
	}
	
	
	

}
