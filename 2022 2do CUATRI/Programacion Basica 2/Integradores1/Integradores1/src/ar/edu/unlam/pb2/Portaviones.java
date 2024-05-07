package ar.edu.unlam.pb2;

public class Portaviones extends Vehiculo implements Volador{
	private String modelo;
	private Double altura=50.0;

	public Portaviones(Integer codigo, String modelo) {
		super(codigo);
		// TODO Auto-generated constructor stub
		this.modelo=modelo;
	}

	@Override
	public Double getAltura() {
		// TODO Auto-generated method stub
		return this.altura;
	}
	
	

}
