package com.salesianostriana.dam.pruebaproyecto.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.salesianostriana.dam.pruebaproyecto.model.ProductoPorUnidad;

public interface ProdUnidadRepositorio extends JpaRepository<ProductoPorUnidad, Long> {

	List<ProductoPorUnidad> findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);
	
	
}
