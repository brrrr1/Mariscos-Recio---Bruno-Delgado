package com.salesianostriana.dam.ud8e03buclesyswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Anotamos con controller
@Controller
public class ProductController {
	
	/*
	 * Necesitamos un objeto del tipo ProductService dentro de esta clase para poder
	 * llamar dentro de los métodos a los métodos del servicio, por lo que
	 * inyectamos aquí un objeto de dicho tipo
	 * */
	@Autowired
	private ProductService service;
	
	/*Anotamos con el tipo de petición que atenderá este método, tipo get ("sin datos-parámetros"), 
	cuando se escriba en el navegador la ruta, esta debe ser http://localhost:9000/productos
	*/
	@GetMapping ("/productos")
	public String controladorCondicionales (Model model){

		/*
		 * Añadimos al model la lista de productos que viene del servicio, devuelta por el método
		 * getLista
		 * */
		model.addAttribute("productList", service.getLista());
		return "PlantillaBucleYFormateo";//Se devuelve el nombre de la plantilla html sin la extensión
	}
}