package com.salesianostriana.dam.brunodelgadoherreroproyecto.service;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.base.BaseServiceImpl;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.exceptions.ProductoNotFoundException;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.ProductoPorUnidad;
import com.salesianostriana.dam.brunodelgadoherreroproyecto.repositories.ProdUnidadRepository;

@Service
public class ProdUnidadService extends BaseServiceImpl<ProductoPorUnidad, Long, ProdUnidadRepository> {
	
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
