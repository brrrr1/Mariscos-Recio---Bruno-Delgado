package com.salesianostriana.dam.pruebaproyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MerchController {
	
	@Autowired
	private MerchService servicio;
	
	@GetMapping ("/merch")
	public String controlador (Model model) {
		model.addAttribute("listaProductos", servicio.getLista());
		return "merch";
	}

}
