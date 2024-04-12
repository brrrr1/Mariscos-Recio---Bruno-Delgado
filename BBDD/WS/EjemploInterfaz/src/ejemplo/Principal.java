package ejemplo;

import java.util.List;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static void saltarTodos(List<PuedeSaltar> listaPuedeSaltar) {
		for (PuedeSaltar puedeSaltar : listaPuedeSaltar) {
			puedeSaltar.saltarHaciaArriba();
		}
	}

}
