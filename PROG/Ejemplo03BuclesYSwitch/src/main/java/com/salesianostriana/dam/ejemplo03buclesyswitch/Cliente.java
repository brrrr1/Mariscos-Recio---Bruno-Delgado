package com.salesianostriana.dam.ejemplo03buclesyswitch;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Cliente {

	private long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String genero;
	
}
