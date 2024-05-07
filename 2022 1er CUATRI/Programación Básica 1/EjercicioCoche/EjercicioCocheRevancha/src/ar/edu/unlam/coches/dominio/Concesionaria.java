package ar.edu.unlam.coches.dominio;

public class Concesionaria {

	public Coche[] flota;
	
	public Concesionaria(int cantidadDeCochesEnLaFlota) {
		this.flota = new Coche[cantidadDeCochesEnLaFlota];
	}
	
	public boolean ingresarCoche(Coche nuevoCoche) {
			for(int i=0;i<flota.length;i++) {
				if(flota[i] == null) {
					flota[i] = nuevoCoche;
					return true;
				}
				
			}
		return false;
	}
	
	public String calcularIdentificador(double identificador) {
		String calculo="";
		for(int i=0;i<this.flota.length;i++) {
			identificador = Math.random();
			calculo = "El modelo "+flota[i].getModelo()+" tiene como identificador "+identificador;
		}
		return calculo;
	}
	
	public String calcularCantidadDeKilometros(int numMay) {
		String calculo= "";
		for(int i=0;i<this.flota.length;i++) {
			numMay=this.flota[0].getKilometros();
			if(this.flota[i].getKilometros()>numMay) {
				numMay=this.flota[i].getKilometros();
				calculo = "El "+this.flota[i].getModelo()+" es el auto con mas Kilometros"+numMay;
			}
		}
		return calculo;
	}
	
	public String encontrarCeroKilometroDeMenorPrecio(double kmMenorPrecio, int ceroKm) {
		String ceroKmMenorPrecio="";
		for(int i=0;i<this.flota.length;i++) {
			kmMenorPrecio = flota[0].getPrecio();
			ceroKm = flota[i].getKilometros();
			if(ceroKm == 0 && flota[i].getPrecio()<kmMenorPrecio) {
				kmMenorPrecio = flota[i].getPrecio();
				ceroKmMenorPrecio = "El auto cerokm con menor precio es "+kmMenorPrecio;
			}
		}
		return ceroKmMenorPrecio;
	}
	
	public int contarCocheDeDeterminadoModelo(String modelo) {
		int contadorModelo=0;
		for(int i=0;i<this.flota.length;i++) {
			if(flota[i].getModelo() != null)
			if(modelo == flota[i].getModelo()) {
				contadorModelo++;
			}
		}
		return contadorModelo;
	}
	
	public int calcularCantidadDeMarcasDistintas(String marcas) {
		int contadorMarcas =0;
		for(int i=0;i<flota.length;i++) {
			marcas = flota[0].getMarca();
			if(marcas != flota[i].getMarca()) {
				contadorMarcas++;
			}
		}
		return contadorMarcas;
	}
	
	public Coche[] ordenarFlota() {
		Coche auxiliar;
		for(int i=1;i<flota.length;i++) {
			for(int j=0;j<flota.length-1;j++) {
				if(flota[i].getKilometros()<flota[j+1].getKilometros()) {
					auxiliar = flota[i];
					flota[i] = flota[j+1];
					auxiliar = flota [j+1];
				}
			}
		}
		return null;
	}
	
	public Coche buscarVehiculo(String marca, String modelo) {
		Coche vehiculo = null;
		for(int i=0;i<flota.length;i++) {
			if(marca == flota[i].getMarca() && modelo == flota[i].getModelo()) {
				//vehiculo = flota[i].getMarca() + flota[i].getModelo();
				
			}
		}
		return vehiculo;
		
	}
	

}
