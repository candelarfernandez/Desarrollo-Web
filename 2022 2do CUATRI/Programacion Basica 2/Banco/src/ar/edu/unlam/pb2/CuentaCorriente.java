package ar.edu.unlam.pb2;

public class CuentaCorriente extends Cuenta {
	private Double limiteDescubierto;
	private Integer puntos;

	public CuentaCorriente(Integer numCuenta, Double saldo, Titular titular, Double limiteDescubierto) {
		super(numCuenta, saldo, titular);
		this.limiteDescubierto = limiteDescubierto;
		this.puntos=0;
	}

	
	public CuentaCorriente(Integer numCuenta, Double saldo, String nombre, String apellido, Integer dni, Double limiteDescubierto) {
		super(numCuenta, dni, nombre, apellido);
		this.limiteDescubierto = limiteDescubierto;
		this.puntos=0;
	}


	public void despositar(Double monto) {
		super.depositar(monto);
		calcularPuntos(monto);
		
	}
	
	public void calcularPuntos(Double monto) {
		this.puntos += ((Double)(monto*0.10)).intValue();
		
	}


	public Integer getPuntos() {
		return puntos;
	}


	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}


	public Double getLimiteDescubierto() {
		return limiteDescubierto;
	}

	public void setLimiteDescubierto(Double limiteDescubierto) {
		this.limiteDescubierto = limiteDescubierto;
	}
	
	@Override
	public Boolean extraer(Double monto) {
		if (monto <= this.getSaldo() + limiteDescubierto) {
			Double saldoFinal = getSaldo()-monto; 
			setSaldo(saldoFinal);
			
			// extraer como lo hace el padre
			//super.extraer(monto);
			return true;
		}
		return false;
		
	}
	public String getTipo() {
		return "CuentaCorriente";
	}
	
}
