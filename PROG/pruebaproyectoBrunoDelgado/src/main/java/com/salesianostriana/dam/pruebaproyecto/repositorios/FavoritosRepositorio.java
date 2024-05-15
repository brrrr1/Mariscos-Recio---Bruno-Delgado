package com.salesianostriana.dam.pruebaproyecto.repositorios;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebaproyecto.model.ListaFavoritos;
import com.salesianostriana.dam.pruebaproyecto.model.ListaFavoritosPK;

public interface FavoritosRepositorio extends JpaRepository<ListaFavoritos, ListaFavoritosPK> {
=======
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebaproyecto.model.Favoritos;
import com.salesianostriana.dam.pruebaproyecto.model.FavoritosPK;
import com.salesianostriana.dam.pruebaproyecto.model.Producto;
import com.salesianostriana.dam.pruebaproyecto.model.Usuario;

public interface FavoritosRepositorio extends JpaRepository<Favoritos, FavoritosPK> {

	boolean existsByUsuarioAndProducto(Usuario usuario, Producto producto);

	Favoritos findByUsuarioAndProducto(Usuario usuario, Producto producto);

	List<Favoritos> findByUsuario(Usuario usuario);
>>>>>>> favoritos

}
