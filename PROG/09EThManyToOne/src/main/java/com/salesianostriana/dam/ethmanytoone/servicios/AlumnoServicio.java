package com.salesianostriana.dam.ethmanytoone.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.ethmanytoone.modelo.Alumno;
import com.salesianostriana.dam.ethmanytoone.repositorios.AlumnoRepository;

@Service
public class AlumnoServicio {
	
	// Inyectamos la dependencia del repositorio
	private AlumnoRepository alumnoRepository;
	
	public AlumnoServicio(AlumnoRepository repo) {
		this.alumnoRepository = repo;
	}
	
	/**
	 * Inserta un nuevo alumno
	 * 
	 * @param El Alumno a insertar
	 * @return El alumno ya insertado (con el Id no vacío).
	 */
	public Alumno add(Alumno a) { return alumnoRepository.save(a); }
	
	
	/**
	 * Edita un alumno, si existe; si no existe, lo inserta como uno nuevo.
	 * @param a
	 * @return
	 */
	public Alumno edit(Alumno a) { return alumnoRepository.save(a); }

	/**
	 * Elimina el alumno
	 * 
	 * @param El alumno a editar 
	 */
	public void delete(Alumno a) { alumnoRepository.delete(a); }
	
	/**
	 * Elimina un alumno por su Id
	 * @param id
	 */
	public void delete(long id) { alumnoRepository.deleteById(id); }
	
	/**
	 * Devuelve una lista con todos los alumnos
	 * @return
	 */
	public List<Alumno> findAll() { return alumnoRepository.findAll(); }
	
	
	/**
	 * Devuelve un alumno en base a su Id o null en caso contrario
	 * @param id
	 * @return el alumno encontrado o <code>null</code>
	 */
	public Alumno findById(long id) {
		return alumnoRepository.findById(id).orElse(null);
	}

}
