package com.salesianostriana.dam.ud8e07fechassinbd.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.ud8e07fechassinbd.model.Alumno;
import com.salesianostriana.dam.ud8e07fechassinbd.servicio.AlumnoServicio;

@Controller
public class AlumnoController {

	/*
	 * Como habéis visto con Luismi, hay 3 formas de inyectar un objeto:
	 * - Con @Autowired
	 * - Haciendo el atributo private y con el constructor
	 * - Con Setters (no la usaremos)
	 * Aquí vemos la segunda para que tengais al menos un ejemplo con esta
	 * ya que los anteriores han sido con @Autowired
	 * */
	private AlumnoServicio alumnoServicio;

	public AlumnoController(AlumnoServicio servicio) {
		alumnoServicio = servicio;
	}

	// Controller para mostrar la página list con la lista de alumnos
	// Inicialmente no muestra ninguno
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("alumnos", alumnoServicio.getLista());
		return "list";
	}

	// En el html list, podemos ver el th:href que nos lleva hasta este controller
	// que muestra primero con este método el formulario vacío que se gestionará
	// en el último método, procesaFormulario
	@GetMapping("/nuevo")
	public String muestraFormulario(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "form";
	}

	/*
	 * Debemos ir acostumbrándonos a que, como vamos a tener muchos
	 * controller, estos irán teniendo rutas complicadas en los Mapping
	 * por eso, iremos agregando rutas más complejas, por ejemplo, 
	 * en este caso, como en ambos casos es para agregar un nuevo alumno
	 * ponemos en la ruta /nuevo
	 * Veremos formas de ahorrar esta escritura de rutas cuando se hagan muy largas
	 * 
	 * Redirect: Significa que al acabar el proceso del controller, no lleva a una
	 * página html sino que nos lleva a otro controller, en este caso, de nuevo al
	 * controller que pinta la lista de alumnos, el método controller que tiene en
	 * el GetMapping la barra. Esto se hace así para "actualizar" la lista con el
	 * nuevo alumno insertado después de procesar el formulario
	 */
	@PostMapping("/nuevo/submit")
	public String procesaFormulario(@ModelAttribute("alumno") Alumno alumno) {
		/*
		 * Como fecha de último acceso no es un campo del formulario, estamos creándola
		 * aquí para poder tenerla en el alumno en este ejemplo
		 */
		alumno.setFechaUltimoAcceso(LocalDateTime.now());
		alumnoServicio.agregar(alumno);;

		return "redirect:/";
	}

}
