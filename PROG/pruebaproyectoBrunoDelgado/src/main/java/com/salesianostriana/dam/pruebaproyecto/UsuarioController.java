package com.salesianostriana.dam.pruebaproyecto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UsuarioController {

	@GetMapping("/usuario")
	public String showFrom(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuarioForm", usuario);
		return "form";
	}
	
	
	@PostMapping("/addUsuario")
	public String submit(@ModelAttribute("empleadoForm") Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		
		return "view";
	}
}
