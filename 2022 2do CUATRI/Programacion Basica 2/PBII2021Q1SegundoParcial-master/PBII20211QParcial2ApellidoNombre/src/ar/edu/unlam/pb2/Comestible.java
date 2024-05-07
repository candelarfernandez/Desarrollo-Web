package ar.edu.unlam.pb2;

public class Comestible extends Producto {
	private String fechaElaboracion;
	private String fechaVencimiento;

	public Comestible(Integer codProducto, String descripcion, String fechaElaboracion, String fechaVencimiento, Double precio) {
		super(codProducto, descripcion, precio);
		this.fechaElaboracion=fechaElaboracion;
		this.fechaVencimiento=fechaVencimiento;
	}

	public String getFechaElaboracion() {
		return fechaElaboracion;
	}

	public void setFechaElaboracion(String fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

}
