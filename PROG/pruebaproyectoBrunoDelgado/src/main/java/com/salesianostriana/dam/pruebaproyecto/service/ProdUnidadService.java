package com.salesianostriana.dam.pruebaproyecto.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.exceptions.ProductoNotFoundException;

import com.salesianostriana.dam.pruebaproyecto.model.ProductoPorUnidad;
import com.salesianostriana.dam.pruebaproyecto.repositorios.ProdUnidadRepositorio;

@Service
public class ProdUnidadService extends BaseServiceImpl<ProductoPorUnidad, Long, ProdUnidadRepositorio> {
	
	@Autowired
	private FavoritosService favServicio;

	public List<ProductoPorUnidad> buscarPorNombre(String busqueda) {
		List<ProductoPorUnidad> result = this.repository.findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(busqueda, busqueda);
		if (result.isEmpty()) {
			throw new ProductoNotFoundException("No hay productos con ese criterio");
		}
		return result;
	}
	
	public void deleteByIdConFavoritos(Long id) {
		Optional<ProductoPorUnidad> optProducto = findById(id);
		
		if (optProducto.isPresent()) {
			favServicio.deleteFavoritosProducto(optProducto.get());
			deleteById(id);			
		}
	}
	
}
