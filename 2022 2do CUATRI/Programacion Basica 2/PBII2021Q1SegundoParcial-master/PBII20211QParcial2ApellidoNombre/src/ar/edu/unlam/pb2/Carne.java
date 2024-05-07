package ar.edu.unlam.pb2;

public class Carne extends Comestible {

	private Double kilos;
	private String marca;
	

	public Carne(Integer codProducto, String descripcion, String fechaElaboracion, String fechaVencimiento, Double kilos, String marca, Double precio) {
		super(codProducto, descripcion, fechaElaboracion, fechaVencimiento, precio);
		// TODO Auto-generated constructor stub
		this.kilos=kilos;
		this.marca=marca;
		
	}

	public Double getKilos() {
		return kilos;
	}

	public void setKilos(Double kilos) {
		this.kilos = kilos;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	

}
