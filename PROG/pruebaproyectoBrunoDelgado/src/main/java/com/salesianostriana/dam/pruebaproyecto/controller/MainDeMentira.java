package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.pruebaproyecto.repositorios.UsuarioRepositorio;

@Controller
public class MainDeMentira {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@GetMapping("/empleadosQuery")
	public String verEmpleados(Model model) {
		model.addAttribute("listaEmpleados", usuarioRepositorio.encontrarEmpleados());
		return "pruebaQuery";
	}
}
