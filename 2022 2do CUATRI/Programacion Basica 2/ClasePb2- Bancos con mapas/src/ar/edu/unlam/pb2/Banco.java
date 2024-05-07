
package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Banco {

	private ArrayList<Cuenta> cuentas;
	private HashMap<Integer, Titular> Titulares;

	public Banco() {
		this.cuentas = new ArrayList<>();
		this.Titulares = new HashMap<>();
	}

	public void agregarCuenta(Cuenta cuenta) {
		this.cuentas.add(cuenta);
	}

	public Boolean transferir(Double monto, Cuenta origen, Cuenta destino) throws MontoInsuficienteException {
		if(origen.extraer(monto)) {
			destino.depositar(monto);
			return true;
		}
		return false;
	}

	public Boolean transferir(Integer numCuentaOrigen, Integer numCuentaDestino, Double monto) throws CuentaNoEncontrada, MontoInsuficienteException {
		Cuenta origen = buscarCuenta(numCuentaOrigen);
		Cuenta destino = buscarCuenta(numCuentaDestino);
		return transferir(monto, origen, destino);
	}

	public Cuenta buscarCuenta(Integer numCuenta) throws CuentaNoEncontrada {
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getNumCuenta().equals(numCuenta)) {
				return cuenta;
			}
		}
		throw new CuentaNoEncontrada("No se pudo encontrar la cuenta");
	}
	
	

	public Integer obtenerSumatoriaDePuntosDeCuentasCorrientes() {
		Integer total = 0;
		for (Cuenta cuenta : cuentas) {
			if (cuenta.getTipo().equals("CuentaCorriente")) {
				total += ((CuentaCorriente)cuenta).getPuntos();
			}
		}
		return total;
	}

	public void agregarCliente(Integer i, Titular titular) throws YaExisteTitular {
		if(this.Titulares.containsKey(i)){
			throw new YaExisteTitular("Dni Duplicado");
		}
		
		this.Titulares.put(i,titular);
		
	}


	public HashMap<Integer, Titular> getTitulares() {
		return Titulares;
	}

	public void setTitulares(HashMap<Integer, Titular> titulares) {
		Titulares = titulares;
	}

	public void buscarCliente(Integer dni) {
		for (Map.Entry<Integer, Titular> entry : Titulares.entrySet()) {
			Integer key = entry.getKey();
			Titular val = entry.getValue();
			System.out.println("DNI "+ key + " de "+ val);
		}
		
	}
	
	
	
}
