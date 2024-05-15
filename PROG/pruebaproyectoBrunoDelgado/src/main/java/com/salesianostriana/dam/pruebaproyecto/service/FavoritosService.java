package com.salesianostriana.dam.pruebaproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.Favoritos;
import com.salesianostriana.dam.pruebaproyecto.model.FavoritosPK;
import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;
import com.salesianostriana.dam.pruebaproyecto.repositorios.FavoritosRepositorio;
import com.salesianostriana.dam.pruebaproyecto.repositorios.ProductoRepositorio;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FavoritosService extends BaseServiceImpl<Favoritos, FavoritosPK, FavoritosRepositorio> {

	public List<Favoritos> findByUsuario(Usuario usuario) {
		return favoritosRepo.findByUsuario(usuario);
	}

	@Autowired
	private ProductoRepositorio productoRepo;

	@Autowired
	FavoritosRepositorio favoritosRepo;

//	public boolean alternarFavorito(Usuario usuario, Long productoId) {
//		Producto producto = productoRepo.findById(productoId)
//				.orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
//
//		Favoritos favoritoExistente = favoritosRepo.findByUsuarioAndProducto(usuario, producto);
//		if (favoritoExistente != null) {
//
//			favoritosRepo.delete(favoritoExistente);
//
//			producto.setLikes(producto.getLikes() - 1);
//			productoRepo.save(producto);
//
//			return false;
//		} else {
//
//			Favoritos nuevoFavorito = new Favoritos(usuario, producto);
//			favoritosRepo.save(nuevoFavorito);
//
//			producto.setLikes(producto.getLikes() + 1);
//			productoRepo.save(producto);
//
//			return true;
//		}
//
//	}

	public void alternarFavorito(Usuario usuario, Long productoId) {
		Producto producto = productoRepo.findById(productoId)
				.orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

		Favoritos favoritoExistente = repository.findByUsuarioAndProducto(usuario, producto);
		if (favoritoExistente != null) {

			repository.delete(favoritoExistente);

			producto.setLikes(producto.getLikes() - 1);
			productoRepo.save(producto);

		} else {

			Favoritos nuevoFavorito = new Favoritos(usuario, producto);
			repository.save(nuevoFavorito);

			producto.setLikes(producto.getLikes() + 1);
			productoRepo.save(producto);

		}

	}

}