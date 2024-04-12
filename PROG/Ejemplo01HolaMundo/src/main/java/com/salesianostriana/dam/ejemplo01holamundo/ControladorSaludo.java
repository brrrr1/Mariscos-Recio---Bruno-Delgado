package com.salesianostriana.dam.ejemplo01holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorSaludo {

	@GetMapping({ "/", "welcome" })
	public String welcome(@RequestParam(name = "nombre", required = false, defaultValue = "Mundo") String nombre,
			Model model) {
		model.addAttribute("nombre", nombre);
		return "index";
	}

	@GetMapping("/saludo2")
	public String welcome2(Model model) {
		model.addAttribute("persona", new Persona("Cristiano", "Ronaldo Dos Santos Aveiro"));
		return "saludoPersonalizado";
	}

	@GetMapping ("/saludo3")
	public String welcome3(Model model) {
	model.addAttribute("saludo", "Hola Mundo");
	model.addAttribute("mensaje", "¡Se me está haciendo largo el proyecto final!");
	model.addAttribute("url", "https://triana.salesianos.edu");
	return "SaludoYEnlace";
	}
}
