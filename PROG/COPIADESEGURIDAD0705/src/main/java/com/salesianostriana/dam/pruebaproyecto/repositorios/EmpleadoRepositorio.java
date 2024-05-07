package com.salesianostriana.dam.pruebaproyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.pruebaproyecto.model.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {

}
