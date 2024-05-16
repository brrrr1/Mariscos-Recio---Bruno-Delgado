package com.salesianostriana.dam.pruebaproyecto.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.exceptions.ProductoNotFoundException;
import com.salesianostriana.dam.pruebaproyecto.model.ProductoPorUnidad;
import com.salesianostriana.dam.pruebaproyecto.repositorios.ProdUnidadRepositorio;

@Service
public class ProdUnidadService extends BaseServiceImpl<ProductoPorUnidad, Long, ProdUnidadRepositorio> {

	public List<ProductoPorUnidad> buscarPorNombre(String busqueda) {
		List<ProductoPorUnidad> result = this.repository.findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(busqueda, busqueda);
		if (result.isEmpty()) {
			throw new ProductoNotFoundException("No hay productos con ese criterio");
		}
		return result;
	}
	
}
