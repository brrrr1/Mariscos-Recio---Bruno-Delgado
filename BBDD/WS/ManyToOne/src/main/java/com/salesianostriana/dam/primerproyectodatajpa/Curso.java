package com.salesianostriana.dam.primerproyectodatajpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

	@Id @GeneratedValue
	private long id;
	private String nombre, tutor;
	//Lo que se pone dentro del mappedBy es el nombre en la clase de enfrente que tiene el atributo anotado con ManyToOne
	//En este caso es private Curso curso; asi que será curso
	@OneToMany(mappedBy="curso", fetch = FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Alumno> alumnos = new ArrayList<>();
	
	public Curso(String nombre, String tutor) {
		this.nombre = nombre;
		this.tutor = tutor;
	}
	
	
	
}
