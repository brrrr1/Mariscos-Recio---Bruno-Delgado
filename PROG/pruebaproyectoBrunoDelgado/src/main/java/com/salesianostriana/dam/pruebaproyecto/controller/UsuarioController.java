package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/listaUsuarios")
	public String listarTodos(Model model) {
		model.addAttribute("listaUsuarios", servicioUsuario.findAll());
		return "usuariosIndex";
	}

	@GetMapping("/uform")
	public String showFrom(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario); // Usamos "usuario" en lugar de "usuarioForm"
		return "form";
	}

	@PostMapping("/addUsuario")
	public String submit(@ModelAttribute("usuario") Usuario usuario, Model model) {
		servicioUsuario.save(usuario);
		model.addAttribute("usuario", usuario);
		return "redirect:/listaUsuarios";
	}

	@GetMapping("/editarUsuario/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {

		// Buscamos al alumno por id y recordemos que el método findById del servicio,
		// devuelve el objeto buscado o null si no se encuentra.

		if (servicioUsuario.findById(id).isPresent()) {
			model.addAttribute("usuario", servicioUsuario.findById(id).get());
			return "form";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/listaUsuarios";
		}

	}

	@PostMapping("/editarUsuario/submit")
	public String procesarFormularioEdicion(@ModelAttribute("usuario") Usuario u) {
		servicioUsuario.edit(u);
		return "redirect:/listaUsuarios";// Volvemos a redirigir la listado a través del controller
		// para pintar la lista actualizada con la modificación hecha
	}

	@GetMapping("/borrarUsuario/{id}")
	public String borrar(@PathVariable("id") long id) {
		servicioUsuario.deleteById(id);
		return "redirect:/listaUsuarios";
	}

}
