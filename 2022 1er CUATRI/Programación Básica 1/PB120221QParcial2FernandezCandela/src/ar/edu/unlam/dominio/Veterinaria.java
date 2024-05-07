package ar.edu.unlam.dominio;

public class Veterinaria {

	private String nombre;
	private Atencion[] atenciones;
	
	
	public Veterinaria(String nombreVeterinaria, int cantidadMaximaAtenciones) {
		// TODO Auto-generated constructor stub
		this.nombre= nombreVeterinaria;
		this.atenciones= new Atencion[cantidadMaximaAtenciones];
	}

	/**
	 * Agrega una atenciona al arreglo de atenciones
	 * 
	 * @param atencion Atencion	que se agregara
	 * @return true en caso de exito
	 * */
	public boolean registrarAtencion(Atencion atencion) {
		for(int i=0;i<atenciones.length;i++) {
			if(atenciones[i] == null) {
				atenciones[i] = atencion;
				return true;
			}
			
		}
		return false;
	}
	
	/**
	 * Obtiene una atencion por su identificador
	 * 
	 * @param id	Identificador de la atencion
	 * @return atencion o null en caso de no encontrarse
	 * */
	public Atencion buscarAtencionPorId(int id) {
		for(int i=0;i<atenciones.length;i++) {
			if(atenciones[i] != null)
			if(atenciones[i].getId() == id) {
				return atenciones[i];
			}
			
		}
		return null;
	}
	
	/**
	 * Obtiene atenciones filtradas por la especie de la mascota
	 * +
	 * @return array de atenciones
	 * */
	public Atencion[] listarAtencionesPorEspecieDeMascota(Especie especieMascota){
		Atencion[] atencionesEspecie = new Atencion[this.atenciones.length];
		int indice =0;
		for(int i=0;i<this.atenciones.length;i++) {
			if(this.atenciones[i] != null && this.atenciones[i].getEspecieMascota().equals(especieMascota)){
				atencionesEspecie[indice++] = this.atenciones[i];
			}
		}
		
		return null;
	}
	
	/**
	 * Elimina una atencion por su identificador
	 * 
	 * @param id 	Identificador de la atencion
	 * @return true en caso de exito
	 * */
	public boolean eliminarAtencionPorId(int id) {
		for(int i=0; i<atenciones.length;i++) {
			if(atenciones[i] != null)
			if(atenciones[i].getId() == id) {
				atenciones[i] = null;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Obtiene la cantidad de atenciones realizadas hasta el momento
	 * 
	 * @return cantidad de atenciones
	 * */
	public int obtenerCantidadDeAtencionesRealizadas() {
		int cantidadDeAtenciones=0;
		for(int i=0;i<atenciones.length;i++) {
			if(atenciones[i] != null) {
				cantidadDeAtenciones++;
			}
		}
		return cantidadDeAtenciones;
	}
	
	/**
	 * Obtiene la cantidad de atenciones disponibles
	 * 
	 * @return atenciones
	 * */
	public int obtenerCantidadDeAtencionesDisponibles(int atencionesRealizadas) {
		int contarAtencionesDisponibles=0;
		atencionesRealizadas= obtenerCantidadDeAtencionesRealizadas();
		for(int i=0; i<atenciones.length;i++) {
			if(atencionesRealizadas < 5) {
				contarAtencionesDisponibles++;
			}
		}
		return contarAtencionesDisponibles;
		
	}
	
	/**
	 * Calcula y devuelve el total de todas las atenciones realizadas
	 * 
	 * @return monto total
	 * */
	public double obtenerTotalDeAtenciones() {
		double monto =0;
		double totalAtenciones=0;
		for(int i=0;i<atenciones.length;i++) {
			if(atenciones[i] != null)
		     totalAtenciones = atenciones[i].getMonto();
			monto += totalAtenciones;
		}
		
		return monto;
	}
	
	/**
	 * Obtiene atenciones ordenadas por monto descendente
	 * 
	 * @return atenciones
	 * */
	public void ordenarAtencionesPorMontoDescendente() {
		Atencion auxiliar;
		for(int i=1;i<atenciones.length;i++) {
			for(int j=0;i<atenciones.length-1;i++) {
				if(atenciones[j].getMonto()<atenciones[j+1].getMonto()) {
					auxiliar = atenciones[j];
					atenciones[j] = atenciones[j+1];
					atenciones[j+1] = auxiliar;
					
				}

			}
			
		}
	}
	
	
	public Atencion[] getAtenciones() {
		return atenciones;
	}

	public void setAtenciones(Atencion[] atenciones) {
		this.atenciones = atenciones;
	}

	/**
	 * Valida las credenciales proporcionadas
	 * 
	 * @param nombreUsuario		Nombre de usuario del administrador
	 * @param contrasenia		Contrasenia del administrador
	 * @return verdadero en caso de exito
	 * */
	public boolean iniciarSesion(String nombreUsuario, String contrasenia) {
		String nombreAdministrador= "candelafdz";
		String contraseniaAdministrador="candela123";
		for(int i=0;i<atenciones.length;i++) {
			if(nombreAdministrador.equals(nombreUsuario) && contraseniaAdministrador.equals(contrasenia)) {
				return true;
			}
		}
		return false;
	}
}
