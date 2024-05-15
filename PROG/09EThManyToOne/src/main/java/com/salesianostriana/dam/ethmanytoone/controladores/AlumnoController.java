package com.salesianostriana.dam.ethmanytoone.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.ethmanytoone.modelo.Alumno;
import com.salesianostriana.dam.ethmanytoone.modelo.Curso;
import com.salesianostriana.dam.ethmanytoone.servicios.AlumnoServicio;
import com.salesianostriana.dam.ethmanytoone.servicios.CursoServicio;

@Controller
public class AlumnoController {
	
	//Inyectamos los servicios
	private AlumnoServicio alumnoServicio;
	private CursoServicio cursoServicio;
	
	
	public AlumnoController(AlumnoServicio servicio, CursoServicio cursoServicio) {
		this.alumnoServicio = servicio;
		this.cursoServicio=cursoServicio;
	}
	
	/**
	 * Método que atiende a las peticiones "índice (barra inicial)" o listado completo de alumnos
	 * Los controladores pueden atender a dos peticiones con ruta distinta, pero 
	 * no puede haber con controladores que atiendan a la misma ruta
	 */
	@GetMapping({"/", "/list"})
	public String listarTodos( Model model) {
		model.addAttribute("lista", alumnoServicio.findAll());

		return "index";
	}
	
	/**
	 * Método que atiende la petición get de mostrar formulario para agregar un nuevo alumno
	 * Agreamos todos los cursos al modelo porque en el formulario
	 * necesitamos "mostrar" para luego elegir los cursos que hay y asignarle 
	 * al nuevo alumno uno de los cursos
	 * Agregamos también un nuevo alumno vacío ya que es el formulario de alta
	 */
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("cursos", cursoServicio.findAll());
		model.addAttribute("alumno", new Alumno());
		
		return "formulario";
	}
	
	/**
	 * Método que procesa la petición post del formulario para agregar un nuevo alumno
	 * Añadimos el objeto alumno que estará disponible para todos los métodos dentro del controlador
	 */
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("alumno") Alumno a, Model model) {
		alumnoServicio.add(a);//Guardamos el alumno en la bd
		/*No haría falta agregar los cursos en este caso, se podría
		 * quitar el model ya que al pintar el formulario (getMapping) si 
		 * necesitamos la lista de cursos para pintarlo en el select pero
		 * al gestionarlo (mandar el alumno) ya lleva la selección de un solo curso
		 * (el elegido en el select) y es uno de sus atributos
		 * Pasa lo mismo en editar y por eso se ha quitado, para que se vea que
		 * se puede hacer sin Model model
		 * */ 
		model.addAttribute("cursos", cursoServicio.findAll());
		//Redirigimos al controlador de inicio para que muestre todos los alumnos de forma
		//actualizada, con el recién incorporado
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
	
		//Buscamos el alumno por id (el recogido al pinchar en el enlace editar del alumno
		//concreto que queremos editar
		Alumno aEditar = alumnoServicio.findById(id);
		//Añadimos al modelo la lista de todos los cursos
		model.addAttribute("cursos", cursoServicio.findAll());
		//Si el alumno buscado no es nulo lo pasamos al modelo y mostramos el fomrulario
		//con los campos relleno (estamos editando)
		if (aEditar != null) {
			model.addAttribute("alumno", aEditar);
			return "formulario";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado de todos los alumnos
			return "redirect:/";
		}
		
		
	}
	
	/**
	 * Método que procesa la respuesta del formulario al editar, post de editar
	 * Pasamos el alumno en el @ModelAttribute y lo editamos
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
