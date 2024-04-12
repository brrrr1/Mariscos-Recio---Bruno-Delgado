package com.salesianostriana.dam.ud8e01holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/*Necesitamos una clase que separa la vista del modelo, en este caso (más adelante habrá más clases de separación), 
 * un controller que se encarga de atender las peticiones que vengan del navegador (cliente). Los controller:
 * Atienden las peticiones.
 * Procesan los datos que llegan de las peticiones.
 * Hacen peticiones a la BBDD a través de otras clases y métodos.
 * Definen la información que se verá en la web (modelo).
 * Determinan qué vista será la encargada de generar la pg HTML
 * 
*/

//Anotamos la clase con @Controller e importamos las clases necesarias
@Controller
public class ControladorSaludo {

	/* Ejemplo 1: primer controlador, llamado welcome
	 * 
	 * "/ o /welcome" es el nombre del recurso que queremos mostrar al inicio, por
	 * tanto la palabra que se debe escribir en la ruta que tendremos que escribir
	 * en el navegador después de Localhost:9000 (o nada o welcome y posteriormente
	 * se puede probar con un parámetro nombre)
	 * 
	 * @GetMapping indica que el método justo de debajo será el que atenderá la
	 * petición tipo Get (la petición es tipo Get solo hay un método y dos cuando es
	 * tipo Post (formulario).   Puede que en códigos antiguos os encontréis el uso
	 * de RequestMapping en lugar de GetMapping.
	 * 
	 * El @RequestParam se utiliza para pasar un parámetro a la petición tipo get, es decir, información o datos que 
	 * vamos a pasar en una petición tipo get (recuerda que no están pensadas para esto pero hay muchas veces
	 * en las que llevan algún parámetro.
	 * Si en la barra del navegador pasamos este parámetro con un valor aparecerá en el saludo, esto es, 
	 * si escribes en el navegador http://localhost:9000/?nombre=Luis aparecerá el saludo personalizado para Luis,
	 * si no hay parámetro, el valor por defecto es Mundo
	 */

	@GetMapping({ "/", "welcome" })
	public String welcome(@RequestParam(name = "nombre", required = false, defaultValue = "Mundo") String nombre,
			Model model) {

		/*
		 * El parámetro "nombre" es la palabra que usamos para darle un identificador a
		 * la variable y debemos usar en la plantilla dentro de <p>Hello <span
		 * th:text="${nombre}">Friend</span>!</p> Ojo porque no tener un criterio a la
		 * hora de dar estos nombres a las variables hace que tengamos muchos errores
		 * (usar mayúsculas o minúsculas, que el nombre no indique qué guarda, mezclas
		 * varias palabras...
		 */

		model.addAttribute("nombre", nombre);// Incluimos la información en el modelo

		return "index";// Nombre de la plantilla que generará la página HTML (sin extensión),
		// en nuestro caso estos html deben estar dentro de la carpeta
		// src/main/resources/templates
		// y deben llamarse igual que el String que devuelve el método,
		// index.html Ojo con las máyúsculas y minúsculas del nombre
		// de la plantilla porque son tenidas en cuenta
	}

	
	/*
	 * Ejemplo 2: Segundo controlador llamado welcome2
	 * Atiende a la petición /saludo2 escrita en el @GetMapping
	 * 
	 * Se puede ver cómo se "pasa o carga información" al
	 * model dentro del método mediante el método addAtributte
	 * como un objeto de la clase Persona, con valores de sus dos
	 * atributos. Más adelante iremos viendo de dónde sacamos esa "información" que
	 * cambiar, como aquí la new Persona creada directamente en el método addAttribute.
	 */

	@GetMapping("/saludo2")
	public String welcome2(Model model) {

		model.addAttribute("persona", new Persona("Ángel", "Naranjo González"));
		return "SaludoPersonalizado";
	}

	/*
	 * @GetMapping es una variante de requestMapping, más "nueva" que se utiliza
	 * como atajo, ya que  basta con el nombre del recurso, mientras que
	 * con @RequestMapping, en general, tenemos que ir  diciendo el tipo de petición
	 * que se está atendiendo, es decir, necesita que le indiquemos el value
	 * (nombre el recurso, por ejemplo, /saludo3) y el método que se usa para la
	 * petición, en nuestro caso, tendríamos que escribir:  
	 * @RequestMapping (value="/saludo3", method=RequestMethod.GET) 
	 * (también existe RequestMethod.POST) 
	 * En general, se usa por simplificar el código  
	 * Se puede ver un ejemplo en:
	 * https://www.arquitecturajava.com/spring-getmapping-postmapping-etc/
	 * 
	 * Nosotros usaremos siempre GetMapping
	 */
	
	/* Ejemplo 3: Tercer controlador llamado welcome3
	 * Atiende a la petición get "/saludo3"
	 * 
	 * */
	
	
	@GetMapping ("/saludo3")
	public String welcome3(Model model) {
		
		model.addAttribute("saludo", "Hola Mundo");
		model.addAttribute("mensaje", "¡Se me está haciendo largo el proyecto final!");
		model.addAttribute("url", "https://triana.salesianos.edu");
		
		return "SaludoYEnlace";
	}
}
