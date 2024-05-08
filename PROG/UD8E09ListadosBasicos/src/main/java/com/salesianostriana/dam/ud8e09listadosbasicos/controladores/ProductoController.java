package com.salesianostriana.dam.ud8e09listadosbasicos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.ud8e09listadosbasicos.servicios.ProductoService;

/* Mapeamos todo el controller con la ruta admin/producto 
 * para no tener que escribir esta parte en todos los getMapping 
 * de todos los métodos de dentro de la clase
 * */
@Controller
@RequestMapping("/admin/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

//En el navegador habrá que escribir http://localhost:9000/admin/producto/ 
//(ojo, la barra última tb, ya que esta es la petición que atiende este método index, 
//pero debemos escribir antes
//la ruta que hemos dicho en el @RequestMapping("/admin/producto") de la clase
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("productos", productoService.findAll());
/*Devolvemos el nombre de la plantilla como siempre, pero debemos tener en cuenta que al estar
 * dentro de la carpeta admin, que a su vez está dentro de la carpeta templates, debemos escribir la ruta
 * adecuadamente, es decir, empezar por "entrar en la carpeta admin y luego el nombre de la plantilla"
 * */		
		
		return "admin/list-producto";
	}


}