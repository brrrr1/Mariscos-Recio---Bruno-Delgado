package com.salesianostriana.dam.pruebaproyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.pruebaproyecto.model.Favoritos;
import com.salesianostriana.dam.pruebaproyecto.model.Lote;
import com.salesianostriana.dam.pruebaproyecto.model.Marisco;
import com.salesianostriana.dam.pruebaproyecto.model.Merch;
import com.salesianostriana.dam.pruebaproyecto.model.Pescado;
import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.service.FavoritosService;
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

	@Autowired
	private FavoritosService servicioFavoritos;

	@GetMapping("/main")
	public String controlador(Model model) {
		model.addAttribute("listaMasFavoritos", servicioProducto.mostrarMasFavoritos());
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

//	@PostMapping("/addFavorito/{usuario_id}/{producto_id}")
	//// public String addFavorito(@PathVariable Long usuario_id, @PathVariable Long
	//// producto_id,
	//// @AuthenticationPrincipal Usuario usuario) {
	///// *
	//// * Usuario usuario = servicioUsuario.findById(usuario_id) .orElseThrow(() ->
	//// new
	//// * RuntimeException("Usuario no encontrado"));
	//// */
	// Producto producto = servicioProducto.findById(producto_id)
	// .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
	// producto.setLikes(producto.getLikes() + 1);
	// Favoritos favorito = new Favoritos(usuario, producto);
	// favorito.addToUsuario(usuario);
	// usuario.getFavoritos().add(favorito);
	// servicioUsuario.save(usuario);

	// return "redirect:/main";
	// }

//	@GetMapping("/agregarAFavoritos/{productoId}")
//	public String addProductoToFavoritos(@AuthenticationPrincipal Usuario usuario, @PathVariable Long productoId) {
//		boolean added = servicioFavoritos.alternarFavorito(usuario, productoId);
//		if (added) {
//			return "redirect:/misFavoritos";
//		} else {
//			return "redirect:/misFavoritos";
//		}
//	}

	@GetMapping("/agregarAFavoritos/{productoId}")
	public String addProductoToFavoritos(@AuthenticationPrincipal Usuario usuario, @PathVariable Long productoId) {
		servicioFavoritos.alternarFavorito(usuario, productoId);
		Optional<Producto> productoOpt = servicioProducto.findById(productoId);

		if (productoOpt.isPresent()) {
			Producto producto = productoOpt.get();
			if (producto instanceof Merch) {
				return "redirect:/productoMerch/{productoId}";
			} else if (producto instanceof Lote) {
				return "redirect:/productoLote/{productoId}";
			} else if (producto instanceof Marisco) {
				return "redirect:/productoMarisco/{productoId}";
			} else if (producto instanceof Pescado) {
				return "redirect:/productoPescado/{productoId}";
			}
		}
		return "redirect:/misFavoritos";
	}

	@GetMapping("/login")
	public String index() {
		return "login";
	}

	@GetMapping("/")
	public String principal() {
		return "main";
	}

//	@GetMapping("/favoritos")
//	public String listarMasFavoritos(Model model) {
//		model.addAttribute("listaMasFavoritos", servicioProducto.mostrarMasFavoritos());
//
//		return "pruebaLikes";
//	}

	@GetMapping("/misFavoritos")
	public String listarMisFavoritos(@AuthenticationPrincipal Usuario usuario, Model model) {
		List<Favoritos> favoritosDelUsuario = servicioFavoritos.findByUsuario(usuario);
		model.addAttribute("listaMisFavoritos", favoritosDelUsuario);

		return "misFavoritos";
	}

	@GetMapping("/masFavoritos")
	public String listarMasFavoritos(Model model) {
		model.addAttribute("listaMasFavoritos", servicioProducto.mostrarMasFavoritos());

		return "masFavoritos";
	}

	@GetMapping("/perfil")
	public String verPerfil(@AuthenticationPrincipal Usuario usuario, Model model) {

		model.addAttribute("usuario", usuario);

		return "perfil";
	}

	@GetMapping("/editarUsuario")
	public String mostrarFormularioEdicion(@AuthenticationPrincipal Usuario usuario, Model model) {

		model.addAttribute("usuario", usuario);
		return "editarUsuarioForm";

	}

	@PostMapping("/editarUsuario/submit")
	public String procesarFormularioEdicion(@ModelAttribute("usuario")  /*@AuthenticationPrincipal */ Usuario usuario) {
		/*String encodedPassword = passwordEncoder.encode(usuario.getPassword());
		 usuario.setPassword(encodedPassword);*/
		servicioUsuario.save(usuario);
		return "redirect:/perfil";

	}
	
	@GetMapping("/cambiarContrasena")
	public String mostrarFormularioPassword(@AuthenticationPrincipal Usuario usuario, Model model) {

		model.addAttribute("usuario", usuario);
		return "cambiarPswd";

	}
	
	@PostMapping("/perfil/editar")
	public String procesarFormularioPassword(@ModelAttribute("usuario")  /*@AuthenticationPrincipal */ Usuario usuario) {

		String encodedPassword = passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(encodedPassword);
		servicioUsuario.save(usuario);
		return "redirect:/perfil";

	}

	/*
	 * @PostMapping("/perfil/editar") public String
	 * procesarFormularioEdicion(@AuthenticationPrincipal Usuario usuario) {
	 * servicioUsuario.edit(usuario); return "redirect:/perfil"; }
	 */

}
