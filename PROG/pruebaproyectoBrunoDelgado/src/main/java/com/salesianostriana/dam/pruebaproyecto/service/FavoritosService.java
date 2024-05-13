package com.salesianostriana.dam.pruebaproyecto.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.Favoritos;
import com.salesianostriana.dam.pruebaproyecto.model.FavoritosPK;
import com.salesianostriana.dam.pruebaproyecto.repositorios.FavoritosRepositorio;

@Service
public class FavoritosService extends BaseServiceImpl<Favoritos, FavoritosPK, FavoritosRepositorio> {

}
