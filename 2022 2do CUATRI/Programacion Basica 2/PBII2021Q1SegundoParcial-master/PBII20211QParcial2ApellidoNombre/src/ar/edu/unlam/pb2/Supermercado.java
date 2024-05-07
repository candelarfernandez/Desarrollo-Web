package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Supermercado {
	
	String nombre; // Nombre del supermercado
	private Set<Producto> productosExistentes; // Listado de productos que se comercializan
	private List<Producto> productosDisponibles; // Detalle de cada producto ingresado
	private Map<Integer, Venta> ventasRealizadas; // Listado de ventas realizadas (identificadas por el n�mero de venta)
	Integer contadorDeVentas; // Identificador del n�mero de venta
	private Map<Integer, Integer> carrito;
	
	public Supermercado(String nombre) {
		// Constructor de la clase
		this.nombre=nombre;
		this.productosDisponibles= new ArrayList<>();
		this.productosExistentes= new HashSet<>();
		this.ventasRealizadas= new HashMap<>();
		this.carrito= new HashMap<>();
		this.contadorDeVentas=0;
	}

	public void ingresarProducto(Producto nuevo) {
		// Ingresa un nuevo producto
		this.productosExistentes.add(nuevo);
		this.productosDisponibles.add(nuevo);
	}

	public Set<Producto> getOfertaDeProductos() {
		// Devuelve el conjunto de productos que se comercializan
		return this.productosExistentes;
	}
	
	public Integer getStock(Integer codigo) {
		// Devuelve la cantidad de unidades de un producto determinado
		Integer unidades=0;
		for (Producto producto : productosDisponibles) {
			if(producto.getCodProducto().equals(codigo)) {
				unidades++;
			}
		}return unidades;
	}
	
	private Boolean productoExiste(Integer codigoDeProducto) throws ProductoInexistente{
		// Verifica si un producto existe
		for (Producto producto : productosExistentes) {
			if(producto.getCodProducto().equals(codigoDeProducto)) {
				return true;
			}
		}throw new ProductoInexistente();
		
	}
	
	private Producto getProductoPorCodigo(Integer codigoDeProducto) throws ProductoSinStock {
		// Busca la disponibilidad de un producto
		for (Producto producto : productosDisponibles) {
			if(producto.getCodProducto().equals(codigoDeProducto)) {
				return producto;
			}
		}throw new ProductoSinStock();
	}
	
	public Integer registrarNuevaVenta(Integer dniDelComprador, String nombreDelComprador) {
		// Registra una nueva venta
		ventasRealizadas.put(contadorDeVentas++, new Venta(dniDelComprador, nombreDelComprador));
		return contadorDeVentas;
	}
	
	public Venta getVenta(Integer nueroDeVenta) {
		// Devuelve una venta en funci�n de su n�mero identificatorio
		return this.ventasRealizadas.get(nueroDeVenta);
	}

	public void agregarAlCarrito(Integer numeroDeVenta, Integer codigoDeProducto) throws ProductoSinStock, ProductoInexistente {
		// Incorpora al carrito de compras de la venta identificada por el "numeroDeVenta", el producto identificado por el "codigoDeProducto"
		if(productoExiste(codigoDeProducto)) {
			if(getProductoPorCodigo(codigoDeProducto).getCodProducto().equals(codigoDeProducto)) {
				ventasRealizadas.get(numeroDeVenta).agregarImporte(getProductoPorCodigo(codigoDeProducto).getPrecio());
		       }
		
			else { throw new ProductoSinStock();
		}
			
		}else {
			throw new ProductoInexistente();
		}
			
		}
	}
		

	


