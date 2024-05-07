package ar.edu.unlam.pb2;

public class Ausencias {
	
	private Integer id;
	private Integer desde;
	private Integer hasta;
	private Tipo tipo_ausencia;
	
	public Ausencias(Integer id, Integer desde, Integer hasta, Tipo tipo_ausencia) {
		super();
		this.id = id;
		this.desde = desde;
		this.hasta = hasta;
		this.tipo_ausencia = tipo_ausencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDesde() {
		return desde;
	}

	public void setDesde(Integer desde) {
		this.desde = desde;
	}

	public Integer getHasta() {
		return hasta;
	}

	public void setHasta(Integer hasta) {
		this.hasta = hasta;
	}

	public Tipo getTipo_ausencia() {
		return tipo_ausencia;
	}

	public void setTipo_ausencia(Tipo tipo_ausencia) {
		this.tipo_ausencia = tipo_ausencia;
	}
	
	
	

}
