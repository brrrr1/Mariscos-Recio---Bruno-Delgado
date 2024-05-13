package com.salesianostriana.dam.pruebaproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pruebaproyecto.model.Favoritos;
import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.service.LoteService;
import com.salesianostriana.dam.pruebaproyecto.service.MariscoService;
import com.salesianostriana.dam.pruebaproyecto.service.MerchService;
import com.salesianostriana.dam.pruebaproyecto.service.PescadoService;
import com.salesianostriana.dam.pruebaproyecto.service.ProductoService;
import com.salesianostriana.dam.pruebaproyecto.service.UsuarioService;

@Controller

public class MainController {
	@Autowired
	private LoteService servicioLote;

	@Autowired
	private MerchService servicioMerch;

	@Autowired
	private MariscoService servicioMarisco;

	@Autowired
	private PescadoService servicioPescado;

	@Autowired
	private UsuarioService servicioUsuario;

	@Autowired
	private ProductoService servicioProducto;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/main")
	public String controlador(Model model) {
		return "main";
	}

	@GetMapping("/lotes")
	public String controladorLotes(Model model) {
		model.addAttribute("listaLotes", servicioLote.findAll());
		return "lotes";
	}

	@GetMapping("/merch")
	public String controladorMerch(Model model) {
		model.addAttribute("listaMerch", servicioMerch.findAll());
		return "merch";
	}

	@GetMapping("/marisco")
	public String controladorMarisco(Model model) {
		model.addAttribute("listaMarisco", servicioMarisco.findAll());

		return "marisco";
	}

	@GetMapping("/pescado")
	public String controladorPescado(Model model) {
		model.addAttribute("listaPescado", servicioPescado.findAll());

		return "pescado";
	}

	@GetMapping("/productoMerch/{id}")
	public String mostrarPaginaProductoMerch(@PathVariable("id") long id, Model model) {
		if (servicioMerch.findById(id).isPresent()) {
			model.addAttribute("merch", servicioMerch.findById(id).get());
			return "compraMerch";
		} else {

			return "redirect:/admin/merch/listaMerch";
		}

	}

	@GetMapping("/productoLote/{id}")
	public String mostrarPaginaProductoLote(@PathVariable("id") long id, Model model) {
		if (servicioLote.findById(id).isPresent()) {
			model.addAttribute("lote", servicioLote.findById(id).get());
			return "compraLote";
		} else {

			return "redirect:/admin/lotes/listaLotes";
		}

	}

	@GetMapping("/productoPescado/{id}")
	public String mostrarPaginaProductoPescado(@PathVariable("id") long id, Model model) {
		if (servicioPescado.findById(id).isPresent()) {
			model.addAttribute("pescado", servicioPescado.findById(id).get());
			return "compraPescado";
		} else {

			return "redirect:/admin/pescado/listaPescado";
		}

	}

	@GetMapping("/productoMarisco/{id}")
	public String mostrarPaginaProductoMarisco(@PathVariable("id") long id, Model model) {
		if (servicioMarisco.findById(id).isPresent()) {
			model.addAttribute("marisco", servicioMarisco.findById(id).get());
			return "compraMarisco";
		} else {

			return "redirect:/admin/marisco/listaMarisco";
		}

	}

	@GetMapping("/register")
	public String registro(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "register";
	}

	@PostMapping("/registrarUsuario")
	public String submit(@ModelAttribute("usuario") Usuario usuario, Model model) {
		String encodedPassword = passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(encodedPassword);
		servicioUsuario.save(usuario);
		model.addAttribute("usuario", usuario);
		return "main";
	}

	@PostMapping("/addFavorito/{usuarioId}/{productoId}")
	public String addFavorito(@PathVariable Long usuarioId, @PathVariable Long productoId) {
		// Obtener el usuario y el producto de la base de datos
		Usuario usuario = servicioUsuario.findById(usuarioId)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		Producto producto = servicioProducto.findById(productoId)
				.orElseThrow(() -> new RuntimeException("Producto no encontrado"));

		producto.setLikes(producto.getLikes() + 1);

		// Crear la asociación en la tabla de favoritos
		Favoritos favorito = new Favoritos(usuario, producto);
		usuario.getFavoritos().add(favorito);

		// Guardar los cambios en la base de datos
		servicioUsuario.save(usuario);

		return "redirect:/main";
	}

}
