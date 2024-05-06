package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService servicioUsuario;

	@GetMapping("/usuarios")
	public String controlador(Model model) {
		model.addAttribute("listaUsuarios", servicioUsuario.findAll());
		return "usuarios";
	}

	@GetMapping("/uform")
	public String showFrom(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuarioForm", usuario);
		return "form";
	}

	@PostMapping("/addUsuario")
	public String submit(@ModelAttribute("usuarioForm") Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		servicioUsuario.save(usuario);
		return "view";
	}
}
