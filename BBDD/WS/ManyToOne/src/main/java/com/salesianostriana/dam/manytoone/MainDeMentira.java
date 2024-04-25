package com.salesianostriana.dam.manytoone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.manytoone.repositorios.AlumnoRepositorio;
import com.salesianostriana.dam.manytoone.repositorios.CursoRepositorio;

import jakarta.annotation.PostConstruct;

@Component
public class MainDeMentira {

	@Autowired
	private AlumnoRepositorio repositorio;
	
	@Autowired
	private CursoRepositorio cursoRepo;
	
	
	
	
	
	@PostConstruct
	void ejecutar() {
		
		//Curso c = new Curso("1ºDAM", "Michigan");
		
		
		Curso c = Curso.builder()
				.nombre("1ºDAM")
				.tutor("Michigan")
				.build();
		
		cursoRepo.save(c);
		
		//Alumno a = new Alumno("Cristiano", "Ronaldo Dos Santos Aveiro", "elbicho@siuu.com");
		
		//Al anotar la clase alumno con @Builder ahora podemos crear cualquier alumno sin necesidad de un constructor con los argumentos que use
		//Hace falta tener constructor sin y con todos los argumentos
		Alumno a = Alumno.builder()
				.nombre("Cristiano")
				.apellidos("Ronaldo Dos Santos Aveiro")
				.email("elbicho@suu.com")
				.build();
		
		a.addToCurso(c);
		
		Alumno a2 = Alumno.builder()
				.nombre("Anuel")
				.apellidos("AA")
				.build();
		
		repositorio.save(a2);
		
		
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
