package ar.edu.unlam.pob2;

public class Circulo extends Figura {
	private Double radio; 
	private static Double PI= 3.1416;
	
	public Circulo(String nombre, Double area, Double perimetro, Double radio) {
		super(nombre, area, perimetro);
		this.radio=radio;
	}

	public Double getRadio() {
		return radio;
	}

	public void setRadio(Double radio) {
		this.radio = radio;
	}

	@Override
	public Double calcularArea() {
		this.radio= PI*2;
		return radio;
	}

	

}
