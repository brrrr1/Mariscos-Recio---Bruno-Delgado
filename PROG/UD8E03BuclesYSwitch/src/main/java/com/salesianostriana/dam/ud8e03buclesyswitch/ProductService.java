package com.salesianostriana.dam.ud8e03buclesyswitch;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

//Anotamos la clase con @Service para decir que en ella
//incluiremos los servicios de nuestra aplicación
@Service
public class ProductService {
	
	/*
	 * Como hemos hecho en algún ejemplo anterior, estamos creando métodos
	 * en la clase servicio que nos dan algunos objetos 
	 * simulando que vienen de la base de datos, en este caso, 
	 * nos da una colección List de productos, creada 
	 * directamente con dos botijos
	 * */
	public List<Product> getLista() {
		return Arrays.asList(
				new Product(1, "Botijo", "Enfría hasta menos 10 grados", 20.5055, true, LocalDateTime.now()),
				new Product(2, "BotijoExtra", "Enfría hasta menos 200 grados", 200.50, true, LocalDateTime.now())
				);		
	}

}
