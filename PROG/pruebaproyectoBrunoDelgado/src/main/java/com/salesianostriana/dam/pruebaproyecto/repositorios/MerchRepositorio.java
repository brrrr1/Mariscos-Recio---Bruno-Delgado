package com.salesianostriana.dam.pruebaproyecto.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebaproyecto.model.Merch;

public interface MerchRepositorio extends JpaRepository<Merch, Long> {

	
	List<Merch> findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);
}
