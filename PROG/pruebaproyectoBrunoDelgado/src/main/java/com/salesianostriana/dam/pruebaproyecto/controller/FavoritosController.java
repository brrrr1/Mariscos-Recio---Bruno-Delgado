package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.service.FavoritosService;



@Controller
@RequestMapping("/admin/favoritos")
public class FavoritosController {

	@Autowired
	private FavoritosService servicioFavoritos;

	
	@GetMapping("/borrar")
	public String borrarFavorito(Model model, Producto p) {
		//model.addAttribute("listaProductos", servicioFavoritos.buscarFavoritosPorProducto(p));
		servicioFavoritos.deleteAll(servicioFavoritos.buscarFavoritosPorProducto(p));
		return "redirect:/admin/merch/listaMerch";
	}
}
