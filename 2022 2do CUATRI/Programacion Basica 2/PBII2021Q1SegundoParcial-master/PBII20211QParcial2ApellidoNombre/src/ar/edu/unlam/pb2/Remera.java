package ar.edu.unlam.pb2;

public class Remera extends Indumentaria {

	private String marca;
	private String color;


	public Remera(Integer codProducto, String descripcion, String talle, String marca, String color, Double precio) {
		super(codProducto, descripcion, talle, precio);
		// TODO Auto-generated constructor stub
		this.marca=marca;
		this.color=color;
		
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
}
