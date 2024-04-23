package com.salesianostriana.dam.ejemplo03buclesyswitch;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Producto {

	
	private long id;
	private String nombre;
	private String descripccion;
	private double precio;
	private boolean inStock;
	
	//Importar la librería de Spring, de las dos que salen
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime date;
	
}
