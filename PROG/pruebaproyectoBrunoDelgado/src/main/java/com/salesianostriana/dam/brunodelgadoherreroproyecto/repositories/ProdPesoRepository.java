package com.salesianostriana.dam.brunodelgadoherreroproyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.ProductoPorPeso;



public interface ProdPesoRepository extends JpaRepository<ProductoPorPeso, Long> {

	List<ProductoPorPeso> findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);
	
}
