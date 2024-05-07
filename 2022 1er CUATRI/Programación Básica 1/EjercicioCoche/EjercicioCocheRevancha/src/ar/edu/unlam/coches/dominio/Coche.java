package ar.edu.unlam.coches.dominio;

public class Coche {
	private String marca;
	private String modelo;
	private int kilometros;
	private int año;
	private double precio;
	private static int cantidadCoches=0;
	private final int CERO_KM=0;
	private final int AÑO_ACTUAL=2022;
	private double identificador;
	
		
	public Coche(String marca, String modelo, double precio) {
		this.marca=marca;
		this.modelo=modelo;
		this.kilometros=CERO_KM;
		this.año=AÑO_ACTUAL;
		this.precio=precio;
		cantidadCoches++;
		
	}
	
	public Coche(String marca, String modelo, int kilometros, int año, double precio) {
		this.marca=marca;
		this.modelo=modelo;
		this.kilometros=kilometros;
		this.precio=precio;
		this.año=AÑO_ACTUAL;
		cantidadCoches++;
		
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public static int getCantidadCoches() {
		return cantidadCoches;
	}

	public static void setCantidadCoches(int cantidadCoches) {
		Coche.cantidadCoches = cantidadCoches;
	}

	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", kilometros=" + kilometros + ", año=" + año
				+ ", precio=" + precio + "]";
	}
	
	

}
