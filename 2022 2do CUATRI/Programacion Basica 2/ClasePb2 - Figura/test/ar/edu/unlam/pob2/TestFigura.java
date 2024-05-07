package ar.edu.unlam.pob2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFigura {
	
	@Test
	public void queSePuedaCreaeUnObjetoCirculo() {
		Figura circulo = new Circulo("circulo1", 0.0, 0.0, 0.0);
		assertNotNull(circulo);
	}
	
	@Test 
	public void queSePuedaCalcularElAreaDeCirculo() {
		Figura circulo = new Circulo("circulo1", 0.0, 0.0, 0.0);
		Double valorEsperado=6.2892;
		Double valorObtenido= circulo.calcularArea();
		assertEquals(valorEsperado, valorObtenido, 0.1);
	}
	
	@Test
	public void queSePuedaObtenerUnaListaDeFigurasDesdeUnaCaja() {
		Figura circulo = new Circulo("circulo1", 0.0, 0.0, 0.0);
		Figura rectangulo = new Rectangulo("circulo1", 0.0, 0.0, 0.0);
		Figura cuadrado = new Cuadrado("circulo1", 0.0, 0.0, 0.0);
		Caja listaFigura = new Caja();
		listaFigura.ListaFiguras.add(rectangulo);
		listaFigura.ListaFiguras.add(circulo);
		listaFigura.ListaFiguras.add(cuadrado);
		Integer valorEsperado = 3;
		Integer valorObtenido = listaFigura.ListaFiguras.size();
		assertEquals(valorEsperado, valorObtenido);
		
	}
	
	@Test
	public void queSePuedaObtenerFigurasConAreaMayorADiezDesdeUnaListaDeFiguras() {
		Figura circulo = new Circulo("circulo1", 15.0, 0.0, 0.0);
		Figura rectangulo = new Rectangulo("circulo1", 0.0, 0.0, 0.0);
		Figura cuadrado = new Cuadrado("circulo1", 20.0, 0.0, 0.0);
		Caja listaFigura = new Caja();
		listaFigura.ListaFiguras.add(rectangulo);
		listaFigura.ListaFiguras.add(circulo);
		listaFigura.ListaFiguras.add(cuadrado);
		listaFigura.ListaFigurasAreaMayorDiez();
		Integer valorEsperado=2;
		Integer valorObtenido= listaFigura.ListaFigurasAreaMayorDiez().size();
		assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void queSePuedanfigurasCirculoDeUnaListaDeFiguras() {
		Figura circulo = new Circulo("circulo1", 15.0, 0.0, 0.0);
		Figura rectangulo = new Rectangulo("circulo1", 0.0, 0.0, 0.0);
		Figura cuadrado = new Cuadrado("circulo1", 20.0, 0.0, 0.0);
		Caja listaFigura = new Caja();
		listaFigura.ListaFiguras.add(rectangulo);
		listaFigura.ListaFiguras.add(circulo);
		listaFigura.ListaFiguras.add(cuadrado);
		listaFigura.getCirculosDeLista();
		Integer valorEsperado=1;
		Integer valorObtenido= listaFigura.getCirculosDeLista().size();
		assertEquals(valorEsperado, valorObtenido);
		
		
	}

}
