package com.salesianostriana.dam.ethmanytoone.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String tutor;
	
	public Curso(String nombre) {
		this.nombre = nombre;
	}	

	public Curso(String nombre, String tutor) {
		this.nombre = nombre;
		this.tutor=tutor;
	}
}
