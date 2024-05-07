package ar.edu.unlam.muni;

import java.util.ArrayList;
import java.util.HashSet;

public class Secretaria {

	private ArrayList<Habitante> habitantes;
	private ArrayList<Vivienda> viviendas;
	private ArrayList<PropietarioVivienda> propietarioViviendas;

	public Secretaria() {
		this.habitantes = new ArrayList<Habitante>();
		this.viviendas = new ArrayList<Vivienda>();
		this.propietarioViviendas = new ArrayList<PropietarioVivienda>();
	}

	public void agregarHabitante(Habitante habitante) {
		habitantes.add(habitante);
	}

	public Integer obtenerCantidadDeHabitantes() {

		return this.habitantes.size();
	}

	public void agregarVivienda(Vivienda vivienda) {
		viviendas.add(vivienda);

	}

	public Integer obtenerCantidadDeViviendas() {

		return this.viviendas.size();
	}

	public Boolean comprarVivienda(Habitante habitante, Vivienda vivienda, Double porcentaje) {
		Double porcentajeDeVivienda = obtenerElPorcentaejDeCompraDeUnaVivienda(vivienda);
		if (porcentajeDeVivienda + porcentaje <= 100.0) {
			PropietarioVivienda comprar = new PropietarioVivienda(habitante, vivienda, porcentaje);
			this.propietarioViviendas.add(comprar);
			return true;
		}
		return false;
	}

	private Double obtenerElPorcentaejDeCompraDeUnaVivienda(Vivienda vivienda) {
		Double porcentaje = 0.0;
		for (int i = 0; i < this.propietarioViviendas.size(); i++) {
			if (propietarioViviendas.get(i).getVivienda().equals(vivienda)) {
				porcentaje += this.propietarioViviendas.get(i).getPorcentaje();
			}
		}
		return porcentaje;
	}
	

	public Integer obtenerCantidadDeCompras() {

		return this.propietarioViviendas.size();
	}

	public HashSet<Vivienda> obtenerViviendaCuyoPorcentajeEsMenorAlCienPorciento() {
		HashSet <Vivienda> viviendasMenorAlCien = new HashSet<>();
		for (PropietarioVivienda propietarioViviendas : propietarioViviendas) {
			if(this.obtenerElPorcentaejDeCompraDeUnaVivienda(propietarioViviendas.getVivienda())<100.0){
				viviendasMenorAlCien.add(propietarioViviendas.getVivienda());
			}
		}
		return viviendasMenorAlCien;
	}

}
