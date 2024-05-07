package ar.edu.unlam.coches.interfaz;

import java.util.Scanner;

import ar.edu.unlam.coches.dominio.Coche;
import ar.edu.unlam.coches.dominio.Concesionaria;

public class MainCoche {
	
    static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		Concesionaria coches = crearConcesionaria();
		menuGeneral(coches);

	}

	private static void menuGeneral(Concesionaria coches) {
		int opcion =0;
		do {
		System.out.println("Bienvenido a la concesionaria!");
		System.out.println("Elegir 1 para ingresar coche nuevo "
				+ "\nElegir 2 para ingresar coche usado "
				+ "\nElegir 3 para mostrar coches "
				+ "\nElegir 4 para mostrar consignas"
				+ "\nElegir 0 para salir");
		opcion =teclado.nextInt();
		switch(opcion) {
		case 1: ingresarCocheNuevo(coches);
			break;
		case 2: ingresarCocheUsado(coches);
			break;
		case 3: mostrarCoches(coches.flota);
		    break;
		case 4:
			calcularIdentificador(coches);
			
			break;
		case 0:
			System.out.println("Usted ha salido de la consecionaria");
			break;
		default:
			System.out.println("Opcion invalida");
			break;
		}
			
		}while(opcion !=0);
	}
	
	private static void mostrarCoches(Coche[] flota) {
		for(int i=0;i<flota.length;i++) {
			if(flota[i] != null) {
				System.out.println(flota[i].toString());
			}
			
		}
	}

	private static void ingresarCocheNuevo(Concesionaria coches) {
		System.out.println("Ingrese marca");
		String marca = teclado.next();
		System.out.println("Ingrese modelo");
		String modelo = teclado.next();
		System.out.println("Ingrese precio");
		double precio = teclado.nextDouble();
		Coche cocheNuevo = new Coche(marca, modelo, precio);
		if(coches.ingresarCoche(cocheNuevo)) {
			System.out.println("Se agrego correctamente");
		}
	}

	private static void ingresarCocheUsado(Concesionaria coches) {
		System.out.println("Ingrese marca");
		String marca = teclado.next();
		System.out.println("Ingrese modelo");
		String modelo = teclado.next();
		System.out.println("Ingrese precio");
		double precio = teclado.nextDouble();
		System.out.println("Ingrese kilometros");
		int kilometros = teclado.nextInt();
		int año =0;
		Coche cocheUsado = new Coche(marca, modelo,kilometros, año, precio);
		if(coches.ingresarCoche(cocheUsado)) {
			System.out.println("Se agrego correctamente");
		}
		
	}

	private static Concesionaria crearConcesionaria() {
		System.out.println("Bienvenido a la consecionaria");
		System.out.println("Ingresar nombre de concesionaria");
		String nombreConcesionaria= teclado.next();
		System.out.println("Ingresar cantidad de coches en la flota");
		int cantidadDeCochesEnLaFlota= teclado.nextInt();
		
		return new Concesionaria(cantidadDeCochesEnLaFlota);
	}
	
	private static void calcularIdentificador(Concesionaria coches) {
		System.out.println(coches.calcularIdentificador(0));
	}
	
	private static void calcularCantidadDeKilometros(Concesionaria coches) {
		int numMay =0;
		System.out.println(coches.calcularCantidadDeKilometros(numMay));
	}
	
	private static void calcularCantidadDeMarcasDistintas(Concesionaria coches) {
		System.out.println("ingresar marca para visualizar cantidad de autos de la misma (chevrolet) (volksvagen)");
		String marcas = teclado.next();
		System.out.println(coches.calcularCantidadDeMarcasDistintas(marcas));
	}
	
	private static void contarCocheDeDeterminadoModelo(Concesionaria coches) {
		System.out.println("ingresar marca para visualizar cantidad de autos de la misma (chevrolet) (volksvagen)");
		String modelo = teclado.next();
		System.out.println(coches.contarCocheDeDeterminadoModelo(modelo));
	}
	private static void encontrarCeroKilometroDeMenorPrecio(Concesionaria coches) {
		int kmMenorPrecio=0;
		int ceroKm=0;
		System.out.println(coches.encontrarCeroKilometroDeMenorPrecio(kmMenorPrecio, ceroKm));
	}
	

}
