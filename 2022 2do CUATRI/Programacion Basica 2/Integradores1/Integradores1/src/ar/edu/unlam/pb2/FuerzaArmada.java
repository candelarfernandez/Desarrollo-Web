package ar.edu.unlam.pb2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FuerzaArmada {
	private Set<Vehiculo> convoy=new HashSet<Vehiculo>();;
	private Map<String, Batalla> batallas= new HashMap<String, Batalla>();
	private Set <Vehiculo> convoyListoParaBatalla=new HashSet<Vehiculo>();
	
	
	public FuerzaArmada() {
	}


	public Set<Vehiculo> getConvoy() {
		return convoy;
	}


	public void setConvoy(Set<Vehiculo> convoy) {
		this.convoy = convoy;
	}


	public Integer getBatallas(String nombre) {
		return batallas.size();
	}


	public void setBatallas(Map<String, Batalla> batallas) {
		this.batallas = batallas;
	}


	public void agregarVehiculo(Vehiculo vehiculo) {
		convoy.add(vehiculo);
	}




	public Integer getCapacidadDeDefensa() {
		return convoy.size();
	}


	public void crearBatalla(Batalla sanlorenzo) {
			batallas.put(sanlorenzo.getNombre(), sanlorenzo);
		
	}
	


	public Set<Vehiculo> getConvoyListoParaBatalla() {
		return convoyListoParaBatalla;
	}


	public void setConvoyListoParaBatalla(Set<Vehiculo> convoyListoParaBatalla) {
		this.convoyListoParaBatalla = convoyListoParaBatalla;
	}


	public Boolean enviarALaBatalla(Batalla tiposDeBatalla, Integer codigo) throws VehiculoIncompatibleException, VehiculoInexistenteException  {
		TipoDeBatalla tipoBatalla= tiposDeBatalla.getTipo();
		
		
		for (Vehiculo vehiculo : convoy) {
			if(vehiculo.getCodigo()== codigo) {
				
			switch(tipoBatalla) {
			case TERRESTRE:
				if(vehiculo instanceof Terrestre) {
					convoyListoParaBatalla.add(vehiculo);
					return true;
				}else {
					throw new VehiculoIncompatibleException("El vehiculo es incompatible");
				}
			
			case ACUATICA:
				if(vehiculo instanceof Acuatico) {
					convoyListoParaBatalla.add(vehiculo);
					return true;
				}else {
					throw new VehiculoIncompatibleException("El vehiculo es incompatible");
				
					}
				
			case AEREA:
				if(vehiculo instanceof Volador) {
					convoyListoParaBatalla.add(vehiculo);
					return true;
				}else {
					throw new VehiculoIncompatibleException("El vehiculo es incompatible");
					
				}
				
			case NAVAL:
				convoyListoParaBatalla.add(vehiculo);
				return true;
				
			}
			
		} 
		
	}
		throw new VehiculoInexistenteException("No existe el vehiculo");
		
		
	}


	


	
	
	
	
	

}
