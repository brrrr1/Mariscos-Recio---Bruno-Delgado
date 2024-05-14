package com.salesianostriana.dam.pruebaproyecto.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.ListaFavoritos;
import com.salesianostriana.dam.pruebaproyecto.model.ListaFavoritosPK;
import com.salesianostriana.dam.pruebaproyecto.repositorios.FavoritosRepositorio;

@Service
public class FavoritosService extends BaseServiceImpl<ListaFavoritos, ListaFavoritosPK, FavoritosRepositorio> {

}
