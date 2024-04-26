package com.salesianostriana.dam.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.ejemploformularios01.model.Empleado;

public class EmpleadoController {

	@GetMapping("/empleado")
	public String showFrom(Model model) {
		//Instanciamos un empleado vacío porque es el que usamos para pintar el formulario que estamos creando sin datos
		Empleado empleado = new Empleado();
		model.addAttribute("empleadoForm", empleado);
		return "form";
	}
	
	
	@PostMapping("/addEmpleado")
	public String submit(@ModelAttribute("empleadoForm") Empleado empleado, Model model) {
		//Se añade al modelo el empleado que se creará al recoger los datos del formulari
		model.addAttribute("empleado", empleado);
		
		return "view";
	}
}
