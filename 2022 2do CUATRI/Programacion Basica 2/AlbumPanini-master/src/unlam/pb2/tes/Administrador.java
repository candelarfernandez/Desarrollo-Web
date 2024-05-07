package unlam.pb2.tes;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Administrador extends Usuario {
	private Set <Figurita> figuritaParaComercializar = new TreeSet();

	public Administrador(Integer dni, String nombreApellido) {
		super(dni, nombreApellido);
	}

	@Override
	public void agregarFigurita(Figurita figuritaAAgregar) {
		figuritaParaComercializar.add(figuritaAAgregar);
	}
	
	@Override
	public void sacarFigurita(Figurita figuritaDelMundial) {
		figuritaParaComercializar.remove(figuritaDelMundial);
	}
	
	

	public Integer cantidadDeFiguritasParaComercializar() {
		return figuritaParaComercializar.size();
	}

	public Set<Figurita> getFiguritasEnSuPoder() {
		return figuritaParaComercializar;
	}

	public Integer getCantidadDeFiguritasExistentes() {
		return figuritaParaComercializar.size();
	}

	

	

	


}
