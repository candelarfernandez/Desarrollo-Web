package ar.edu.unlam.pb2;

public class Submarino extends Vehiculo implements Acuatico{
	
	private String modelo;
	private Double profundidad=200.0;
	
	public Submarino(Integer codigo, String modelo) {
		super(codigo);
		this.modelo=modelo;
	}

	@Override
	public Double getProfundidad() {
		// TODO Auto-generated method stub
		return this.profundidad;
	}
	
	
	
	
	

}
