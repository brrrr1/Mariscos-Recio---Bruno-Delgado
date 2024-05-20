package com.salesianostriana.dam.brunodelgadoherreroproyecto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.brunodelgadoherreroproyecto.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	/*
	 * @Query(""" SELECT p FROM Producto p
	 * 
	 * """) public List<Producto> mostrarMasFavoritos();
	 */

	List<Producto> findTop9ByOrderByLikesDesc();
	

	
	
	

}
