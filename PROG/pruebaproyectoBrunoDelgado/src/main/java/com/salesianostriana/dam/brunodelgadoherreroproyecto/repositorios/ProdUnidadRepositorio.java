package com.salesianostriana.dam.brunodelgadoherreroproyecto.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.ProductoPorUnidad;

public interface ProdUnidadRepositorio extends JpaRepository<ProductoPorUnidad, Long> {

	List<ProductoPorUnidad> findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);
	
	
}
