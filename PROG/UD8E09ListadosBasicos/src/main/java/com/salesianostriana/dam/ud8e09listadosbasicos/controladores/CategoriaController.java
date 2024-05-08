package com.salesianostriana.dam.ud8e09listadosbasicos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.ud8e09listadosbasicos.servicios.CategoriaService;

/* Sobre rutas:Ahora podéis ver que mapeamos la ruta del controlador entero
 * a la petición admin/categoria, es decir, para que todas las peticiones que tengamos dentro de esta 
 * clase controller en cada uno de los métodos, tengan este tramo de ruta común y así, no tendremos 
 * que escribir todo este tramo de ruta en cada getMapping de cada método
 * 
 * */
@Controller
@RequestMapping("/admin/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
		
	
	//En el navegador habrá que escribir http://localhost:9000/admin/categoria/ 
	//(ojo, la barra última también, ya que esta es la petición que atiende este 
	//método index, pero debemos escribir antes
	//la ruta que hemos dicho en el @RequestMapping("/admin/categoria") de la clase
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("categorias", categoriaService.findAll());
		
		//Devolvemos la plantilla list-categoria pero al estar dentro de la carpeta admin, que a su vez
		//está dentro de templates (nuestra raiz) tenemos que poner la ruta desde templates, 
		//es decir, debemos "entrar en admin" y luego dar 
		//el nombre del archivo del html a mostrar, en este caso, list-categoria.
		return "admin/list-categoria";
	}
			
	

}

