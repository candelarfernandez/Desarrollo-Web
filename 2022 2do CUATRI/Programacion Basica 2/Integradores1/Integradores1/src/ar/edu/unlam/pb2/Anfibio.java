package ar.edu.unlam.pb2;

public class Anfibio extends Vehiculo implements Terrestre, Acuatico{
	private String modelo;
	private Double velocidad=100.0;
	private Double profundidad=200.0;
	
	public Anfibio(Integer codigo, String modelo) {
		super(codigo);
		this.modelo=modelo;
	}

	@Override
	public Double getProfundidad() {
		// TODO Auto-generated method stub
		return this.profundidad;
	}

	@Override
	public Double getVelocidad() {
		// TODO Auto-generated method stub
		return this.velocidad;
	}
	
	
	
	
	

}
