package ar.unlam.edu.pb2;

public class CuentaGandado {

	private Integer contador;
	private Integer limite = 9;

	public CuentaGandado() {
		this.contador = 0;
	}

	public Integer getContador() {

		return this.contador;
	}

	public void sumar() {
		if (contador < limite) {
			contador++;
		} else {
			contador = 0;
		}

	}

	public void resetear() {
		contador = 0;

	}

}
