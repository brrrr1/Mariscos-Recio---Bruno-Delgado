package com.salesianostriana.dam.pruebaproyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.Favoritos;
import com.salesianostriana.dam.pruebaproyecto.model.FavoritosPK;
import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.repositorios.FavoritosRepositorio;
import com.salesianostriana.dam.pruebaproyecto.repositorios.ProductoRepositorio;

@Service
public class FavoritosService extends BaseServiceImpl<Favoritos, FavoritosPK, FavoritosRepositorio> {

	@Autowired
	private ProductoRepositorio productoRepo;

	@Autowired
	FavoritosRepositorio favoritosRepo;

	public boolean toggleFavorito(Usuario usuario, long productoId) {
		Producto producto = productoRepo.findById(productoId)
				.orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

		/*
		 * if (favoritosRepo.existsByUsuarioAndProducto(usuario, producto)) { Favoritos
		 * favorito = favoritosRepo.findByUsuarioAndProducto(usuario, producto);
		 * favoritosRepo.delete(favorito);
		 * 
		 * producto.setLikes(producto.getLikes() - 1); productoRepo.save(producto); }
		 * else { Favoritos favoritos = new Favoritos(usuario, producto);
		 * favoritosRepo.save(favoritos);
		 * 
		 * producto.setLikes(producto.getLikes() + 1); productoRepo.save(producto);
		 * 
		 * }
		 * 
		 * return true;
		 */

		Favoritos favoritoExistente = favoritosRepo.findByUsuarioAndProducto(usuario, producto);
		if (favoritoExistente != null) {

			favoritosRepo.delete(favoritoExistente);

			producto.setLikes(producto.getLikes() - 1);
			productoRepo.save(producto);

			return false;
		} else {

			Favoritos nuevoFavorito = new Favoritos(usuario, producto);
			favoritosRepo.save(nuevoFavorito);

			producto.setLikes(producto.getLikes() + 1);
			productoRepo.save(producto);

			return true;
		}

	}
}
