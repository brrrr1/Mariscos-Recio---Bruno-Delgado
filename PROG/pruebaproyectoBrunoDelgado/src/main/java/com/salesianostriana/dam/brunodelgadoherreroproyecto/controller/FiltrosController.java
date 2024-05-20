package com.salesianostriana.dam.brunodelgadoherreroproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.service.LoteService;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.service.MariscoService;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.service.MerchService;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.service.PescadoService;

@Controller
public class FiltrosController {

	@Autowired
	private LoteService servicioLote;

	@Autowired
	private MerchService servicioMerch;

	@Autowired
	private MariscoService servicioMarisco;

	@Autowired
	private PescadoService servicioPescado;

	// MERCH

	@GetMapping("/merchOrdenAZ")
	public String controladorMerchOrdenAZ(Model model) {
		model.addAttribute("listaMerch", servicioMerch.ordenarAlfabeticoAZ());
		return "merch";
	}

	@GetMapping("/merchOrdenZA")
	public String controladorMerchOrdenZA(Model model) {
		model.addAttribute("listaMerch", servicioMerch.ordenarAlfabeticoZA());
		return "merch";
	}

	@GetMapping("/merchOrdenLikesMayor")
	public String controladorMerchOrdenLikesMayor(Model model) {
		model.addAttribute("listaMerch", servicioMerch.ordenarLikesMayor());
		return "merch";
	}

	@GetMapping("/merchOrdenLikesMenor")
	public String controladorMerchOrdenLikesMenor(Model model) {
		model.addAttribute("listaMerch", servicioMerch.ordenarLikesMenor());
		return "merch";
	}

	@GetMapping("/merchOrdenDescMayor")
	public String controladorMerchOrdenDescMayor(Model model) {
		model.addAttribute("listaMerch", servicioMerch.ordenarDescMayor());
		return "merch";
	}

	@GetMapping("/merchOrdenDescMenor")
	public String controladorMerchOrdenDescMenor(Model model) {
		model.addAttribute("listaMerch", servicioMerch.ordenarDescMenor());
		return "merch";
	}

	@GetMapping("/merchOrdenPrecioMayor")
	public String controladorMerchOrdenPrecioMayor(Model model) {
		model.addAttribute("listaMerch", servicioMerch.ordenarPrecioMayor());
		return "merch";
	}

	@GetMapping("/merchOrdenPrecioMenor")
	public String controladorMerchOrdenPrecioMenor(Model model) {
		model.addAttribute("listaMerch", servicioMerch.ordenarPrecioMenor());
		return "merch";
	}

	// LOTE

	@GetMapping("/loteOrdenAZ")
	public String controladorLoteOrdenAZ(Model model) {
		model.addAttribute("listaLotes", servicioLote.ordenarAlfabeticoAZ());
		return "lotes";
	}

	@GetMapping("/loteOrdenZA")
	public String controladorLoteOrdenZA(Model model) {
		model.addAttribute("listaLotes", servicioLote.ordenarAlfabeticoZA());
		return "lotes";
	}

	@GetMapping("/loteOrdenLikesMayor")
	public String controladorLoteOrdenLikesMayor(Model model) {
		model.addAttribute("listaLotes", servicioLote.ordenarLikesMayor());
		return "lotes";
	}

	@GetMapping("/loteOrdenLikesMenor")
	public String controladorLoteOrdenLikesMenor(Model model) {
		model.addAttribute("listaLotes", servicioLote.ordenarLikesMenor());
		return "lotes";
	}

	@GetMapping("/loteOrdenDescMayor")
	public String controladorLoteOrdenDescMayor(Model model) {
		model.addAttribute("listaLotes", servicioLote.ordenarDescMayor());
		return "lotes";
	}

	@GetMapping("/loteOrdenDescMenor")
	public String controladorLoteOrdenDescMenor(Model model) {
		model.addAttribute("listaLotes", servicioLote.ordenarDescMenor());
		return "lotes";
	}

	@GetMapping("/loteOrdenPrecioMayor")
	public String controladorLoteOrdenPrecioMayor(Model model) {
		model.addAttribute("listaLotes", servicioLote.ordenarPrecioMayor());
		return "lotes";
	}

	@GetMapping("/loteOrdenPrecioMenor")
	public String controladorLoteOrdenPrecioMenor(Model model) {
		model.addAttribute("listaLotes", servicioLote.ordenarPrecioMenor());
		return "lotes";
	}

	// MARISCO

	@GetMapping("/mariscoOrdenAZ")
	public String controladorMariscoOrdenAZ(Model model) {
		model.addAttribute("listaMarisco", servicioMarisco.ordenarAlfabeticoAZ());
		return "marisco";
	}

	@GetMapping("/mariscoOrdenZA")
	public String controladorMariscoOrdenZA(Model model) {
		model.addAttribute("listaMarisco", servicioMarisco.ordenarAlfabeticoZA());
		return "marisco";
	}

	@GetMapping("/mariscoOrdenLikesMayor")
	public String controladorMariscoOrdenLikesMayor(Model model) {
		model.addAttribute("listaMarisco", servicioMarisco.ordenarLikesMayor());
		return "marisco";
	}

	@GetMapping("/mariscoOrdenLikesMenor")
	public String controladorMariscoOrdenLikesMenor(Model model) {
		model.addAttribute("listaMarisco", servicioMarisco.ordenarLikesMenor());
		return "marisco";
	}

	@GetMapping("/mariscoOrdenPrecioMayor")
	public String controladorMariscoOrdenPrecioMayor(Model model) {
		model.addAttribute("listaMarisco", servicioMarisco.ordenarPrecioMayor());
		return "marisco";
	}

	@GetMapping("/mariscoOrdenPrecioMenor")
	public String controladorMariscoOrdenPrecioMenor(Model model) {
		model.addAttribute("listaMarisco", servicioMarisco.ordenarPrecioMenor());
		return "marisco";
	}

	// PESCADO

	@GetMapping("/pescadoOrdenAZ")
	public String controladorPescadoOrdenAZ(Model model) {
		model.addAttribute("listaPescado", servicioPescado.ordenarAlfabeticoAZ());
		return "pescado";
	}

	@GetMapping("/pescadoOrdenZA")
	public String controladorPescadoOrdenZA(Model model) {
		model.addAttribute("listaPescado", servicioPescado.ordenarAlfabeticoZA());
		return "pescado";
	}

	@GetMapping("/pescadoOrdenLikesMayor")
	public String controladorPescadoOrdenLikesMayor(Model model) {
		model.addAttribute("listaPescado", servicioPescado.ordenarLikesMayor());
		return "pescado";
	}

	@GetMapping("/pescadoOrdenLikesMenor")
	public String controladorPescadoOrdenLikesMenor(Model model) {
		model.addAttribute("listaPescado", servicioPescado.ordenarLikesMenor());
		return "pescado";
	}

	@GetMapping("/pescadoOrdenPrecioMayor")
	public String controladorPescadoOrdenPrecioMayor(Model model) {
		model.addAttribute("listaPescado", servicioPescado.ordenarPrecioMayor());
		return "pescado";
	}

	@GetMapping("/pescadoOrdenPrecioMenor")
	public String controladorPescadoOrdenPrecioMenor(Model model) {
		model.addAttribute("listaPescado", servicioPescado.ordenarPrecioMenor());
		return "pescado";
	}

}
