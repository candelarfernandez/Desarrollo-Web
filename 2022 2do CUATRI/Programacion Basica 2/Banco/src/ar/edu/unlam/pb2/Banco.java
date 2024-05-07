package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Banco {
	private ArrayList<Cuenta> cuentas;
	
	public Banco() {
		this.cuentas= new ArrayList<>();
	}
	
	private void agregarCuenta(Cuenta cuenta) {
		this.cuentas.add(cuenta);
	}
	
	public boolean Transferir(Double monto, Cuenta origen, Cuenta destino) {
		if(origen.extraer(monto)) {
			destino.depositar(monto);
			return true;
			
		}
		
		return false;
		
	}
	public boolean Transferir(Integer numCuentaOrigen, Integer numCuentaDestino, Double monto) {
		
		Cuenta origen = buscarCuenta(numCuentaOrigen);
		Cuenta destino = buscarCuenta(numCuentaDestino);
	
		return Transferir(monto, origen, destino);
	}
	
	private Cuenta buscarCuenta(Integer numCuenta) {
		for (Cuenta cuenta : cuentas) {
			if(cuenta.getNumCuenta().equals(numCuenta)) {
				return cuenta;
			}
		}
		return null;
	}
	
	public Integer obtenerSumatoriaDePuntosDeTodasCuentasCorrientes() {
		Integer sumaPuntos = 0;
		for (Cuenta cuenta : cuentas) {
			if(cuenta instanceof CuentaCorriente){  // cuenta.getTipo().equals("CuentaCorriente)
				 sumaPuntos += ((CuentaCorriente)cuenta).getPuntos(); //castear
			}
			
			
		}
		return sumaPuntos;
		
	}

}
