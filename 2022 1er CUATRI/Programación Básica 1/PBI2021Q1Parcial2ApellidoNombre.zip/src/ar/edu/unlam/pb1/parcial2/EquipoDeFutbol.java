package ar.edu.unlam.pb1.parcial2;

public class EquipoDeFutbol {
	private String nombre;
	private Jugador jugadores[];
	
	public EquipoDeFutbol(String nombre, int cantidadJugadores) {
		this.nombre = nombre;
		this.jugadores= new Jugador[cantidadJugadores];
	}

	/*
	 * La capacidad m�xima de un equipo es 5. No se permiten jugadores repetidos (ya sea el n�mero o nombre del jugador)
	 * Se retorna el resultado de la operaci�n
	 */
	public boolean agregarJugador(Jugador nuevo) {
		
		for(int i=0;i<jugadores.length.i++) {
			if(jugadores[i] == null) {
				jugadores[i] = nuevo;
			}
		}
		return false;
	}
	
	/*
	 * Permite buscar un jugador por su numero. 
	 * 
	 */
	public Jugador buscar(int numero) {
		return null;
	}
	
	/*
	 * Permite buscar un jugador por su nombre. 
	 * 
	 */
	public Jugador buscar(String nombre) {
		return null;
	}
	
	/*
	 * Calcula el valor del equipo. 
	 * 
	 */
	public double calcularLaEdadPromedioDelEquipo() {
		return 0.0;
	}
	
	/*
	 * Calcula el valor del equipo
	 * 
	 */
	public double calcularElValorDelEquipo() {
		return 0.0;
	}
	
	public String toString() {
		return this.nombre;
	}
	
}
