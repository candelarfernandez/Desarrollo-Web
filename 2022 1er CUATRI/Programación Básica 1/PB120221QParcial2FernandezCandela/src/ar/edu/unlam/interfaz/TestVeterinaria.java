package ar.edu.unlam.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.Atencion;
import ar.edu.unlam.dominio.Especie;
import ar.edu.unlam.dominio.Veterinaria;

public class TestVeterinaria {

	private static final int SALIR= 9;
	private static final int CANTIDAD_MAXIMA_ATENCIONES = 5;

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		String nombreVeterinaria = "UNLaM-Vet";
		mostrarMensaje("Bienvenido a "+ nombreVeterinaria);
		
		Veterinaria veterinaria = new Veterinaria(nombreVeterinaria, CANTIDAD_MAXIMA_ATENCIONES);

		int opcion = 0;

		do {
			opcion = seleccionarOpcion(teclado);

			switch (opcion) {
			case 1:
				
				// Registra una atencion con los datos ingresados por el empleado e informa el resultado
				
				crearAtencion(teclado, veterinaria);
				
				break;
			case 2:
				// Se solicita el ingreso del id y se muestra la informacion de la atencion
				// encontrada. Si no se encuentra, mostrar un mensaje
				System.out.println("Ingrese id para consultar atencion");
				int id= teclado.nextInt();
				buscarAtencionPorId(veterinaria, id);
				break;
			case 3:
				// Ingresar la especie de mascota para listar las atenciones que correspondan.
				// Si no hay atenciones indicar lo propio
				break;
			case 4:
				// Se solicita el ingresdo del id de la atencion y se elimina. Indicar el
				// resultado de la operacion
				System.out.println("Ingrese id para eliminar atencion");
				id= teclado.nextInt();
				eliminarAtencion(veterinaria, id);
				break;
			case 5:
				// Listar las atenciones realizadas y las disponibles
				listaAtencionesRealizadas(veterinaria);
				listaAtencionesDisponibles(veterinaria);
				break;
			case 6:
				// Informar el total de todas las atenciones realizadas. Debe inciar sesión para realizar esta operacion.
				// Si las credenciales son invalidas, indicarlo y volver al menu principal.
				System.out.println("Ingresar nombre de usuario");
				String nombreUsuario=teclado.next();
				System.out.println("Ingresar contrasenia de usuario");
				String contrasenia = teclado.next();
				iniciarSesion(nombreUsuario, contrasenia, veterinaria);
				break;
			case 7:
				// Informar por pantalla atenciones ordenadas en forma decreciente. Si no hay atenciones mostrar un mensaje aclaratorio.
				// Si las credenciales son invalidas, indicarlo y volver al menu principal.
				atencionesOrdenadas(veterinaria.getAtenciones());
				break;
			case SALIR:
				mostrarMensaje("Gracias por utilizar el sistema");		
				break;
			}

		} while (opcion != SALIR);
	
		teclado.close();
	}

	private static int listaAtencionesDisponibles(Veterinaria veterinaria) {
		int lista=0;
		lista += veterinaria.obtenerCantidadDeAtencionesDisponibles(0);
		return lista;
		
	}

	private static boolean atencionesOrdenadas(Atencion[] atenciones) {
		for(int i=0; i<atenciones.length;i++) {
			if(atenciones[i] != null) {
				System.out.println(atenciones[i].toString());
			}
			else {
				System.out.println("No existe la atencion");
			}
		}
		
		return false;
				
	}

	private static boolean iniciarSesion(String nombreUsuario, String contrasenia, Veterinaria veterinaria) {
		if(veterinaria.iniciarSesion(nombreUsuario, contrasenia) == true)
		{
			System.out.println(veterinaria.obtenerTotalDeAtenciones());
			return true;
		}
		else {
			System.out.println("no se pudo iniciar sesion");
		}
		return false;
		
		
	}

	private static int listaAtencionesRealizadas(Veterinaria veterinaria) {
		int lista =0;
		lista += veterinaria.obtenerCantidadDeAtencionesRealizadas();
			return lista;
		}
		
	

	private static boolean eliminarAtencion(Veterinaria veterinaria, int id) {
		if(veterinaria.eliminarAtencionPorId(id)) {
			System.out.println(veterinaria.eliminarAtencionPorId(id));
			return true;
		}
		else {
			System.out.println("No se pudo eliminar");
		}
		return false;
		
		
	}

	private static boolean buscarAtencionPorId(Veterinaria veterinaria, int id) {
		
		if(veterinaria.buscarAtencionPorId(id) != null)
		{
			System.out.println(veterinaria.buscarAtencionPorId(0));
			return true;
		}
		else {
			System.out.println("No se encontro atencion");
		}
		return false;
		
	}

	/**
	 * Muestra el menu principal y solicita el ingreso de la funcionalidad deseada
	 * 
	 * @param teclado	Para el ingreso de datos
	 * @return opcion seleccionada
	 * */
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
	 * @param teclado	Para el ingreso de datos
	 * */
	private static boolean crearAtencion(Scanner teclado, Veterinaria veterinaria) {
		System.out.println("Ingresar id");
		int id= teclado.nextInt();
		System.out.println("Ingresar nombre del cliente");
		String nombreCliente= teclado.next();
		System.out.println("Ingresar nombre de mascota");
		String nombreMascota=teclado.next();
		Especie especieMascota = ingresarEspecieMascota(teclado);
		System.out.println("Ingresar monto");
		double monto= teclado.nextDouble();
		
		Atencion nuevaAtencion = new Atencion(id, nombreCliente, nombreMascota, especieMascota, monto);
		
		if(veterinaria.registrarAtencion(nuevaAtencion)) {
			return true;
		}
		
		return false;
	}
	
	private static Especie ingresarEspecieMascota(Scanner teclado) {
		int opcionEspecie =0;
		do {
			mostrarMensaje( "\nIngrese la especie de la mascota: ");
			mostrarMensaje("\n1 - Perro\n2 - Gato\n3 - Ave: ");
			opcionEspecie=teclado.nextInt();	
			
		}while(opcionEspecie < 1 || opcionEspecie > 3 );
		Especie especieMascota = Especie.values()[opcionEspecie -1];
		return especieMascota;
	}

	private static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
