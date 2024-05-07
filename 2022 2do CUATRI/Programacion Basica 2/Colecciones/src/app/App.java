package app;

import java.util.LinkedList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<String> lista = new LinkedList<String>();
		// Agregar
		lista.add("A");
		lista.add("B");
		lista.add("C");
		lista.add("D");
		lista.add("E");
		lista.add("F");
		// Insertar
		lista.add(3, "Otra");
		System.out.println(lista.toString());
		// Recuperar
		System.out.println(lista.get(3));
		// Eliminar - Por objeto e indice
		System.out.println(lista.remove(3));
		// Tamaño
		System.out.println(lista.size());
		// esta?
		System.out.println(lista.toString());
		System.out.println(lista.contains("Otra"));
		// Buscar pos
		System.out.println(lista.indexOf("E"));
		// Recorrer
		for (String string : lista) {
			System.out.print(string + " ");
		}
		System.out.println();
		// Imprimir
		System.out.println(lista);
		// Vaciar
		System.out.println(lista.isEmpty());
		lista.clear();
		System.out.println(lista.isEmpty());
	}

}
