package ar.edu.unlam.pb2;

public class Destructor extends Vehiculo implements Terrestre{
	private String modelo;
	private Double velocidad=200.0;

	public Destructor(Integer codigo, String modelo) {
		super(codigo);
		// TODO Auto-generated constructor stub
		this.modelo=modelo;
	}

	@Override
	public Double getVelocidad() {
		// TODO Auto-generated method stub
		return this.velocidad;
	}
	
	
	
	
	

}
