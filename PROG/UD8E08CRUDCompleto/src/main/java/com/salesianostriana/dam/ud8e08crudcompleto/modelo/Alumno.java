package com.salesianostriana.dam.ud8e08crudcompleto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
public class Alumno {
	
	@Id
	@GeneratedValue
	private long id;	
	private String nombre;
	private String apellidos;
	private String email;
	/*
	/**
	 * @param nombre
	 * @param apellidos
	 * @param email
	 */
	/*
	public Alumno(String nombre, String apellidos, String email) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}
	*/
}
