package com.salesianostriana.dam.ethmanytoone.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.ethmanytoone.modelo.Curso;
import com.salesianostriana.dam.ethmanytoone.servicios.CursoServicio;

@Controller
public class CursoController {

	private CursoServicio cursoServicio;
		
	public CursoController(CursoServicio servicio) {
		this.cursoServicio = servicio;
	}
	
	/**
	 * Método que gestiona la petición listado de todos los cursos
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
		//Redirigimos al controlador para que actualice la lista de cursos con el agregado
		return "redirect:/listcursos";
	}
	
	
	/**
	 * Método que atiende la petición de mostrar el formulario de edición de un curso
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
	
}
