package com.salesianostriana.dam.pruebaproyecto.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.pruebaproyecto.model.Favoritos;
import com.salesianostriana.dam.pruebaproyecto.model.FavoritosPK;
import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;

public interface FavoritosRepositorio extends JpaRepository<Favoritos, FavoritosPK> {

	boolean existsByUsuarioAndProducto(Usuario usuario, Producto producto);

	Favoritos findByUsuarioAndProducto(Usuario usuario, Producto producto);

	List<Favoritos> findByUsuario(Usuario usuario);
	
	@Query("""
			SELECT f FROM Favoritos f
			WHERE f.producto = ?1
			""")
	List<Favoritos> buscarProductoFavorito(Producto p);

}
