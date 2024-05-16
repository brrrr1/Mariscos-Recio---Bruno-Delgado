package com.salesianostriana.dam.pruebaproyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.exceptions.ProductoNotFoundException;
import com.salesianostriana.dam.pruebaproyecto.model.Merch;
import com.salesianostriana.dam.pruebaproyecto.repositorios.MerchRepositorio;

@Service
public class MerchService extends BaseServiceImpl<Merch, Long, MerchRepositorio> {
	
	
	@Autowired
	private FavoritosService favServicio;

	public List<Merch> buscarPorNombre(String busqueda) {
		List<Merch> result = this.repository.findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(busqueda, busqueda);
		if (result.isEmpty()) {
			throw new ProductoNotFoundException("No hay productos con ese criterio");
		}
		return result;
	}
	
	public void deleteByIdConFavoritos(Long id) {
		Optional<Merch> optProducto = findById(id);
		
		if (optProducto.isPresent()) {
			favServicio.deleteFavoritosProducto(optProducto.get());
			deleteById(id);			
		}
	}
}

	

