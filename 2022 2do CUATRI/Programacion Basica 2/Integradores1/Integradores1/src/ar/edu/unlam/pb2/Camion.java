package ar.edu.unlam.pb2;

public class Camion extends Vehiculo implements Terrestre {
	private String modelo;
	private Double velocidad=120.0;

	public Camion(Integer codigo, String modelo) {
		super(codigo);
		this.modelo=modelo;
	}

	@Override
	public Double getVelocidad() {
		// TODO Auto-generated method stub
		return this.velocidad;
	}
	
	
	

}
