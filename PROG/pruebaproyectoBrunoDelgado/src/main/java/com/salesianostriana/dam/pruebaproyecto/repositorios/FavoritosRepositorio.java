package com.salesianostriana.dam.pruebaproyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebaproyecto.model.ListaFavoritos;
import com.salesianostriana.dam.pruebaproyecto.model.ListaFavoritosPK;

public interface FavoritosRepositorio extends JpaRepository<ListaFavoritos, ListaFavoritosPK> {

}
