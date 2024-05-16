package com.salesianostriana.dam.pruebaproyecto.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.model.Merch;
import com.salesianostriana.dam.pruebaproyecto.repositorios.MerchRepositorio;

@Service
public class MerchService extends BaseServiceImpl<Merch, Long, MerchRepositorio> {
	
	
	@Autowired
	private FavoritosService favServicio;

	
	
	public void deleteByIdConFavoritos(Long id) {
		Optional<Merch> optProducto = findById(id);
		
		if (optProducto.isPresent()) {
			favServicio.deleteFavoritosProducto(optProducto.get());
			deleteById(id);			
		}
	}
}

	

