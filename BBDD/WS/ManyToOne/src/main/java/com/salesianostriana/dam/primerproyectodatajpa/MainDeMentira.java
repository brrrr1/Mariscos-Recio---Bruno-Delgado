package com.salesianostriana.dam.primerproyectodatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.primerproyectodatajpa.repositorios.AlumnoRepositorio;
import com.salesianostriana.dam.primerproyectodatajpa.repositorios.CursoRepositorio;

import jakarta.annotation.PostConstruct;

@Component
public class MainDeMentira {

	@Autowired
	private AlumnoRepositorio repositorio;
	
	@Autowired
	private CursoRepositorio cursoRepo;
	
	
	
	
	
	@PostConstruct
	void ejecutar() {
		
		Curso c = new Curso("1ºDAM", "Michigan");
		cursoRepo.save(c);
		
		Alumno a = new Alumno("Cristiano", "Ronaldo Dos Santos Aveiro", "elbicho@siuu.com");
		
		a.addToCurso(c);
		
		repositorio.save(a);
		repositorio.findAll().forEach(System.out::println);	
		
		/*
		repositorio.save(new Alumno("Cristiano", "Ronaldo Dos Santos Aveiro", "elbicho@siuu.com", c));
		repositorio.save(new Alumno("Anuel", "AA", "anueldoblea@rhlm.brr", c));
		
		//MALA manera de hacerlo
		//repositorio.findAll().forEach(a -> System.out.println(a));
		
		//BUENA manera de hacerlo
		repositorio.findAll().forEach(System.out::println);	
		*/
		
	}
	
}
