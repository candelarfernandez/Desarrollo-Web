package ar.edu.unlam.pb2;

public class Avion extends Vehiculo implements Volador {
	private String modelo;
	private Double altura=12.0;

	

	public Avion(Integer codigo, String modelo) {
		super(codigo);
		this.modelo=modelo;
		
	}



	@Override
	public Double getAltura() {
		// TODO Auto-generated method stub
		return this.altura;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	

}
