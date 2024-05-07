package ar.edu.unlam.pob2;

import java.util.ArrayList;

public abstract class Figura {
	
	protected String nombre;
	protected Double area;
	protected Double perimetro;
	
	public Figura(String nombre, Double area, Double perimetro) {
		this.nombre=nombre;
		this.area=area;
		this.perimetro=perimetro;
	}
	
	
	
	
	public abstract Double calcularArea();
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Double getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(Double perimetro) {
		this.perimetro = perimetro;
	}

	

}
