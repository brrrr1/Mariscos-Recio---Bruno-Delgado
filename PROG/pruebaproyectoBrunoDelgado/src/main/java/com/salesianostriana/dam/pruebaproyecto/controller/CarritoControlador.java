package com.salesianostriana.dam.pruebaproyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.service.CarritoService;
import com.salesianostriana.dam.pruebaproyecto.service.ProductoService;

@Controller
public class CarritoControlador {

	@Autowired
	CarritoService carritoServicio;

	@Autowired
	ProductoService productoServicio;

	@GetMapping("/carrito")
	public String showCarrito(@AuthenticationPrincipal Usuario usuario, Model model) {
		if (carritoServicio.hayCarritoCreado(usuario)) {

		}
	}

	@GetMapping("/productoACarrito/{id}")
	public String showCarrito(@AuthenticationPrincipal Usuario usuario, @PathVariable("id") Long id, Model model) {
		
		Optional<Producto> producto = productoServicio.findById(id);
		
		if(producto.isPresent()) {
			carritoServicio.addProducto(usuario, producto.get(), 1);
			return "redirect:/carrito;
		}else {
			
		}

	}

	@GetMapping("carrito/modificar/{id}/cantidad/{cant}")
	public String modificarCarrito(@AuthenticationPrincipal Usuario usuario, @PathVariable("id") Long id,
			@PathVariable("cant") int cantidad, Model model) {

		Optional<Producto> producto = productoServicio.findById(id);

		if (producto.isPresent()) {
			carritoServicio.modificarCantidad(usuario, producto.get(), cantidad);
		}

		return "redirect:/carrito";
	}

}
