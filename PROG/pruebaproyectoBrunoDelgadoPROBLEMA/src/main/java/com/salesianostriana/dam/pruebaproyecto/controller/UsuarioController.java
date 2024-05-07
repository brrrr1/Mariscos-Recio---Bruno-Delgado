package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.service.UsuarioService;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService servicioUsuario;

	@GetMapping("/usuarios")
	public String controladorUsuarios(Model model) {
		model.addAttribute("listaUsuarios", servicioUsuario.findAll());
		return "admin/usuarios";
	}

	@GetMapping("/listaUsuarios")
	public String listarTodos(Model model) {
		model.addAttribute("listaUsuarios", servicioUsuario.findAll());
		return "admin/usuariosIndex";
	}

	@GetMapping("/uform")
	public String showFrom(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "admin/usuarioForm";
	}

	@PostMapping("/addUsuario")
	public String submit(@ModelAttribute("usuario") Usuario usuario, Model model) {
		servicioUsuario.save(usuario);
		model.addAttribute("usuario", usuario);
		return "redirect:/admin/usuarios/listaUsuarios";
	}

	@GetMapping("/editarUsuario/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		if (servicioUsuario.findById(id).isPresent()) {
			model.addAttribute("usuario", servicioUsuario.findById(id).get());
			return "admin/usuarioForm";
		} else {
			return "redirect:admin/usuarios/listaUsuarios";
		}

	}

	@PostMapping("/editarUsuario/submit")
	public String procesarFormularioEdicion(@ModelAttribute("usuario") Usuario u) {
		servicioUsuario.edit(u);
		return "redirect:/admin/usuarios/listaUsuarios";// Volvemos a redirigir la listado a través del controller
		// para pintar la lista actualizada con la modificación hecha
	}

	@GetMapping("/borrarUsuario/{id}")
	public String borrar(@PathVariable("id") long id) {
		servicioUsuario.deleteById(id);
		return "redirect:/admin/usuarios/listaUsuarios";
	}

}
