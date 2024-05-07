package ar.edu.unlam.pb2;

public class Heladera extends Electrodomestico {

	private Boolean isNoFrost;
	private String marca;
	

	public Heladera(Integer codProducto, String descripcion, Boolean isNoFrost, Integer garantia, String marca, Double precio) {
		super(codProducto, descripcion, garantia, precio);
		// TODO Auto-generated constructor stub
		this.isNoFrost=isNoFrost;
		this.marca=marca;
		
	}

	public Boolean getIsNoFrost() {
		return isNoFrost;
	}

	public void setIsNoFrost(Boolean isNoFrost) {
		this.isNoFrost = isNoFrost;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	

}
