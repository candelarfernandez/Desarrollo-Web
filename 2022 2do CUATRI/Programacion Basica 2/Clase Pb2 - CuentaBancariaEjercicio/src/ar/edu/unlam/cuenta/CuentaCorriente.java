package ar.edu.unlam.cuenta;

public class CuentaCorriente extends Cuenta {

	private Double limiteDescubierto;
	
	public CuentaCorriente(Integer numCuenta, Double saldo, Titular titular, Double limiteDescubierto) {
		super(numCuenta, saldo, titular);
		this.limiteDescubierto=limiteDescubierto;
	}
	
	public CuentaCorriente(Integer numCuenta, Double saldo, String nombre, String apellido, Integer dni,  Double limiteDescubierto) {
		super(numCuenta, dni, nombre, apellido);
		this.limiteDescubierto=limiteDescubierto;
	}
	
	public Double getLimiteDescubierto() {
		return limiteDescubierto;
	}

	public void setLimiteDescubierto(Double limiteDescubierto) {
		this.limiteDescubierto = limiteDescubierto;
	}

	@Override
	public Boolean extraer(Double monto){
		if(monto <= this.getSaldo() + limiteDescubierto){
			setSaldo(getSaldo() - monto);
			// extraer como lo hace el padre: super.extraer(monto);
			return true;
		}
		return false;
	}
	
	

	
	


}
