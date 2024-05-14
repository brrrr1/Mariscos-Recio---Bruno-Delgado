package com.salesianostriana.dam.pruebaproyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebaproyecto.model.Favoritos;
import com.salesianostriana.dam.pruebaproyecto.model.FavoritosPK;
import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;

public interface FavoritosRepositorio extends JpaRepository<Favoritos, FavoritosPK> {

	boolean existsByUsuarioAndProducto(Usuario usuario, Producto producto);

	Favoritos findByUsuarioAndProducto(Usuario usuario, Producto producto);
}
