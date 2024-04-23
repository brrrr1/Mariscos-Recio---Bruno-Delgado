package com.salesianostriana.dam.primerproyectodatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor 
public class Alumno {

		@Id @GeneratedValue
		private Long Id;	
		private String nombre;
		private String apellidos;
		private String email;
		
		
		public Alumno(String nombre, String apellidos, String email) {
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.email = email;
		}


		
		

}
