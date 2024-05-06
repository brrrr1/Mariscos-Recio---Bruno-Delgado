package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	
	@GetMapping ("/main")
	public String controlador (Model model) {
		return "main";
	}
}
