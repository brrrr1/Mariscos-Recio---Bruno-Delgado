package com.salesianostriana.dam.ud8e02operacionesycondiciones;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
	
	/*
	 * Hemos creado una clase servicio, que nos provea de algunos de los objetos 
	 * que vamos a utilizar. Para inyectar aquí ese objeto lo anotamos con @Autowired
	 * con ello, aseguramos que se nos inyecte el objeto
	 * tipo DummyService cuando nos haga falta.
	 * Con ese objeto service, podemos llamar a los métodos de la clase 
	 * DummyService que son los que nos dan dichos productos simulando
	 * que vienen de la base de datos.
	 */
	
	@Autowired
	private DummyService service;
	
	/* Como ya se comentó en el ejemplo 1, la finalidad de @RequestParam, 
	 * es poder recibir parámetros desde una 
	 * ruta en una petición tipo GET, para trabajar con ellos e incluso poder emitir 
	 * una respuesta que dependa de los parámetros que hemos obtenido
	 * 
	 * Recordemos que el parámetro debe escribirse en 
	 * la ruta del navegador, por ejemplo:
	 * localhost:9000/?nombre=pepe y se tendrá ese parámetro recogido
	 * 
	 * En este caso, estamos pasando el parámetro "nombre" (antes del Model) 
	 * y con la información/detalles que aparecen en 
	 * los paréntesis que van delante, es decir, 
	 * name=nombre, requerido=false y valor por defecto (si no aparece el parámetro)=Mundo
	 * */
	
	@GetMapping({"/", "/welcome"})
	public String welcome(@RequestParam(name="nombre", required=false, defaultValue="Mundo") String nombre, Model model) {
		/*
		 * Funciona igual que en el ejemplo anterior, vamos añadiendo 
		 * variables y su valor al model mediante addAttribute 
		 * (se verán más adelante otras formas de añadir atributos pero esta es válida para casi todo)
		*/
		
		model.addAttribute("nombre", nombre);
		//Tomamos la fecha y hora actual del sistema con
		model.addAttribute("today", LocalDate.now());
		// Obtenemos desde el servicio la instancia de un producto
		model.addAttribute("producto", service.getProducto());
		// Obtenemos desde el servicio un listado con varios productos
		model.addAttribute("lista", service.getLista());
		// Obtenemos desde el servicio un HashMap con un producto
		model.addAttribute("map", service.getMap());
		// Obtenemos del servicio la instancia de un producto sin alguno de sus valores		
		model.addAttribute("producto2", service.getProductoSinAlgunosValores());
		
		//Devolvemos el nombre del archivo html que se debe pintar como respuesta a esta petición
		return "index";
	}

}
