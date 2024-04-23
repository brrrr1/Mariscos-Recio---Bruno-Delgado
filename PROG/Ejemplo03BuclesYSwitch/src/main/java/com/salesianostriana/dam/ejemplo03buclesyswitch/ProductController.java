package com.salesianostriana.dam.ejemplo03buclesyswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/productos")
	public String controladorCondicionales (Model model) {
		//Añadimos al model la lista de productos que viene del servicio.
		//productList es el nombre de la variable en HTML, y aquí corresponde a service.getLista()
		model.addAttribute("productList", service.getLista());
		return "PlantillaBucleYFormateo";
	}
}
