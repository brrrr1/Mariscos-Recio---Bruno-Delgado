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

import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Empleado;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.service.EmpleadoService;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.service.UsuarioService;

@Controller
@RequestMapping("/admin/empleados")
public class EmpleadoController {

	@Autowired
	private EmpleadoService servicioEmpleado;

	@Autowired
	private UsuarioService servicioUsuario;

	@GetMapping("/empleados")
	public String controladorEmpleados(Model model) {
		model.addAttribute("listaEmpleados", servicioEmpleado.findAll());
		return "admin/empleados";
	}

	@GetMapping("/listaEmpleados")
	public String listarTodos(Model model) {
		model.addAttribute("listaEmpleados", servicioEmpleado.findAll());
		return "admin/empleadosIndex";
	}

	@GetMapping("/eform")
	public String showFrom(Model model) {
		Empleado empleado = new Empleado();
		model.addAttribute("empleado", empleado);
		return "admin/empleadoForm";
	}

	@PostMapping("/addEmpleado")
	public String submit(@ModelAttribute("empleado") Empleado empleado, Model model) {
		servicioEmpleado.save(empleado);
		servicioUsuario.save(servicioEmpleado.generarUsuario(empleado));
		model.addAttribute("empleado", empleado);
		return "redirect:/admin/empleados/listaEmpleados";
	}

	@GetMapping("/editarEmpleado/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		if (servicioEmpleado.findById(id).isPresent()) {
			model.addAttribute("empleado", servicioEmpleado.findById(id).get());
			return "admin/EmpleadoForm";
		} else {
			return "redirect:admin/empleados/listaEmpleados";
		}

	}

	@PostMapping("/editarEmpleado/submit")
	public String procesarFormularioEdicion(@ModelAttribute("empleado") Empleado e) {
		servicioEmpleado.edit(e);
		
		servicioUsuario.editarUsuarioDeUnEmpleado(e);
		
		return "redirect:/admin/empleados/listaEmpleados";

	}

	@GetMapping("/borrarEmpleado/{id}")
	public String borrar(@PathVariable("id") long id) {
		
		Empleado e = servicioEmpleado.buscarPorId(id);
		
		servicioUsuario.borrarUsuariosDeUnEmpleado(e);
		
		servicioEmpleado.deleteById(id);
		
		return "redirect:/admin/empleados/listaEmpleados";
	}

	@GetMapping("/buscarEmpleado")
	public String buscarEmpleadoPorNombre(Model model, @RequestParam("busqueda") String busqueda) {
		model.addAttribute("listaEmpleados", servicioEmpleado.buscarPorNombre(busqueda));
		return "admin/empleadosIndex";
	}

	@GetMapping("/darDeBaja/{id}")
	public String darDeBaja(@PathVariable("id") long id) {
		
		Empleado e = servicioEmpleado.buscarPorId(id);
		servicioEmpleado.darDeBaja(e);
		

		servicioUsuario.cambiarUsuarioTrasBaja(e);

		
		
		return "redirect:/admin/empleados/listaEmpleados";
	}

}
