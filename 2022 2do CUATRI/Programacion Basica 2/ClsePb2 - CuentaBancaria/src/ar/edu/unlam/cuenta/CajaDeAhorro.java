package ar.edu.unlam.cuenta;

public class CajaDeAhorro extends Cuenta {

	private String tipo;
	
	public CajaDeAhorro(Integer numCuenta, Integer dni, String nombre, String apellido, String tipo) {
		super(numCuenta, dni, nombre, apellido);
		this.tipo=tipo;
		
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
