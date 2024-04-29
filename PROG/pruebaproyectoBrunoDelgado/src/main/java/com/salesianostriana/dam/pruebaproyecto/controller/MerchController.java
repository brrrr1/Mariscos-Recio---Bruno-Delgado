package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pruebaproyecto.model.Merch;
import com.salesianostriana.dam.pruebaproyecto.service.MerchService;



@Controller
public class MerchController {
	
	@Autowired
	private MerchService servicio;
	
	/*@GetMapping ("/merch")
	public String controlador (Model model) {
		model.addAttribute("listaProductos", servicio.getLista());
		return "merch";
	}*/
	
	@GetMapping ("/merch")
	public String controlador (Model model) {
		model.addAttribute("listaProductos", servicio.findAll());
		return "merch";
	}
	
	@GetMapping("/mform")
	public String showFrom(Model model) {
		Merch merch = new Merch();
		model.addAttribute("merchForm", merch);
		return "merchForm";
	}
	
	
	@PostMapping("/addMerch")
	public String submit(@ModelAttribute("merchForm") Merch merch, Model model) {
		model.addAttribute("merch", merch);
		
		servicio.agregarBD(merch);
		
		return "merchView";
	}

}
