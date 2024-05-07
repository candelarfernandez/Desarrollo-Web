package ar.edu.unlam.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.Atencion;
import ar.edu.unlam.dominio.Especie;
import ar.edu.unlam.dominio.Veterinaria;

public class TestVeterinaria {

	private static final int SALIR = 9;
	private static final int CANTIDAD_MAXIMA_ATENCIONES = 5;
	
	private static final int REGISTRAR_ATENCION = 1;
	private static final int BUSCAR_ATENCION_POR_ID = 2;
	private static final int LISTAR_ATENCIONES_ESPECIE = 3;
	private static final int ELIMINAR_ATENCION = 4;
	private static final int INFORMAR_ATENCIONES = 5;
	private static final int INFORMAR_TOTAL_ATENCIONES = 6;
	private static final int INFORMAR_ATENCIONES_ORDENADAS = 7;

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		String nombreVeterinaria = "UNLaM-Vet";
		mostrarMensaje("Bienvenido a " + nombreVeterinaria);

		Veterinaria veterinaria = new Veterinaria(nombreVeterinaria, CANTIDAD_MAXIMA_ATENCIONES);

		int opcion = 0;

		boolean inicioValido = false;

		do {
			opcion = seleccionarOpcion(teclado);

			switch (opcion) {
			case REGISTRAR_ATENCION:
				// Registra una atencion con los datos ingresados por el empleado e informa el
				// resultado
				boolean atencionCreada = crearAtencion(teclado, veterinaria);
				if (atencionCreada) {
					mostrarMensaje("\nAtencion creada correctamente!");
				} else {
					mostrarMensaje("\nNo fue posible crear la atencion");
				}
				break;
			case BUSCAR_ATENCION_POR_ID:
				// Se solicita el ingreso del id y se muestra la informacion de la atencion
				// encontrada. Si no se encuentra, mostrar un mensaje
				Atencion atencion = buscarAtencionPorId(teclado, veterinaria);

				if (atencion != null) {
					mostrarMensaje("\nAtencion encontrada:\n\n" + atencion.toString());
				} else {
					mostrarMensaje("\nNo se encontro una atencion para ese ID.");
				}
				break;
			case LISTAR_ATENCIONES_ESPECIE:
				// Ingresar la especie de mascota para listar las atenciones que correspondan.
				// Si no hay atenciones indicar lo propio

				Especie especie = ingresarEspecieMascota(teclado);

				Atencion[] atencionesEspecie = veterinaria.listarAtencionesPorEspecieDeMascota(especie);

				mostrarAtenciones(atencionesEspecie);

				break;
			case ELIMINAR_ATENCION:
				// Se solicita el ingresdo del id de la atencion y se elimina. Indicar el
				// resultado de la operacion

				boolean eliminado = eliminarAtencion(teclado, veterinaria);
				if (eliminado) {
					mostrarMensaje("\nAtencion eliminada correctamente!");
				} else {
					mostrarMensaje("\nNo fue posible eliminar la atencion.");
				}
				break;
			case INFORMAR_ATENCIONES:
				// Listar las atenciones realizadas y las disponibles
				int atencionesRealizadas = veterinaria.obtenerCantidadDeAtencionesRealizadas();
				int atencionesDisponibles = veterinaria.obtenerCantidadDeAtencionesDisponibles(atencionesRealizadas);
				String mensaje = "\nCantidad de ateciones realizadas: " + atencionesRealizadas
						+ ".\nCantidad de atenciones disponibles: " + atencionesDisponibles + ".";
				mostrarMensaje(mensaje);
				break;
			case INFORMAR_TOTAL_ATENCIONES:
				// Informar el total de todas las atenciones realizadas. Debe inciar sesión para
				// realizar esta operacion.
				// Si las credenciales son invalidas, indicarlo y volver al menu principal.
				inicioValido = iniciarSesion(teclado, veterinaria);

				if (inicioValido) {
					double total = veterinaria.obtenerTotalDeAtenciones();
					mostrarMensaje("\nEl total de las atenciones es: AR$ " + total);
				} else {
					mostrarMensaje("\nUsuario y/o contrasenia invalido.");
				}

				break;
			case INFORMAR_ATENCIONES_ORDENADAS:
				// Informar por pantalla atenciones ordenadas en forma decreciente. Si no hay
				// atenciones mostrar un mensaje aclaratorio.
				// Si las credenciales son invalidas, indicarlo y volver al menu principal.
				

				inicioValido = iniciarSesion(teclado, veterinaria);

				if (inicioValido) {
					veterinaria.ordenarAtencionesPorMontoDescendente();
					Atencion[] atenciones = veterinaria.getAtenciones();
					mostrarAtenciones(atenciones);
				} else {
					mostrarMensaje("\nUsuario y/o contrasenia invalido.");
				}

				break;
			case SALIR:
				mostrarMensaje("\nGracias por utilizar el sistema.");
				break;
			}

		} while (opcion != SALIR);

		teclado.close();
	}

	/**
	 * Muestra el menu principal y solicita el ingreso de la funcionalidad deseada
	 * 
	 * @param teclado Para el ingreso de datos
	 * @return opcion seleccionada
	 */
	private static int seleccionarOpcion(Scanner teclado) {

		int opcionSeleccionada = 0;

		mostrarMensaje("\n************************");
		mostrarMensaje("Menu Principal\n");
		mostrarMensaje("1 - Registar una atencion ");
		mostrarMensaje("2 - Buscar atencion por su identificador unico");
		mostrarMensaje("3 - Listar atenciones por una especie determinada");
		mostrarMensaje("4 - Eliminar una atencion por su id");
		mostrarMensaje("5 - Informar la cantidad de atenciones realizadas y las disponibles");
		mostrarMensaje("6 - Infomar el total de todas las atenciones realizadas [Requiere iniciar sesion]");
		mostrarMensaje("7 - Listar atenciones por monto descendente [Requiere iniciar sesion]");
		mostrarMensaje("\n9 - Salir");
		mostrarMensaje("\n************************");
		mostrarMensaje("\nIngrese una opcion");

		opcionSeleccionada = teclado.nextInt();

		return opcionSeleccionada;
	}

	/**
	 * Solicita el ingreso de la informacion para crear una atencion y la crea
	 * 
	 * @param teclado     Para el ingreso de datos
	 * @param veterinaria Clase principal
	 */
	private static boolean crearAtencion(Scanner teclado, Veterinaria veterinaria) {
		mostrarMensaje("\nIngrese ID: ");
		int id = teclado.nextInt();

		mostrarMensaje("\nIngrese el nombre del cliente: ");
		String nombreCliente = teclado.next();

		mostrarMensaje("\nIngrese el nombre de la mascota: ");
		String nombreMascota = teclado.next();

		mostrarMensaje("\nIngrese monto de la atencion: ");
		double monto = teclado.nextDouble();

		Especie especieMascota = ingresarEspecieMascota(teclado);

		Atencion atencion = new Atencion(id, nombreCliente, nombreMascota, especieMascota, monto);

		return veterinaria.registrarAtencion(atencion);
	}

	private static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	private static Atencion buscarAtencionPorId(Scanner teclado, Veterinaria veterinaria) {
		int id = ingresarId(teclado);
		return veterinaria.buscarAtencionPorId(id);
	}

	private static int ingresarId(Scanner teclado) {
		mostrarMensaje("\nIngrese ID: ");
		return teclado.nextInt();
	}

	private static Especie ingresarEspecieMascota(Scanner teclado) {
		int opcionEspecie = 0;
		do {

			mostrarMensaje("\nIngrese la especie de la mascota: ");
			mostrarMensaje("\n1 - Perro\n2 - Gato\n3 - Ave: ");
			opcionEspecie = teclado.nextInt();

		} while (opcionEspecie < 1 || opcionEspecie > 3);

		Especie especieMascota = Especie.values()[opcionEspecie - 1];

		return especieMascota;
	}

	private static void mostrarAtenciones(Atencion[] atencionesEspecie) {
		for (int i = 0; i < atencionesEspecie.length; i++) {
			if (atencionesEspecie[i] != null) {
				mostrarMensaje("\nAtencion: " + atencionesEspecie[i].toString());
			}
		}
	}

	private static boolean eliminarAtencion(Scanner teclado, Veterinaria veterinaria) {
		int id = ingresarId(teclado);
		return veterinaria.eliminarAtencionPorId(id);
	}

	private static boolean iniciarSesion(Scanner teclado, Veterinaria veterinaria) {
		mostrarMensaje("\nIngrese usuario: ");
		String nombreUsuario = teclado.next();

		mostrarMensaje("\nIngrese contrasenia: ");
		String contrasenia = teclado.next();

		return veterinaria.iniciarSesion(nombreUsuario, contrasenia);
	}

}
