package ar.edu.unlam.pob2;

import java.util.ArrayList;

public class Caja {
	
	ArrayList<Figura> ListaFiguras = new ArrayList<Figura>();

	public ArrayList<Figura> getListaFiguras() {
		return ListaFiguras;
	}

	public void setListaFiguras(ArrayList<Figura> listaFiguras) {
		ListaFiguras = listaFiguras;
	}
	
	public ArrayList<Figura> ListaFigurasAreaMayorDiez(){
		
		ArrayList<Figura> FigurasDiez = new ArrayList<Figura>();
		for(int i=0;i<this.ListaFiguras.size();i++) {
			if(this.ListaFiguras.get(i).getArea() > 10.0) {
				FigurasDiez.add(ListaFiguras.get(i));
			}
		}
		return FigurasDiez;
		
	}

	public ArrayList<Figura> getCirculosDeLista() {
		
		ArrayList<Figura> FigurasCirculo = new ArrayList<Figura>();
		for(int i=0;i<this.ListaFiguras.size();i++) {
			Figura circulo = new Circulo("circulo1", 15.0, 0.0, 0.0);
			if( this.ListaFiguras.get(i) instanceof Circulo) {
				FigurasCirculo.add(ListaFiguras.get(i));
			}
		}
		
		return FigurasCirculo;
		
		
	}
	

}
