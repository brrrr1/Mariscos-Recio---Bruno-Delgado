package com.salesianostriana.dam.ejemploformularios01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Empleado {
	@Id
	@GeneratedValue
	private long id;
	private String nombre;
	private String email;

}
