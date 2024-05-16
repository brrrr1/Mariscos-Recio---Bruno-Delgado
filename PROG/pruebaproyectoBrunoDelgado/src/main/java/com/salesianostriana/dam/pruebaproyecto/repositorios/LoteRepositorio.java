package com.salesianostriana.dam.pruebaproyecto.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebaproyecto.model.Lote;


public interface LoteRepositorio extends JpaRepository<Lote, Long> {

	List<Lote> findByNombreContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String nombre, String descripcion);
}
