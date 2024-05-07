package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBanco {

	@Test
	public void queSePuedaCrearUnaCajaDeAhorro() {
		CajaAhorro cajaAhorro = new CajaAhorro(null, null, null, null, null);
		CuentaCorriente cuentaCorriente = new CuentaCorriente(null, null, null, null, null, null);
		cuentaCorriente.extraer(45.50);
	
	}

}
