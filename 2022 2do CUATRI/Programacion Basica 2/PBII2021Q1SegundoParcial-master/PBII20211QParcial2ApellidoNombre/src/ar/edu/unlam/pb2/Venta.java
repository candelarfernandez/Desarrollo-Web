package ar.edu.unlam.pb2;

public class Venta {
	private Integer dniDelComprador;
	private String nombreDelComprador;
	private Double importe;

	public Venta(Integer dniDelComprador, String nombreDelComprador) {
		// TODO Auto-generated constructor stub
		this.dniDelComprador=dniDelComprador;
		this.nombreDelComprador=nombreDelComprador;
		this.importe=0.0;
	}

	public Integer getDniDelComprador() {
		return dniDelComprador;
	}

	public void setDniDelComprador(Integer dniDelComprador) {
		this.dniDelComprador = dniDelComprador;
	}

	public String getNombreDelComprador() {
		return nombreDelComprador;
	}

	public void setNombreDelComprador(String nombreDelComprador) {
		this.nombreDelComprador = nombreDelComprador;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public void agregarImporte(Double precio) {
		this.importe+=precio;
	}


}
