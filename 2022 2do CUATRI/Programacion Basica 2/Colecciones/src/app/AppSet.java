package app;

import java.util.HashSet;
import java.util.Set;

public class AppSet {

	public static void main(String[] args) {
		Set<String> con = new HashSet<String>();
		// Agregar
		con.add("A");
		con.add("B");
		con.add("F");
		con.add("C");
		con.add("E");
		con.add("D");
		// Insertar
		con.add("Otra");
		System.out.println(con.toString());
		// Recuperar
		//system.out.println(con.get(3));
		// Eliminar - Por objeto e indice
		System.out.println(con.remove("otra"));
		// Tamaño
		System.out.println(con.size());
		// esta?
		System.out.println(con.toString());
		System.out.println(con.contains("Otra"));
		// Buscar pos
		//System.out.println(con.indexOf("E"));
		// Recorrer
		for (String string : con) {
			System.out.print(string + " ");
		}
		System.out.println();
		// Imprimir
		System.out.println(con);
		// Vaciar
		System.out.println(con.isEmpty());
		con.clear();
		System.out.println(con.isEmpty());

	}

}
