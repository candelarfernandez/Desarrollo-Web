package ar.unlam.edu.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentaGanado {

	@Test
	public void queSePuedaCrearUnCuentaGanado() {
		CuentaGandado cuentaGanado = new CuentaGandado();
		assertNotNull(cuentaGanado);
	}
		
	@Test
	public void queSeCreeUnCuentaGanadoConContadorEnCero() {
		CuentaGandado cuentaGanado = new CuentaGandado();
		Integer valorEsperado = 0;
		Integer valorObtenido = cuentaGanado.getContador();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSumeUno() {
		CuentaGandado cuentaGanado = new CuentaGandado();
		Integer valorEsperado = 1;
		cuentaGanado.sumar();
		Integer valorObtenido = cuentaGanado.getContador();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void quePaseElLimiteYvUelvaACero() {
		CuentaGandado cuentaGanado = new CuentaGandado();
		Integer valorEsperado = 0;
		cuentaGanado.sumar();
		cuentaGanado.sumar();
		cuentaGanado.sumar();
		cuentaGanado.sumar();
		cuentaGanado.sumar();
		cuentaGanado.sumar();
		cuentaGanado.sumar();
		cuentaGanado.sumar();
		cuentaGanado.sumar();
		cuentaGanado.sumar();
		Integer valorObtenido = cuentaGanado.getContador();
		assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void queElCuentaGanadoResetee() {
		CuentaGandado cuentaGanado = new CuentaGandado();
		Integer valorEsperado = 0;
		cuentaGanado.sumar();
		cuentaGanado.resetear();
		Integer valorObtenido = cuentaGanado.getContador();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void cualquierCosa() {
		Double x = 7.0;
		Double y = 3.0;
		Double division = x/y;
		Double suma = x+y;
		Double valorEsperadoSuma = 10.0;
		assertEquals(valorEsperadoSuma,suma);
		Double valorEsperadoDivision = 2.334;
		assertEquals(valorEsperadoDivision,division, 0.01);
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
