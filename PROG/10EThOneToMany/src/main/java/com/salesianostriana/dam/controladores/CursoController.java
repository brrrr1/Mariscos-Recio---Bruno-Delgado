package com.salesianostriana.dam.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.modelo.Curso;
import com.salesianostriana.dam.servicios.AlumnoServicio;
import com.salesianostriana.dam.servicios.CursoServicio;

@Controller
public class CursoController {

	private CursoServicio cursoServicio;
	private AlumnoServicio alumnoServicio;
	
	
	public CursoController(CursoServicio servicio, AlumnoServicio alumnoServicio) {
		this.cursoServicio = servicio;
		this.alumnoServicio=alumnoServicio;
	}
	
	/**
	 * Método que gestiona la petición listado solo de cursos (sin alumnos)
	 * 
	 */
	@GetMapping({"/listcursos"})
	public String listarCursos(Model model) {
		model.addAttribute("cursos", cursoServicio.findAll());
		return "listacursos";
	}
	
	/**
	 * Método que atiende la petición de mostrar formulario para agregar un nuevo curso
	 */
	@GetMapping("/nuevocurso")
	public String mostrarFormulario(Model model) {

		model.addAttribute("curso", new Curso());
		return "formcursos";
	}
	
	/**
	 * Método que procesa la respuesta del formulario para agregar un nuevo curso
	 */
	@PostMapping("/nuevocurso/submit")
	public String procesarFormularioCurso(@ModelAttribute("curso") Curso c) {
		cursoServicio.add(c);
		return "redirect:/listcursos";
	}
	
	
	/**
	 * Método que atiende la petición de mostrar el formulario de edición de un alumno
	 * 
	 * @param id del alumno a editar
	 * @param model
	 * @return
	 */
	@GetMapping("/editarcurso/{id}")
	public String mostrarFormularioEdicionCurso(@PathVariable("id") long id, Model model) {
		
		Curso cEditar = cursoServicio.findById(id);
		
		if (cEditar != null) {
			model.addAttribute("curso", cEditar);
			return "formcursos";
		} else {
			// No existe ningún curso con el Id proporcionado.
			// Redirigimos hacia el listado de cursos.
			return "redirect:/listcursos";
		}
		
		
	}
	
	/**
	 * Método que procesa la respuesta del formulario al editar un curso
	 */
	@PostMapping("/editarcurso/submit")
	public String procesarFormularioEdicion(@ModelAttribute("curso") Curso c) {
		cursoServicio.edit(c);
		return "redirect:/listcursos";
	}
	
	/**
	 * Método que borra un curso por su Id
	 * @param id
	 * @return
	 */
	@GetMapping("/borrarcurso/{id}")
	public String borrar(@PathVariable("id") long id) {
		cursoServicio.delete(id);
		return "redirect:/listcursos";
	}
	
	/**
	 * Método que atiende la petición de mostrar formulario para agregar alumnos a un determinado curso
	 */
	@GetMapping("/configurarcurso/{id}")
	public String configurarCurso(@PathVariable("id") long id, Model model) {

		//Buscamos el curso por id, recogido al pinchar en el curso que vamos a configurar
		Curso cConfigurar = cursoServicio.findById(id);
		
		//Añadimos al modelo la lista de alumnos que debemos pintar para poder
		//asignar estos en el curso que estamos onfigurando
		if (cConfigurar!=null) {
			model.addAttribute("lista", alumnoServicio.findAll());
			model.addAttribute("curso", cConfigurar);
			return "gestioncursos";
		} else {
			//No existe ningún curso con ese id proporcionado y redigirimos hacia el istado de cursos
			return "redirect:/listcursos";
		}

	}
	/**
	 * Método que procesa la petición de respuesta del formulario al configurar 
	 * un curso añadiendo alumnos al mismo. Aquí usamos el helper que asigna un alumno el id del curso asociado
	 * Ojo, en este ejemplo, no se "borran" alumnos de un curso al desmarcar el check configurando el curso y usando el 
	 * helper removeAlumno, solo se "borran" de un curso cuando se asignan a otro curso, eso es, cuando en la tabla de un alumno,
	 * se guarda el id de otro curso en dicho alumno (se "cambia" de curso).
	 * Ese apartado se deja para vosotros.
	 */
	@PostMapping("/configurarcurso/submit")
	public String procesarFormularioEdicionCurso(@ModelAttribute("curso") Curso c) {
		
		cursoServicio.asignaAlumnosAUnCurso(c);
		
		return "redirect:/listcursos";
	}
	
	/**
	 * Método que gestiona la petición listado de alumnos
	 * 
	 */
	@GetMapping({"/listacursosconalumnos/{id}"})
	public String listarCursosCompletos(@PathVariable("id") long id, Model model) {

		Curso cConAlumnos = cursoServicio.findById(id);
		if (cConAlumnos!=null) {
			
			model.addAttribute("curso", cConAlumnos);
			return "listacursoscompletos";
		} else {
			//No existe ningún curso con ese id proporcionado y redigirimos hacia el istado de cursos
			return "redirect:/listcursos";
		}
		
	}
	
}


