package ar.edu.unlam.pb2;

public class Electrodomestico extends Producto {
	private Integer garantia;

	public Electrodomestico(Integer codProducto, String descripcion, Integer garantia, Double precio) {
		super(codProducto, descripcion, precio);
		// TODO Auto-generated constructor stub
		this.garantia=garantia;
	}

	public Integer getGarantia() {
		return garantia;
	}

	public void setGarantia(Integer garantia) {
		this.garantia = garantia;
	}

}
