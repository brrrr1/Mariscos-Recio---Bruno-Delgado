package com.salesianostriana.dam.pruebaproyecto.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebaproyecto.model.ProductoPorPeso;



public interface ProdPesoRepositorio extends JpaRepository<ProductoPorPeso, Long> {

	List<ProductoPorPeso> findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);
	
}
