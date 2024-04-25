package com.salesianostriana.dam.composicion.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.composicion.Avion;

public interface AvionRepositorio 
extends JpaRepository<Avion, Long> {

}