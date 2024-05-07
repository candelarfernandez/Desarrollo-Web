package ar.edu.unlam.cuenta;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuenta1 {

	@Test
	public void queSePuedaCrearUnaCajaDeAhorro() {
		CajaDeAhorro cajaAhorro = new CajaDeAhorro(null, null, null, null, null);
		CuentaCorriente cuentaCorriente = new CuentaCorriente(null, null, null, null, null, null);
		cuentaCorriente.extraer(45.50);
	}

}
