package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBanco {

	@Test
	public void queSePuedaDividir() {
		Cuenta cuenta = new CuentaCorriente(1,3.0,"S","A",1,300.0);
		try {
			assertNull(cuenta.div(cuenta.div(4.0,0.0), 2.0));
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	//para que cuando termine con exception complie, si le pasamos un valor que no es exception, va a dar rojo ya que le pide que sea asi
	@Test (expected = CuentaNoEncontrada.class)
	public void queAlBuscarUnaCuentaQueNoExistaDuvuelvaUnaExcepcion() throws CuentaNoEncontrada{
		Cuenta cuentaCorriente = new CuentaCorriente(1,3.0,"S","A",1,300.0);
		Banco banco = new Banco();
		banco.agregarCuenta(cuentaCorriente);
		banco.buscarCuenta(5);
	}
	
	@Test (expected = MontoInsuficienteException.class)
	public void queNoSePuedaTransferirSiDevuelveException () throws MontoInsuficienteException, CuentaNoEncontrada  {
		Cuenta cuentaCorriente = new CuentaCorriente(1,3.0,"S","A",1,300.0);
		Cuenta cajaAhorro = new CajaAhorro(2, 44, "cande", "agos");
		Banco banco = new Banco();
		banco.agregarCuenta(cuentaCorriente);
		banco.agregarCuenta(cajaAhorro);
		
		banco.transferir(2, 1, 200.0);
		
		
	}
	@Test 
	public void queSePuedaAgregarUsuarioAlBanco() throws YaExisteTitular {
		Banco banco = new Banco();
		Titular titular = new Titular ("Rocio","Espa�a",43446347);
		banco.agregarCliente(43446347, titular);
		Integer valorEsperado = 1;
		Integer valorObtenido = banco.getTitulares().size();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test (expected = YaExisteTitular.class)
	public void queNoSePuedaAgregarAlBancoConElMismoDni() throws YaExisteTitular{
		Banco banco = new Banco();
		Titular titular = new Titular ("Rocio","Espa�a",43446347);
		Titular titular1 = new Titular ("Rocio","Espa�a",43446347);
		banco.agregarCliente(43446347, titular1);
		banco.agregarCliente(43446347, titular);
		
	}
	@Test
	public void buscarUnMapa() throws YaExisteTitular {
		Banco banco = new Banco();
		Titular titular = new Titular ("Rocio","Espa�a",43446347);
		banco.agregarCliente(43446347, titular);
		banco.buscarCliente(43446347);
	}
	
	/*
	 * para recorrer un mapa 
	 * for(objeto que recupero de la coleccion : coleccion)
	 * for(MapEntry(key,value)entry[devuelvo un conjunto de]:clientes.EntrySet[devuelve una coleccion])
	 * dentro del MapEntry tengo un entry.getKey() - entry.getValue()*/
	

}
