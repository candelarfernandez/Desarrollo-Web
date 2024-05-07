package ar.edu.unlam.pob2;

public class Rectangulo extends Figura {
	
	private Double lado;
	public Rectangulo(String nombre, Double area, Double perimetro, Double lado) {
		super(nombre, area, perimetro);
		this.lado=lado;
	}
	public Double getLado() {
		return lado;
	}
	public void setLado(Double lado) {
		this.lado = lado;
	}
	@Override
	public Double calcularArea() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
