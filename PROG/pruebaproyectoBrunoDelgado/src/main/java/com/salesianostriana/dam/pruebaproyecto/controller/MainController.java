package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.pruebaproyecto.service.LoteService;
import com.salesianostriana.dam.pruebaproyecto.service.MariscoService;
import com.salesianostriana.dam.pruebaproyecto.service.MerchService;
import com.salesianostriana.dam.pruebaproyecto.service.PescadoService;

@Controller

public class MainController {
	@Autowired
	private LoteService servicioLote;

	@Autowired
	private MerchService servicioMerch;

	@Autowired
	private MariscoService servicioMarisco;

	@Autowired
	private PescadoService servicioPescado;

	@GetMapping("/main")
	public String controlador(Model model) {
		return "main";
	}

	@GetMapping("/lotes")
	public String controladorLotes(Model model) {
		model.addAttribute("listaLotes", servicioLote.findAll());
		return "lotes";
	}

	@GetMapping("/merch")
	public String controladorMerch(Model model) {
		model.addAttribute("listaMerch", servicioMerch.findAll());
		return "merch";
	}

	@GetMapping("/marisco")
	public String controladorMarisco(Model model) {
		model.addAttribute("listaMarisco", servicioMarisco.findAll());

		return "marisco";
	}

	@GetMapping("/pescado")
	public String controladorPescado(Model model) {
		model.addAttribute("listaPescado", servicioPescado.findAll());

		return "pescado";
	}

	@GetMapping("/productoMerch/{id}")
	public String mostrarPaginaProductoMerch(@PathVariable("id") long id, Model model) {
		if (servicioMerch.findById(id).isPresent()) {
			model.addAttribute("merch", servicioMerch.findById(id).get());
			return "compraMerch";
		} else {

			return "redirect:/admin/merch/listaMerch";
		}

	}

	@GetMapping("/productoLote/{id}")
	public String mostrarPaginaProductoLote(@PathVariable("id") long id, Model model) {
		if (servicioLote.findById(id).isPresent()) {
			model.addAttribute("lote", servicioLote.findById(id).get());
			return "compraLote";
		} else {

			return "redirect:/admin/lotes/listaLotes";
		}

	}

	@GetMapping("/productoPescado/{id}")
	public String mostrarPaginaProductoPescado(@PathVariable("id") long id, Model model) {
		if (servicioPescado.findById(id).isPresent()) {
			model.addAttribute("pescado", servicioPescado.findById(id).get());
			return "compraPescado";
		} else {

			return "redirect:/admin/pescado/listaPescado";
		}

	}

	@GetMapping("/productoMarisco/{id}")
	public String mostrarPaginaProductoMarisco(@PathVariable("id") long id, Model model) {
		if (servicioMarisco.findById(id).isPresent()) {
			model.addAttribute("marisco", servicioMarisco.findById(id).get());
			return "compraMarisco";
		} else {

			return "redirect:/admin/marisco/listaMarisco";
		}

	}
}
