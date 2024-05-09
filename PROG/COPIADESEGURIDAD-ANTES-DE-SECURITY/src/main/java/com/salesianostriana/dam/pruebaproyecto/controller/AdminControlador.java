package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminControlador {

	@GetMapping("/home")
	public String home() {
		return "admin/adminIndex";
	}

}
