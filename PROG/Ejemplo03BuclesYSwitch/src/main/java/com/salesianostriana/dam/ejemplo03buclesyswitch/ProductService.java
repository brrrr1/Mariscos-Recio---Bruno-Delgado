package com.salesianostriana.dam.ejemplo03buclesyswitch;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	
	public List<Producto> getLista(){
		return Arrays.asList(
				new Producto(1, "Botijo", "Enfria hasta -10ºC", 20.5055, true, LocalDateTime.now()),
				new Producto(2, "BotijoExtra", "Enfria hasta -200ºC", 200.50, true, LocalDateTime.now())
				);
				
	}
}
