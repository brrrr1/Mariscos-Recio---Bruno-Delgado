package com.salesianostriana.dam.ejemplo03buclesyswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService servicio;
	
	@GetMapping("/listGen")
	public String listarVarios (Model model) {
		
		model.addAttribute("customerList", servicio.getLista());		
		return "PlantillaSwitch";
	}

}
