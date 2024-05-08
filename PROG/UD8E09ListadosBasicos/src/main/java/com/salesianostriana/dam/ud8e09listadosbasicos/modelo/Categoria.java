package com.salesianostriana.dam.ud8e09listadosbasicos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Categoria {

	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	
	private boolean destacada;
	
	private String imagen;
}