package unlam.pb2.tes;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestPanini {

	@Test
	public void queSePuedaCrearUnaFigurita() {
		Figurita figuritaDelMundial = new Figurita (1, "A", "Paises Bajos", "Virgil van Dijk", 55000000, Estado.pegada);
		assertNotNull(figuritaDelMundial);
	}
	
	@Test
	public void queSePuedaCrearUnAdministrador() {
		Usuario administradorNuevo = new Administrador (37931874, "Lucas Turrer");
		Figurita figuritaDelMundial = new Figurita (1, "A", "Paises Bajos", "Virgil van Dijk", 55000000, Estado.pegada);
		
		assertNotNull(administradorNuevo);
	}
	
	@Test
	public void queSePuedaCrearUnUsuarioFinal() {
		Usuario usuarioFinalNuevo = new UsuarioFinal (37931874, "Lucas Turrer");
		Figurita figuritaDelMundial = new Figurita (1, "A", "Paises Bajos", "Virgil van Dijk", 55000000, Estado.pegada);
		
		assertNotNull(usuarioFinalNuevo);
	}
	
	@Test
	public void queUnAdministradorPuedaAgregarUnaFigurita() {
		Usuario administradorNuevo = new Administrador (37931874, "Lucas Turrer");
		Figurita figuritaDelMundial = new Figurita (1, "A", "Paises Bajos", "Virgil van Dijk", 55000000, Estado.pegada);
		
		administradorNuevo.agregarFigurita(figuritaDelMundial);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = ((Administrador) administradorNuevo).cantidadDeFiguritasParaComercializar();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queUnUsuarioFinalPuedaAgregarUnaFigurita() {
		Usuario usuarioFinalNuevo = new UsuarioFinal (37931874, "Lucas Turrer");
		Figurita figuritaDelMundial = new Figurita (1, "A", "Paises Bajos", "Virgil van Dijk", 55000000, Estado.pegada);
		
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = ((UsuarioFinal) usuarioFinalNuevo).cantidadDeFiguritasParaComercializar();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas() {
		Usuario administradorNuevo = new Administrador (37931874, "Lucas Turrer");
		Figurita figuritaDelMundial = new Figurita (510, "B", "Inglaterra", "Harry Kane", 75000000, Estado.sinPegar);
		Figurita figuritaDelMundial2 = new Figurita (110, "A", "Paises Bajos", "Virgil van Dijk", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial3 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial4 = new Figurita (20, "A", "Ecuador", "Reasco", 55000000, Estado.sinPegar);
		
		Set<Figurita> listaFigus = ((Administrador) administradorNuevo).getFiguritasEnSuPoder();
		administradorNuevo.agregarFigurita(figuritaDelMundial);
		administradorNuevo.agregarFigurita(figuritaDelMundial2);
		administradorNuevo.agregarFigurita(figuritaDelMundial3);
		administradorNuevo.agregarFigurita(figuritaDelMundial4);
		
		for (Figurita figurita : listaFigus) {
			assertEquals(20, (int) figurita.getCodigo());
			break;
		}
		
	}
	
	@Test
	public void queUnAdministradorNoPuedaAgregarUnaFiguritaExistente() {
		Usuario administradorNuevo = new Administrador (37931874, "Lucas Turrer");
		Figurita figuritaDelMundial = new Figurita (510, "B", "Inglaterra", "Harry Kane", 75000000, Estado.sinPegar);
		Figurita figuritaDelMundial2 = new Figurita (110, "A", "Paises Bajos", "Virgil van Dijk", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial3 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial4 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.sinPegar);
		
		administradorNuevo.agregarFigurita(figuritaDelMundial);
		administradorNuevo.agregarFigurita(figuritaDelMundial2);
		administradorNuevo.agregarFigurita(figuritaDelMundial3);
		administradorNuevo.agregarFigurita(figuritaDelMundial4);
		
		Integer valorEsperado = 3;
		Integer valorObtenido = ((Administrador) administradorNuevo).getCantidadDeFiguritasExistentes();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queUnUsuarioFinalSiPuedaAgregarFiguritasExistentes() {
		Usuario usuarioFinalNuevo = new UsuarioFinal (37931874, "Lucas Turrer");
		Figurita figuritaDelMundial = new Figurita (510, "B", "Inglaterra", "Harry Kane", 75000000, Estado.sinPegar);
		Figurita figuritaDelMundial2 = new Figurita (110, "A", "Paises Bajos", "Virgil van Dijk", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial3 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial4 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.sinPegar);
		
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial);
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial2);
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial3);
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial4);
		
		Integer valorEsperado = 4;
		Integer valorObtenido = ((UsuarioFinal) usuarioFinalNuevo).getCantidadDeFiguritasExistentes();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queUnUsuarioFinalPuedaPegarUnaFigurita() throws FiguritaRepetida{
		Usuario usuarioFinalNuevo = new UsuarioFinal (37931874, "Lucas Turrer");
		Figurita figuritaDelMundial = new Figurita (510, "B", "Inglaterra", "Harry Kane", 75000000, Estado.sinPegar);
		Figurita figuritaDelMundial2 = new Figurita (110, "A", "Paises Bajos", "Virgil van Dijk", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial3 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial4 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.sinPegar);
		
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial);
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial2);
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial3);
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial4);
		
		((UsuarioFinal) usuarioFinalNuevo).pegarFigurita(figuritaDelMundial);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = ((UsuarioFinal) usuarioFinalNuevo).cantidadDeFiguritasEnElAlbum();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test (expected = FiguritaRepetida.class)
	public void queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws FiguritaRepetida{
		Usuario usuarioFinalNuevo = new UsuarioFinal (37931874, "Lucas Turrer");
		Figurita figuritaDelMundial = new Figurita (510, "B", "Inglaterra", "Harry Kane", 75000000, Estado.sinPegar);
		Figurita figuritaDelMundial2 = new Figurita (110, "A", "Paises Bajos", "Virgil van Dijk", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial3 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial4 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.sinPegar);
		
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial);
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial2);
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial3);
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial4);
		
		((UsuarioFinal) usuarioFinalNuevo).pegarFigurita(figuritaDelMundial3);
		((UsuarioFinal) usuarioFinalNuevo).pegarFigurita(figuritaDelMundial4);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = ((UsuarioFinal) usuarioFinalNuevo).cantidadDeFiguritasEnElAlbum();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales() throws FiguritaNoDisponible{
		Usuario usuarioFinalNuevo = new UsuarioFinal (37931874, "Lucas Turrer");
		Usuario usuarioFinalNuevo2 = new UsuarioFinal (16555888, "Grabriel Carrer");
		
		Figurita figuritaDelMundial = new Figurita (510, "B", "Inglaterra", "Harry Kane", 75000000, Estado.sinPegar);
		Figurita figuritaDelMundial2 = new Figurita (110, "A", "Paises Bajos", "Virgil van Dijk", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial3 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial4 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.sinPegar);
		
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial); /* Kane */
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial2); /* Virgil */
		
		usuarioFinalNuevo2.agregarFigurita(figuritaDelMundial3); /* Caicedo */
		usuarioFinalNuevo2.agregarFigurita(figuritaDelMundial4); /* Caicedo */
		
		((UsuarioFinal) usuarioFinalNuevo).cambiarFigurita(usuarioFinalNuevo2,figuritaDelMundial3,figuritaDelMundial);
		
		assertTrue(((UsuarioFinal) usuarioFinalNuevo2).figuritaEnLaColeccion(figuritaDelMundial3));
		
		/*List <Figurita> coleccionUsuario = ((UsuarioFinal) usuarioFinalNuevo2).recibirColeccion();
		
		for (Figurita figurita : coleccionUsuario) {
			System.out.println(figurita.getNombreDelJugador());
		}*/
	}
	
	@Test (expected = FiguritaNoDisponible.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueNoLaTenga() throws FiguritaNoDisponible{
		Usuario usuarioFinalNuevo = new UsuarioFinal (37931874, "Lucas Turrer");
		Usuario usuarioFinalNuevo2 = new UsuarioFinal (16555888, "Grabriel Carrer");
		
		Figurita figuritaDelMundial = new Figurita (510, "B", "Inglaterra", "Harry Kane", 75000000, Estado.sinPegar);
		Figurita figuritaDelMundial2 = new Figurita (110, "A", "Paises Bajos", "Virgil van Dijk", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial3 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial4 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial5 = new Figurita (150, "C", "Argentina", "Messi", 55000000, Estado.sinPegar);
		
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial); /* Kane */
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial2); /* Virgil */
		
		usuarioFinalNuevo2.agregarFigurita(figuritaDelMundial3); /* Caicedo */
		usuarioFinalNuevo2.agregarFigurita(figuritaDelMundial4); /* Caicedo */
		
		((UsuarioFinal) usuarioFinalNuevo).cambiarFigurita(usuarioFinalNuevo2,figuritaDelMundial5,figuritaDelMundial);
		
		Boolean valorEsperado = false;
		Boolean valorObtenido = ((UsuarioFinal) usuarioFinalNuevo).figuritaEnLaColeccion(figuritaDelMundial5);
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test (expected = FiguritaNoDisponible.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueYaLaHayaPegado() throws FiguritaNoDisponible{
		Usuario usuarioFinalNuevo = new UsuarioFinal (37931874, "Lucas Turrer");
		Usuario usuarioFinalNuevo2 = new UsuarioFinal (16555888, "Grabriel Carrer");
		
		Figurita figuritaDelMundial = new Figurita (510, "B", "Inglaterra", "Harry Kane", 75000000, Estado.sinPegar);
		Figurita figuritaDelMundial2 = new Figurita (110, "A", "Paises Bajos", "Virgil van Dijk", 55000000, Estado.sinPegar);
		Figurita figuritaDelMundial3 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.pegada);
		Figurita figuritaDelMundial4 = new Figurita (120, "A", "Ecuador", "Caicedo", 55000000, Estado.sinPegar);
		
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial); /* Kane */
		usuarioFinalNuevo.agregarFigurita(figuritaDelMundial2); /* Virgil */
		
		usuarioFinalNuevo2.agregarFigurita(figuritaDelMundial3); /* Caicedo */
		usuarioFinalNuevo2.agregarFigurita(figuritaDelMundial4); /* Caicedo */
		
		((UsuarioFinal) usuarioFinalNuevo).cambiarFigurita(usuarioFinalNuevo2,figuritaDelMundial3,figuritaDelMundial);
	}

}
