package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pruebaproyecto.model.Merch;
import com.salesianostriana.dam.pruebaproyecto.service.MerchService;

@Controller
public class MerchController {

	@Autowired
	private MerchService servicio;

	/*
	 * @GetMapping ("/merch") public String controlador (Model model) {
	 * model.addAttribute("listaProductos", servicio.getLista()); return "merch"; }
	 */

	@GetMapping("/merch")
	public String controlador(Model model) {
		model.addAttribute("listaMerch", servicio.findAll());
		return "merch";
	}

	@GetMapping({ "/", "/list" })
	public String listarTodos(Model model) {
		model.addAttribute("listaMerch", servicio.findAll());
		return "merchIndex";
	}

	@GetMapping("/mform")
	public String showFrom(Model model) {
		Merch merch = new Merch();
		model.addAttribute("merch", merch);
		return "merchForm";
	}

	@PostMapping("/addMerch")
	public String submit(@ModelAttribute("merchForm") Merch merch, Model model) {
		servicio.save(merch);
		model.addAttribute("merch", merch);

		return "redirect:/";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {

		// Buscamos al alumno por id y recordemos que el método findById del servicio,
		// devuelve el objeto buscado o null si no se encuentra.

		if (servicio.findById(id).isPresent()) {
			model.addAttribute("merch", servicio.findById(id).get());
			return "merchForm";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/";
		}

	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("merch") Merch m) {
		servicio.edit(m);
		return "redirect:/";// Volvemos a redirigir la listado a través del controller
		// para pintar la lista actualizada con la modificación hecha
	}

	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		servicio.deleteById(id);
		return "redirect:/";
	}

}
