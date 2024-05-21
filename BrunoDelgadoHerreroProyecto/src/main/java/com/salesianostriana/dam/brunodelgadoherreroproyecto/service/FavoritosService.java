package com.salesianostriana.dam.brunodelgadoherreroproyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Favoritos;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.FavoritosPK;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Producto;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Usuario;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositories.FavoritosRepository;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositories.ProductoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FavoritosService extends BaseServiceImpl<Favoritos, FavoritosPK, FavoritosRepository> {

	public List<Favoritos> findByUsuario(Usuario usuario) {
		return favoritosRepo.findByUsuario(usuario);
	}

	@Autowired
	private ProductoRepository productoRepo;

	@Autowired
	FavoritosRepository favoritosRepo;



	//Método que busca un producto, comprueba si el usuario lo tiene en favorito. Si lo tiene lo quita y si no lo añade.
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
	//Método que llama a la consulta que busca los favoritos en los que se encuentra un producto
	public List<Favoritos> buscarFavoritosPorProducto(Producto p) {
		return repository.buscarProductoFavorito(p);
	}
	
	public void deleteAll(List<Favoritos> lista) {
		repository.deleteAll(lista);
	}
	
	public void deleteFavoritosProducto(Producto p) {
		deleteAll(buscarFavoritosPorProducto(p));
	}

}