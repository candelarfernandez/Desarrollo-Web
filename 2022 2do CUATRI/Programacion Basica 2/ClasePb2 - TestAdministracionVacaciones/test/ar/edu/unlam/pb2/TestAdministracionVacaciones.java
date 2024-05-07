package ar.edu.unlam.pb2;

import static org.junit.Assert.*;


import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class TestAdministracionVacaciones {

	@Test
	public void queSePuedaAgregarUnEmpleado() throws Exception {
	   Empresa empresa = new Empresa("FLybondy");
	   Generacion g = empresa.buscarGeneracionePorId(1);
	   Empleado empleado = new Empleado (568,"Rocio",LocalDate.of(2022, 10, 26),Rol.TRAFICO,g);
	   empresa.agregarEmpleado(empleado);
	   assertEquals(1,empresa.getEmpleados().size());
	}
	
	@Test 
	public void queSePuedaObtenerUnaListaOrdenadaPorId() throws Exception{
		Empresa empresa = new Empresa("FLybondy");
		Generacion g = empresa.buscarGeneracionePorId(1);
		Generacion g1 = empresa.buscarGeneracionePorId(2);
		Empleado empleado = new Empleado (568,"Rocio",LocalDate.of(2022, 10, 26),Rol.TRAFICO,g);
		Empleado empleado1 = new Empleado (534,"Luchi",LocalDate.of(2022, 10, 26),Rol.RAMPA,g);
		Empleado empleado2 = new Empleado (511,"Andi",LocalDate.of(2022, 10, 26),Rol.LEAD,g);
		Empleado empleado3 = new Empleado (522,"Andi",LocalDate.of(2022, 10, 26),Rol.TRAFICO,g1);
		Empleado empleado4 = new Empleado (571,"Andi",LocalDate.of(2022, 10, 26),Rol.TRAFICO,g1);
		empresa.agregarEmpleado(empleado);
		empresa.agregarEmpleado(empleado1);
		empresa.agregarEmpleado(empleado2);
		empresa.agregarEmpleado(empleado3);
		empresa.agregarEmpleado(empleado4);
		//lista treeset que ordena
		Set <Empleado>listaEmpleados = empresa.ObtenerEmpleadosOrdenadosPorId();
		for (Empleado empleado5 : listaEmpleados) {
			assertEquals(511, (int)empleado5.getId());
			break;
		}
		
	}
	
	@Test 
	public void queSePuedaObtenerUnaListaOrdenadaPorNombre() throws Exception{
		Empresa empresa = new Empresa("FLybondy");
		Generacion g = empresa.buscarGeneracionePorId(1);
		Generacion g1 = empresa.buscarGeneracionePorId(2);
		Empleado empleado = new Empleado (568,"Rocio",LocalDate.of(2022, 10, 26),Rol.TRAFICO,g);
		Empleado empleado1 = new Empleado (534,"Luchi",LocalDate.of(2022, 10, 26),Rol.RAMPA,g);
		Empleado empleado2 = new Empleado (511,"Andi",LocalDate.of(2022, 10, 26),Rol.LEAD,g);
		Empleado empleado3 = new Empleado (522,"Cande",LocalDate.of(2022, 10, 26),Rol.TRAFICO,g1);
		Empleado empleado4 = new Empleado (571,"Pipi",LocalDate.of(2022, 10, 26),Rol.TRAFICO,g1);
		empresa.agregarEmpleado(empleado);
		empresa.agregarEmpleado(empleado1);
		empresa.agregarEmpleado(empleado2);
		empresa.agregarEmpleado(empleado3);
		empresa.agregarEmpleado(empleado4);
		//lista treeset que ordena
		Set <Empleado>listaEmpleados = empresa.ObtenerEmpleadosOrdenadosPorNombre();
		for (Empleado empleado5 : listaEmpleados) {
			assertEquals("Andi", empleado5.getNombre());
			break;
		}
	}
	
		
	}
	


