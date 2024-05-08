package com.salesianostriana.dam.pruebaproyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebaproyecto.model.ProductoPorUnidad;

public interface ProdUnidadRepositorio extends JpaRepository<ProductoPorUnidad, Long> {

}
