package com.salesianostriana.dam.seguridadenmemoria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

	@GetMapping("/")
	public String index() {
		return "admin";
	}

}
