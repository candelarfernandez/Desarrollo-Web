package ar.edu.unlam.pb2;

import java.util.Objects;

public class Producto {
	private Integer codProducto;
	private String descripcion;
	private Double precio;

	public Producto(Integer codProducto, String descripcion, Double precio) {
		super();
		this.codProducto = codProducto;
		this.descripcion=descripcion;
		this.precio=precio;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(Integer codProducto) {
		this.codProducto = codProducto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codProducto, descripcion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codProducto, other.codProducto) && Objects.equals(descripcion, other.descripcion);
	}
	

}
