package ar.edu.unlam.pb2;

public class Galletitas extends Comestible {
	private String marca;
	

	public Galletitas(Integer codProducto, String descripcion,  String fechaElaboracion, String fechaVencimiento, String marca, Double precio) {
		super(codProducto, descripcion, fechaElaboracion, fechaVencimiento, precio);
		this.marca=marca;
		
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	

}
