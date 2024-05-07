package ar.edu.unlam.dominio;

public class Veterinaria {

	private String nombre;
	private Atencion[] atenciones;
	private String contrasenia;
	private String nombreUsuario;

	public Veterinaria(String nombreVeterinaria, int cantidadMaximaAtenciones) {
		this.nombre = nombreVeterinaria;
		this.atenciones = new Atencion[cantidadMaximaAtenciones];
		this.nombreUsuario = "admin";
		this.contrasenia = "1234";
	}

	/**
	 * Agrega una atenciona al arreglo de atenciones
	 * 
	 * @param atencion Atencion que se agregara
	 * @return true en caso de exito
	 */
	public boolean registrarAtencion(Atencion atencion) {
		for (int i = 0; i < this.atenciones.length; i++) {
			if (this.atenciones[i] == null) {
				this.atenciones[i] = atencion;
				return true;
			}
		}
		return false;
	}

	/**
	 * Obtiene una atencion por su identificador
	 * 
	 * @param id Identificador de la atencion
	 * @return atencion o null en caso de no encontrarse
	 */
	public Atencion buscarAtencionPorId(int id) {
		Atencion atencionEncontrada = null;
		for (int i = 0; i < this.atenciones.length; i++) {
			if (this.atenciones[i] != null && this.atenciones[i].getId() == id) {
				atencionEncontrada = this.atenciones[i];
				break;
			}
		}

		return atencionEncontrada;
	}

	/**
	 * Obtiene atenciones filtradas por la especie de la mascota
	 * 
	 * @return array de atenciones
	 */
	public Atencion[] listarAtencionesPorEspecieDeMascota(Especie especieMascota) {

		Atencion[] atencionesEspecie = new Atencion[this.atenciones.length];
		int indice = 0;

		for (int i = 0; i < this.atenciones.length; i++) {
			if (this.atenciones[i] != null && this.atenciones[i].getEspecieMascota().equals(especieMascota)) {
				atencionesEspecie[indice++] = this.atenciones[i];
			}
		}

		return atencionesEspecie;
	}

	/**
	 * Elimina una atencion por su identificador
	 * 
	 * @param id Identificador de la atencion
	 * @return true en caso de exito
	 */
	public boolean eliminarAtencionPorId(int id) {

		for (int i = 0; i < this.atenciones.length; i++) {
			if (this.atenciones[i] != null && this.atenciones[i].getId() == id) {
				this.atenciones[i] = null;
				return true;
			}
		}

		return false;
	}

	/**
	 * Obtiene la cantidad de atenciones realizadas hasta el momento
	 * 
	 * @return cantidad de atenciones
	 */
	public int obtenerCantidadDeAtencionesRealizadas() {
		int cantidadAtenciones = 0;

		for (int i = 0; i < this.atenciones.length; i++) {
			if (this.atenciones[i] != null) {
				cantidadAtenciones++;
			}
		}

		return cantidadAtenciones;
	}

	/**
	 * Obtiene la cantidad de atenciones disponibles
	 * 
	 * @return atenciones
	 */
	public int obtenerCantidadDeAtencionesDisponibles(int atencionesRealizadas) {
		return this.atenciones.length - atencionesRealizadas;
	}

	/**
	 * Calcula y devuelve el total de todas las atenciones realizadas
	 * 
	 * @return monto total
	 */
	public double obtenerTotalDeAtenciones() {
		double total = 0.0;

		for (int i = 0; i < this.atenciones.length; i++) {
			if (this.atenciones[i] != null) {
				total += this.atenciones[i].getMonto();
			}
		}

		return total;
	}

	/**
	 * Obtiene atenciones ordenadas por monto descendente
	 * 
	 * @return atenciones
	 */
	public void ordenarAtencionesPorMontoDescendente() {

		Atencion auxiliar = null;

		for (int i = 1; i < this.atenciones.length; i++) {

			for (int j = 0; j < this.atenciones.length - 1; j++) {

				if (this.atenciones[j] != null && this.atenciones[j + 1] != null
						&& this.atenciones[j].getMonto() < this.atenciones[j + 1].getMonto()) {

					auxiliar = this.atenciones[j];
					this.atenciones[j] = this.atenciones[j + 1];
					this.atenciones[j + 1] = auxiliar;
				}
			}
		}
	}

	/**
	 * Valida las credenciales proporcionadas
	 * 
	 * @param nombreUsuario Nombre de usuario del administrador
	 * @param contrasenia   Contrasenia del administrador
	 * @return verdadero en caso de exito
	 */
	public boolean iniciarSesion(String nombreUsuario, String contrasenia) {
		return this.nombreUsuario.equals(nombreUsuario) && this.contrasenia.equals(contrasenia);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Atencion[] getAtenciones() {
		return atenciones;
	}

	public void setAtenciones(Atencion[] atenciones) {
		this.atenciones = atenciones;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
}
