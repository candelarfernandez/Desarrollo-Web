package ar.edu.unlam.pb2;

import java.util.Comparator;

public class ordenEmpleadoPorNombre implements Comparator<Empleado>{

	@Override
	public int compare(Empleado o1, Empleado o2) {
		if(o1.getNombre().compareTo(o2.getNombre())==0) {
			return o1.getId().compareTo(o2.getId());
		}
		return o1.getNombre().compareTo(o2.getNombre())*(-1); //forma descendente
		
	}

//	@Override
//	public int compare(Empleado o1, Empleado o2) {
	//	if(o1.getNombre().compareTo(o2.getNombre())== 0){ //si dos nosmbres llegan a hacer iguales
			//los odeno por su id entonces
	//		return o1.getId().compareTo(o2.getId()); 
	//	}
	//	return o1.getNombre().compareTo(o2.getNombre()); //forma acendente
		//forma descendente .getNombre() * (-1);
//	}
	
	

	
}
