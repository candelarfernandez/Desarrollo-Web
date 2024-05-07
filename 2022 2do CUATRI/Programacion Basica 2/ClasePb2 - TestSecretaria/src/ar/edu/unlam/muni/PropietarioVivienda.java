package ar.edu.unlam.muni;

public class PropietarioVivienda {

	private Habitante habitante;
	private Vivienda vivienda;
	private Double porcentaje;

	public PropietarioVivienda(Habitante habitante, Vivienda vivienda, Double porcentaje) {
		this.habitante = habitante;
		this.vivienda = vivienda;
		this.porcentaje = porcentaje;
		// this.id=id;
	}

	public Habitante getHabitante() {
		return habitante;
	}

	public void setHabitante(Habitante habitante) {
		this.habitante = habitante;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

}
