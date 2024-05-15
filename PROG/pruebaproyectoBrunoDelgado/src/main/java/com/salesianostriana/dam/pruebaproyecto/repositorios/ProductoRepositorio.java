package com.salesianostriana.dam.pruebaproyecto.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebaproyecto.model.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

	/*
	 * @Query(""" SELECT p FROM Producto p
	 * 
	 * """) public List<Producto> mostrarMasFavoritos();
	 */

	List<Producto> findTop9ByOrderByLikesDesc();

}
