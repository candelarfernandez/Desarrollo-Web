package ar.edu.unlam.pb2;

public class HidroAvion extends Vehiculo implements Volador, Acuatico{
	private String modelo;
	private Double profundidad=200.0;
	private Double altura=500.0;

	public HidroAvion(Integer codigo, String modelo) {
		super(codigo);
		this.modelo=modelo;
	}

	@Override
	public Double getProfundidad() {
		// TODO Auto-generated method stub
		return this.profundidad;
	}

	@Override
	public Double getAltura() {
		// TODO Auto-generated method stub
		return this.altura;
	}
	
	
	

}
