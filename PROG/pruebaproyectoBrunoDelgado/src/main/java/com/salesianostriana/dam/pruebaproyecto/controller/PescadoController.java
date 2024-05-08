package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.pruebaproyecto.model.Pescado;
import com.salesianostriana.dam.pruebaproyecto.service.PescadoService;

@Controller
@RequestMapping("/admin/pescado")
public class PescadoController {

	@Autowired
	private PescadoService servicioPescado;

	@GetMapping("/pescado")
	public String controladorPescado(Model model) {
		model.addAttribute("listaPescado", servicioPescado.findAll());

		return "pescado";
	}

	@GetMapping("/listaPescado")
	public String listarTodos(Model model) {
		model.addAttribute("listaPescado", servicioPescado.findAll());
		return "admin/pescadoIndex";
	}

	@GetMapping("/pescadoForm")
	public String showFrom(Model model) {
		Pescado pescado = new Pescado();
		model.addAttribute("pescado", pescado);
		return "admin/pescadoForm";
	}

	@PostMapping("/addPescado")
	public String submit(@ModelAttribute("pescadoForm") Pescado pescado, Model model) {
		servicioPescado.save(pescado);
		model.addAttribute("pescado", pescado);

		return "redirect:/admin/pescado/listaPescado";
	}

	@GetMapping("/editarPescado/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		if (servicioPescado.findById(id).isPresent()) {
			model.addAttribute("pescado", servicioPescado.findById(id).get());
			return "admin/pescadoForm";
		} else {

			return "redirect:/admin/pescado/listaPescado";
		}

	}

	@PostMapping("/editarPescado/submit")
	public String procesarFormularioEdicion(@ModelAttribute("pescado") Pescado p) {
		servicioPescado.edit(p);
		return "redirect:/admin/pescado/listaPescado";
	}

	@GetMapping("/borrarPescado/{id}")
	public String borrar(@PathVariable("id") long id) {
		servicioPescado.deleteById(id);
		return "redirect:/admin/pescado/listaPescado";
	}
}
