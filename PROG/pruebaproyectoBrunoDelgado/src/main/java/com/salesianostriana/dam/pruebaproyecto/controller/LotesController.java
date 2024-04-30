package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pruebaproyecto.model.Lote;
import com.salesianostriana.dam.pruebaproyecto.service.LoteService;

@Controller
public class LotesController {
	@Autowired
	private LoteService servicioLote;

	/*
	 * @GetMapping ("/merch") public String controlador (Model model) {
	 * model.addAttribute("listaProductos", servicio.getLista()); return "merch"; }
	 */

	@GetMapping("/lotes")
	public String controlador(Model model) {
		model.addAttribute("listaLotes", servicioLote.findAll());
		return "lotes";
	}

	@GetMapping("/lform")
	public String showFrom(Model model) {
		Lote lote = new Lote();
		model.addAttribute("lotesForm", lote);
		return "lotesForm";
	}

	@PostMapping("/addLote")
	public String submit(@ModelAttribute("lotesForm") Lote lote, Model model) {
		model.addAttribute("lote", lote);

		servicioLote.save(lote);

		return "lotesView";
	}
}
