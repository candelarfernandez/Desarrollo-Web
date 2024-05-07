package ar.edu.unlam.pb1.parcial2;

public class PartidoDeFutbol {
	private EquipoDeFutbol local;
	private EquipoDeFutbol visitante;
	private Evento goles[];
	private Evento amontestados[];
	private Evento expulsados[];
	
	public PartidoDeFutbol(EquipoDeFutbol local, EquipoDeFutbol visitante) {
		this.local = local;
		this.visitante = visitante;
	}
	
	/*
	 * Se debe marcar un nuevo Gol 
	 * Dependiendo del autor (según al equipo que pertenezca) y del tipo (si es a favor o en contra) se sabrá a quien contabilizarlo
	 */
	public void marcar(Evento gol) {

	}
	
	/*
	 * Se registra un nuevo amonestado en el partido. 
	 * Si el mismo ya poseía una amonestación previa, se lo debe expulsar. 
	 * El método devuelve la cantidad de amonestaciones del jugador. 
	 * Los valores posibles de retorno son:
	 * 1 - Si no tenía amonestación previa o 
	 * 2 - Si ya poseía una amonestación previa y termina siendo expulsado
	 * 
	 */
	public int amonestar(Evento amonestado) {

		return 0;
	}
	
	/*
	 * Se registra un nuevo expulsado en el partido. 
	 */
	public void expulsar(Evento expulsado) {

	}
	
	/*
	 * Se cuentan la cantidad de goles por equipo (Se debe considerar si el gol resultó a favor o en contra), y devuelve el equipo ganador (Si hubo un empate retorna null) 
	 */
	public EquipoDeFutbol getGanador() {
		return null;
	}
	
	/*
	 * El método toString debe describir el ESTADO del partido (Equipos que se enfrentan, los goles realizados, los amonestado y expulsados).
	 */
	public String toString() {
		String resultado = "";
		return resultado;
	}

	public EquipoDeFutbol getLocal() {
		return local;
	}

	public EquipoDeFutbol getVisitante() {
		return visitante;
	}

}
