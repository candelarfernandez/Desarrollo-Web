package ar.edu.unlam.muni;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class TestSecretaria {

	@Test
	public void queSePuedaAgregarUnHabitanteALaSecretaria() {
		Secretaria secretaria = new Secretaria();
		Habitante habitante = new Habitante(44424, "Candela");
		secretaria.agregarHabitante(habitante);
		Integer valorEsperado = 1;
		Integer valorObtenido = secretaria.obtenerCantidadDeHabitantes();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queSePuedaAgregarUnaViviendaALaSecretaria() {
		Secretaria secretaria = new Secretaria();
		Vivienda vivienda = new Vivienda("florencio varela", 123, "San Justo", 5);
		secretaria.agregarVivienda(vivienda);
		Integer valorEsperado = 1;
		Integer valorObtenido = secretaria.obtenerCantidadDeViviendas();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void propietarioVivienda() {
		Secretaria secretaria = new Secretaria();
		Habitante habitante = new Habitante(44424, "Candela");
		Vivienda vivienda = new Vivienda("florencio varela", 123, "San Justo", 5);
		assertTrue (secretaria.comprarVivienda(habitante, vivienda, 100.0));
		Integer valorEsperado = 1;
		Integer valorObtenido = secretaria.obtenerCantidadDeCompras();
		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void queDosPropietariosPuedanComprarUnaVivienda() {
		Secretaria secretaria = new Secretaria();
		Habitante habitante = new Habitante(44424, "Candela");
		Habitante habitante2 = new Habitante(33324, "Agostina");
		Vivienda vivienda = new Vivienda("florencio varela", 123, "San Justo", 5);
		secretaria.comprarVivienda(habitante, vivienda, 40.0);
		secretaria.comprarVivienda(habitante2, vivienda, 60.0);
		Integer valorEsperado = 2;
		Integer valorObtenido = secretaria.obtenerCantidadDeCompras();
		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void queNoSePuedanAgregarCompradoresSiElPorcentajeSuperaElCienPorciento() {
		Secretaria secretaria = new Secretaria();
		Habitante habitante = new Habitante(44424, "Candela");
		Habitante habitante2 = new Habitante(33324, "Agostina");
		Vivienda vivienda = new Vivienda("florencio varela", 123, "San Justo", 5);
		assertTrue(secretaria.comprarVivienda(habitante, vivienda, 60.0));
		assertFalse(secretaria.comprarVivienda(habitante2, vivienda, 60.0));
		
	}
	
	@Test
	public void queSePuedaObtenerElPorcentajeDeAquellasViviendasQueSeaMenorAlCienPorciento(){
		Secretaria secretaria = new Secretaria();
		Habitante habitante = new Habitante(44424, "Candela");
		Habitante habitante2 = new Habitante(33324, "Agostina");
		Vivienda vivienda = new Vivienda("florencio varela", 123, "San kito", 5);
		Vivienda vivienda2 = new Vivienda("florencio vtyj", 553, "San yusto", 7);
		Vivienda vivienda3 = new Vivienda("florencio gre", 443, "San htro", 6);
		secretaria.comprarVivienda(habitante, vivienda, 60.0);
		secretaria.comprarVivienda(habitante2, vivienda, 35.0);
		secretaria.comprarVivienda(habitante2, vivienda2, 30.0);
		secretaria.comprarVivienda(habitante2, vivienda3, 100.0);
		HashSet <Vivienda> viviendasMenor100 = secretaria.obtenerViviendaCuyoPorcentajeEsMenorAlCienPorciento();
		Integer valorEsperado = 2;
		Integer valorObtenido = viviendasMenor100.size();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	//cual es la ventaja y desventaja de usar el hash set, son array de tipo set, no permite duplicados
}
