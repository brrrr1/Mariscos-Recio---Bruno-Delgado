package com.salesianostriana.dam.pruebaproyecto;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class MerchService {

	public List<Merch> getLista(){
		return Arrays.asList(
				new Merch(1, "Taza", "Impresionante taza de Mariscos Recio para disfrutar de tu colacao con magdalenas", 20, "foto", 7),
				new Merch(2, "Llavero", "Brillante llaver ode acero inoxidable para presumir tu marisco por todos lados", 12, "foto", 3.5),
				new Merch(3, "Imán Nevera", "Genial pin para poner en la nevera y recordar siempre que estamos a tu disposición", 5, "foto", 2)
				);	
	}
	
}
