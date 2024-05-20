package com.salesianostriana.dam.brunodelgadoherreroproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Lote;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.service.LineaDePedidoService;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.service.LoteService;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.service.ProdUnidadService;

@Controller
@RequestMapping("/admin/lotes")
public class LotesController {
	@Autowired
	private LoteService servicioLote;
	
	@Autowired
	private ProdUnidadService servicioProdUnidad;
	
	@Autowired
	private LineaDePedidoService servicioLdp;
	
	@GetMapping("/lotes")
	public String controladorLotes(Model model) {
		model.addAttribute("listaLotes", servicioLote.findAll());
		return "lotes";
	}

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
		if(servicioLdp.buscarProductoEnLp(id).isPresent()) {
			return "noBorrar";
		}
		
		
		
		
		servicioLdp.deleteById(id);
		


		servicioProdUnidad.deleteByIdConFavoritos(id);
		return "redirect:/admin/lotes/listaLotes";
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
	

	
	@GetMapping("/buscarLotesIndex")
	public String buscarLotePorNombre(Model model, @RequestParam("busqueda") String busqueda) {
	    model.addAttribute("listaLotes", servicioProdUnidad.buscarPorNombre(busqueda));
	    return "admin/lotesIndex";
	}
}