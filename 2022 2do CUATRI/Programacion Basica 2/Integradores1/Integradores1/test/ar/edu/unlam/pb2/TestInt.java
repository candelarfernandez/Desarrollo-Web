package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

public class TestInt {

	@Test
	public void queSePuedaCrearUnObjetoVolador() {
		Avion avion = new Avion(1,"A-10");

		assertEquals(12.0, avion.getAltura(), 0.01);
	}

	@Test
	public void queSePuedaCrearUnObjetoTerrestre() {
		Tanque tanque = new Tanque(2, "Renault FT");

		assertEquals(250.0, tanque.getVelocidad(), 0.1);
	}

	@Test
	public void queSePuedaCrearUnObjetoAcuatico() {
		Submarino submarino = new Submarino(3, "ARA - San Juan");
		
		assertEquals(200.0, submarino.getProfundidad(), 0.01);
	}

	@Test
	public void queSePuedaCrearUnObjetoAnfibio() {
		Anfibio anfibio = new Anfibio(4, "LARC-5");
		
		assertEquals(100.0, anfibio.getVelocidad(), 0.01);
		assertEquals(200.0, anfibio.getProfundidad(), 0.01);
	}

	@Test
	public void queSePuedaCrearUnHidroavion() {
		
		HidroAvion ag600 = new HidroAvion(5, "AG600");

		assertEquals(500.0, ag600.getAltura(), 0.01);
		assertEquals(200.0, ag600.getProfundidad(), 0.01);
	}

	@Test
	public void queSePuedaArmarElConvoy() {
		
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Avion(1, "A-10"));
		argentina.agregarVehiculo(new Avion(2, "A-10"));
		argentina.agregarVehiculo(new Avion(3, "F-102"));
		argentina.agregarVehiculo(new Avion(4, "F-15"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Submarino(8, "ARA - San Juan"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(12, "Mitsubishi F1M"));
		argentina.agregarVehiculo(new Anfibio(13, "LARC-5"));

		Integer valorEsperado=13;
		Integer valorObtenido=argentina.getCapacidadDeDefensa();
		assertEquals(valorEsperado, valorObtenido);
		
	}


	@Test
	public void queSePuedaCrearUnaBatalla() {
		FuerzaArmada argentina = new FuerzaArmada();
		Batalla sanlorenzo = new Batalla("San lorenzo", 100.5, 20.3, TipoDeBatalla.TERRESTRE);
		argentina.crearBatalla(sanlorenzo);
		Integer valorEsperado=1;
		assertEquals(valorEsperado, argentina.getBatallas("San Lorenzo"));
	}
	

   
   @Test
	public void queSePuedaPresentarBatallaNaval() throws VehiculoIncompatibleException, VehiculoInexistenteException  {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(12, "A-10"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		
		Batalla sanlorenzo = new Batalla("San lorenzo", 100.5, 20.3, TipoDeBatalla.TERRESTRE);
		argentina.crearBatalla(sanlorenzo);

		
		argentina.enviarALaBatalla(sanlorenzo, 9);
		argentina.enviarALaBatalla(sanlorenzo, 10);		
		argentina.enviarALaBatalla(sanlorenzo, 11);		
		argentina.enviarALaBatalla(sanlorenzo, 5);
				
		
		assertEquals((Integer)4, (Integer)argentina.getConvoyListoParaBatalla().size());
		
	}

   @Test (expected = VehiculoIncompatibleException.class)
	public void queSeNoSePuedaEnviarAUnaBatallaEnTierraUnBarco() throws VehiculoInexistenteException, VehiculoIncompatibleException {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(12, "A-10"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		
		Batalla sanlorenzo = new Batalla("San lorenzo", 100.5, 20.3, TipoDeBatalla.TERRESTRE);
		argentina.crearBatalla(sanlorenzo);

		
		argentina.enviarALaBatalla(sanlorenzo, 9);
		argentina.enviarALaBatalla(sanlorenzo, 10);		
		argentina.enviarALaBatalla(sanlorenzo, 11);		
		argentina.enviarALaBatalla(sanlorenzo, 5);
		argentina.enviarALaBatalla(sanlorenzo, 12);
				
		
		assertEquals((Integer)5, (Integer)argentina.getConvoyListoParaBatalla().size());

	}

	@Test (expected = VehiculoInexistenteException.class)
	public void queSeNoSePuedaEnviarAUnaBatallaUnVehiculoQueNoExista() throws VehiculoInexistenteException, VehiculoIncompatibleException {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new HidroAvion(12, "A-10"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		
		Batalla sanlorenzo = new Batalla("San lorenzo", 100.5, 20.3, TipoDeBatalla.TERRESTRE);
		argentina.crearBatalla(sanlorenzo);

		
		argentina.enviarALaBatalla(sanlorenzo, 9);
		argentina.enviarALaBatalla(sanlorenzo, 10);		
		argentina.enviarALaBatalla(sanlorenzo, 11);		
		argentina.enviarALaBatalla(sanlorenzo, 5);
		argentina.enviarALaBatalla(sanlorenzo, 18);
				
		


	}
}
