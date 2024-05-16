package com.salesianostriana.dam.pruebaproyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.pruebaproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.pruebaproyecto.exceptions.ProductoNotFoundException;
import com.salesianostriana.dam.pruebaproyecto.model.ProductoPorPeso;
import com.salesianostriana.dam.pruebaproyecto.repositorios.ProdPesoRepositorio;

@Service
public class ProdPesoService extends BaseServiceImpl<ProductoPorPeso, Long, ProdPesoRepositorio> {

	public List<ProductoPorPeso> buscarPorNombre(String busqueda) {
		List<ProductoPorPeso> result = this.repository.findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(busqueda, busqueda);
		if (result.isEmpty()) {
			throw new ProductoNotFoundException("No hay productos con ese criterio");
		}
		return result;
	}
	
}
