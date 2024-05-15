package com.salesianostriana.dam.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.modelo.Alumno;
import com.salesianostriana.dam.servicios.AlumnoServicio;
import com.salesianostriana.dam.servicios.CursoServicio;

/**
 * @author Luismi y Ángel
 *
 */
@Controller
public class AlumnoController {
	
	private AlumnoServicio alumnoServicio;
	private CursoServicio cursoServicio;
	
	
	public AlumnoController(AlumnoServicio alumnoServicio, CursoServicio cursoServicio) {
		this.alumnoServicio = alumnoServicio;
		this.cursoServicio=cursoServicio;
	}
	
	/**
	 * Método que gestiona la petición "índice" o listado de alumnos
	 * 
	 */
	@GetMapping({"/", "/list"})
	public String listarTodos(Model model) {
		model.addAttribute("lista", alumnoServicio.findAll());
		return "index";
	}
	
	/**
	 * Método que atiende la petición de mostrar formulario para agregar un nuevo alumno
	 */
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		
		model.addAttribute("cursos", cursoServicio.findAll());
		model.addAttribute("alumno", new Alumno());
		
		return "formulario";
	}
	
	/**
	 * Método que procesa la respuesta del formulario para agregar un nuevo alumno
	 */
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("alumno") Alumno a, Model model) {
		alumnoServicio.add(a);
		model.addAttribute("cursos", cursoServicio.findAll());
		return "redirect:/";
	}
	
	
	/**
	 * Método que atiende la petición de mostrar el formulario de edición de un alumno
	 * 
	 * @param id del alumno a editar
	 * @param model
	 * @return
	 */
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		Alumno aEditar = alumnoServicio.findById(id);
		model.addAttribute("cursos", cursoServicio.findAll());
		if (aEditar != null) {
			model.addAttribute("alumno", aEditar);
			return "formulario";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia la página inicial que muestra el listado.
			return "redirect:/";
		}
		
		
	}
	
	/**
	 * Método que procesa la respuesta del formulario al editar
	 */
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("alumno") Alumno a) {
		alumnoServicio.edit(a);
		return "redirect:/";
	}
	
	/**
	 * Método que borra un alumno por su Id
	 * @param id
	 * @return
	 */
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		alumnoServicio.delete(id);
		return "redirect:/";
	}

}
