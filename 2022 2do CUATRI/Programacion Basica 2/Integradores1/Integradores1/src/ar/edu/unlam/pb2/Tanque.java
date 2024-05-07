package ar.edu.unlam.pb2;

public class Tanque extends Vehiculo implements Terrestre{
	private String modelo;
	private Double velocidad=250.0;
	

	public Tanque(Integer codigo, String modelo) {
		super(codigo);
		this.modelo=modelo;
		
	}

	@Override
	public Double getVelocidad() {
		// TODO Auto-generated method stub
		return this.velocidad;
	}

}
