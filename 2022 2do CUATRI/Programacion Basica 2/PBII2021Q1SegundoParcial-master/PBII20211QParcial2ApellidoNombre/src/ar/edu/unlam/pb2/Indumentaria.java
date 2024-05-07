package ar.edu.unlam.pb2;

public class Indumentaria extends Producto {

	private String talle;

	public Indumentaria(Integer codProducto, String descripcion, String talle, Double precio) {
		super(codProducto, descripcion, precio);
		// TODO Auto-generated constructor stub
		this.talle=talle;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}



}
