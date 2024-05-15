/**
 * 
 */
package com.salesianostriana.dam.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.modelo.Alumno;
import com.salesianostriana.dam.modelo.Curso;
import com.salesianostriana.dam.repositorios.CursoRepository;

/**
 * @author luismi
 *
 */
@Service
public class CursoServicio {

	// Inyectamos la dependencia al nuevo estilo, sin @Autowired
	private CursoRepository cursoRepository;	
	private AlumnoServicio alumnoServicio;
	
	public CursoServicio(CursoRepository repo, AlumnoServicio alumnoServicio) {
		this.cursoRepository = repo;
		this.alumnoServicio = alumnoServicio;
	}
	
	/**
	 * Inserta un nuevo curso
	 * 
	 * @param El Curso a insertar
	 * @return El Curso ya insertado (con el Id no vacío).
	 */
	public Curso add(Curso c) { return cursoRepository.save(c); }
	
	
	/**
	 * Edita un curso, si existe; si no, lo inserta como uno nuevo.
	 * @param c
	 * @return
	 */
	public Curso edit(Curso c) { return cursoRepository.save(c); }

	/**
	 * Elimina el curso
	 * 
	 * @param c
	 */
	public void delete(Curso c) { cursoRepository.delete(c); }
	
	/**
	 * Elimina un Curso por su Id
	 * @param id
	 */
	public void delete(long id) { cursoRepository.deleteById(id); }
	
	/**
	 * Devuelve todos los cursos
	 * @return
	 */
	public List<Curso> findAll() { return cursoRepository.findAll(); }
	
	
	/**
	 * Devuelve un curso en base a su Id
	 * @param id
	 * @return el curso encontrado o <code>null</code>
	 */
	public Curso findById(long id) {
		return cursoRepository.findById(id).orElse(null);
	}
	
	/**
	 * Este método recoge un curso que tiene alumnos asignados,
	 * y realiza la asignación opuesta, seteando dicho curso a todos
	 * los alumnos de la lista
	 * @param c Curso que tiene alumnos en su lista de alumnos
	 * @return Devuelve el curso 
	 */
	public Curso asignaAlumnosAUnCurso(Curso c) {
		
		for(Alumno a : c.getAlumnos()) {
			a.setCurso(c);
			alumnoServicio.edit(a);
		}
		
		return c;
		
		
	}
	
	
	
}
