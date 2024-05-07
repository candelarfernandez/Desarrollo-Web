package unlam.pb2.tes;

import java.util.Objects;

public class Figurita implements Comparable <Figurita>{
	private Integer codigo;
	private String grupoDelMundial;
	private String seleccion;
	private String nombreDelJugador;
	private Integer valorDelMercado;
	private Estado estadoDeLaFigurita;

	public Figurita(Integer codigo, String grupoDelMundial , String seleccion, String nombreDelJugador, Integer valorDelMercado, Estado estadoDeLaFigurita) {
		this.codigo = codigo;
		this.grupoDelMundial = grupoDelMundial;
		this.seleccion = seleccion;
		this.nombreDelJugador = nombreDelJugador;
		this.valorDelMercado = valorDelMercado;
		this.estadoDeLaFigurita = estadoDeLaFigurita;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figurita other = (Figurita) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getGrupoDelMundial() {
		return grupoDelMundial;
	}

	public void setGrupoDelMundial(String grupoDelMundial) {
		this.grupoDelMundial = grupoDelMundial;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

	public String getNombreDelJugador() {
		return nombreDelJugador;
	}

	public void setNombreDelJugador(String nombreDelJugador) {
		this.nombreDelJugador = nombreDelJugador;
	}

	public Integer getValorDelMercado() {
		return valorDelMercado;
	}

	public void setValorDelMercado(Integer valorDelMercado) {
		this.valorDelMercado = valorDelMercado;
	}

	public Estado getEstadoDeLaFigurita() {
		return estadoDeLaFigurita;
	}

	public void setEstadoDeLaFigurita(Estado estadoDeLaFigurita) {
		this.estadoDeLaFigurita = estadoDeLaFigurita;
	}

	
	@Override
	public int compareTo(Figurita o) {
		if(this.grupoDelMundial.equals(o.grupoDelMundial)) {
			if(this.seleccion.equals(o.seleccion)) {
				return this.codigo.compareTo(o.codigo);
			} else {return this.seleccion.compareTo(o.seleccion);
					}
		}
		return this.grupoDelMundial.compareTo(o.grupoDelMundial);
	}
	
	

}
