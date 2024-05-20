package com.salesianostriana.dam.brunodelgadoherreroproyecto.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.ProductoPorUnidad;

public interface ProdUnidadRepository extends JpaRepository<ProductoPorUnidad, Long> {

	List<ProductoPorUnidad> findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);
	
	
}
