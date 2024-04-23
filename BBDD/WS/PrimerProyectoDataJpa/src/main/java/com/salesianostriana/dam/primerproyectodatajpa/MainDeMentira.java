package com.salesianostriana.dam.primerproyectodatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import salesianostriana.dam.primerproyectodatajpa.repositorios.AlumnoRepository;

@Component
public class MainDeMentira {

	//Las clases que son entidades no se pueden inyectar, por lo que aquí haremos la inyección de dependendcias de un repositorio
	@Autowired
	private AlumnoRepository repo;
	
	@PostConstruct
	void ejecutar() {
		repo.save(new Alumno("Cristiano", "Ronaldo", "delgado.hebru24@triana.salesianos.edu"));
		
		
	}
	
}
