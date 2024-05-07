package ar.edu.unlam.cuenta;

public class Cuenta {
	private Integer numCuenta;
	private Double saldo;
	private Titular titular;
	
	
	
	public Cuenta(Integer numCuenta, Double saldo, Titular titular){
		this.numCuenta=numCuenta;
		this.saldo=saldo;
		this.titular=titular;
		
	}
	public Cuenta(Integer numCuenta, Titular titular){
		super();
		this.numCuenta=numCuenta;
		this.saldo=0.0;
		this.titular=titular;
	}
	
	public Cuenta(Integer numCuenta, Integer dni, String nombre, String apellido){
		super();
		this.numCuenta=numCuenta;
		this.saldo=0.0;
		this.titular= new Titular(apellido, dni, nombre);
	}
	
	public Boolean extraer(Double monto){
		if(monto <= this.saldo){
			this.saldo-=monto;
			return true;
		}
		return false;
	}
	
	public void depositar(Double montoADepositar){
		this.saldo += montoADepositar;
	}

	public Integer getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(Integer numCuenta) {
		this.numCuenta = numCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}

	
}
