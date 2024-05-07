package ar.edu.unlam.pb2;

public class CajaAhorro extends Cuenta {
	
	private String tipo;
	
	public CajaAhorro(Integer numCuenta, Integer dni, String nombre, String apellido, String tipo) {
		super(numCuenta, dni, nombre, apellido);
		this.tipo = tipo;
	
	}

	public Boolean extraer(Double monto) {
		if (monto <= getSaldo()) {
			setSaldo(getSaldo()-monto);
			return true;
		}
		return false;
	}
	
	

	public String getTipo() {
		return "Caja ahorro";
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
