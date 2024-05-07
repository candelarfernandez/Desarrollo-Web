package ar.edu.unlam.muni;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSecretaria {
	
	@Test
	public void queSePuedaCrearUnaSecretaria(){
		Secretaria secretaria = new Secretaria("Cordoba");
		assertNotNull(secretaria);
	}
	
	// linked list 
	@Test
	public void queSePuedaAgregarUnHabitanteALaSecretaria(){
		Integer dni = 5;
		String nombre = "Juan";
		String calle= "Florencio varela";
		Integer numero= 1900;
		Integer numeroMunicipio=1;
		String nombreMunicipio= "San justo";
		Municipio municipio= new Municipio(numeroMunicipio, nombreMunicipio);
		Vivienda vivienda = new Vivienda(calle, numero, municipio);
		Habitante habitante = new Habitante(dni, nombre, vivienda);
		
		Secretaria secretaria = new Secretaria("Cordoba");
		secretaria.agregarhabitante(habitante);
		Integer valorEsperado=1;
		Integer valorObtenido= secretaria.getHabitantes().size();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedeAgregarUnHabitanteALaVivienda() {
		Secretaria secretaria = new Secretaria("Corodba");
		Integer dni = 5;
		String nombre = "Juan";
		String calle= "Florencio varela";
		Integer numero= 1900;
		Integer numeroMunicipio=1;
		String nombreMunicipio= "San justo";
		Integer limiteHabitantes=5;
		Integer contador=0;
		Municipio municipio= new Municipio(numeroMunicipio, nombreMunicipio);
		Vivienda vivienda = new Vivienda(calle, numero, municipio);
		Habitante habitante = new Habitante(dni, nombre, vivienda);
		while (contador<limiteHabitantes) {
			vivienda.contadorHabitante();
			vivienda.agregarHabitante(habitante);
			contador++;	
		}
		Integer valorEsperado=vivienda.getContador();
		Integer valorObtenido=vivienda.getHabitanteVivienda().size();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	
	

}
