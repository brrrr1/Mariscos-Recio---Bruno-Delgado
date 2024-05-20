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


import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Usuario;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.service.UsuarioService;

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
		boolean usernameExists = servicioUsuario.buscarUsername(usuario.getUsername());

		if (usernameExists) {
			return "usernameRepetido";
		} else {
			servicioUsuario.codificarContra(usuario);

			servicioUsuario.save(usuario);
			model.addAttribute("usuario", usuario);
			return "redirect:/admin/usuarios/listaUsuarios";
		}
	}

	@GetMapping("/editarUsuario/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		if (servicioUsuario.findById(id).isPresent()) {
			
			if(servicioUsuario.findById(id).get().isEsAdmin()) {
				return "editarAdmin";
			}else {
				model.addAttribute("usuario", servicioUsuario.findById(id).get());
				return "admin/usuarioForm";
			}
			
			
			
		} else {
			return "redirect:admin/usuarios/listaUsuarios";
		}

	}

	@PostMapping("/editarUsuario/submit")
	public String procesarFormularioEdicion(@ModelAttribute("usuario") Usuario u) {

		servicioUsuario.establecerContra(u);

		servicioUsuario.save(u);

		servicioUsuario.editarEmpleado(u);

		return "redirect:/admin/usuarios/listaUsuarios";
	}

	@GetMapping("/borrarUsuario/{id}")
	public String borrar(@PathVariable("id") long id) {

		Usuario u = servicioUsuario.findById(id).get();

		if (u.isEsAdmin()) {
			return "borrarAdmin";
		} else {
			return servicioUsuario.borrarUsuario(id);
		}
		


	}

	@GetMapping("/buscarUsuario")
	public String buscarUsuarioPorNombre(Model model, @RequestParam("busqueda") String busqueda) {
		model.addAttribute("listaUsuarios", servicioUsuario.buscarPorNombre(busqueda));
		return "admin/usuariosIndex";
	}

}
