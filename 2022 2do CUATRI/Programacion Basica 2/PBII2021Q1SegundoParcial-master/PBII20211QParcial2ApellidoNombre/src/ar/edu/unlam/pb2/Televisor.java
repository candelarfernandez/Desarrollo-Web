package ar.edu.unlam.pb2;

public class Televisor extends Electrodomestico {

	private Integer pulgadas;
	private String marca;
	

	public Televisor(Integer codProducto, String descripcion, Integer pulgadas, Integer garantia, String marca, Double precio) {
		super(codProducto, descripcion, garantia, precio);
		// TODO Auto-generated constructor stub
		this.pulgadas=pulgadas;
		this.marca=marca;
		
	}

	public Integer getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(Integer pulgadas) {
		this.pulgadas = pulgadas;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}



}
