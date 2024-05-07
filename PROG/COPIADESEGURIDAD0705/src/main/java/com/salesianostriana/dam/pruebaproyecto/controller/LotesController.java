package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.pruebaproyecto.model.Lote;
import com.salesianostriana.dam.pruebaproyecto.service.LoteService;

@Controller
@RequestMapping("/admin/lotes")
public class LotesController {
	@Autowired
	private LoteService servicioLote;

	@GetMapping("/listaLotes")
	public String listarTodos(Model model) {
		model.addAttribute("listaLotes", servicioLote.findAll());
		return "admin/lotesIndex";
	}

	@GetMapping("/lform")
	public String showFrom(Model model) {
		Lote lote = new Lote();
		model.addAttribute("lote", lote);
		return "admin/lotesForm";
	}

	@PostMapping("/addLote")
	public String submit(@ModelAttribute("lotesForm") Lote lote, Model model) {
		servicioLote.save(lote);
		model.addAttribute("lote", lote);
		return "redirect:/admin/lotes/listaLotes";
	}

	@GetMapping("/editarLote/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {

		if (servicioLote.findById(id).isPresent()) {
			model.addAttribute("lote", servicioLote.findById(id).get());
			return "admin/lotesForm";
		} else {

			return "redirect:/admin/lotes/listaLotes";
		}

	}

	@PostMapping("/editarLote/submit")
	public String procesarFormularioEdicion(@ModelAttribute("merch") Lote l) {
		servicioLote.edit(l);
		return "redirect:/admin/lotes/listaLotes";

	}

	@GetMapping("/borrarLote/{id}")
	public String borrar(@PathVariable("id") long id) {
		servicioLote.deleteById(id);
		return "redirect:/admin/lotes/listaLotes";
	}
}
