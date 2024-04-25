package com.salesianostriana.dam.pruebaproyecto;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.repositorios.MerchRepositorio;


@Service
public class MerchService {
	
	

	public List<Merch> getLista(){

		Merch m1 = Merch.builder()
				.id(1)
				.nombre("Taza")
				.descripcion("Impresionante taza de Mariscos Recio para disfrutar de tu colacao con magdalenas")
				.precio(7)
				.likes(20)
				.stock(50)
				.build();
		
		Merch m2 = Merch.builder()
				.id(2)
				.nombre("Llavero")
				.descripcion("Brillante llavero de acero inoxidable para presumir tu marisco por todos lados")
				.precio(3.5)
				.likes(12)
				.stock(50)
				.build();
		
		Merch m3 = Merch.builder()
				.id(3)
				.nombre("Imán Nevera")
				.descripcion("Genial pin para poner en la nevera y recordar siempre que estamos a tu disposición")
				.precio(2)
				.likes(5)
				.stock(50)
				.build();
				
		return Arrays.asList(
				m1,m2,m3	
				);	
		
	}
	
}
