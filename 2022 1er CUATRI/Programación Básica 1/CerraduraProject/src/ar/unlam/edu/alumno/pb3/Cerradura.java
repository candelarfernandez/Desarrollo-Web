package ar.unlam.edu.alumno.pb3;

import java.util.Scanner;

public class Cerradura {
	 
		
	final int CONTRASENIA_CORRECTA=1;
	final int CONTRASENIA_INCORRECTA=2;
	
	String clave = "Unlam2022";
	
	//mostrar mensaje
	public void mostrarMensaje (String mensaje) {
		System.out.println(mensaje);
		
		//instancio objeto
		Scanner teclado = new Scanner(System.in);
		mostrarMensaje("Bienvenidos!");
		
		//ingresar contraseña correctamente
		mostrarMensaje("Ingrese la contraseña:");
		String ingresarContrasenia = teclado.nextLine();
		
		
		//resolucion
		int opcion=0;
		opcion = teclado.nextInt();
		
		switch (opcion) {
		case CONTRASENIA_CORRECTA:
			if (ingresarContrasenia==this.clave) {
				mostrarMensaje("Usted ha iniciado sesión");
				
			}	
			break;
		
		case CONTRASENIA_INCORRECTA:
			if(ingresarContrasenia!=this.clave) {
				mostrarMensaje("La contraseña ingresada es incorrecta");
			}
			break;
		}
		
		
			
	  
	
	}
}
