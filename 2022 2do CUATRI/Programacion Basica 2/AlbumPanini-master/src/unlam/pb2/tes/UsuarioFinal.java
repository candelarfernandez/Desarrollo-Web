package unlam.pb2.tes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsuarioFinal extends Usuario {
	private List <Figurita> figuritasEnLaColeccion = new ArrayList();
	private Set <Figurita> albumDeFiguritas = new HashSet();

	public UsuarioFinal(Integer dni, String nombreApellido) {
		super(dni, nombreApellido);
	}

	@Override
	public void agregarFigurita(Figurita figuritaAAgregar) {
		figuritasEnLaColeccion.add(figuritaAAgregar);
	}
	
	@Override
	public void sacarFigurita(Figurita figuritaDelMundial) {
		figuritasEnLaColeccion.remove(figuritaDelMundial);
	}

	public Integer cantidadDeFiguritasParaComercializar() {
		return figuritasEnLaColeccion.size();
	}

	public Integer getCantidadDeFiguritasExistentes() {
		return figuritasEnLaColeccion.size();
	}
	
	public void pegarFigurita(Figurita figuritaParaPegar) throws FiguritaRepetida {
		if(figuritasEnLaColeccion.contains(figuritaParaPegar)) {
			if(albumDeFiguritas.contains(figuritaParaPegar)) {
				throw new FiguritaRepetida();
			}else {albumDeFiguritas.add(figuritaParaPegar);
			figuritaParaPegar.setEstadoDeLaFigurita(Estado.pegada);
			figuritasEnLaColeccion.remove(figuritaParaPegar);
			}
			} else{
				throw new FiguritaRepetida();
			}
	}

	public Integer cantidadDeFiguritasEnElAlbum() {
		return albumDeFiguritas.size();
	}

	public void cambiarFigurita(Usuario usuarioParaElCambio, Figurita figuritaARecibir, Figurita figuritaAEntregar) throws FiguritaNoDisponible {
		if(((UsuarioFinal) usuarioParaElCambio).figuritaEnLaColeccion(figuritaARecibir)) {
			if(figuritaARecibir.getEstadoDeLaFigurita()== Estado.sinPegar) {
				usuarioParaElCambio.sacarFigurita(figuritaARecibir);
				usuarioParaElCambio.agregarFigurita(figuritaAEntregar);
				figuritasEnLaColeccion.remove(figuritaAEntregar);
				figuritasEnLaColeccion.add(figuritaARecibir);
			}else {
				throw new FiguritaNoDisponible();
			}
			
		} else {
			throw new FiguritaNoDisponible();
		}
	}
	
	

	public Boolean figuritaEnLaColeccion(Figurita figuritaDelMundial) {
		if(figuritasEnLaColeccion.contains(figuritaDelMundial)) {
			return true;
		} return false;
	}

	public List recibirColeccion() {
		return figuritasEnLaColeccion;
	}

	

}
