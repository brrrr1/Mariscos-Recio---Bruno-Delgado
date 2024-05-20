package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.pruebaproyecto.model.Marisco;
import com.salesianostriana.dam.pruebaproyecto.service.LineaDePedidoService;
import com.salesianostriana.dam.pruebaproyecto.service.MariscoService;
import com.salesianostriana.dam.pruebaproyecto.service.ProdPesoService;

@Controller
@RequestMapping("/admin/marisco")
public class MariscoController {

	@Autowired
	private MariscoService servicioMarisco;
	
	@Autowired
	private ProdPesoService servicioProdPeso;
	
	@Autowired
	private LineaDePedidoService servicioLdp;

	@GetMapping("/marisco")
	public String controladorMarisco(Model model) {
		model.addAttribute("listaMarisco", servicioMarisco.findAll());

		return "marisco";
	}

	@GetMapping("/listaMarisco")
	public String listarTodos(Model model) {
		model.addAttribute("listaMarisco", servicioMarisco.findAll());
		return "admin/mariscoIndex";
	}

	@GetMapping("/mariscoForm")
	public String showFrom(Model model) {
		Marisco marisco = new Marisco();
		model.addAttribute("marisco", marisco);
		return "admin/mariscoForm";
	}

	@PostMapping("/addMarisco")
	public String submit(@ModelAttribute("mariscoForm") Marisco marisco, Model model) {
		servicioMarisco.save(marisco);
		model.addAttribute("marisco", marisco);

		return "redirect:/admin/marisco/listaMarisco";
	}

	@GetMapping("/editarMarisco/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		if (servicioMarisco.findById(id).isPresent()) {
			model.addAttribute("marisco", servicioMarisco.findById(id).get());
			return "admin/mariscoForm";
		} else {

			return "redirect:/admin/marisco/listaMarisco";
		}

	}

	@PostMapping("/editarMarisco/submit")
	public String procesarFormularioEdicion(@ModelAttribute("marisco") Marisco m) {
		servicioMarisco.edit(m);
		return "redirect:/admin/marisco/listaMarisco";
	}
	
	@GetMapping("/borrarMarisco/{id}")
	public String borrar(@PathVariable("id") long id) {
		
		if(servicioLdp.buscarProductoEnLp(id).isPresent()) {
			return "noBorrar";
		}
		
		servicioProdPeso.deleteByIdConFavoritos(id);
		return "redirect:/admin/marisco/listaMarisco";
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
	
	@GetMapping("/buscarMariscoIndex")
	public String buscarMariscoPorNombre(Model model, @RequestParam("busqueda") String busqueda) {
	    model.addAttribute("listaMarisco", servicioProdPeso.buscarPorNombre(busqueda));
	    return "admin/mariscoIndex";
	}

}
