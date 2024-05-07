package unlam.pb2.tes;

import java.util.Objects;

public abstract class Usuario {
	private Integer dni;
	private String nombreApellido;
	
	public Usuario(Integer dni, String nombreApellido) {
		this.dni = dni;
		this.nombreApellido = nombreApellido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dni, other.dni);
	}
	
	public abstract void agregarFigurita(Figurita figuritaDelMundial);
	public abstract void sacarFigurita(Figurita figuritaDelMundial);
	
	
}
