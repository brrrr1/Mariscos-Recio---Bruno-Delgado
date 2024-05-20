package com.salesianostriana.dam.pruebaproyecto.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.pruebaproyecto.model.LineaDePedido;
import com.salesianostriana.dam.pruebaproyecto.model.Pedido;
import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.model.ProductoPorUnidad;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.repositorios.LineaDePedidoRepositorio;
import com.salesianostriana.dam.pruebaproyecto.service.LineaDePedidoService;
import com.salesianostriana.dam.pruebaproyecto.service.PedidoService;
import com.salesianostriana.dam.pruebaproyecto.service.ProductoService;

@Controller
public class CarritoControlador {

	@Autowired
	private LineaDePedidoService ldpService;

	@Autowired
	private PedidoService pedidoServicio;

	@Autowired
	private ProductoService productoServicio;

	@GetMapping("/anadirALP/{id}")
	public String anadirALP(@PathVariable("id") Long id, Model model) {
		
		Producto producto = productoServicio.findById(id).get();
		ldpService.anadirOActualizarLineaDePedido(producto);
		model.addAttribute("lineaDePedido", ldpService.findAll());
		return "carrito";
	}

	@GetMapping("/borrarDeLp/{id}")
	public String borrarDeLp(@PathVariable("id") Long id, Model model) {
		ldpService.borrarProductoDeLp(id);

		return "redirect:/carrito";
	}

	@GetMapping("/carrito")
	public String anadirALP(Model model) {
		model.addAttribute("lineaDePedido", ldpService.findAll());
		return "carrito";
	}

	@GetMapping("/limpiarCarrito")
	public String limpiar(Model model) {

		Pedido pedido = new Pedido();
		pedidoServicio.limpiarCarrito(pedido);
		return "carrito";
	}

	@GetMapping("/finalizarPedido")
	public String finalizarPedido(Model model, @AuthenticationPrincipal Usuario usuario) {

		Pedido pedido = new Pedido();
		
		ldpService.finalizarPedido(usuario, pedido);
		
		pedidoServicio.save(pedido);
		model.addAttribute("pedido", pedido);

		return "pedidoFinalizado";
	}

	@GetMapping("/reducirCantidad/{id}")
	public String reducirCantidad(@PathVariable("id") Long id, Model model) {
		Producto producto = productoServicio.findById(id).get();
		ldpService.reducirCantidadOEliminarLineaDePedido(producto);
		model.addAttribute("lineaDePedido", ldpService.findAll());
		return "carrito";
	}

}
