package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.salesianostriana.dam.pruebaproyecto.service.FavoritosService;

@Controller
public class FavoritosController {

	@Autowired
	private FavoritosService servicioFavoritos;
	/*
	 * @PostMapping("/addFavorito") public String
	 * aniadirAFavoritos(@ModelAttribute("favorito") Favoritos favorito, Model
	 * model) { favorito.addToUsuario(null) return
	 * "redirect:/admin/empleados/listaEmpleados"; }
	 * 
	 */
}
