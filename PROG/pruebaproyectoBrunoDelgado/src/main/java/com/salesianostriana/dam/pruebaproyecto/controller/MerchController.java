package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.pruebaproyecto.model.Merch;
import com.salesianostriana.dam.pruebaproyecto.service.MerchService;

@Controller
@RequestMapping("/admin/merch")
public class MerchController {

	@Autowired
	private MerchService servicio;

	@GetMapping("/merch")
	public String controladorMerch(Model model) {
		model.addAttribute("listaMerch", servicio.findAll());
		return "merch";
	}

	@GetMapping("/listaMerch")
	public String listarTodos(Model model) {
		model.addAttribute("listaMerch", servicio.findAll());
		return "admin/merchIndex";
	}

	@GetMapping("/mform")
	public String showFrom(Model model) {
		Merch merch = new Merch();
		model.addAttribute("merch", merch);
		return "admin/merchForm";
	}

	@PostMapping("/addMerch")
	public String submit(@ModelAttribute("merchForm") Merch merch, Model model) {
		servicio.save(merch);
		model.addAttribute("merch", merch);

		return "redirect:/admin/merch/listaMerch";
	}

	@GetMapping("/editarMerch/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		if (servicio.findById(id).isPresent()) {
			model.addAttribute("merch", servicio.findById(id).get());
			return "admin/merchForm";
		} else {

			return "redirect:/admin/merch/listaMerch";
		}

	}

	@PostMapping("/editarMerch/submit")
	public String procesarFormularioEdicion(@ModelAttribute("merch") Merch m) {
		servicio.edit(m);
		return "redirect:/admin/merch/listaMerch";
	}

	@GetMapping("/borrarMerch/{id}")
	public String borrar(@PathVariable("id") long id) {
		servicio.deleteById(id);
		return "redirect:/admin/merch/listaMerch";
	}

	@GetMapping("/productoMerch/{id}")
	public String mostrarPaginaProducto(@PathVariable("id") long id, Model model) {
		if (servicio.findById(id).isPresent()) {
			model.addAttribute("merch", servicio.findById(id).get());
			return "compraMerch";
		} else {

			return "redirect:/admin/merch/listaMerch";
		}

	}

}
