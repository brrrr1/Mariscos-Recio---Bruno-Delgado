package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping("/login")
	public String index() {
		return "login";
	}

}
